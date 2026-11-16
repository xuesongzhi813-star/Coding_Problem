# K个一组翻转链表笔记

## 题目解析

类似一个模拟的题，按k个节点为一组，翻转本组的节点顺序，最后不满k个的就按原顺序（相对顺序和以前一样，即每一组的相对顺序）

## 解题策略

采用模拟的思想：先按k个一组分出有n组要翻转，再使用头插另起一个新链表（头插新链表，相当于翻转），每一组开始前更新本次头插的位置节点即可。

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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        //先求按k个一组，能分成几组
        ListNode cur=head;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        int n=size/k;

        //翻转-->可以使用头插新链表
        //cur:负责遍历原数组进行头插
        //tmp：负责找新的一组开始时的第一个节点（也就是下一组头插连接的节点）
        //prev：每一组头插连接的节点
        cur=head;
        ListNode newHead=new ListNode();
        ListNode tmp=newHead;
        ListNode prev=newHead;
        while(n>0){
            //每一组开始前的准备工作
            //1.prev=tmp，获得本轮头插连接在哪个节点后
            //2.tmp获取本轮第一个节点，作为下一轮头插到的节点
            prev=tmp;
            tmp=cur;
            for(int i=0;i<k;i++){
                //开始头插循环
                ListNode theNext=prev.next;
                prev.next=cur;
                cur=cur.next;
                prev.next.next=theNext;
            }
            n--;
        }
        
        //将cur后的节点全部拼接即可
        prev=tmp;
        prev.next=cur;

        return newHead.next;
    }
}
```

原始笔记参考：  
本题解题策略:模拟策略:  
1. 先求需要逆序多少组: n=total_size/3; 
2. 重复n次，长度为k的逆序，头插k次

本次模拟中，需要注意的几个事项:  
1. cur始终是按照原顺序在移动； 
2. tmp是指向下一组逆序的开头； 3.prev是本组逆序的头插开头 
