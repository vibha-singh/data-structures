package main.datastructures.bst;

public class BST {

    public static void main(String[] args) {

        // TreeSet
        // TreeMap
        Node root = new Node(50);
        insertIterative(root,30);
        insertIterative(root,70);
        insertIterative(root,40);
        insertIterative(root,60);
        insertIterative(root,80);
        System.out.println(deleteNodeRecursive(root,50));


    }

    // Time complexity: O(H), Auxiliary Space: O(H)
    static boolean searchRecursive(Node root, int x){
        if(root == null){
            return false;
        } else if(x > root.key){
            return searchRecursive(root.right, x);
        } else if(x < root.key){
            return searchRecursive(root.left , x);
        } else{
            return true;
        }
    }

    // Time Complexity: O(H), Auxiliary Space: O(1)
    static boolean searchIterative(Node root, int x){
        while(root != null) {
            if (root != null) {
                if (x > root.key) {
                    root = root.right;
                } else if (x < root.key) {
                    root = root.left;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    //Time Complexity : O(H) and Auxiliary Space: O(H)
    static Node insertRecursive(Node root, int x){
        if(root == null)
            return new Node(x);
        else{
            if(x > root.key){
                root.right =  insertRecursive(root.right, x);
            } else if(x < root.key){
                 root.left = insertRecursive(root.left, x);
            }
        }
        return root;
    }
    //Time Complexity : O(H) and Auxiliary Space: O(1)
    static Node insertIterative(Node root, int x){
        Node newNode = new Node(x);
        Node curr = root;
        Node parent = null;
        while(curr != null){
            parent = curr;
            if(x > curr.key ){
                curr = curr.right;
            } else if(x < curr.key){
                curr = curr.left;
            } else{
                return root;
            }
        }
        // if BST is empty
        if(parent == null){
            return newNode;
        }
        if(x > parent.key ){
            parent.right =  newNode;
        }else {
            parent.left = newNode;
        }
        return root;
    }
//
//    static Node deleteNodeIterative(Node root, int x){
//        if(root == null) return null;
//
//    }

    // Time Complexity: O(H) , Auxiliary Space: O(H)
    static Node deleteNodeRecursive(Node root, int x){
        if(root == null) return null;
        if(x > root.key){
            root.right = deleteNodeRecursive(root.right,x);
        } else if(x < root.key){
            root.left = deleteNodeRecursive(root.left,x);
        } else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                Node succ = getSuccessor(root);
                root.key = succ.key;
                //check why root.right
                root.right = deleteNodeRecursive(root.right, succ.key);
            }

        }
        return root;
    }

    // to find successor for only delete operation is go to right and find extreme left
    static Node getSuccessor(Node root){
        Node curr = root.right;
        while(curr != null && curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    static int floor(Node root, int key) {
        if(root == null) return -1;
        Node res = null;
        while(root != null){
            if(root.key == key) return root.key;
            else if(key < root.key) root = root.left;
            else {
                res = root;
                root = root.right;
            }
        }
        return res == null ? -1:  res.key;

    }

    int findCeil(Node root, int key) {
        if (root == null) return -1;

        Node res = null;
        while(root != null){
            if(root.key == key) return key;
            else if(key > root.key) root = root.right;
            else{
                res = root;
                root = root.left;
            }
        }

        return res == null ? -1 : res.key;
    }
}

class Node{
    int key;
    Node left,right;
    Node(int x){
        key = x;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
