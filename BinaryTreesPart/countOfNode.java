package BinaryTreesPart;

import BinaryTreesPart.BuildTreePreorder.Node;

public class countOfNode {
    public static int countNode(Node root){
        if(root == null){
            return 0;
        }
        int lcount = countNode(root.Left);
        int rcount = countNode(root.Right);
        return lcount + rcount + 1;
    }    
}
