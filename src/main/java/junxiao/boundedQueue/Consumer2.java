package junxiao.boundedQueue;


public class Consumer2 implements Runnable{
	private final MessageQ<String> mq;
	public Consumer2(MessageQ<String> q){
		mq = q;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message = mq.take();
			System.out.println("get message: " + message);
		}
		
	}

}
