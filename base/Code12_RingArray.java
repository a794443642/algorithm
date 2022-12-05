package algorithm.JavaCode.base;

public class Code12_RingArray {
    public static class MyQueue {
        private int[] arr;
        private Integer rear;
        private Integer front;
        private Integer limit;
        private Integer size;

        public MyQueue(Integer limit) {
            arr = new int[limit];
            rear = 0;
            front = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("栈满了不能加了");
            }
            size++;
            arr[front] = value;
            front = nextIndex(front);
        }

        private Integer nextIndex(Integer index) {
            return (index++) % limit;
        }

        public Integer  poll() {
            if (size == 0) {
                throw new RuntimeException("栈空了，不能拿了");
            }
            size--;
            int ans = arr[rear];
            rear = nextIndex(rear);
            return ans;
        }
        public boolean isEmpty(){
            return size == 0;
        }
    }
}
