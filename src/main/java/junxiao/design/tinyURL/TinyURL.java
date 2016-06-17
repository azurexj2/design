package junxiao.design.tinyURL;
import java.util.*;

public class TinyURL{
    private static final String ALPHABET = "abcdefghipqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();
    public static void main(String[] args){
        int len = args.length;
        if (len!=1){
            System.err.println("tinyURL + num");
            System.exit(1);
        }
        int id = Integer.parseInt(args[0]);
        TinyURL shorter = new TinyURL();
        String url = shorter.genURL(id);
        int id2 = shorter.genID(url);
        System.out.println("input id " + id);
        System.out.println("url is www.ti.ny/" + url);
        System.out.println("decode url is " + id2);

    }
    public String genURL(int id){
        StringBuilder res = new StringBuilder();
        while (id >0){
            int n = id % BASE;
            res.append(ALPHABET.charAt(n));
            id /= BASE;
        }
        return res.reverse().toString();
    }


    public int genID(String url){
        int res = 0;
        for (int i=0; i < url.length();++i){
            char c = url.charAt(i);
            int ind = ALPHABET.indexOf(c);
            res = res * BASE + ind;
        }
        return res;
    }
}

