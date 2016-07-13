package net.xiuc.tq;

import javafx.scene.control.Separator;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 秀川 on 16/7/11.
 */
public class SgPinyinParse {

    public static void main(String[] args) throws IOException {
        SgPinyinParse parse = new SgPinyinParse();
        File file = new File("/Users/xiuc/Documents/java/scel");
        String[] scelList = file.list();
        for(String str : scelList) {
            parse.sogou(file.getAbsolutePath() + File.separator + str);
        }
    }

    private void sogou(String path) throws IOException {
        File file=new File(path);
        SougouScelMdel model = new SougouScelReader().read(file);
        Map<String,List<String>> words = model.getWordMap(); //词<拼音,词>
        Set<Map.Entry<String,List<String>>> set = words.entrySet();
        Iterator<Map.Entry<String,List<String>>> iter = set.iterator();
        while(iter.hasNext()){
            Map.Entry<String,List<String>> entry = iter.next();
            String key = entry.getKey().replaceAll("'", ",");
            List<String> list = entry.getValue();
            int size = list.size();
            for(int i = 0; i < size; i++){
                String word = list.get(i);
                System.out.print(word + " (" + key + ")");
                System.out.println();
            }
        }
    }

}
