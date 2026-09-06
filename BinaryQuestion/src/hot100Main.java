public class hot100Main {
    public static void main(String[] args) {
        hot100 hot100=new hot100();
        //测试hot100：最长连续序列
        int[] nums={1,100,200,2,4,3};
        int i = hot100.longestConsecutive(nums);
        System.out.println(i);
    }
}
