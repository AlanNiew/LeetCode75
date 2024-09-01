package linkList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/31 16:01
 */
public class Problem32 {
    public static void main(String[] args) {
        ListNode node = ListNode.build(new int[]{5,4,2,1});
        node.print();
        System.out.println(new Problem32().pairSum(node));
    }
    public int pairSum(ListNode head) {
        int max = -1;
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        //反转后半部分节点
        ListNode last = reverseList(slow);
        ListNode pre = head;
        while (last != null && pre != null){
            int val = last.val + pre.val;
            if (val>max)max = val;
            last = last.next;
            pre = pre.next;
        }
        return max;
    }

    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }



}
