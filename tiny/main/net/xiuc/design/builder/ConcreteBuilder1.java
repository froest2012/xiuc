package net.xiuc.design.builder;

/**
 * Created by 秀川 on 16/3/22.
 */
public class ConcreteBuilder1 implements Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.addPart("part A");
    }

    @Override
    public void buildPartB() {
        product.addPart("part B");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
