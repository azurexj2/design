package junxiao.design;
import java.util.*;
import junxiao.design.node.*;
import junxiao.design.consistentHash.*;

public class runDesign {
    public static void main(String[] args){
        System.out.println("in runDsign");
        List<Node> servers = new ArrayList<>();
        servers.add(new Server("ace4385u"));
        servers.add(new Server("43b2kt"));
        ConsistentHash<String> h = new ConsistentHash<>(3, servers);
        Node s = h.get("hello");
        System.out.println(" key 'hello' in node " + s.getID());
        System.out.println("removing server id " + servers.get(0).getID());
        h.removeNode(servers.get(0));
        servers.remove(0);
        System.out.println("now key 'hello' in node " + h.get("hello").getID());
    }
}

