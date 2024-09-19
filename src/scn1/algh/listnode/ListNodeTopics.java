package scn1.algh.listnode;


import java.util.*;
import java.util.stream.Stream;

public class ListNodeTopics {
    public static void main(String[] args) {

    }

    /**
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * @param head
     * @param val
     * @return
     * @Tips 删除链表节点的两个方法，一个是直接进行删除（需要对head进行特殊判断，特殊操作）
     * 第二个是创建一个虚拟节点 dummyNode 这样所有结点的删除都是一个规则 但返回时要注意是dummyNode.next
     */
    public ListNode removeElements(ListNode head, int val) {
        /*while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;*/
        ListNode dummyNode = new ListNode(1, head);
        ListNode cur = dummyNode; //链表操作需要留一个head副本进行操作
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 反转链表
     *
     * @return
     * @Tips 关键就是定义一个null为pre，指向前面，不可以用cur作为pre，会循环没意义
     * @Tips * @param head
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 交换每两个相邻的节点
     *
     * @param head
     * @return
     * @Tips 引入一个虚拟头节点 模拟交换的过程进行编码即可
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode nextNode = null;
        ListNode nextNextNode = null;
        ListNode tmp = null;
        while (cur != null) {
            nextNode = cur.next;
            nextNextNode = cur.next.next;
            tmp = nextNextNode.next;
            cur.next = nextNextNode;
            nextNextNode.next = nextNode;
            nextNode.next = tmp;
            cur = tmp;
        }
        return dummy.next;
    }

    /**
     * 删除链表的后n个元素
     *
     * @param head
     * @return
     * @Tips 一次遍历的话肯定是用双指针的，技巧就在于让快慢指针之间相差n，当快指针遍历到最后，删除慢指针所在的节点即可
     */
    public ListNode deleteLastNElements(ListNode head, int n) {

        return null;
    }


}

class ListNode {
    // 结点的值
    int val;
    // 下一个结点
    ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    int size;
    ListNode head;

    //获取索引为index的链表节点的值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode res = head;
        for (int i = 0; i <= index; i++) {
            res = res.next;
        }
        return res.val;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        head.next = newHead;
        size++;
    }

    public void addAtTail(int val) {
        ListNode tailNode = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = tailNode;
        size++;
    }
}