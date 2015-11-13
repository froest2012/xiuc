package net.xiuc.tiny;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 千里码 囍刷刷，天真的我居然相信了提示
 * http://www.qlcoder.com/task/7581
 * <p/>
 * Created by 秀川 on 2015-11-02.
 * God bless me!
 * No bugs!
 */
public class FindTheCode {

    private static final Logger logger = LoggerFactory.getLogger(FindTheCode.class);

    private static AtomicLong i = new AtomicLong();

    public static void main(String[] args) {
        //        int code = run();
        List<Thread> threads = Lists.newArrayList();
        for (int j = 0; j < 1000; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String str = "20151102xiuchuan1";
                    try {
                        MessageDigest MD5 = MessageDigest.getInstance("MD5");
                        while (true) {
                            long j = i.getAndAdd(1L);
                            str += j;
                            MD5.update(str.getBytes());
                            byte[] res = MD5.digest();
                            String result = new String(res, "UTF-8");
                            if (result.startsWith("000000")) {
                                logger.info("验证码为：" + j);
                                System.out.println("====================验证码为：" + j);
                                break;
                            }
                        }
                    } catch (NoSuchAlgorithmException e) {
                        logger.error("MD5加密解密失败:", e);
                    } catch (UnsupportedEncodingException e) {
                        logger.error("编码错误:", e);
                    }
                }
            });
//            thread.setDaemon(true);
            threads.add(thread);
        }
        for (int j = 0; j < 1000; j++) {
            threads.get(j).start();
        }
        System.out.println(Thread.activeCount());
        //        logger.info("我今天的验证码是"+i.get());
    }

    private static void start() {
        String str = "20151102xiuchuan1";
        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            while (true) {
                long j = i.getAndAdd(1L);
                str += j;
                MD5.update(str.getBytes());
                byte[] res = MD5.digest();
                String result = new String(res, "UTF-8");
                if (result.startsWith("000000")) {
                    logger.info("验证码为：" + j);
                    System.out.printf("验证码为：" + j);
                    break;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5加密解密失败:", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("编码错误:", e);
        }
    }


}
