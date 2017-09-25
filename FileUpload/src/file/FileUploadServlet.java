package file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "FileUploadServlet", value = {"/fileUploadServlet"})
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FileUploadProperties fileUploadProperties = FileUploadProperties.getInstance();
        String exts = fileUploadProperties.getProperty("exts");
        String fileMaxSize = fileUploadProperties.getProperty("file.max.size");
        String totalFileMaxSize = fileUploadProperties.getProperty("total.file.max.size");

        //检查我们是否有文件上传请求
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        System.out.println("--- isMultipart --- " + isMultipart);

        //为基于磁盘的文件创建一个工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();

        //设置工厂约束
        factory.setSizeThreshold(1024 * 5);
        File tempRepository = new File("/Users/scp/Workspace/Java/FileUpload/src/");
        factory.setRepository(tempRepository);

        //创建一个新的文件上传处理程序
        ServletFileUpload upload = new ServletFileUpload(factory);

        //设置单个文件最大字节数
        upload.setFileSizeMax(Long.parseLong(fileMaxSize));//1024 * 1024 * 1 = 1M
        //设置整体请求大小约束
        upload.setSizeMax(Long.parseLong(totalFileMaxSize));//1024 * 1024 * 5 = 5M

        try {
            List<FileItem> fileItems = upload.parseRequest(req);
            Iterator<FileItem> fileItemIterator = fileItems.iterator();
            while (fileItemIterator.hasNext()) {
                FileItem fileItem = fileItemIterator.next();
                if (fileItem.isFormField()) {
                    String fieldName = fileItem.getFieldName();
                    String fieldValue = fileItem.getString();
                    System.out.println("--- fieldName : " + fieldName + " fieldValue " + fieldValue + "---");
                } else {
                    String fieldName = fileItem.getFieldName();
                    String fileName = fileItem.getName();
                    String contentType = fileItem.getContentType();
                    long sizeInBytes = fileItem.getSize();
                    System.out.println("*** " + fieldName + " ***");
                    System.out.println("*** " + fileName + " ***");
                    System.out.println("*** " + contentType + " ***");
                    System.out.println("*** " + sizeInBytes + " ***");

                    InputStream in = fileItem.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    fileName = "/Users/scp/Workspace/Java/FileUpload/src/" + fileName;
                    FileOutputStream out = new FileOutputStream(fileName);
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }
                    out.close();
                    in.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
}
