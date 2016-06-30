package junxiao.boundedQueue;
import java.util.*;


public class MessageQueue<T> implements MessageQ<T>{
	private final Deque<T> queue;
	private final static int MAX_SIZE = 10;
	public MessageQueue(Deque<T> q){
		queue = q;
	}
	@Override
	public synchronized T take(){
		while(queue.size()==0){
			try {
				wait();
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
		T message = queue.poll();
		notifyAll();
		return message;
	}
	@Override
	public synchronized void put(T message){
		while(queue.size()==MAX_SIZE){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		queue.offer(message);
		notifyAll();
	}
	
}
