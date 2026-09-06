import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPoint {
    /**
     * 最大盛水容积
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxone=0;
        while(left<right){
            //使用更小的边
            int heights=height[left]>height[right]?right:left;
            //记录更大的值
            maxone=Math.max(maxone,height[heights]*(right-left));
            //更小的一侧进行移动
            if(height[left]<height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxone;
    }

    /**
     * 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //先对其进行升序排序，确保不重复（）
        Arrays.sort(nums);
        int left=0;
        int cur=nums.length-1;
        int right=cur-1;
        int target=0;
        List<List<Integer>> lists=new ArrayList<>();
        //循环条件：保证能有三个数相加
        while(cur>=2){
            left=0;
            right=cur-1;
            //进入第二层循环，每次都是一个固定的cur
            //循环条件：保证除cur外，一定还能有两个数相加
            while(left<right){
                int sum=nums[left]+nums[right]+nums[cur];
                //与target比较大小从而决定如何进行下一步
                if(target>sum){
                    //如果小于target，则left移动，指向更大值
                    left++;
                }
                else if(target<sum){
                    //如果大于target，则right移动，指向更小值
                    right--;
                }
                else{
                    //如果相等，则存为一中结果，并且结束
                    List<Integer> combination=new ArrayList<>();
                    combination.add(nums[left]);
                    combination.add(nums[right]);
                    combination.add(nums[cur]);
                    lists.add(combination);
                    break;
                }
            }
            cur--;
        }
        return lists;
    }
}
