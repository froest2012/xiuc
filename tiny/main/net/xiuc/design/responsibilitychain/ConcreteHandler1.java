package net.xiuc.design.responsibilitychain;

/**
 * Created by 秀川 on 16/4/5.
 */
public class ConcreteHandler1 extends Handler {

    @Override
    public void request(int i) {
        if(i < 10){
            System.out.println("i < 10");
        }else{
            getNext().request(i);
        }
    }
}
