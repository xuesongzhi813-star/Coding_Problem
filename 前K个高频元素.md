# 前K个高频元素的笔记

## 题目解析

本题有两个关键点：  
1. 记录元素出现的频率

2. 返回前k个出现频率最高的数组

## 解决策略

1. 关于记录元素频率，我们可以使用哈希表解决

2. 前K个属于是Top-K问题，使用小根堆解决

**细节补充**  
本题求的是前K个，因此单纯的小根堆是不能解决问题的。

解决策略：只存K个元素，满了之后每次都比较，只有更大的才能进堆


```
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      //使用哈希表记录元素出现的个数
      Map<Integer,Integer> hashMap=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
      }
      //使用小根堆，记录元素
      PriorityQueue<int[]> queue=new PriorityQueue<>(
        (v1,v2)->{
            return v1[1]-v2[1];
        }
      );
      //小根堆中只存k个元素，不断变更直至k个元素都是大频率
      for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
        int a=entry.getKey();
        int b=entry.getValue();
        //构造数组，放入小根堆 
        int[] arr=new int[]{a,b};
        if(queue.size()<k){
            //当长度不足k的时候，放入小根堆
            queue.offer(arr);
        }
        else{
            //当长度=k后，把出现频率小的元素给踢出去，出现频率多的元素放进来
            if(arr[1]>(queue.peek()[1])){
                queue.poll();
                queue.offer(arr);
            }
        }
      }
      //此时，小根堆中的元素就是结果
      int[] ret=new int[k];
      int i=0;
      while(k>0){
        ret[i]=queue.poll()[0];
        i++;
        k--;
      }
      return ret;
    }
}
```