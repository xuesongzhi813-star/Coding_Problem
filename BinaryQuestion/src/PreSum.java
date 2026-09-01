import java.util.HashMap;
import java.util.Map;

public class PreSum {
//    public static int pivotIndex(int[] nums) {
//        //先创建前后缀数组，不需要长度与i有关联太麻烦
//        int[] f=new int[nums.length];
//        int[] g=new int[nums.length];
//        f[0]=0;
//        g[nums.length-1]=0;
//        //赋值数组
//        //f[i]表示从0~i-1下标数和，前缀和
//        for(int i=1;i<f.length;i++){
//            f[i]=f[i-1]+nums[i-1];
//        }
//        //g[i]表示从i+1~n-1下标数和，后缀和
//        for(int i=nums.length-2;i>=0;i--){
//            g[i]=g[i+1]+nums[i+1];
//        }
//        //使用数组，寻找中心下标
//        for(int i=0;i<nums.length;i++){
//            if(f[i]==g[i]){
//                return i;
//            }
//        }
//        //不存在则返回-1
//        return -1;
//    }

    public static int subarraySum(int[] nums, int k) {
        //记录滚动相加的前缀和
        //就是整个下标以i结尾的数组遍历总和，因为每一次移动都会加上当前位置数
        int total=0;
        //创建一个哈希表，记录前缀和出现的次数
        //key为sum[i]-k的前缀和取值，value为出现的次数
        //i不断向后遍历，每一个i结尾对应的子数组个数就是value的出现次数
        //因为每一个以i下标为结尾的“大数组”sum不变，那么sum-k不变，则每一个key对应这个大数组中成立的子数组“满足的条件”
        //value对应一个以i结尾的大数组内满足的子数组个数
        Map<Integer,Integer> map=new HashMap<>();
        //如果整个数组的和==k，需要越界数组去找和为k的后半部，这是不可能的，先设置一个
        map.put(0,1);
        int ret=0;
        for(int i=0;i<nums.length;i++){
            //计算出当前的前缀和
            total+=nums[i];
            //子数组增加，获取目前为止，所有满足的
            ret+=map.getOrDefault(total-k,0);
            //放入哈希
            map.put(total,map.getOrDefault(total,0)+1);

        }
        return ret;
    }
}
