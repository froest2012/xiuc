package net.xiuc.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 测试从list获取子列表把元素删除以后list中的元素是否存在
 *
 * 子列表中的元素删除以后父list中的元素也删除了
 * Created by 秀川 on 16/5/13.
 */
public class SubListRemoveTest {
    public static void main(String[] args) {
        List<String> tmp = Lists.newArrayList();
        tmp.add("a");
        tmp.add("b");
        tmp.add("c");
        tmp.add("d");

        List<String> sub = tmp.subList(0, 2);
        sub.clear();

        for (String s: tmp){
            System.out.println(s);
        }
    }
}
