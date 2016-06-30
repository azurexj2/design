package junxiao.boundedQueue;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
		Deque<String> queue = new ArrayDeque<>();
		MessageQ<String> mq = new MessageQueue<>(queue);
		Runnable p1 = new Producer2(mq);
		Runnable p2 = new Producer2(mq);
		Runnable c1 = new Consumer2(mq);
		
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(c1).start();

	}

}
