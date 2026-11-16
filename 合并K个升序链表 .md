# 合并K个升序链表的笔记

## 题目解析

本题本质与“合并两个升序链表”一致，只是把两个升级到了K个。

完全可以使用暴力解法：从前两个开始合并，合并成一个后，再继续向后与一个合并。但是时间复杂度趋近于O（n^3）。所以，我们需要对这个方法进行优化

## 方法优化

**方法引入**

优先级队列-->小根堆，最顶的元素，一定是最小的。

因此，我们可以借助小根堆，每次出一个“最小节点”，再补充这个节点所属的链表后的节点。这样拼接出的链表，就是“升序链表”，同时是基于原方法的优化。

**细节补充**

1. 因为，题目提供的链表不是一个“可以明确排序的类型”，因此，我们自己要在“创建优先级队列”时，添加一个“排序规则”

2. 如果当前链表节点为null/下一个节点为null，就不能再往优先级队列中添加值了

3. 一开始是拿“虚拟头节点”进行拼接的，因此，返回的节点是虚拟头节点的下一个

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //解题思路和“合并两个升序链表”基本一致
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //创建一个“小根堆”，把k个链表的头节点全部放入小根堆，踢出最小的，并且不断加入节点
        //ListNode是自定义的链表，需要先提供“排序标准”
        PriorityQueue<ListNode> queue=new PriorityQueue<>((a,b)->a.val-b.val);
        //将所有k个链表的头节点全部放入
        for(ListNode list:lists){
            if(list!=null){
            queue.add(list);
            }
        }
        //创建合并后的链表,虚拟头节点
        ListNode prev=new ListNode(0);
        ListNode test=prev;
        //对小根堆元素开始处理
        while(!queue.isEmpty()){
            //先取出最小的节点
            ListNode cur=queue.poll();
            test.next=cur;
            //移出去的节点，接着入队
            if(cur.next!=null){
            queue.add(cur.next);
            }
            test=test.next;
        }
        //全部节点处理完后，返回合并的链表
        return prev.next;
    }
}
```
