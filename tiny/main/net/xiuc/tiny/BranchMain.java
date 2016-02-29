package net.xiuc.tiny;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 千里码 处理分支类的方法调用
 * http://www.qlcoder.com/task/758d
 *
 * Created by xiuc on 15/11/9.
 */
public class BranchMain {
    private static final Logger logger = LoggerFactory.getLogger(BranchMain.class);
    private static List<String> lines = Lists.newArrayList();//记录所有的行信息
    private static Map<String,String> values = Maps.newHashMap();//记录所有直接返回值的方法的值
    private static StringBuilder sb = new StringBuilder();
    private static String line1 = "";//把return处理以后的返回去除" paramLong ="
    /**
     * 用反射的方式把这个类中的所有返回一个数字的方法找出来放到一个map中
     * 遍历所有的方法,如果方法的实现中出现map中的方法,则用map中的数据替代
     * 生成新的类
     */
    public static void main(String[] args){
        readBranches();
        replaceMethod();
        removeMethods();
    }

    private static void removeMethods() {
        for(String method : values.keySet()){
            String str = null;
            do{
                int from = str == null ? 0 : sb.indexOf(str)+str.length();
                str = sb.substring(sb.indexOf(method + "(",from),sb.indexOf(")",sb.indexOf(method + "(",from)+method.length() + 1)+1);
            }while(!str.contains("long"));
            int index = sb.indexOf("long"+str+" {");
            int to = sb.indexOf("}",index+("long"+str+" {").length())+1;
//            str = sb.substring(index,to);
            sb.replace(index,to,"");
        }
        System.out.println(sb);
    }

    private static void replaceMethod() {
        for(String method:values.keySet()){
//            if(method.equals(" e5")){
//                System.out.println();
//            }
            String str = null;
            do{
                int from = str == null ? 0 : sb.indexOf(str)+str.length();
                str = sb.substring(sb.indexOf(method + "(",from),sb.indexOf(")",sb.indexOf(method + "(",from)+method.length() + 1)+1);
            }while(str.contains("long"));
            if(method.equals(" pe")){
                System.out.println();
            }
            if(str != null && (str.matches("^"+method+"\\(\\w*\\)$") || str.matches("^"+method+"\\(\\w* ?[\\+\\-\\*\\/\\%\\^\\|\\&]? ?\\d*L\\)$"))){
                System.out.println("'"+str+"' replace to : '" + values.get(method));
                sb = sb.replace(sb.indexOf(str),sb.indexOf(str) + str.length()," "+values.get(method));
            }
        }
    }

    /**
     * 把branches读取到内存中以字符串的形式存储
     * @return 返回StringBuilder
     */
    private static void readBranches() {
        File file = new File("/Users/xiuc/Documents/work/xiuc/tiny/main/net/xiuc/tiny/Branches1.java");
        BufferedReader br = null;
        String line = "";
        String methodName = "";
        try {
            int flag = 0;
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null){
                line1 = line;
                if(line.contains("long paramLong")){
                    if(line.contains(" pe")){
                        System.out.println();
                    }
                    methodName = readMethodName(line);
                    flag++;
                }else if(flag % 2 == 1) {
                    String value = readValue(line);
                    if(value != null && !values.containsKey(methodName)){
                        values.put(methodName,value);
                    }
                    flag = 0;//处理完成以后标志复位
                }
                sb.append(line1).append("\r\n");
                lines.add(line1);//所有的行记录下来
            }
        } catch (FileNotFoundException e) {
            logger.error("文件没找到",e);
        } catch (IOException e) {
            logger.error("IO异常",e);
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error("关闭BufferedReader异常", e);
                }
            }
        }
//        System.out.println(sb);
    }

    /**
     * 获取方法名称
     * @param line
     * @return
     */
    private static String readMethodName(String line) {
        return line.substring(line.indexOf("long") + "long".length(), line.indexOf("("));
    }

    /**
     * 获取直接返回数值的方法的值
     * @param line
     * @return
     */
    private static String readValue(String line) {
        if(line.contains("return")){
            if(line.contains(" paramLong =")){
                line = line.replace(" paramLong =","");
            }
            String str = line.substring(line.indexOf("return") + "return".length(), line.indexOf(";")+1).trim();
            if(str.matches("\\d*L;")||str.matches("^\\d*L ?[\\+\\-\\*\\/\\%\\^\\|\\&]? ?\\d*L;$")){//TODO
                return str.substring(0,str.indexOf(";"));
            }

        }
        line1 = line;
        return null;
    }


}
