package BinaryTreesPart;

import BinaryTreesPart.BuildTreePreorder.Node;

public class postorderClass {
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.Left);
        postorder(root.Right);
        System.out.print(root.Data + " ");
    }
}
