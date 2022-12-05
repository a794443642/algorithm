package algorithm.JavaCode.base;

import java.util.Stack;

/**
 * 
 * 实现一个特殊的栈，在基础操作基础上，在实现返回栈中最小元素
* 1)pop，push，getMin 操作时间复杂度O(1)
* 2) 设计的栈类型可以使用现成的栈结构
 */
public class Code13_GetMinStack {
    public static class GetMinStack1{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        public GetMinStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        
        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum<=this.getMin()){
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }
        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("your stack is empty.");
            }
            int value = this.stackData.pop();
            if(value == this.getMin()){
                stackMin.pop();
            }
            return value;
        }

        private int getMin() {
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("your stack is empty.");
            }
            return stackMin.peek();
        }
    }
    public static class GetMinStack2 {
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public GetMinStack2() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum < this.getMin()) {
				this.stackMin.push(newNum);
			} else {
				int newMin = this.stackMin.peek();
				this.stackMin.push(newMin);
			}
			this.stackData.push(newNum);
		}

		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			this.stackMin.pop();
			return this.stackData.pop();
		}

		public int getMin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}
    public static void main(String[] args) {
		GetMinStack1 stack1 = new GetMinStack1();
		stack1.push(3);
		System.out.println(stack1.getMin());
		stack1.push(4);
		System.out.println(stack1.getMin());
		stack1.push(1);
		System.out.println(stack1.getMin());
		System.out.println(stack1.pop());
		System.out.println(stack1.getMin());

		System.out.println("=============");

		GetMinStack2 stack2 = new GetMinStack2();
		stack2.push(3);
		System.out.println(stack2.getMin());
		stack2.push(4);
		System.out.println(stack2.getMin());
		stack2.push(1);
		System.out.println(stack2.getMin());
		System.out.println(stack2.pop());
		System.out.println(stack2.getMin());
	}
}
