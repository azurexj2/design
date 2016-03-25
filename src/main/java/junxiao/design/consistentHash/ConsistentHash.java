package junxiao.design.consistentHash;

import junxiao.design.node.Node;
import java.util.*;

public class ConsistentHash<T> {
    private int replica;
    private SortedMap<Integer, Node> map;
    public ConsistentHash(int replica, Collection<Node> servers){
        map = new TreeMap<Integer, Node>();
        this.replica = replica;
        int i = 0;
        System.out.println("total " +
                servers.size() + " servers in cache");
        for (Node n : servers){
            System.out.println("adding server id " +
                    n.getID() + " to cache");
            addNode(n);
        }
    }
    public void addNode(Node node){
        for (int i =0; i < replica; ++i){
            map.put( (node.getID() + i).hashCode(), node);
        }
    }
    public void removeNode(Node node){
        for (int i =0; i < replica; ++i){
            map.remove( (node.getID() + i).hashCode());
        }
    }
    public Node get(T key){
        //need assert whether the tailMap is empty
        SortedMap<Integer, Node> tmp = map.tailMap(key.hashCode());
        if (!tmp.isEmpty()){
            // key is largerthan all node,
            // assign the first node to it
            return map.get(map.firstKey());
        }
        else {
            return tmp.get(tmp.firstKey());
        }
    }
}
