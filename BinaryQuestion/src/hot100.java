import java.util.HashSet;
import java.util.Set;

public class hot100 {
    public int longestConsecutive(int[] nums) {
        //先使用hashSet对数组元素去重
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        //再去遍历去重后的数组
        int longestLength=0;
        for(int num:set){
            //核心思路：判断当前数是不是开头
            //如果是，就进入循环，一直找后续
            //如果不是，就下一个

            if(!set.contains(num-1)){
                //不存在前一个数
                int currentNum=num;
                int currentLength=1;

                //进入循环查找
                while(set.contains(currentNum+1)){
                    currentNum=currentNum+1;
                    currentLength++;
                }

                //结束找到值
                longestLength=Math.max(currentLength,longestLength);
            }
            //如果不是开头则直接下一个
        }
        return longestLength;
    }
}
