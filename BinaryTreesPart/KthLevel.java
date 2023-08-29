package BinaryTreesPart;

import BinaryTreesPart.BuildTreePreorder.Node;

public class KthLevel {
       
    public static int Kth(Node root){
        if(root == null){
            return 0;
        }
       
        int lc = Kth(root.Left);
        int rc = Kth(root.Right);
        int Level = Math.max(lc , rc)+1;
        if(Level == 3){
            System.out.print(root.Data + " ");
        }
        return Level;
       
    }    
}
