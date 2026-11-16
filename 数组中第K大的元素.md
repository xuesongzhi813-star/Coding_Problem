# 数组中第K大的元素笔记

## 题目解析

典型的Top-k类型的问题（第K个大/小）。  
第K大一般就是：
- “自建大根堆返回第K个”

- “使用小根堆（k的容积），不断筛选大的进来，最后顶部最小的，就是第K个”

## 解题策略

本题主要是为了考察自建大根堆

自建大根堆步骤：从下到上的向下调整+poll方法

```
class Solution {
    //本质考察：手搓大根堆
    public void createMaxHeap(int[] elem,int usedSize){
        //手搓大根堆关键：从后向前，向下调整
        for(int parent=(usedSize-1-1/2);parent>=0;parent--){
            //从最后一棵子树进行
            shiftDown(parent,elem,usedSize);
        }
    }

    public void shiftDown(int parent,int[] elem,int usedSize){
        //先确认孩子
        int child=parent*2+1;
        while(child<usedSize){
            //判断是左孩子大，还是右孩子大，取更大的孩子来比较
            if(child+1<usedSize && elem[child+1]>elem[child]){
                child=child+1;
            }
            //孩子与父比较
            if(elem[parent]<elem[child]){
                swap(elem,parent,child);
                //判断本轮的向下调整，有没有影响到之前调整的大根堆
                parent=child;
                child=2*parent+1;
            }
            else{
                break;  //重要！不然无限循环
            }
        }
    }

    public int poll(int[] elem,int usedSize){
        //逻辑：与最后一个交换，usedSize--
        if(elem.length==0){
            return -1;
        }
        //先记录poll的元素
        int ret=elem[0];
        swap(elem,0,usedSize-1);
        usedSize--;
        //向下调整,重新调整为大根堆
        shiftDown(0,elem,usedSize);
        return ret;
    }

    public void swap(int[] elem,int parent,int child){
        int tmp=elem[parent];
        elem[parent]=elem[child];
        elem[child]=tmp;
    }

    public int findKthLargest(int[] nums, int k) {
        //手搓进入大根堆
        createMaxHeap(nums,nums.length);
        //从大根堆中取出第K个就是结果
        int result=0;
        int n=nums.length;
        while(k>0){
            result=poll(nums,n);
            k--;
            n--;
        }
        return result;
    }
}
```