package linkList;

/**
 * @author SouthWind
 * 编程千万条，规范第一条
 * Date 2024/8/29 21:50
 */
public class ListNode {
    // 节点
    int val;
    // 指向下一个节点
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //构建链表
    public static ListNode build(int[] arr){
        // 头节点
        ListNode head = new ListNode();
        ListNode tmp = head;
        for (int j : arr) {
            tmp.next = new ListNode(j);
            tmp = tmp.next;
        }
        return head.next;
    }

    //打印链表
    public void print(){
        ListNode tmp = this;
        while (tmp != null){
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public int len(ListNode node){
        ListNode tmp = node;
        int len = 0;
        while (tmp != null){
            len++;
            tmp = tmp.next;
        }
        System.out.println(len);
        return len;
    }
}
