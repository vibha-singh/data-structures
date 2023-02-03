package main.geeksForGeeks.dataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

public class MaxDepthOfnArray {
    public static void main(String[] args) {
        /* Let us create below tree
         *             A
         *         / / \ \
         *     B F D E
         *     / \ | /|\
         *     K J G C H I
         *     /\         \
         * N M         L
         */

        Node root = new Node('A');
        (root.child).add(new Node('B'));
        (root.child).add(new Node('F'));
        (root.child).add(new Node('D'));
        (root.child).add(new Node('E'));
        (root.child.get(0).child).add(new Node('K'));
        (root.child.get(0).child).add(new Node('J'));
        (root.child.get(2).child).add(new Node('G'));
        (root.child.get(3).child).add(new Node('C'));
        (root.child.get(3).child).add(new Node('H'));
        (root.child.get(3).child).add(new Node('I'));
        (root.child.get(0).child.get(0).child).add(new Node('N'));
        (root.child.get(0).child.get(0).child).add(new Node('M'));
        (root.child.get(3).child.get(2).child).add(new Node('L'));
        System.out.println(root.maxDepthNArray(root));

    }

    static class Node {
        char data;
        List<Node> child;

        public Node(char data){
            this.data = data;
            this.child = new ArrayList<>();
        }
         int maxDepthNArray(Node root) {
            if(root == null) return 0;
            int ans = 0;
            for(int i = 0; i< root.child.size() ; i++) {
                int tempAns = maxDepthNArray(root.child.get(i));
                ans = Math.max(ans, tempAns);
            }

            return ans+1;
        }

    }
}
