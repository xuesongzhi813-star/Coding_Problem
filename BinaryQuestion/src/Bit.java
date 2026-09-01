/**
 * 位运算相关的算法题
 */
public class Bit {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++){
            int total=0;
            //代替i去位运算，负责下标有误
            int ret=i;
            while(ret!=0){
                ret &= (ret-1);
                total++;
            }
            arr[i]=total;
        }
        return arr;
    }

    /**
     * 找出“两个只出现一次的数”
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            result[0] ^=nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            result[1] ^=nums[i];
        }

        return result;
    }


    /**
     * 找到缺失的两个数
     * @param nums
     * @return
     */
    public int[] missingTwo(int[] nums) {
        //定义结果返回的数组
        int[] result=new int[2];
        //先让数组中所有元素与其下标全部异或一次
        int count=0;
        for(int i=0;i<nums.length;i++){
            //先与数组元素异或
            count^=nums[i];
            //虽然下标是从0开始，但是范围是1~n
            count^=i+1;
        }
        //别忘了因为数少两个，最后两个个要补上
        count^=nums.length+1;
        count^=nums.length+2;
        int ret=count & (-count);

        //不同的两个数
        int a=0;
        int b=0;
        //找到第几位，是不同的，并且以此对整个数组元素分类，再次与1~n^(因为所有都是只出现一次，还是要人为加上1~n)
        for(int i=0;i<nums.length;i++){
            if((ret & nums[i])==0){
                a^=nums[i];
                if((ret & (i+1))==0){
                    a^=(i+1);
                }
                else {
                    b^=(i+1);
                }
            }
            else{
                b^=nums[i];
                if((ret & (i+1))==0){
                    a^=(i+1);
                }
                else {
                    b^=(i+1);
                }
            }
        }
        //不要忘记了n-1和n还未被^
        //同样需要我们进行分类
        for (int i=nums.length+1;i<nums.length+3;i++) {
            if ((i & ret) == 0) {
                a^=i;
            }
            else {
                b^=i;
            }
        }
        //最终得到两数
        result[0]=a;
        result[1]=b;
        return result;
    }
}
