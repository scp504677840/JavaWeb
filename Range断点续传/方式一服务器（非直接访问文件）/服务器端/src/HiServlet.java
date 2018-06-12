import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.regex.Pattern;

/**
 * Range
 * 用于请求头中，指定第一个字节的位置和最后一个字节的位置，一般格式：
 * Range:(unit=first byte pos)-[last byte pos]
 * 三种格式：
 * Range: bytes=1000-2000
 * 传送范围从1000到2000字节
 * Range: bytes=1000-
 * 传送范围从第1000一直到最后
 * Range: bytes=1000
 * 传送最后1000个字节
 * <p>
 * Content-Range
 * 用于响应头，指定整个实体中的一部分的插入位置，他也指示了整个实体的长度。在服务器向客户返回一个部分响应，它必须描述响应覆盖的范围和整个实体长度。一般格式：
 * Content-Range: bytes (unit first byte pos) - [last byte pos]/[entity legth]
 */
@WebServlet(name = "HiServlet", urlPatterns = {"/hi"})
public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置下载请求头
        response.setHeader("Content-Disposition", "attachment;filename=range.txt");
        // 设置支持断点续传；bytes表示支持；none表示不支持。
        response.setHeader("Accept-Range", "bytes");//bytes/none

        // 获取客户端传过来的range
        String range = request.getHeader("Range");
        // 格式一：bytes=5-10
        // 格式二：bytes=5-
        // 格式三：bytes=5
        // 当range为空或不是bytes=开头时
        if (range == null || !range.startsWith("bytes=")) {
            response.setStatus(404);
            return;
        }

        // 取出 "bytes=" 后面的字符；如：5-10
        String numStr = range.substring(6);
        // 服务器输出流
        ServletOutputStream out = null;
        // 随机访问文件
        RandomAccessFile file = null;

        try {

            // 获取Response的输出流
            out = response.getOutputStream();
            // 获取要下载文件，记得一定要使用随机访问文件对象
            file = new RandomAccessFile("/Users/scp/Documents/Workspace/Java/TLab/web/range.txt", "r");
            // 获取文件的总大小
            long count = file.length();
            // 记录读取文件的起始位置
            long start, end;

            // 例如：5-10
            if (Pattern.matches("^\\d+-\\d+$", numStr)) {
                String[] nums = numStr.split("-");
                start = Integer.valueOf(nums[0]);
                end = Integer.valueOf(nums[1]);
            }
            // 例如：5-
            else if (Pattern.matches("^\\d+-$", numStr)) {
                String[] nums = numStr.split("-");
                start = Integer.valueOf(nums[0]);
                end = count;
            }
            // 例如：5
            else if (Pattern.matches("^\\d+$", numStr)) {
                start = count - Integer.valueOf(numStr);
                end = count;
            } else {
                response.setStatus(404);
                return;
            }

            // 例如：告诉客户端我们要传输文件信息
            //response.setHeader("Content-Range", "1000-3000/5000");
            response.setHeader("Content-Range", start + "-" + end + "/" + count);

            // 设置开始读取文件的位置
            file.seek(start);

            // 缓冲区
            byte[] buf = new byte[1024];
            // 记录每次读取的长度
            long length;

            // 遍历读取
            while (true) {
                length = file.read(buf);
                //记录已经读到的位置
                start += length;

                if (length == 0) {
                    break;
                }

                // 当起始位置大于结束位置时，
                // 如start=200；end=260；length=100；
                // start+=length=300；
                // start > end
                // 300 > 260
                if (start > end) {
                    // 重新计算length。length = 300 - 260；也就是本次输出40个字节就可以了。
                    length = start - end;
                }

                // 输出
                out.write(buf, 0, (int) length);

                // 当起始位置大于结束位置时，也就是需要的字节数都已经拿到。
                if (start >= end) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
