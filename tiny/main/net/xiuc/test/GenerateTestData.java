package net.xiuc.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.xiuc.util.FileUtil;
import net.xiuc.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by xiuc on 15/11/13.
 */
public class GenerateTestData {

    private static final Logger logger = LoggerFactory.getLogger(GenerateTestData.class);

    FileUtil fileUtil = FileUtil.fileUtil;
    StringUtil stringUtil = StringUtil.stringTools;

    public static void main(String[] args) {
        GenerateTestData gtd = new GenerateTestData();
        gtd.generateTestData();

    }

    public void generateTestData() {
        String firstNames = fileUtil.readFromFile("/Users/xiuc/Documents/work/xiuc/tiny/main/net/xiuc/data/firstName");
        String lastNames = fileUtil.readFromFile("/Users/xiuc/Documents/work/xiuc/tiny/main/net/xiuc/data/lastName");

        List<String> firstNameList = stringUtil.split(firstNames, ",");
        List<String> lastNameList = stringUtil.split(lastNames, ",");

        List<String> nameList = Lists.newArrayList();
        int len = 100000, firstLen = firstNameList.size(), lastLen = lastNameList.size();
        while (nameList.size() < len) {
            Integer firstIndex = (int) (Math.random() * firstLen);
            Integer lastIndex = (int) (Math.random() * lastLen);

            String name = firstNameList.get(firstIndex) + lastNameList.get(lastIndex);
            if (!nameList.contains(name)) {
                nameList.add(name);
            }
        }
        fileUtil.writeToFile(nameList, "/Users/xiuc/Documents/work/xiuc/tiny/main/net/xiuc/data/name");
        logger.info("生成名字成功");

    }
}
