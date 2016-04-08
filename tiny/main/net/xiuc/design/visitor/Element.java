package net.xiuc.design.visitor;

/**
 * Created by 秀川 on 16/4/8.
 */
public interface Element {
    void accept(Visitor visitor);
}
