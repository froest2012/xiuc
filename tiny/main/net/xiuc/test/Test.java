package net.xiuc.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiuc on 15/11/30.
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args){
        long i = 1L<<(64-46);
        logger.info(""+getLen(4294967297L));
        logger.info(""+bitString(4294967297L));
    }

    private static String bitString(long a){
        String str = Long.toBinaryString(a);
        if(str.length() < 64){
            int len = 64 - str.length();
            int i = 0;
            while(i++ < len){
                str = "0" + str;
            }
        }
        return str;
    }

    private static long getLen(long t){
        long cnt = 0;
        int k = 0;
        while(k < 64){
            long x = t & (1L << (64-k));
            if(x != 0){
                cnt++;
            }
            k++;
        }
        return cnt;
    }
}
