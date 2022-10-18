package leetcode.java.BST;

import leetcode.java.BST.TreeNode;


import java.util.StringTokenizer;

class Serialize_and_Deserialize_Binary_Tree {
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb){
        if(root == null )
            sb.append("# ");
        else {
            sb.append(root.val+" ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    public TreeNode deserialize(String s){
        if(s == null || s.length() == 0) return null;
        StringTokenizer st = new StringTokenizer(s, " ");
        return deserialize(st);
    }
    public TreeNode deserialize(StringTokenizer st){
        if(!st.hasMoreTokens()) return  null;
        String s = st.nextToken();
        if(s.equals("#")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserialize(st);
        root.right = deserialize(st);
        return root;
    }
}
