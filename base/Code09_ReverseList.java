package algorithm.JavaCode.base;

public class Code09_ReverseList {
    public static Node<Integer> reverseLinkedNode(Node<Integer> head) {
        Node<Integer> pre = null;
        Node<Integer> next = null;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode<Integer> reverseDoubleNode(DoubleNode<Integer> head) {
        DoubleNode<Integer> pre = null;
        DoubleNode<Integer> next = null;
        while (head != null) {
            next = head.getNext();
            head.setNext(pre);
            head.setPrev(next);
            pre = head;
            head = next;
        }
        return pre;
    }
    

}
