package net.xiuc.design.responsibilitychain;

/**
 * Created by 秀川 on 16/4/5.
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void request(int i) {
        if(i >= 10 && i < 20){
            System.out.println("i >= 10 && i < 20");
        }else{
            getNext().request(i);
        }
    }
}
