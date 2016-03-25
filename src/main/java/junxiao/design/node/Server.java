package junxiao.design.node;

import java.util.*;

public class Server implements Node {
    private String id;
    public Server(String id){
        this.id = id;
    }
    @Override
    public void setID(String id){
        this.id = id;
    }
    @Override
    public String getID(){
        return id;
    }
}
