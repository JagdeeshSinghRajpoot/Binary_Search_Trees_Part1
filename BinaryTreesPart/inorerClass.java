package BinaryTreesPart;

import BinaryTreesPart.BuildTreePreorder.Node;

public class inorerClass {
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.Left);
        System.out.print(root.Data + " ");
        inorder(root.Right);
    }
}
