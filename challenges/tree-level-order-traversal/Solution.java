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
 * Hackerrank Minimum Average Waiting Time
 *
 * @link https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 */
class Solution {
    
	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
        ArrayList<ArrayDeque<Integer>> arrayStack = new ArrayList<ArrayDeque<Integer>>();
        preOrder(root,arrayStack, 0);
        arrayStack.forEach(deque -> {
            while(!deque.isEmpty()){
                System.out.print(deque.pollFirst() + " ");
            }
        });
    }

    public static void preOrder(Node root, ArrayList<ArrayDeque<Integer>> arrayStack, int level)
    {
        if(root == null) {
            return;
        }
        try{
            arrayStack.get(level);
        }catch(IndexOutOfBoundsException e){ 
            arrayStack.add(new ArrayDeque<Integer>());
        }finally {
            arrayStack.get(level).push(root.data);
        }
        preOrder(root.right, arrayStack, level +1);
        preOrder(root.left,arrayStack,level+1);
        
    }

	public static Node insert(Node root, int data) {