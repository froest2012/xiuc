package net.xiuc.design.abstractfactory;

/**
 * Created by 秀川 on 16/3/25.
 */
public class CommonFactory implements IFactory {
    @Override
    public IProduct createProduct() {
        return new ProductFruit();
    }

    @Override
    public IGoods createGoods() {
        return new GoodsTool();
    }
}
