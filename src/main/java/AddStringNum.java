/**
 * @author liufei
 * @description:
 * @date 2020/5/26 13:01
 **/
public class AddStringNum {
        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //int a = in.nextInt();
            //System.out.println(a);
            String str1 = "1234596789";
            String str2 = "98765";
            String result = add(str1,str2);
            System.out.println(result);
            StringBuffer s1 = new StringBuffer("99");
            System.out.println(s1.charAt(1)-'0' );

        }
        public static String add(String str1,String str2){
            StringBuffer s1 = new StringBuffer(str1).reverse();
            StringBuffer s2 = new StringBuffer(str2).reverse();
            StringBuffer res = new StringBuffer();

            int len1 = s1.length();
            int len2 = s2.length();
            int len ;
            //补位保持长度一致
            if(len1<len2){
                len = len2;
                int count = len2 - len1;
                while(count-- > 0){
                    s1.append('0');
                }
            }else{
                len  = len1;
                int count = len1 -len2;
                while(count-- >0){
                    s2.append('0');
                }
            }
            int overflow =0;
            int num;
            for(int i=0;i<len;i++){
                num = Integer.parseInt(s1.charAt(i)+"") + Integer.parseInt(s2.charAt(i)+"")+overflow;
                if(num >= 10){//进位
                    overflow = 1;
                    num =num -10;
                }else{
                    overflow = 0;
                }
                res.append(String.valueOf(num));
            }
            if(overflow ==1){
                res.append("1");
            }
            return res.reverse().toString();

        }



}
