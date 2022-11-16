package com.example.suanfa.oct31;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Leet142 {

    public static void main(String[] args) {
        int[] ints = {-1, 2, -7, 7, -4, 19, 6, -9, -5, -2, -15};
//        -1 -》2 -》-7 -》7 -》-4 -》19
//                       ||         ||
//                       -5《- -9《- -6
//        int[] ints = {3, 2, 0, -4, 3};
        ListNode2 head = new ListNode2(-1);
        ListNode2 cur = head;
        for (int i = 1; i < ints.length; i++) {
            cur.next = new ListNode2(ints[i]);
            cur = cur.next;
        }
        System.out.println(detectCycle(head).val);

    }

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
     * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
     * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 不允许修改 链表。
     */
    public static ListNode2 detectCycle(ListNode2 head) {
        // 环节点的特点：一共有两个指向他的节点
        ListNode2 cur = head; // 当前节点
        ListNode2 huan = null;
        if (cur == null || cur.next == null) return null;
        HashSet<Integer> set = new HashSet<>();
        while (cur.next != null) {
            set.add(cur.val);
            cur = cur.next;
            if (set.contains(cur.val)) {
                huan = cur;
            }
        }
        cur = head;
        if (huan != null) {
            while (cur.next.val != huan.val) {
                cur = cur.next;
            }
            return cur;
        } else if (huan == null) {

        }
        return null;
    }

    //    解题思路：分两个步骤，
//    首先通过快慢指针的方法判断链表是否有环；接下来如果有环，则寻找入环的第一个节点。
//    具体的方法为，首先假定链表起点到入环的第一个节点A的长度为a【未知】，
//    到快慢指针相遇的节点B的长度为（a + b）【这个长度是已知的】。
//    现在我们想知道a的值，注意到快指针p2始终是慢指针p走过长度的2倍，所以慢指针p从B继续走（a + b）又能回到B点，
//    如果只走a个长度就能回到节点A。但是a的值是不知道的，解决思路是曲线救国，注意到起点到A的长度是a，
//    那么可以用一个从起点开始的新指针q和从节点B开始的慢指针p同步走，相遇的地方必然是入环的第一个节点A。
//    文字有点绕，画个图就一目了然了~~ ``
    // 快慢指针
    public static ListNode2 detectCycle2(ListNode2 head) {
        // 环节点的特点：一共有两个指向他的节点
        //
        return null;
    }
}
