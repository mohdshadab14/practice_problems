package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    Node root;

    private static class Node {
        int key;
        Node lchild;
        Node rchild;

        private Node(int key){
            this.key = key;
            this.lchild = null;
            this.rchild = null;
        }
    }

    public void breadthFirstTraversal(Node root){
        System.out.println("\n-------Breadth First Traversal-----------\n");
        Queue<Node> queue = new LinkedList<>();

        if(root==null){
            System.out.println("Tree is empty");
        }else{
            queue.add(root);
            while(!queue.isEmpty()){
                Node n = queue.poll();
                System.out.print(n.key+" ");
                if(n.lchild!=null){
                    queue.add(n.lchild);
                }
                if(n.rchild!=null){
                    queue.add(n.rchild);
                }
            }
        }
    }

    void preOrderTraversal(Node node){
        if(node!=null){
            System.out.print(node.key+" ");
            inorderTraversal(node.lchild);
            inorderTraversal(node.rchild);
        }
    }
    void postOrderTraversal(Node node){
        if(node!=null){
            inorderTraversal(node.lchild);
            inorderTraversal(node.rchild);
            System.out.print(node.key+" ");
        }
    }
    void inorderTraversal(Node node){
        if(node!=null){
            inorderTraversal(node.lchild);
            System.out.print(node.key+" ");
            inorderTraversal(node.rchild);
        }
    }



    public void insertInBST(Node node ,int key){
        Node newNode = new Node(key);
        this.insert(node,newNode,key);
    }

    public void insert(Node node, Node newNode,int key){

        if(this.root==null){
            this.root = newNode;
        }else{

            if(key < node.key){
                if(node.lchild == null){
                    node.lchild = newNode;
                }else{
                    insert(node.lchild,newNode,key);
                }
            }else{
                if(node.rchild ==null){
                    node.rchild = newNode;
                }else {
                    insert(node.rchild,newNode,key);
                }
            }
        }
    }

}
