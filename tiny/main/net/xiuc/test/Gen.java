package net.xiuc.test;

import com.google.common.collect.Maps;
import net.xiuc.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.Map;

/**
 * 千里码 访客统计2
 * http://www.qlcoder.com/task/758a
 */
public class Gen {
    private static FileUtil fileUtil = FileUtil.fileUtil;
    private static final Logger logger = LoggerFactory.getLogger(Gen.class);

    private static final long twist(long u, long v) {
        return (((u & 0x80000000L) | (v & 0x7fffffffL)) >> 1) ^ ((v & 1) == 1 ? 0x9908b0dfL : 0);
    }

    private long[] state = new long[624];
    private int left = 1;

    public Gen() {
        for (int j = 1; j < 624; j++) {
            state[j] = (1812433253L * (state[j - 1] ^ (state[j - 1] >> 30)) + j);
            state[j] &= 0xffffffffL;
        }
    }

    public void next_state() {
        int p = 0;
        left = 624;
        for (int j = 228; --j > 0; p++)
            state[p] = state[p + 397] ^ twist(state[p], state[p + 1]);

        for (int j = 397; --j > 0; p++)
            state[p] = state[p - 227] ^ twist(state[p], state[p + 1]);

        state[p] = state[p - 227] ^ twist(state[p], state[0]);
    }

    public long next() {
        if (--left == 0) next_state();
        return state[624 - left];
    }

    public static void main(String[] args) {
        Gen rand = new Gen();
        long[] bukits = new long[67108865];
//        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < 5000000000L; i++) {
//            sb.append(rand.next()).append("\r\n");
//            if (i != 0 && i % 100000 == 0) {
//                fileUtil.writeStrToFile(String.valueOf(sb), "/Users/xiuc/Document s/work/xiuc/tiny/main/net/xiuc/data/fk2", true);
//                sb = new StringBuilder();
//            }
            long tmp1 = i / 64,tmp2 = i % 64;
            int index = Integer.valueOf(String.valueOf(tmp1));
            long off = 1L<<(64-tmp2);
            bukits[index] = bukits[index] | off;
        }
        long cnt = 0;
        for(int i = 0; i < 67108864; i++){
            long t = bukits[i];
//            String tmp = rand.bitString(t);
            cnt += rand.getLen(t);
        }
        logger.info("用户数有:"+cnt);
        logger.info("答案:");
    }

    private String bitString(long a){
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

    private long getLen(long t){
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
