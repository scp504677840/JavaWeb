package one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Tool {

    /**
     * 远程校验cookie是否合法
     *
     * @param checkUrl    校验的URL地址
     * @param cookieName  cookie名称
     * @param cookieValue cookie值
     * @return cookie是否合法
     */
    public static boolean doCheckCookie(String checkUrl, String cookieName, String cookieValue) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL(checkUrl + "?cookieName=" + cookieName + "&cookieValue=" + cookieValue);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            InputStream in = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String temp = null;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            isr.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //当出异常时，关闭连接
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        System.out.println("------Tool------cookie是否合法：" + sb);
        return "true".equalsIgnoreCase(sb.toString());
    }

}
