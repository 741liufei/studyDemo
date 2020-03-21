package test.sort;

import com.alibaba.dubbo.common.utils.StringUtils;

/**
 * @author feis.liu
 * @description: 冒泡排序
 * @date 2019/12/16 12:03
 **/
public class BubbleSort {

    public static void main(String[] args){
        Integer[] values= {4,5,1,9,6,2,3};
        sort(values);
        System.out.println(StringUtils.toArgumentString(values));
    }

    /**
     * 采用冒泡排序排列数组
     * 依次比较相邻的两个数字如果 前面的数字比后面的数字大则进行交换，一次遍历之后最大的数保证移动到最后一位
     * 然后遍历0--(N-2)N-1个数字 直到 遍历到0-0结束
     * @param values
     */
    public static   void sort(Integer [] values){
        for (int i=0;i<values.length-1;i++){
            for (int j=0; j< values.length-i-1;j++ ){
                if (values[j] > values[j+1] ){
                    int temp = values[j];
                    values[j] =  values[j+1];
                    values[j+1] = temp;
                }
            }
        }

    }
}
