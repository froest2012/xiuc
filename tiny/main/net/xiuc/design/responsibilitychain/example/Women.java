package net.xiuc.design.responsibilitychain.example;

/**
 * Created by 秀川 on 16/4/25.
 */
public class Women implements IWomen {

    /**
     * 1. 未出嫁
     * 2. 出嫁
     * 3. 寡妇
     */
    private int type;

    private String request = "";

    public Women(int type, String request){
        this.type = type;
        switch (this.type){
            case 1 : {
                this.request = "女儿的请求是:" + request;
                break;
            }
            case 2 : {
                this.request = "妻子的请求是:" + request;
                break;
            }
            case 3 : {
                this.request = "母亲的请求是:" + request;
                break;
            }
        }
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
