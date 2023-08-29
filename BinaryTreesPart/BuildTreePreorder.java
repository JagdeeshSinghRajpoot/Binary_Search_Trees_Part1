package BinaryTreesPart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.sound.sampled.SourceDataLine;

public class BuildTreePreorder {

    static class Node {
        public static final String HeightOfTree = null;
        int Data;
        Node Left;
        Node Right;

        public Node(int data) {
            this.Data = data;
            this.Left = null;
            this.Right = null;
        }
    }

   

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.Left = buildTree(nodes);
            newNode.Right = buildTree(nodes);

            return newNode;
        }
    }

    
    public static int diameter2(Node root){      //Approach 1. -> O(n^2)
        if(root == null){
            return 0;
        }
        int ldiam = diameter2(root.Left);
        int lh = HeightOfTree.height(root.Left);
        int rdiam = diameter2(root.Right);
        int rh = HeightOfTree.height(root.Right);

        int selfDiam = lh + rh + 1;
        return Math.max(selfDiam, Math.max(ldiam,rdiam)); 

        }
/*
        static class Info{
            int diam;
            int ht;
    
            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }   

    public static Info diameter(Node root){  // O(n)
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameter(root.Left);
        Info rightInfo = diameter(root.Right);

        int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam), rightInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

        return new Info(diam, ht);
    }
*/
    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }else if(node == null || subRoot == null || node.Data != subRoot.Data){
            return false;
        }

        if(!isIdentical(node.Left, subRoot.Left)){
            return false;
        }
        if(!isIdentical(node.Right, subRoot.Right)){
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.Data == subRoot.Data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot);
    }

    static class Info{
        Node node;
        int hd;
        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();

        HashMap<Integer,Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.Left != null){
                    q.add(new Info(curr.node.Left, curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.Right != null){
                    q.add(new Info(curr.node.Right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }
            
        }

        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).Data+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTree tree = new BinaryTree();
        // Node root = BinaryTree.buildTree(nodes);

        // PreorderClass.preorder(root);
        // System.out.println();
        // inorerClass.inorder(root);
        // System.out.println();
        // postorderClass.postorder(root);
        // System.out.println();
        // LevelOrdrClass.levelOrder(root);
        
        Node root = new Node(1);
        root.Left = new Node(2);
        root.Right = new Node(3);
        root.Left.Left = new Node(4);
        root.Left.Right = new Node(5);
        root.Right.Left = new Node(6);
        root.Right.Right = new Node(7);
/*      
         1
        / \
       2   3
      / \ / \
     4  5 6  7
 */
        // System.out.println(HeightOfTree.height(root));
        // System.out.println(countOfNode.countNode(root));
        // System.out.println(diameter2(root));
        // System.out.println(diameter(root).diam);

        Node subRoot = new Node(2);
        subRoot.Left = new Node(4);
        subRoot.Right = new Node(5);
/*      
        1
       / \
      2   3
 */
        // System.out.println(isSubtree(root,subRoot));
        // topView(root);
        System.out.println(KthLevel.Kth(root));
    }      
  
}