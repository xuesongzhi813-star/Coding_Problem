# LRU缓存笔记

## 思路解析：

题目中的重要点：

- get：要去缓存中取value，不存在返回-1，时间复杂度要O（1）-->可以使用哈希表，直接查询
- put：如果关键字key存在，要变更value
- put：不存在则插入key-value
- put：若超出容量，则会踢出最久未使用的关键字


应对解析：

- 每次对一个数操作之后（插入/更改），这个关键字就会被移动到头部（O（1）的前提下，只有双向链表的移动可以实现）

- 不常使用的删除-->就是删除链表的尾巴

题目解决：

1.构造一个自己的双向链表  
2.链表的配套方法：

- 头插：因为每次新进来的元素一定是“最近被使用的”
- 尾删：因为是头插，所以链表尾巴一定是“最久没被使用的”
- 移动链表头：每次重新赋值（put）/查询（get）之后，都算作“被使用”，因此要移动这个节点到头部

```
    class LRUCache {
        //自定义一个双向链表
      class LinkNode{
        LinkNode prev;
        LinkNode next;
        int key;
        int value;
        //构造方法
        public LinkNode(int k,int v){
            this.key=k;
            this.value=v;
            prev=null;
            next=null;
        }
        public LinkNode(){

        }
      }
        //一个哈希表
        Map<Integer,LinkNode> hashMap=new HashMap<>();
        //LRU数据结构的大小
        int capicity;
        //当前LRU的容积
        int size;
        //LRU数据结构的头和尾
        LinkNode head;
        LinkNode tail;
        public LRUCache(int capacity) {
            //初始化，容积确定+头，尾初始
            this.capicity=capacity;
            size=0;
            head=new LinkNode();
            tail=new LinkNode();
            head.next=tail;
            tail.prev=head;
        }

        public int get(int key) {
            //功能：获取到value+把这个元素提取到头
            int result=0;
            if(hashMap.containsKey(key)){
                //从哈希表中提取
                LinkNode linkNode = hashMap.get(key);
                result=linkNode.value;
                //提取到头（在尾/在头/在中间）
                //难点：如何处理在中间
                //直接移动到头
                moveToHead(linkNode);
                return result;
            }
            else {
                //没有找到则返回-1
                return -1;
            }
        }

        public void put(int key, int value) {
            //如果重复存在，把元素移动到头
            if(hashMap.containsKey(key)){
                LinkNode linkNode=hashMap.get(key);
                linkNode.value=value;
                moveToHead(linkNode);
                return;
            }
            //先定义一个链表节点
            LinkNode linkNode=new LinkNode(key,value);
            //判断容积是否满了，如果满了要先清理一个出去
            if(size==capicity) {
                LinkNode cur=deleteLast();
                //从哈希表踢出去
                hashMap.remove(cur.key);
            }
            //踢出后/没满
            hashMap.put(key,linkNode);
            addFirst(linkNode);
        }

        //自定义的双向链表，头插(其实尾插根本用不上，因为插入必然是在头（最新被使用，则在头）
        public void addFirst(LinkNode linkNode){
            linkNode.next=head.next;
            head.next.prev=linkNode;
            head.next=linkNode;
            linkNode.prev=head;
            size++;
        }

        //自定义的双向链表，尾删(删除最久没有使用的，就是尾巴元素)
        public LinkNode deleteLast(){
            LinkNode cur=tail.prev;
            tail.prev=tail.prev.prev;
            tail.prev.next=tail;
            size--;
            return cur;
        }

        //移动到头的方法
        public void moveToHead(LinkNode linkNode){
                linkNode.prev.next=linkNode.next;
                linkNode.next.prev=linkNode.prev;
                linkNode.next=head.next;
                linkNode.prev=head;
                linkNode.next.prev=linkNode;
                head.next=linkNode;  
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```