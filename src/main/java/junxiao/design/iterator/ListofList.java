package junxiao.design.iterator;
import java.util.*;

public class ListofList<T> implements Iterable<T>{
	private List<List<T>> list;
	public ListofList(List<List<T>> list){
		this.list = list;
	}
	@Override
	public Iterator<T> iterator(){
		return new ListOfListIter();
	}
	private class ListOfListIter implements Iterator<T> {
		private int row;
		private int col;
		public ListOfListIter(){
			row = 0;
			col = 0;
			moveToValid();
		}
		@Override
		public boolean hasNext(){
			return row<list.size();
		}
		@Override
		public T next(){
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			T res = list.get(row).get(col);
			++col;
			moveToValid();
			return res;
		}
		private void moveToValid(){
			while(row < list.size()){
				if (col < list.get(row).size())
					return;
				++row;
				col = 0;
			}
		}
	}
}
