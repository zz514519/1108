/**
 * Author : Zhang Zhe
 */

class Listlink{
    public int data;
    public  Listlink next;
    public Listlink(int data){
        this.data=data;
        this.next=null;
    }
}
class List {
    public Listlink head;

    public List() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        Listlink node = new Listlink(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        Listlink node = new Listlink(data);
        Listlink cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //打印单列表
    public void display() {
        Listlink cur = this.head;
        if (this.head == null) {
            return;
        } else {
            while (cur != null) {
                System.out.print(cur.data + "    ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    //获取链表长度
    public int getlength() {
        Listlink cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //插入到index位置
    //任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        if (index < 0 || index > getlength()) {
            return false;
        }
        if (index == 0) {
            addFirst(data);
            return true;
        } else {
            Listlink node = new Listlink(data);
            Listlink cur = this.head;
            int count = 0;
            while (count < index - 1) {
                cur = cur.next;
                count++;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }
    //查询是否含有key
    public boolean contains(int key){
        Listlink cur = this.head;
        while (cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //找前驱
    public Listlink seachPrev(int key){
        Listlink cur = this.head;
        while (cur.next!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    public void remove(int key){
        Listlink cur = seachPrev(key);
        if(cur==null){
            System.out.println("没有要删除的节点！");
            return ;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
        Listlink del = cur.next;
        cur.next=del.next;
    }
    public void removeAll(int key){
        Listlink cur = this.head;
        Listlink prev = this.head.next;
        while(prev!=null){
            if(cur.next.data==key){
                cur.next=prev.next;
                prev=prev.next;
            }else{
                cur=prev;
                prev=prev.next;
            }
        }
        if(this.head.data==key){
            this.head = this.head.next;
        }
    }
    //逆序单列表
    public Listlink reverse(){
        Listlink cur=this.head;
        Listlink prev=null;
        Listlink newHead=null;
        while (cur != null) {
            Listlink curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }
    //打印逆序单列表
    public void play(){
        Listlink cur=reverse();
        if(cur==null){
            return;
        }
        while(cur!=null){
            System.out.print(cur.data+"    ");
            cur=cur.next;
        }
        System.out.println();
    }
    //返回中间值
    public Listlink middleNode(){
        Listlink fast = this.head;
        Listlink slow = this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //寻找倒数第K个节点
    public Listlink findKthToTail(int k) {
        Listlink fast = this.head;
        Listlink slow = this.head;
        if (k <= 0) {
            return null;
        }
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("没有这个节点！");
                return null;
            }
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
