//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BinarySolution binarySolution = new BinarySolution();
        //测试查找平方根
//        System.out.println(solution.mySqrt(2147483647));
        //测试查找插入位置
//        int[] a={1};
//        System.out.println("要插入的位置是："+solution.searchInsert(a, 0));
        //测试寻找山峰数组峰顶
//        int[] a={0,1,2,1,0};
//        System.out.println("山峰数组的峰顶是:"+solution.peakIndexInMountainArray(a));
        //测试旋转数组中的最小值
//        int[] a={3,4,5,1,2};
//        System.out.println("旋转数组中最小值是："+solution.findMin(a));
        //测试寻找缺少的数字
//        int[] a={0,1,2,3,5};
//        int i = binarySolution.takeAttendance(a);
//        System.out.println("缺失的数字是："+i);
        //测试前缀和，寻找中心下标
//        int[] arr={1,7,3,6,5,6};
//        int i = PreSum.pivotIndex(arr);
//        System.out.println("中心下标是:"+i);
//    }
        int[] a={1,2,3};
        int i = PreSum.subarraySum(a, 3);
        System.out.println("子数组个数为："+i);
    }

}