package Goldman_Sachs;

/*
 * Instructions to candidate.
 * Implement the "put" and "contains" methods.
 * Fix the "inOrderTraversal" method.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GS_07_SearchTree {
    static class BST  {

        private Node root;

        public BST() {
            this.root = null;
        }

        public void put(int value) {
            // your code
            this.root = insert(this.root, value);
        }
        public Node insert(Node node, int value){
            if(node == null) return new Node(value);
            else if(node.val > value){
                node.left = insert(node.left, value);
            }else node.right = insert(node.right, value);
            return node;
        }

        public boolean contains(int value) {
            // iterative way of doing search
            Node curr = root;
            while(curr != null){
                if(value == curr.val) return true;
                else if(value < curr.val) curr = curr.left;
                else curr = curr.right;
            }
            return false;
            // recursive way of doing search
            // recursive way of doing search
//            return containsRecursive(root, value);
        }
        public boolean containsRecursive(Node node, int value){
            if(node == null) return false;
            else if(node.val == value) return true;
            else if(node.val > value) return containsRecursive(node.left, value);
            else return containsRecursive(node.right, value);
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversalHelper(root, acc);
            return acc;
        }
        public void inOrderTraversalHelper(Node node, List<Integer> acc){
            if(node == null) return;
            inOrderTraversalHelper(node.left, acc);
            acc.add(node.val);
            inOrderTraversalHelper(node.right, acc);
        }

        private static class Node {
            Integer val;
            Node left;
            Node right;
            Node(Integer val){
                this.val = val;
            }
        }
    }


    public static void main(String[] args) {

        final BST searchTree = new BST();

        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);
        System.out.println(searchTree.inOrderTraversal());
        if(Arrays.asList(1,2,3,5).equals(searchTree.inOrderTraversal())
                && !searchTree.contains(0)
                && searchTree.contains(1)
                && searchTree.contains(2)
                && searchTree.contains(3)
                && !searchTree.contains(4)
                && searchTree.contains(5)
                && !searchTree.contains(6)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

    }
}
