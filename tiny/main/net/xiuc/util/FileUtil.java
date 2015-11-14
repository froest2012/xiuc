package net.xiuc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.List;

/**
 * file tools
 * Created by xiuc on 15/11/14.
 */
public enum  FileUtil {
    fileUtil;

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * read file content from given path
     * @param path
     * @return
     */
    public String readFromFile(String path){
        if(StringUtils.isEmpty(path)){
            return "";
        }
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try{
            br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            while((line = br.readLine()) != null){
                sb.append(line);
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
        return sb.toString();
    }

    /**
     * 把list中的数据写入到文件中
     * @param list
     */
    public void writeToFile(List<String> list,String path) {
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(new File((path))));
            int i = 0;
            StringBuilder sb = null;
            while (i < list.size()){
                sb = new StringBuilder();
                sb.append(list.get(i)).append("\r\n");
                bw.write(sb.toString());
                i++;
            }
        } catch (IOException e) {
            logger.error("I/O error",e);
        } finally {
            try {
                if(bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                logger.error("close BufferedWrite error",e);
            }
        }
    }
}
