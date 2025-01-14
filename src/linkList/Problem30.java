package linkList;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 11:48
 */
public class Problem30 {

    public static void main(String[] args) {
        int[] nodeArr = new int[]{1,2,3,4,5};
        ListNode head = ListNode.build(nodeArr);
        head.print();
        new Solution().oddEvenList(head);
    }

    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            //长度小于2的链表直接返回
            if (head == null || head.next == null || head.next.next == null) return head;
            //1做奇数头节点
            ListNode oddHead = head;
            //2做偶数头节点
            ListNode evenHead = oddHead.next;
            ListNode even = evenHead;
            while (even != null && even.next != null){
                oddHead.next = even.next;
                oddHead = oddHead.next;
                even.next = oddHead.next;
                even = even.next;
            }
            oddHead.next = evenHead;
            return head;
        }
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
