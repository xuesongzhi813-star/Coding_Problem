import java.util.*;

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
//        int [] ints={2,3};
//        int[] result = bit.missingTwo(ints);
//        System.out.println(result.toString());

        String sss="444";
        char[] s=sss.toCharArray();
        String a=s.toString();
        System.out.println(a);
        char q='a';
        s[0]=q;
        Map<String, List<String>> map=new HashMap<>();
        map.containsKey("");
        map.put("",new ArrayList<>());
        Arrays.sort(s);
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            entry.getKey();
        }
        Set<Integer> set=new HashSet<>();
        set.add(1);
        System.out.println(s.toString());
    }
}
