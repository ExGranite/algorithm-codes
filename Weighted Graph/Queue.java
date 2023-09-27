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
    
    Node checkMin(){
        int min = head.dist, count = 0, minCount = 0;
        for(Node n = head.next; n != null; n = n.next){
            count++;
            if(n.dist < min){
                min = n.dist; minCount = count;
            }
        }
        return dequeue(minCount);
    }
    
    Node find(int a){
        int count = 0; Node temp = null;
        for(Node n = head; n != null; n = n.next){
            if(count == a){
                temp = n;
                break;
            }
        }
        return temp;
    }
    
    Node dequeue(int a){
        int count = 0; Node temp = null;
        for(Node n = head; n != null; n = n.next){
            if(count == a){
                temp = n;
                n = n.next;
                break;
            }
        }
        return temp;
    }
}
class Node {
    Node next;
    int position, dist = 999;
    Node(int p){
        position = p;
    }
}