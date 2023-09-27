class Queue {
    Node head;
    Node tail;
    
    void enqueue(int a){
        Node n = new Node(a);
        if(head == null){
            head = n; tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }
    
    boolean check(){
        if(head == null){
            return false;
        }
        else 
            return true;
    }
    
    int dequeue(){
        Node temp = head;
        head = head.next;
        return head.position;
    }
}
class Node {
    Node next;
    int position;
    Node(int p){
        position = p;
    }
}