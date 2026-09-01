/**
 * 调式“位运算算法题”的方法
 */
public class BitMain {
    public static void main(String[] args) {
        Bit bit=new Bit();
        //测试找数的二进制表示中1的个数
//        int[] ints = bit.countBits(2);
//        System.out.println(ints.toString());
//        int[] nums={1,2,1,3,2,5};
//        int[] ints = bit.singleNumber(nums);
//        System.out.println(ints.toString());
        //测试“找到缺失的两个数”
        int [] ints={2,3};
        int[] result = bit.missingTwo(ints);
        System.out.println(result.toString());
    }
}
