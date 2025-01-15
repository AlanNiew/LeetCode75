package linkList;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 12:08
 */
public class Problem31 {

    public static void main(String[] args) {
        ListNode node = ListNode.build(new int[]{1,2,3,4,5});
        node.print();
        new Problem31().reverseList(node).print();
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            while (head!=null){
                ListNode next = new ListNode(head.val);
                next.next = pre;
                pre = next;
                head = head.next;
            }
            return pre;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = new ListNode();
        while (cur!=null){
            int val = cur.val;
            ListNode tmp = new ListNode(val);
            /*
            头插法,将头节点的next取出来
            头节点先拼接上新进来的节点
            后新节点再连接之前取出的next节点
             */
            ListNode next = pre.next;
            pre.next = tmp;
            tmp.next = next;
            cur = cur.next;
        }
        return pre.next;
    }

}
