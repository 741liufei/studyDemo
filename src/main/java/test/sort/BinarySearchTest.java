package test.sort;

import com.sun.corba.se.impl.orbutil.StackImpl;

import java.util.Arrays;

/**
 * 二分法查找
 * Created by liufei on 2018/4/19.
 */
public class BinarySearchTest {
    public static int[] nums = {2,3,3,3,3,3,3,3};

    public static void main(String[] args){
        int search =2;
//        int mid = search(nums,search);
//        System.out.print("数组"+ Arrays.toString(nums)+"中"+search+"数字的位置在："+(mid+1));
        int count = searchRepeatNum(nums,search);
        System.out.print("数组"+ Arrays.toString(nums)+"中"+search+"数字出现的次数为："+(count));
    }

    public static int search(int[] nums,int search){
        int begin =0;
        int end = nums.length-1;
        int count =0;
        while (begin<end){
            //取中间数
            int mid = (begin+end)/2;
            if(search==nums[mid]){
                return mid;
            }else if(search<nums[mid]){
                end  = mid-1;
            }else {
                begin = mid+1;
            }
        }
        return count;
    }


    public static int searchRepeatNum(int[] nums ,int search){
        int begin =0;
        int end = nums.length-1;
        int count =0;
        while(begin<=end){
            int mid = (begin+end)/2;
            if(search<nums[mid]){
                end = mid-1;
            }else if(search>nums[mid]){
                begin = mid+1;
            }else {
                if(begin==end){
                    count ++;
                }else {
                    count = getCount(nums,mid,begin,end)+1;
                }
                return count;
            }
        }
        return count;
    }

    public static int getCount(int[]nums,int mid,int begin,int end){
        int count=0;
        int search = nums[mid];
        //判断左边是否有数据
        if(mid-begin>=1){//左边有数据，判断是否左边区间的数据是否和查找数相同
            for(int i = mid-1;i>=begin;i--){
                if(nums[i]==search){
                    count++;
                }else {
                    break;
                }
            }
        }
        //判断右边区间是否有数据
        if(end - mid>=1){//判断右边数据是否相同
            for(int i=mid+1;i<=end;i++){
                if(nums[i]==search){
                    count++;
                }else {
                    return count;
                }
            }
        }
        return  count;
    }
}
