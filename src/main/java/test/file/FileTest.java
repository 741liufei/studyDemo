package test.file;

import java.io.*;

/**
 * @author: feis.liu
 * @date: 2018/8/21 17:39
 * @Description:
 */
public class FileTest {

    public static  void main(String []args){
        File file =  new File("C:\\Users\\feis.liu\\Desktop\\报文\\门票\\ticket_favorites_1.txt");
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);

            StringBuilder result = new StringBuilder();
            int len = 0;
            byte[] bytes = new byte[20];
//            while ((len=fileInputStream.read(bytes))!=-1){
//                result.append(new String(bytes,0,len));
//            }
//            System.out.println(result.toString());

            //缓冲输入流，每次读入的内容会存到缓存中，减少文件的的io操作
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            while ((len=bufferedInputStream.read(bytes))!=-1){
                result.append(new String (bytes,0,len));
            }
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
