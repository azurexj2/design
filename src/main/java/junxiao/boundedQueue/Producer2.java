package junxiao.boundedQueue;
import java.util.*;


public class Producer2 implements Runnable{
	private final MessageQ<String> mq;
	private final Random rand;
	public Producer2(MessageQ<String> q){
		mq = q;
		rand = new Random();
	}
	
	@Override
	public void run(){
			while (true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int val = rand.nextInt(100);
				mq.put("message: " + val);
				System.out.println("prodcing " + val);
			}
	}
}