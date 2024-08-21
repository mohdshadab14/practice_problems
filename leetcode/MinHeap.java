package leetcode;


import java.util.ArrayList;

public class MinHeap {

    private Node root;
    private ArrayList<Node> list;
    private int lastInsertion;


    private MinHeap(){
        this.list = new ArrayList<>();
        this.lastInsertion = -1;
    }

    private static class Node{
        int key;
        Node lChild;
        Node rChild;
        Node parentNode;
        private Node(int key){
            this.key = key;
            this.lChild = null;
            this.rChild = null;
            this.parentNode = null;
        }

    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.insert(4);
        minHeap.insert(50);
        minHeap.insert(2);
        minHeap.insert(1);

        minHeap.traverse(minHeap.root);
        System.out.println(minHeap.delete());
        System.out.println(minHeap.delete());
        System.out.println(minHeap.delete());
        System.out.println(minHeap.delete());
        System.out.println(minHeap.delete());
        System.out.println(minHeap.delete());
        System.out.println(minHeap.delete());
        System.out.println(minHeap.delete());

        System.out.println("--------------");
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.traverse(minHeap.root);


    }

    public void insert(int key){

        Node newNode = new Node(key);

        if(root==null){
            root = newNode;
            list.add(newNode);
            lastInsertion++;
        }else{

            Node vacantPosition;

            if(list.get(lastInsertion).lChild==null){
              vacantPosition = list.get(lastInsertion);
              vacantPosition.lChild = newNode;
            } else if(list.get(lastInsertion).rChild==null){
                vacantPosition = list.get(lastInsertion);
                vacantPosition.rChild = newNode;
            }else{
                lastInsertion++;
                vacantPosition = list.get(lastInsertion);
                vacantPosition.lChild = newNode;
            }
            list.add(newNode);
            newNode.parentNode = vacantPosition;
            heapify(newNode);
        }
    }

    public void heapify(Node node){
        if(node==null){
            return;
        }else{
            if(node.parentNode==null){
                return;
            }else{
                if(node.parentNode.key > node.key){
                    int temp = node.parentNode.key;
                    node.parentNode.key = node.key;
                    node.key = temp;
                    heapify(node.parentNode);
                }
            }
            return;
        }
    }

    public int delete(){
        if(root==null){
            System.out.println("Heap is empty");
            return 99999;
        }else if(root.lChild==null){
            int key = root.key;
            root = null;
            list.removeLast();
            return key;
        }else{
            Node lastInsertionNode = list.get(lastInsertion);
            int key = root.key;
            if(lastInsertionNode.rChild!=null){
                root.key = lastInsertionNode.rChild.key;
                list.removeLast();
                lastInsertionNode.rChild = null;
                heapifyDown(root);
            }else{
                root.key = lastInsertionNode.lChild.key;
                list.removeLast();
                lastInsertionNode.lChild = null;
                lastInsertion--;
                heapifyDown(root);
            }
            return key;
        }
    }
    public void heapifyDown(Node node){

        if(node.lChild==null && node.rChild==null){
            return;
        }else{
            Node smallChild;
            if(node.lChild!=null && node.rChild!=null){
                //compareChildren and then minimum with root
                smallChild = getSmall(node.lChild,node.rChild);

            }else{
                //compare root with left child
                smallChild = node.lChild;
            }
            if(smallChild.key < node.key){
                int temp = smallChild.key;
                smallChild.key = node.key;
                node.key = temp;
                heapifyDown(smallChild);
            }
        }

    }

    private Node getSmall(Node lChild, Node rChild) {
        if(lChild.key<rChild.key){
            return lChild;
        }else{
            return rChild;
        }
    }

    public void traverse(Node node){
        if(node!=null){
            System.out.println(node.key);
            traverse(node.lChild);
            traverse(node.rChild);
        }
    }
}
