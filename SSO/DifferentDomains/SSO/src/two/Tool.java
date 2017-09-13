package two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Tool {

    /**
     * 远程校验cookie是否合法
     *
     * @param checkUrl 校验的URL地址
     * @param map      参数
     * @return cookie是否合法
     */
    public static boolean doCheckCookie(String checkUrl, Map<String, String> map) {

        StringBuilder sb = new StringBuilder();
        HttpURLConnection httpURLConnection = null;

        try {
            //组装URL
            StringBuilder sb_url = new StringBuilder();
            sb_url.append(checkUrl);
            sb_url.append("?");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb_url.append(entry.getKey());
                sb_url.append("=");
                sb_url.append(entry.getValue());
                sb_url.append("&");
            }
            //去掉最后的 & 符号
            checkUrl = sb_url.substring(0, sb_url.length() - 1);

            URL url = new URL(checkUrl);

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
