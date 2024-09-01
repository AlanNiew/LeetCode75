package linkList;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 11:48
 */
public class Problem30 {

    public static void main(String[] args) {
        int[] nodeArr = new int[]{2,1};
        ListNode head = ListNode.build(nodeArr);
        head.print();
        Problem30 problem30 = new Problem30();
        problem30.oddEvenList(head).print();
    }

    /**
     * 奇偶链表
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head==null)return null;
        ListNode oddNode = new ListNode();
        ListNode oddNext = oddNode;
        ListNode evenNode = new ListNode();
        ListNode evenNext = evenNode;
        ListNode cur = head;
        int n = 1;
        while (cur!=null){
            ListNode tmp = new ListNode(cur.val);
            if (n++%2==0){
                evenNext.next = tmp;
                evenNext = tmp;
            }else {
                oddNext.next = tmp;
                oddNext = tmp;
            }
            cur = cur.next;
        }
        oddNext.next = evenNode.next;
        return oddNode.next;
    }
}
