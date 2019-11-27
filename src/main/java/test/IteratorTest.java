package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author feis.liu
 * @description:
 * @date 2019/11/20 14:16
 **/
public class IteratorTest {

    public static void main(String[] args){
        int[] result = twoSum(new int[]{3, 2, 4},6);
        System.out.println();
    }

    public  static  int[] twoSumOne(int[] nums, int target) {
        int[] result = new int[2];
        for(int i =0;i<nums.length;i++){
            for(int j=i+1; j<nums.length ;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result  = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                result[0] =map.get(nums[i]);
                result[1] = i;
                return result;
            }
            //将target减去数组数字的结果存入map，如果遍历到map里有这个值的时候就可以直接取下标了
            map.put(target-nums[i],i);
        }
        return result;
    }

    public static void testIteratorList(){
        List<String> testList = new ArrayList<>();

        testList.add("111");
        testList.add("222");
        testList.add("333");
        Iterator<String> iterator = testList.iterator();
        while (iterator.hasNext()){
            String result =iterator.next();
            System.out.println(result);
        }
    }

    public static void testIteratorMap(){
        Map<String,String> map = new HashMap<>();
        map.put("b","1");
        map.put("a","2");
        map.put("c","3");
        map.put("d","4");
        map.put("e","5");
        map.put("f","6");
        map.put("g","7");
        Iterator<Entry<String,String>> iterator = map.entrySet().iterator();

//        while(iterator.hasNext()){
//            Entry<String,String> entry= iterator.next();
//            System.out.println(entry.getKey()+entry.getValue());
//        }
        for (Entry<String,String> entry :map.entrySet()){
            System.out.println(entry.getKey()+entry.getValue());
        }
    }

}
