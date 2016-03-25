package net.xiuc.design.abstractfactory;

/**
 * Created by 秀川 on 16/3/25.
 */
public interface IFactory {
    IProduct createProduct();
    IGoods createGoods();
}
