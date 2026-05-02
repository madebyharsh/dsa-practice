package trees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.insert(12);
        bt.insert(2);
        bt.insert(132);
        bt.insert(42);
        bt.insert(4);
        bt.insert(99);
        System.out.println(bt.inOrderTraversal());
        bt.delete(99);
        System.out.println(bt.inOrderTraversal());
        bt.delete(132);
        System.out.println(bt.inOrderTraversal());
        bt.delete(2);
        System.out.println(bt.inOrderTraversal());
    }
}
