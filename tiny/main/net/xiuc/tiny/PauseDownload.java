package net.xiuc.tiny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 千里码 断点续传
 * http://www.qlcoder.com/task/754b
 *
 * 考点:http请求Range:bytes=1-100(文件的第1个字节到第100个字节)
 *
 * Created by xiuc on 15/11/27.
 */
public class PauseDownload {

    private static final Logger logger = LoggerFactory.getLogger(PauseDownload.class);

    public static void main(String[] args){
        PauseDownload p = new PauseDownload();
        p.resolve("http://qlcoder.com/download/hugefile");
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
            conn.setRequestProperty("Range", "bytes=12345678901-12345678999");
            conn.setRequestProperty("Cookie", "remember_82e5d2c56bdd0811318f0cf078b78bfc=eyJpdiI6IlJMRG50M3VNTkxDWmpDXC83YXVqMTBRPT0iLCJ2YWx1ZSI6IkhHMEg1VCtTUVFweStzaGlveXR4UEU1bVJ6V2VmVVo4XC9ESUJwXC9aMGpXekRvelZSZzZMMkxDRU9IZmhuUmNnSW83M0s4OUFTK2Rrd1wvYlh0VEcxRTZ3UzRiMjFWbm93QmlSS2lJaUR5UGlNPSIsIm1hYyI6IjFjOTA5ZWQ5MDBmNmFiZGRhYmY1NzA5OTczMjgzZTg3YWUzZjhiNmZiMDVhYWI5M2E1YzFlOGY4OTFkODMzZDAifQ%3D%3D; 这题的答案是oreo=eyJpdiI6IkVGazEzZnpTaks3dVZUQXl4WlBySlE9PSIsInZhbHVlIjoieTAyZWV6XC9IVVpQcVwvMk5PNnRDSWxRPT0iLCJtYWMiOiJhMTM1NmZiNjczZjZhNTIyNGNhZDdlOTIxODY2MjA1YmI5ZjU3OTI3MzUyN2Y1OGFlOWIwNzU2MGZmODQyZDY5In0%3D; Hm_lvt_420590b976ac0a82d0b82a80985a3b8a=1446795696,1446946471,1447170416; Hm_lpvt_420590b976ac0a82d0b82a80985a3b8a=1448787000; XSRF-TOKEN=eyJpdiI6IjNYVTdBVFU4bm1LN3o5enZSaE5JMlE9PSIsInZhbHVlIjoiVEVJaWM0OWcyMHpkazNnMWJBV0NuN2tJdUxGdmFVam5RNEh4M25HQXBlK3dCSDlNOERFYXdydE5PV3E5XC81Zmd1aWJZbktudFBYSEFQcXhsOERPUHhnPT0iLCJtYWMiOiI1OTBkZWU5ZWZlZWEwM2M3M2QyMTkyODc0MzNlOGMwNTc0NTljMjEzNWRlN2ZlMjIzNTRjMTJjMmVkMzRiMzc0In0%3D; laravel_session=eyJpdiI6IjUzNUdPNDlqMklvVkZ1ZXU2OEl2anc9PSIsInZhbHVlIjoiQUxXdzFIZitSY1wvNnk4ZVwvZ25TdzBIZ3FoWUVlbHJVd0tCTURJXC92ZklEVWVHeDd2NCtPQXJqTEVRYjlmbWxadURSSXhqRzlcL0NMOWtrRFhVYytseExRPT0iLCJtYWMiOiI2ZWYzNDY0NzM5MGQ3MzRhYTg0Yzk2MzljOWI1NWQ3MThiNDgwNmJhN2M2ZTE1NTA5ZDg1YjRmNmU4OWU5ZjBjIn0%3D");
            conn.connect();

            BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line = "";
            while ((line = bf.readLine()) != null){
                logger.info(line,"\r\n");
            }
            bf.close();
        }catch (Exception e){
            logger.error("请求异常:",e);
        }finally {
            if(conn != null) {
                conn.disconnect();
            }
        }
    }}
