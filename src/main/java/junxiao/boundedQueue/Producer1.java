package junxiao.boundedQueue;
import java.util.concurrent.BlockingQueue;
import java.util.*;


public class Producer1 implements Runnable{
	private final BlockingQueue<Integer> queue;
	private final Random rand;
	public Producer1(BlockingQueue<Integer> q){
		queue = q;
		rand = new Random();
	}
	
	@Override
	public void run(){
		try {
			while (true){
				Thread.sleep(1000);
				int val = produce();
				System.out.println("prodcing " + val + " queue size "+ queue.size());
				queue.put(val);
			}
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	private int produce(){
		return rand.nextInt(100);
	}
	
}
