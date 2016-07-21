package net.xiuc.tq;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.xiuc.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * Created by 秀川 on 16/7/5.
 */
public class SearchPolyphoneUtil {
    private static final Logger logger = LoggerFactory.getLogger(SearchPolyphoneUtil.class);
    public static final String OTHERPATH = "/Users/xiuc/Documents/management/搜索/other_data";
    public static final String SOURCEPATH = "/Users/xiuc/Documents/management/搜索/pinyin_data";
    public static final String DESTPATH = "/Users/xiuc/Documents/management/搜索/dest_data";
    public static final String SOURCEPATH2 = "/Users/xiuc/Documents/management/搜索/pinyin_data2";
    public static final String DESTPATH2 = "/Users/xiuc/Documents/management/搜索/dest_data2";

    private static FileUtil fileUtil = FileUtil.fileUtil;

    public static void main(String[] args) {
        //遍历pinyin_data数据文件,去除商品名称中的规格型号,把商品名称中不包含规格型号字符串第一个子串的商品保存到other_data,其他的保存到set
        //把set中的商品信息保存到dest_data
        readFromFile(SearchPolyphoneUtil.SOURCEPATH);
//        readFromFile2(SOURCEPATH);
    }

    private static void readFromFile2(String path) {
        Map<String, String> result = Maps.newHashMap();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(path)));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] tmpArr = line.split(" ");
                if(tmpArr[0].contains("三角窗内装饰")) {
                    System.out.println();
                }
                if (!result.containsKey(tmpArr[0]) && isPolyphone(tmpArr[0])) {
                    result.put(tmpArr[0], line);
                }
            }
            List<String> res = Lists.newArrayList();
            for (String str : result.values()) {
                res.add(str);
            }
            Collections.sort(res);
            fileUtil.writeToFile(res, DESTPATH2, false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readFromFile(String path) {
        BufferedReader br = null;
        Set<String> goodsNameWithOutGoodsFormat = Sets.newHashSet();
        List<String> result = Lists.newArrayList();
        try {
            br = new BufferedReader(new FileReader(new File(path)));
            StringBuilder sb = new StringBuilder();
            String line = "";
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i % 100 == 0 || i > 70000) {
                    logger.info(i + "");
                }
                String[] tmpArr = line.split(",");
                String shortName = tmpArr[0];
                if (tmpArr.length > 1 && tmpArr[1] != null) {
                    String[] goodsFormatArr = tmpArr[1].split(" ");
                    for (int j = 0; j < goodsFormatArr.length; j++) {
                        if (tmpArr[0].contains(goodsFormatArr[j])) {
                            shortName = tmpArr[0].substring(0, tmpArr[0].indexOf(goodsFormatArr[j]));
                        }
                    }
                }
                if (shortName != null) {
                    StringTokenizer tokenizer = new StringTokenizer(shortName, " ");
                    while (tokenizer.hasMoreElements()) {
                        String tmp = tokenizer.nextToken();
                        if (isPolyphone(tmp)) {
                            goodsNameWithOutGoodsFormat.addAll(splitStrWithKuohao(tmp));
                        }
                    }
                }
                i++;
            }

            for (String str : goodsNameWithOutGoodsFormat) {
                if (str.charAt(str.length() - 1) == '）' || str.charAt(str.length() - 1) == ')') {
                    int end = str.indexOf("）");
                    if (end == -1) {
                        end = str.indexOf(")");
                    }
                    str = str.substring(0, end);
                }
                char lastCh = str.charAt(str.length() - 1);
                if (lastCh <= 128) {
                    str = str.substring(0, str.length() - 1);
                }
                str += " " + convertToSpell(str) + "";
                result.add(str);
            }
//            fileUtil.writeStrToFile(sb.toString(), OTHERPATH, false);
            fileUtil.writeToFile(result, "/Users/xiuc/Documents/management/搜索/dest_data4", false);
        } catch (FileNotFoundException e) {
            logger.error("read file error:", e);
        } catch (IOException e) {
            logger.error("I/O error:", e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                logger.error("close BufferedRead error:", e);
            }
        }
    }

    public static boolean isPolyphone(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String[] tmp = PinyinHelper.toHanyuPinyinStringArray(ch);
            if (tmp != null && tmp.length > 1) {
                String th1 = tmp[0].substring(0, tmp[0].length() - 1);
                for (int j = 1; j < tmp.length; j++) {
                    String thn = tmp[j].substring(0, tmp[j].length() - 1);
                    if (!th1.equals(thn)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    private static Set<String> splitStrWithKuohao(String str) {
        Set<String> tmp = Sets.newHashSet();
        if (str.contains("(") || str.contains("（")) {
            int start = str.indexOf("(");
            if (start == -1) {
                start = str.indexOf("（");
            }
            String tmpStr = str.substring(0, start);
            if (isHanyu(tmpStr)) {
                tmp.add(tmpStr);
            }
            if (str.contains(")") || str.contains("）")) {
                int end = str.indexOf(")");
                if (end == -1) {
                    end = str.indexOf("）");
                }
                tmpStr = str.substring(start + 1, end);
                if (isHanyu(tmpStr)) {
                    tmp.add(tmpStr);
                }
            } else {
                tmpStr = str.substring(start + 1);
                if (isHanyu(tmpStr)) {
                    tmp.add(tmpStr);
                }
            }
        } else {
            if (isHanyu(str)) {
                tmp.add(str);
            }
        }
        return tmp;
    }

    private static boolean isHanyu(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 128) {
                return true;
            }
        }
        return false;
    }

    public static String convertToFirstSpell(String chines) {
        StringBuilder pinyinName = new StringBuilder();
        char[] nameChar = chines.toCharArray();
        for (int i = 0; i < nameChar.length; i++) {
            char ch = nameChar[i];
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || Character.isWhitespace(ch)) {
                pinyinName.append(nameChar[i]);
            } else if (!Character.isWhitespace(ch)) {
                try {
                    String[] pinyinArr = PinyinHelper.toHanyuPinyinStringArray(ch, new HanyuPinyinOutputFormat());
                    if (pinyinArr != null && pinyinArr.length > 0 && pinyinArr[0].length() > 0) {
                        pinyinName.append(pinyinArr[0].charAt(0));
                    }
                } catch (Exception e) {
                    logger.error(chines, e);
                }
            }
        }
        return pinyinName.toString();
    }

    public static String convertToSpell(String chines) {
        StringBuilder pinyinName = new StringBuilder();
        char[] nameChar = chines.toCharArray();
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    String[] pinyinArr = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], new HanyuPinyinOutputFormat());
                    if (pinyinArr == null || pinyinArr.length == 0) {
                        continue;
                    }
                    String pinyin = pinyinArr[0];
                    //首字母大写
                    pinyin = String.valueOf(pinyin.charAt(0)).toLowerCase() + pinyin.substring(1, pinyin.length());
                    char c = pinyin.charAt(pinyin.length() - 1);
                    if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))){
                        pinyin = pinyin.substring(0, pinyin.length() - 1);
                    }
                    if (i > 0) {
                        pinyinName.append(",");
                    }
                    pinyinName.append(pinyin);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName.append(String.valueOf(nameChar[i]).toLowerCase());
            }
        }
        return pinyinName.toString();
    }
}

