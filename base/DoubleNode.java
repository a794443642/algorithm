package algorithm.JavaCode.base;

public class DoubleNode<T> {
    private T value;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public DoubleNode<T> getNext() {
        return next;
    }
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
    public DoubleNode<T> getPrev() {
        return prev;
    }
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }
    public DoubleNode(T value) {
        this.value = value;
    }
    
    
}
