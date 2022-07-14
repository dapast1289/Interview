package leetcodeold;

import java.util.ArrayList;
import java.util.List;

public class L116 {

    public static void main(String[] args) {
//        [1,2,3,4,5,6,7]
        Node r1 = new Node(1);
        Node r2 = new Node(2);
        Node r3 = new Node(3);
        Node r4 = new Node(4);
        Node r5 = new Node(5);
        Node r6 = new Node(6);
        Node r7 = new Node(7);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.left = r6;
        r3.right = r7;

        L116 l116 = new L116();
        l116.connect(r1);
        System.out.println();
    }

    public Node connect(Node root) {
        List<Node> roots = new ArrayList<>();
        roots.add(root);
        connect(roots);
        return root;
    }

    public void connect(List<Node> roots) {
        if (roots.size() == 0) {
            return;
        }
        List<Node> leaves = new ArrayList<>();
        for (int i = 1; i < roots.size(); i++) {
            Node node = roots.get(i - 1);
            node.next = roots.get(i);
        }
        for (Node node : roots) {
            if (node.left != null) {
                leaves.add(node.left);
            }
            if (node.right != null) {
                leaves.add(node.right);
            }
        }
        connect(leaves);
    }
}
