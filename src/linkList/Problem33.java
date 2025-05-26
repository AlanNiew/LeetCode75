package linkList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Niu
 * @Date: 2025/5/26 09:09
 * @Description:
 */
public class Problem33 {

    public static void main(String[] args) {
        int[] nodeArr = new int[]{4,2,2,3};
        //4 5 6 3 2 1
        //6 5 4 1 2 3
        ListNode head = ListNode.build(nodeArr);
        head.print();

        System.out.println(new Problem33().pairSum(head));
    }

    /**
     * 链表中的两数相加
     * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，
     * 第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
     */
    public int pairSum(ListNode head) {
        // 反转前半截链表
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null){
            fast = fast.next.next;
            ListNode tmp = new ListNode(slow.val);
            tmp.next = pre;
            pre = tmp;
            slow = slow.next;
        }
        pre.print();
        slow.print();
        int max = 0;
        while (slow != null){
            int val = slow.val + pre.val;
            if (val>max)max = val;
            slow = slow.next;
            pre = pre.next;
        }
        return max;
    }
}
