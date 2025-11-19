public interface PriQueueInterface<T>{
    public boolean isEmpty();
    public boolean isFull();
    public int size();
    public void enqueue();
}