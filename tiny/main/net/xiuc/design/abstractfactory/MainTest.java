package net.xiuc.design.abstractfactory;

/**
 * Created by 秀川 on 16/3/25.
 */
public class MainTest {
    public static void main(String[] args) {
        IFactory factory = new CommonFactory();

        IProduct product = factory.createProduct();
        product.insert(new Product());

        IGoods goods = factory.createGoods();
        goods.insert(new Goods());

    }
}
