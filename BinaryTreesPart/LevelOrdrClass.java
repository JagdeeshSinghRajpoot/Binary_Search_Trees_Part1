package BinaryTreesPart;

import java.util.LinkedList;
import java.util.Queue;

import BinaryTreesPart.BuildTreePreorder.Node;

public class LevelOrdrClass {
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }else {
                System.out.print(currNode.Data + " ");
                if(currNode.Left != null){
                    q.add(currNode.Left);
                }
                if(currNode.Right != null){
                    q.add(currNode.Right);
                }
            }
        }
    }
}
