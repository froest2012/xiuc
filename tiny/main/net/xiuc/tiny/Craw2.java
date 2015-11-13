package net.xiuc.tiny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 千里码 http://www.qlcoder.com/task/7563
 * Created by xiuc on 15/11/12.
 */
public class Craw2 {

    private static final Logger logger = LoggerFactory.getLogger(HttpRequest.class);

    public static void main(String[] args){
        Craw2 httpRequest = new Craw2();
        httpRequest.resolve("http://www.qlcoder.com/train/secret");
    }

    public void resolve(String urlStr){
        if(urlStr == null) return;
        HttpURLConnection conn = null;
        URL url;
        try {
            url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Host", "www.qlcoder.com");
            conn.setRequestProperty("Referer", "http://www.qlcoder.com/task/7563");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            conn.setRequestProperty("Cache-Control", "max-age=0");
            conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.setRequestProperty("Origin", "http://www.qlcoder.com");
            conn.setRequestProperty("User-Agent", "qlcoder spider");
            conn.setRequestProperty("Cookie", "remember_82e5d2c56bdd0811318f0cf078b78bfc=eyJpdiI6Iml5R09lXC8yNWZLdXY2YXlsTncxc053PT0iLCJ2YWx1ZSI6Ikk1OEV4NXY3UDZNa2crVUtKU2pmaCtnZmxDSkJ2Wm10bVQwVUFyQU94YUF2MGpMMzczVzQ5VmJTajVDTVJrRDZCU3Zaa2ZPK096T01jS2ZPZFVKT0VpTmxIXC9vTFg1QzNCRFwvWSsrYkZ2TWM9IiwibWFjIjoiYTJmYWE4Yjc1NzNiM2I4M2JkNDRiN2RjY2I2MTNmODk5M2M5NDc4NzAwMjFmOTY2YWY5NDA4MTEwNzUxMjU4YyJ9;这题的答案是oreo=eyJpdiI6IkNBYzM3TjQxbjd2QTdpSzVuWkJwMFE9PSIsInZhbHVlIjoiRVpJYUFidGxVdXptQ3ZiUitra2xVUT09IiwibWFjIjoiZDIzNzJhZjU3NDIxMjY5ZTAyZTE1N2Y1ZTI2OWMxNDFhOTAwZDI2Mzc4NTQ3NjIxZjY5Yzc5ZTA1ZDg1ZmIyMiJ9; Hm_lvt_420590b976ac0a82d0b82a80985a3b8a=1446795696,1446946471,1447170416; Hm_lpvt_420590b976ac0a82d0b82a80985a3b8a=1447288151; XSRF-TOKEN=eyJpdiI6IkFQWEZnRms4QjBjT0lVQzVkQVR1Vmc9PSIsInZhbHVlIjoiSUlIbFZDSkd1NXBYSXBtd2dBMlozS09acVYxQldOUFN2cElHNnExZ0MwRHVkNndDdHVhd1VSbWFJaERkaVV3a1dYcm02QmQ2SkRNYUx3ZkVUaTRwNEE9PSIsIm1hYyI6IjJkMWI0YTIxYzdjZjkyMTVjOWViMmNhMTU0YWMyYzcwZTk0ZGQ3ZjkyZjQyNjEyYjE3ZWFjMjI2MGU4ZDdjZGMifQ%3D%3D; laravel_session=eyJpdiI6IjJvWGorYTNQbGl0Ykp4TFRwN0tCVUE9PSIsInZhbHVlIjoibFA4djlkMm50aVdMWlZudnhtbFlVZzJwd3QxckFiU0RhdncyN09SQUdIdEVUN05GQnl2cjZsbnpqZXRTNndpOGhXRUVSaDRkKytydW9kZDR1S2UzUFE9PSIsIm1hYyI6ImE3Y2M2ZmFhNjQ3NzdjNGE2ZjhjZDExMzM3NDFjODY4MjIxNjdjYmEwNzM3YTcxYTc2ZDYxNmJhYzViYzMzNWEifQ%3D%3D");
            conn.connect();
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
