package algorithm.JavaCode.base;

import java.util.Stack;

public class Code14_TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }
        public void pushToPop(){
            while(stackPop.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
        public void add(Integer num){
            stackPush.push(num);
            pushToPop();
        }
        public Integer poll(){
            if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			}
            pushToPop();
            return stackPop.pop();
        }
        public Integer peek(){
            if (stackPop.empty() && stackPush.empty()) {
				throw new RuntimeException("Queue is empty!");
			}
			pushToPop();
			return stackPop.peek();
        }
    }
    public static void main(String[] args) {
		TwoStacksQueue test = new TwoStacksQueue();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
		System.out.println(test.peek());
		System.out.println(test.poll());
	}

}
