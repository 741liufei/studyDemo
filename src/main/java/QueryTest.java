/**
 * @author liufei
 * @description:
 * @date 2020/5/15 14:08
 **/
public class QueryTest {

    public static void main(String[]args){
        String a ="11";

    }


    public static int[] searchNumNew(int[]nums,int search){
        int begin = 0;
        int end = nums.length-1;
        int left = begin;
        int right = end;
        //向右查找确定比search大的右边界
        int firstIndex=-1;
        int count = 0;
        while(nums[right] > search){
            if(nums[right-1]<=search){
                break;
            }
            int mid = (begin + right )/2;
            if (search < nums[mid] ){//如果mid比search大则把右边界改为mid
                right = mid ;
            }else{
               begin = mid;
            }
        }
        end = right;
        while (nums[left]<search){
            if(left+1 < nums.length &&nums[left+1] > search){
                break;
            }
            int mid = (left + end )/2;
            if (search > nums[mid] ){//如果mid比search小则把左边界改为mid
                left = mid ;
            }else{
                end = mid;
            }
        }
        count = right-left-1;
        if (count>0){
            firstIndex= left+1;
        }else{
            count =0;
        }
        int[] result =new int [2];
        result[0]=firstIndex;
        result[1]=count;

        return result;


    }

    public static int[] searchRepeatNum(int[] nums ,int search){
        int begin =0;
        int end = nums.length-1;
        int count =0;
        int firstIndex=-1;
        while(begin<=end){
            int mid = (begin+end)/2;
            if(search<nums[mid]){
                end = mid-1;
            }else if(search>nums[mid]){
                begin = mid+1;
            }else {
                if(begin==end){
                    count ++;
                    firstIndex = mid;
                    break;
                }else {
                    firstIndex = mid;
                    count = getCount(nums,mid,begin,end)+1;
                    break;
                }
            }
        }
        count = end-begin-1;
        if (count>0){
            firstIndex= begin+1;
        }

        int[] result =new int [2];
        result[0]=firstIndex;
        result[1]=count;
        return result;
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
