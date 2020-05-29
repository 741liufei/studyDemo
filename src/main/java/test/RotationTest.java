package test;

/**
 * @author liufei
 * @description:
 * @date 2020/5/28 11:12
 **/
public class RotationTest {
    public static int[][] change(int [][]matrix,int n){
        //纵坐标
        int dic  = n-1;
        int[][]temp = new int[n][n];
        for(int i=0;i<n;i++,dic--){
            for(int j=0;j<n;j++){
                //旋转后的最后一列 对应旋转前的第一行
                temp[j][dic] = matrix[i][j];
            }
        }
        return temp;
    }

    public static void main(String[]args){
        int [][]matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][]temp=change(matrix,4);
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                System.out.print(temp[i][j]+"\t");
            }
            System.out.println();
        }
    }


}
