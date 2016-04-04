package net.xiuc.design.bridge;

/**
 * Created by 秀川 on 16/4/4.
 */
public class Abstractor {

    private Implemetor implemetor;

    public void setImplemetor(Implemetor implemetor){
        this.implemetor = implemetor;
    }

    public void operate(){
        implemetor.operate();
    }
}
