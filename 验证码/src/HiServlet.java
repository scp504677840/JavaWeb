import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 */
@WebServlet(name = "HiServlet", urlPatterns = "/hi")
public class HiServlet extends HttpServlet {

    /**
     * 图像的宽
     */
    private int width = 180;

    /**
     * 图像的高
     */
    private int height = 60;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置浏览器不缓存
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");

        // 构建图像
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();

        // 1.设置背景色
        setBackground(graphics);

        // 2.设置边框
        setBorder(graphics);

        // 3.画干扰线
        drawRandomLine(graphics);

        // 4.写随机数
        drawRandomNum((Graphics2D) graphics);

        // 5.图形写给浏览器
        response.setContentType("image/jpeg");
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 设置背景色
     *
     * @param graphics 图像
     */
    private void setBackground(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, width, height);
    }

    /**
     * 设置边框
     *
     * @param graphics 图像
     */
    private void setBorder(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(1, 1, width - 2, height - 2);
    }

    /**
     * 画干扰线
     *
     * @param graphics 图像
     */
    private void drawRandomLine(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            int x1 = new Random().nextInt(width);
            int y1 = new Random().nextInt(height);
            int x2 = new Random().nextInt(width);
            int y2 = new Random().nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 写随机数
     *
     * @param graphics 图像
     */
    private void drawRandomNum(Graphics2D graphics) {
        graphics.setColor(Color.GREEN);
        graphics.setFont(new Font("宋体", Font.BOLD, 20));

        String data = "QAZWSXEDCRFVTGBYHNUJMIKOLP";

        int x = 20;
        int y = 40;
        for (int i = 0; i < 4; i++) {
            int degree = new Random().nextInt() % 30;//-30 到 30
            String str = String.valueOf(data.charAt(new Random().nextInt(data.length())));
            graphics.rotate(degree * Math.PI / 180, x, y);
            graphics.drawString(str, x, y);
            graphics.rotate(-degree * Math.PI / 180, x, y);
            x += 40;
        }
    }

}
