package BinaryTreesPart;

import BinaryTreesPart.BuildTreePreorder.Node;

public class HeightOfTree {
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.Left);
        int right = height(root.Right);
        return Math.max(left,right)+1;
    }
}
