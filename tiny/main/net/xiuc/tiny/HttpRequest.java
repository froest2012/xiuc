package net.xiuc.tiny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 千里码 http://www.qlcoder.com/task/754e
 * 模拟http请求
 * Created by xiuc on 15/11/10.
 */
public class HttpRequest {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequest.class);

    public static void main(String[] args){
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.resolve("http://www.qlcoder.com/task/17/solve");
    }

    public void resolve(String urlStr){
        if(urlStr == null) return;
        HttpURLConnection conn = null;
        URL url;
        try {
            url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);//post请求需要把参数放在body中传到服务器
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Referer", "http://cpc.people.com.cn/");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Content-Length", "62");
            conn.setRequestProperty("Host", "www.qlcoder.com");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.setRequestProperty("Origin", "http://www.qlcoder.com");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36");
            conn.setRequestProperty("Cookie", "XSRF-TOKEN=eyJpdiI6Imp3eW5TMm44OUh2VlRrYk1VWFwvdEJnPT0iLCJ2YWx1ZSI6ImszY2owUERremZ4Y1l0YlNvMVBsU05aUzZjRVhCQlVyb0VMSU8wUmt2NWdubVJLUk5MVnRIdzh1Wjd5V2hBNmRBVUE1a095cFpQVVo2aXJxTGdiRWJnPT0iLCJtYWMiOiIyYjI5YzRlNzc4MzA2NzllOTMzMTRlZjY5MzFhNWE5YWYwMzQ0MTIxMWU3NTk2OTZmZGQwZjAzMjU5N2FkOTJkIn0%3D; laravel_session=eyJpdiI6InZlSjB3cEh5UHVkYWJpZ01NcnVGaUE9PSIsInZhbHVlIjoiK2dwekRxN1Vnb1BTdnVLVlNHWVUwVFVlU3pjekxXR3hKaDJubmNlbTBnWEtFaFJ4XC9HT2tOdFpcLzBoU0ZlOWJPM1dtZ1BjQ0xlaWlkbWJSSFZFSU9pdz09IiwibWFjIjoiNDJiNTBmMjFkOTVjOThhZmU4NWYwZmI2ZTNiZTM0NGYwZDgxMTEyOGI4MGQxNjZkNzRiMWQxMGUyY2NjYjY3NCJ9;这题的答案是oreo=eyJpdiI6IllwdE94czFJXC92WXRCSmRkc092emJ3PT0iLCJ2YWx1ZSI6ImxZZEx1Y1d4MFdHR1k5WUpxTDBOZXc9PSIsIm1hYyI6IjMzYWZhNjJiOGRmMGRmZTY3YjIxZjY0NzlhYjE4YjMxZTczNDIxNTNhYjA4ZjgxMjg1N2M0YjI2ODk0Y2M1ZDEifQ%3D%3D; Hm_lvt_420590b976ac0a82d0b82a80985a3b8a=1446795696,1446946471,1446949896; Hm_lpvt_420590b976ac0a82d0b82a80985a3b8a=1447165087");
            conn.connect();
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            String content = "_token=hKbpuS5JPpMqijgc64OAYO1KTWhkPaGFUHf09Qv6&answer=referer";
            out.writeBytes(content);
            out.flush();
            out.close();
            BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line = "";
            while ((line = bf.readLine()) != null){
                System.out.println(line);
            }
            bf.close();
        }catch (Exception e){
            logger.error("请求异常:",e);
            System.out.println(e);
        }finally {
            if(conn != null) {
                conn.disconnect();
            }
        }
    }
}
