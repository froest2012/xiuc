package net.xiuc.tq;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.xiuc.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by 秀川 on 16/7/12.
 */
public class PinyinMain {

    private static final Logger logger = LoggerFactory.getLogger(PinyinMain.class);
    private static FileUtil fileUtil = FileUtil.fileUtil;

    public static void main(String[] args) {
        PinyinMain main = new PinyinMain();
        Map<String, String> map = main.readFromFile("/Users/xiuc/Documents/management/搜索/pinyin/tqmall_pinyin_extend");
        List<String> list = Lists.newArrayList();
        for (Map.Entry entry : map.entrySet()) {
            list.add(entry.getKey() + " " + entry.getValue());
        }
        Collections.sort(list);
        fileUtil.writeToFile(list, "/Users/xiuc/Documents/management/搜索/pinyin/res_tqmall_pinyin_extend", false);
    }

    /**
     * read file content from given path
     * @param path
     * @return
     */
    public Map<String, String> readFromFile(String path){
        Map<String, String> map = Maps.newHashMap();
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try{
            br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            while((line = br.readLine()) != null){
                String[] tmp = line.split(" ");
                if(tmp.length > 1 && SearchPolyphoneUtil.isPolyphone(tmp[0])) {
                    map.put(tmp[0], tmp[1]);
                }
            }
        }catch (FileNotFoundException e) {
            logger.error("read file error:",e);
        } catch (IOException e) {
            logger.error("I/O error:", e);
        } finally {
            try{
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                logger.error("close BufferedRead error:", e);
            }
        }
        return map;
    }
}
