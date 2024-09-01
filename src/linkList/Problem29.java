package linkList;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 11:38
 */
public class Problem29 {
    public static void main(String[] args) {
        int [] nodeArr = new int[]{2,1};
        ListNode head = ListNode.build(nodeArr);
        head.print();
        Problem29 problem29 = new Problem29();
        problem29.deleteMiddle(head).print();
    }

    public ListNode deleteMiddle(ListNode head) {
        //快慢指针
        //头节点，方便操作
        ListNode tmp = new ListNode(0,head);
        ListNode fast = tmp;
        ListNode slow = tmp;
        while (true){
            fast = fast.next;
            if (fast!=null){
                fast = fast.next;
            }
            if (fast==null)break;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tmp.next;
    }

}
