package test.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快速排序
 * Created by liufei on 2018/4/3.
 */
public class QuickSort {
    static int[] nums ={4,2,6,5,3,1};

    public static void  main(String[] args){
        //请输入数字
        System.out.println("请输入数组数字个数：");
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        nums = new int[length];
        for (int i=0;i<length;i++){
            System.out.println("请输入数组数字,第"+(i+1)+"位");
            Scanner scanner = new Scanner(System.in);
            nums[i]  = scanner.nextInt();
        }
        System.out.println("要排序的数组为："+ Arrays.toString(nums));
        quitSort(0,nums.length-1);
        System.out.println("经过快速排序后的数组为："+Arrays.toString(nums));
    }

    /**
     * 快速排序
     * @param begin 数组开始标记位
     * @param end 数组结束标记位
     */
    public static void quitSort(int begin,int end){
        while (begin>=end){
            return;
        }
        //临时数据作为交换中间数
        int temp = 0;
        //设置最左边数作为基准数
        int index = begin;
        //设置左右哨兵
        int left = begin;
        //右哨兵
        int right = end;
        while (left!=right){
            //首先从右往左查找比基准数还小的数
            while (nums[right]>=nums[index]&&left<right){
                right--;
            }
            //左哨兵从左往右查找比基准数大的数
            while (nums[left]<=nums[index]&&left<right){
                left ++;
            }
            if(left<right){//左右哨兵没有相遇则互相进行交换
                temp = nums[right];
                nums[right]= nums[left];
                nums[left] = temp;
            }
        }
        temp = nums[left];
        nums[left] = nums[index];
        nums[index] = temp;
        index = left;
        //经过上述处理可以保证基准数左边都比它小，右边都比它大，然后再取左边范围递归，然后再取右边范围递归
        quitSort(begin,index-1);
        //处理右边范围
        quitSort(index+1,end);
    }
}
