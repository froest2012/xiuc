package net.xiuc.design.command.example;

/**
 * Created by 秀川 on 16/4/25.
 */
public class Women implements IWomen {

    /**
     *
     */
    private int type;

    private String request = "";

    public Women(int type, String request){
        this.type = type;
        switch (this.type){
            case 1 : {
                this.request = ""
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
