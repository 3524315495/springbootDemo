package com.example.suanfa.nov4;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet589 {
    /**
     * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     */
    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Node> nodes1 = new ArrayList<>();
        nodes1.add(new Node(5));
        nodes1.add(new Node(6));

        nodes.add(new Node(3, nodes1));
        nodes.add(new Node(2));
        nodes.add(new Node(4));
        Node node = new Node(1, nodes);
        List<Integer> preorder = preorder2(node);
        System.out.println(preorder);
    }

    /**
     * 递归
     */
    public static List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return null;
        list.add(root.val);
        for (Node child : root.children) {
            list.add(child.val);
            preorder(child);
        }
        return list;
    }

    /**
     * 栈
     */
    public static List<Integer> preorder2(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        if (root == null) return null;
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                nodeStack.add(node.children.get(i));
            }
        }
        return list;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};