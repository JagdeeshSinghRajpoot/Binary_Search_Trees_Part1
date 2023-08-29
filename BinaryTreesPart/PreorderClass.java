package BinaryTreesPart;

import BinaryTreesPart.BuildTreePreorder.Node;

public class PreorderClass {
    public static void preorder(Node root) {

        if (root == null) {
            // System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.Data + " ");
        preorder(root.Left);
        preorder(root.Right);
    }
    
}
