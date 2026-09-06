import java.util.List;

public class TwoPointMain {
    public static void main(String[] args) {
        TwoPoint twoPoint=new TwoPoint();
        //测试“双指针”--盛水最多的容器
//        int[] height={1,8,6,2,5,4,8,3,7};
//        int i = twoPoint.maxArea(height);
//        System.out.println(i);

        //测试“双指针”--三数之和
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = twoPoint.threeSum(nums);
        for(List<Integer> list:lists){
            System.out.println(list.toArray());
        }
    }
}
