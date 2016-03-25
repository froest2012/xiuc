package net.xiuc.design.abstractfactory;

/**
 * Created by 秀川 on 16/3/25.
 */
public class ProductFruit implements IProduct {
    @Override
    public void insert(Product product) {
        System.out.println("向product表插入一条数据");
    }
}
