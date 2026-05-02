package trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int val){
            this.value = val;
        }

    }

    private Node root;

    // public APIs
    public void insert(int val){
        this.root = insert(val, root);
    }

    public void delete(int val){
        this.root = delete(val, this.root);
    }

    public List<Integer> inOrderTraversal(){
        List<Integer> result = new ArrayList<>();
        inOrder(this.root, result);
        return result;
    }

    // private APIs
    private Node insert(int val, Node root){
        if(root == null) return new Node(val);
        else if(root.value > val) root.left = insert(val, root.left);
        else root.right = insert(val, root.right);
        return root;
    }

    private Node delete(int val, Node root){
        if(root == null) return null;
        if(root.value > val){
            root.left = delete(val, root.left);
        }
        else if(root.value < val){
            root.right = delete(val, root.right);
        }
        else{
            // no leaf node;
            if(root.left == null && root.right == null) return null;

            // one side node avaialble;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            // both sided avaialble then find inOrderSuccessor
            Node node = findMin(root);
            root.value = node.value;
            root.right = delete(node.value, node.right);
        }
        return root;
    }

    private Node findMin(Node root){
        if(root.left == null) return root;
        return findMin(root.left);
    }

    private void inOrder(Node root, List<Integer> result){
        if(root == null) return;
        inOrder(root.left, result);
        result.add(root.value);
        inOrder(root.right, result);
    }
}
