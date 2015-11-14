package net.xiuc.util;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.StringTokenizer;

/**
 * String tools
 * Created by xiuc on 15/11/14.
 */
public enum StringUtil {
    stringTools;

    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public List<String> split(String src,String regex){
        StringTokenizer st = new StringTokenizer(src,regex);
        List<String> strList = Lists.newArrayList();
        while(st.hasMoreElements()){
            strList.add(String.valueOf(st.nextElement()));
        }
        return strList;
    }
}
