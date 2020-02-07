import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

/**
 * HackerRank Binary Search Tree : Lowest Common Ancestor
 *
 * @link https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
 */
class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
      	ArrayDeque<Node> v1Array = new ArrayDeque<Node>();
        ArrayDeque<Node> v2Array = new ArrayDeque<Node>();

        find(root, v1, v1Array);
        find(root, v2, v2Array);
        Node node = root;
        while(v1Array.peekFirst() != null && v2Array.peekFirst() != null && v1Array.peekFirst().data == v2Array.peekFirst().data) {
            node = v1Array.pollFirst();
            v2Array.pollFirst();
        }
        return node;
    }

    public static void find(Node root, int v1, ArrayDeque<Node> deque)
    {
        if(root == null) {
            return;
        }

        deque.addLast(root);
        if(root.data == v1) {
            return;
        }
        if(v1 <= root.data) {
            find(root.left, v1, deque);
        }
        else {
            find(root.right, v1, deque);
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}