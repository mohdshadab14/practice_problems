package leetcode;



public class MergeSortedListList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalListHead = null;

        ListNode finalListCurrent = new ListNode();
        finalListHead = finalListCurrent;

        while(list1!=null && list2!=null){

            if(list1.val<list2.val){
                finalListCurrent.next = list1;
                list1 = list1.next;
            }else{
                finalListCurrent.next = list2;
                list2 = list2.next;
            }
            finalListCurrent = finalListCurrent.next;
        }
        if(list1!=null){
            finalListCurrent.next = list1;
        }else if(list2!=null){
            finalListCurrent.next = list2;
        }
        finalListHead = finalListHead.next;
        return finalListHead;
    }

}