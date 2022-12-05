package algorithm.JavaCode.base;

public class Code11_DoubleEndsQueueToStackAndQueue {
    public static class DoubleEndsQueue<T> {
        private DoubleNode<T> head;
        private DoubleNode<T> tail;

        public void addFromHead(T value) {
            DoubleNode<T> cur = new DoubleNode<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.setNext(head);
                head.setPrev(cur);
                head = cur;
            }
        }
        public void addFormBottom(T value) {
            DoubleNode<T> cur = new DoubleNode<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.setPrev(tail);
                tail.setNext(cur);
                tail = cur;
            }
        }
        public T popFromHead(){
            if(head == null){
                return null;
            }
            DoubleNode<T> cur = head;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                head = head.getNext();
                cur.setNext(null);
                head.setPrev(null);
            }
            return cur.getValue();
        }
        public T popFromBottom(){
            if(tail == null){
                return null;
            }
            DoubleNode<T> cur = tail;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                tail = tail.getPrev();
                tail.setNext(null);
                cur.setPrev(null);
            }
            return cur.getValue();
        }
        public boolean isEmpty(){
            return head == null;
        }
    }
    //栈
    public static class Mystack<T>{
        private DoubleEndsQueue<T> queue;

        public Mystack() {
            this.queue = new DoubleEndsQueue<T>();
        }
        public void push(T value){
            queue.addFromHead(value);
        }
        public T pop(){
            return queue.popFromHead();
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }
    //队列
    public static class MyQueue<T>{
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            this.queue = new DoubleEndsQueue<T>();
        }
        public void push(T value){
            queue.addFromHead(value);
        }
        public T poll(){
            return queue.popFromBottom();
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }

}
