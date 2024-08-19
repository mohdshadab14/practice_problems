package datastructures;

public class TestTree {

    public static void main(String[] args) {

        BST bst = new BST();

        bst.insertInBST(bst.root,10);
        bst.insertInBST(bst.root,15);
        bst.insertInBST(bst.root,5);
        bst.insertInBST(bst.root,12);
        bst.insertInBST(bst.root,2);
        bst.insertInBST(bst.root,8);
        bst.insertInBST(bst.root,1);
        bst.insertInBST(bst.root,13);

        System.out.println("\n------------Pre Order Traversal---------------\n");
        bst.preOrderTraversal(bst.root);
        System.out.println("\n------------In Order Traversal---------------- \n");
        bst.inorderTraversal(bst.root);
        System.out.println("\n------------Post Order Traverasl---------------\n");
        bst.postOrderTraversal(bst.root);
        System.out.println("\n------------Breadth First Traversal------------\n");
        bst.breadthFirstTraversal(bst.root);
        System.out.println("\n------------Depth First Traversal---------------\n");


    }

}
