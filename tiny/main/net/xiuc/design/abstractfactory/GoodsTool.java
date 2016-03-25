package net.xiuc.design.abstractfactory;

/**
 * Created by 秀川 on 16/3/25.
 */
public class GoodsTool implements IGoods {
    @Override
    public void insert(Goods goods) {
        System.out.println("向goods表插入一条数据");
    }
}
