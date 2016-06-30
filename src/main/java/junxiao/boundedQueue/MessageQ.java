package junxiao.boundedQueue;

public interface MessageQ<T> {
	public T take();
	public void put(T message);

}
