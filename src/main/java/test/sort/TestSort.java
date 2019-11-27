package test.sort;

import java.util.Arrays;

/**
 * 排序算法
 * Created by liufei on 2018/3/29.
 */
public class TestSort {

    public static  void main(String[] args){
        int[] nums = maopaoSort();
        //运用二分法找到数据
        int flag=8;
        int location = MiddleSort(nums,flag);
        System.out.println("数组："+Arrays.toString(nums)+"中,数字："+flag+"在第"+(location+1)+"位置");
    }

    /**
     * 冒泡排序
     */
    public static int[]  maopaoSort(){
        //要排序的数组
        int[] nums = {9,7,1,2,3,8};
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    temp =nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    /**
     * 二分法查找 找到flag对应的数据从大到小
     */
    public static int MiddleSort(int[] nums,int flag){
        //查找的开始位置
        int first =0;
        //查找的结束位置
        int end = nums.length;
        //最终找到的位置
        for(int i =0;i<nums.length;i++){
            int middle = (first+end)/2;
            int middleNum = nums[middle];
            if(flag==middleNum){
                return middle;
            }else if(flag<middleNum){
                first = middle+1;
            }else {
                end = middle-1;
            }
        }
        return 0;
    }
}




