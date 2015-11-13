package net.xiuc.tiny;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

/**
 * 输入一个文件夹，查找到文件夹中最大的文件，并获取到其中的内容
 * <p/>
 * http://www.qlcoder.com/task/755a
 * <p/>
 * Created by 秀川 on 2015-10-31.
 * God bless me!
 * No bugs!
 */
public class FindMaxFile {

    private static final Logger logger = LoggerFactory.getLogger(FindMaxFile.class);

    public static void main(String[] args) {
        String path = "/Users/froest2012/Downloads/root";
        File file = new File(path);
        //遍历文件夹获取所有的文件
        List<File> list = Lists.newArrayList();
        searchAllFiles(file, list);
        file = getMaxFile(list);
        String content = readerFileContent(file);
        logger.info("the content in the max size of file is :" + content);
    }

    /**
     * 读取文件内容
     *
     * @param file 待读取的文件
     * @return 返回文件内容
     */
    private static String readerFileContent(File file) {
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        } catch (IOException e) {
            logger.error("read file failure", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                logger.error("close BufferedReader failure", e);
            }
        }
        return "";
    }

    /**
     * 比较文件内容大小
     * <p/>
     * 传入所有文件的list，遍历这些文件，比较文件的大小
     * 获取到文件内容最大的文件
     *
     * @param list
     * @return
     */
    private static File getMaxFile(List<File> list) {
        FileInputStream in = null;
        FileInputStream tmpIn = null;
        try {
            if (list != null && list.size() > 0) {
                File file = list.get(0);
                if (list.size() == 1) {
                    return file;
                }
                in = new FileInputStream(file);
                long maxLen = in.available();
                for (int i = 1; i < list.size(); i++) {
                    File file1 = list.get(i);
                    try {
                        tmpIn = new FileInputStream(file1);
                        long tmpLen = tmpIn.available();
                        if (tmpLen > maxLen) {
                            file = file1;
                            maxLen = tmpLen;
                        }
                    }finally {
                        if(tmpIn != null){
                            tmpIn.close();
                        }
                    }
                }
                return file;
            }
        }catch (IOException e){
            logger.error("open file failure",e);
        }finally {
            try{
                if(in != null){
                    in.close();
                }
            }catch (Exception e){

            }
        }
        return null;
    }

    /**
     * 尾递归
     * <p/>
     * 遍历文件夹，如果是文件，添加到list中
     * 如果是文件夹，继续遍历
     *
     * @param file 传入的文件
     * @param list 保存遍历到的文件的list
     */
    private static void searchAllFiles(File file, List<File> list) {
        if (file.isFile()) {
            list.add(file);
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    searchAllFiles(file1, list);
                }
            }
        }
    }

}
