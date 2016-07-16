package junxiao.design.iterator;
import java.util.*;
public class RunIter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		list.add(new ArrayList<Integer>(Arrays.asList(5,6)));
		ListofList<Integer> lol = new ListofList<>(list);
		Iterator<Integer> iter = lol.iterator();
		System.out.println(list);
		//while(iter.hasNext()){
		//	System.out.println(iter.next());
		//}
		Iterator<Integer> it = new LoLIter<>(list);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
