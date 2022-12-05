package algorithm.JavaCode.base;

public class Code10_DeleteGivenValue {

    public static Node<Integer> removeValue(Node<Integer> head, int num) {
        // head 来到一个不需要删除的位置
        while(head!=null){
              if(head.getValue()!=num){
                break;
              }
              head = head.getNext();
        }
        Node<Integer> pre = head;
        Node<Integer> cur = head;
        while(cur != null){
            if(cur.getValue() == num){
                pre.setNext(cur.getNext());
            }else{
                pre = cur;
            }
            cur = cur.getNext();
        }
        return head;
    }
}
