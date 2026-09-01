public class BinarySolution {
    /**
     * 二分查找x的平方根
     * 细节：注意存在大数的平方，会越界，使用long类型
     * 二段性：i*i>x||i*i<=x
     * @param
     * @return left强转成int
     */
    public int mySqrt(int x) {
        long left=1;
        long right=x;
        if(x==0){
            return 0;
        }
        while(left<right){
            long mid=left+(right-left+1)/2;
            if(mid*mid>x){
                //尽量去找最小贴近于x的平方根
                right=mid-1;
            }
            if(mid*mid<=x){
                left=mid;
            }
        }
        return (int) left;
    }

    /**
     * 二分查找要插入的位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
       //在末尾进行添加的情况
        if(nums[left]<target){
            return nums.length;
        }
        return left;
    }

    /**
     * 寻找山峰数组的山峰值
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if(arr[mid]>arr[mid-1]){
                left=mid;
            }
            else{
                right=mid-1;
            }
        }
        return left;
    }

    /**
     * 寻找旋转排序数组中最小值
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int n=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[n-1]){
                //在AB段，要向CD段移动
                left=mid+1;
            }
            else{
                //在CD段，要尽量去找C点
                right=mid;
            }
        }
        return nums[left];
    }

    /**
     * 查询0~n-1中缺失的数字
     * @param records
     * @return
     */
    public int takeAttendance(int[] records) {
        //使用二分查找
        int left=0;
        int right=records.length-1;
        int n=records.length;
        while(left<right){
            int mid=left+(right-left)/2;
            //如果在左区间，则向右区间去查找
            if(records[mid]==mid){
                left=mid+1;
            }
            //如果在右区间，则向右区间的左端点去查找
            if(records[mid]!=mid){
                right=mid;
            }
        }
        //如果是末尾缺失的情况，此时不存在右区间
        if(left==n-1&&left==records[left]){
            return (left+1);
        }
        return left;
    }
}
