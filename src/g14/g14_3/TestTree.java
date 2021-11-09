package g14.g14_3;

public class TestTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(3, "John");
        tree.insert(8, "T1000");
        tree.insert(1, "Sara");
        tree.insert(2, "T800");
        tree.insert(15, "TTT");
        tree.insert(5, "555f");
        Node findJohn = tree.find(3);
        findJohn.printNode();
        System.out.println();
        tree.print(findJohn);
    }
}
