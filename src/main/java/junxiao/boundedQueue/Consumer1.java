package junxiao.boundedQueue;
import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Consumer1 implements Runnable{
	private final BlockingQueue<Integer> queue;
	public Consumer1(BlockingQueue<Integer> q){
		queue = q;
	}
	@Override
	public void run(){
		try {
			while(true){
				Thread.sleep(2000);
				consume(queue.take());
			}
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	private void consume(int x){
		System.out.println("consuming " + x);
	}

}
