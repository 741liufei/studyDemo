package test.sort;

import java.util.Arrays;

/**
 * 归并排序
 * Created by liufei on 2018/4/17.
 */
public class MergeSort {
    public static void main(String[] args){
        int[] num ={1,3,7,4,5,8,6,9};
        split(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }
    /**
     * 将数组进行拆分
     * @param num
     * @param begin 第一位坐标
     * @param end 最后一位坐标
     */
    public static void split(int[] num,int begin ,int end){
        //中间位置坐标
        int mid = (begin+end)/2;
        if(begin<end){
           //递归拆分左边数据
            split(num,begin,mid);
            //递归拆分右边数据
            split(num,mid+1,end);
            merge(num,begin,mid,end);
        }
    }
    /**
     * 合并
     * @param n
     * @param begin 开始标记
     * @param mid 中间标记
     * @param end 结束标记
     */
    public static  void  merge(int[]n ,int begin,int mid ,int end){
        int[] temp = new int[end - begin+1];
        //第一个数组的起始坐标
        int i =begin;
        //第二个数组的坐标
        int j=mid+1;
        //合并后数组的坐标
        int k =0;
        while (i<=mid&j<=end){
            if(n[i]<n[j]){
                temp[k++]= n[i++];
            }else {
                temp[k++] =n[j++];
            }
        }
        while (i<=mid){
            temp[k++] = n[i++];
        }
        while(j<=end){
            temp[k++] = n[j++];
        }
        //将临时组数据覆盖到数组中
        for(int k2 = 0;k2<temp.length;k2++){
            n[k2+begin] = temp[k2];
        }
    }
}
