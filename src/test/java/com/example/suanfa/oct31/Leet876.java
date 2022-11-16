package com.example.suanfa.oct31;


import java.util.List;

public class Leet876 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode head = new ListNode(1, new ListNode(2, null));
        ListNode middleNode = middleNode2(head);
        System.out.println(middleNode.val);
    }
//    123456
    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     */
    public static ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode ans = head;
        while (ans!=null){
            length++;
            ans = ans.next;
        }
        for (int i=0; i<length/2; i++){
            head=head.next;
        }
        return head;
    }

    // 快慢指针
    public static ListNode middleNode2(ListNode head) {
        // 快指针走两个节点，慢指针走一个节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}



