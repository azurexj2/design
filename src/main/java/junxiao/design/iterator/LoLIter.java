package junxiao.design.iterator;

import java.util.Iterator;
import java.util.*;
public class LoLIter<E> implements Iterator<E> {
	private List<List<E>> list;
	private int row;
	private int col;
	public LoLIter(List<List<E>> list){
		this.list = list;
		row = 0;
		col = 0;
		moveToValid();
	}
	@Override
	public boolean hasNext(){
		return row<list.size();
	}
	@Override
	public E next(){
		E res = list.get(row).get(col);
		++col;
		moveToValid();
		return res;
	}
	private void moveToValid(){
		while(row<list.size()){
			if (col<list.get(row).size())
				return;
			++row;
			col = 0;
		}
	}
}
