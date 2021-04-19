package sample;
import bianshi.Class1;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {
    static List<Double> y1 = new ArrayList<Double>();
    public static void main(String[] args) {
        MWNumericArray y = null; // 存放y值的数组
        Class1 class1;
        Object[] result = null;
        String filePath = "C:\\Users\\Student-16\\Desktop\\java\\TestData.txt";
        readFile(filePath);
        System.out.println(y1);
        int l1=y1.toArray().length;
        System.out.println(l1);
        int size=y1.size();
        System.out.println(size);
      //  y = new MWNumericArray(y1,MWClassID.DOUBLE);
        Double[] array = y1.toArray(new Double[size]);
        //    y = new MWNumericArray(y1,MWClassID.DOUBLE);
        for (Double aDouble : array) {
            System.out.println(aDouble);
        }
//        Double[] c={0.1353,0.1141,0.7274,0.9374,1.3336,0.8989,0.5994,0.3704,-0.0215,-0.4320,-0.8481,
//        -1.1350,-0.9487,-1.0849,-0.7861,-0.0797,0.0537,0.4731,0.9286,0.9229,1.1438,0.8028,
//        0.7368,0.3173,-0.2063,-0.6739,-0.9843,-1.0214,-1.0449,-0.8841,-0.3890,-0.2103,0.4031,
//        0.5123,1.0050,0.9123,0.9921,0.9339,0.4243,0.0420};
//
//        for (Double aDouble : c) {
//            System.out.println(aDouble);
//        }
        y = new MWNumericArray(array,MWClassID.DOUBLE);
        try {
            class1= new Class1();
            result=class1.bianshi(1,y);
            System.out.println("the result is "+result[0]);
        } catch (MWException e) {
            e.printStackTrace();
        }
        //System.out.println(str);
    }
    public static void readFile(String filePath)
    {

        try {
            String encoding="UTF-8";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int cnt=0;
                while((lineTxt = bufferedReader.readLine()) != null){
                String []s=lineTxt.split("，");
                    for (String s1 : s) {
                       // System.out.println(s1);
                        y1.add(Double.parseDouble(s1));
                    }
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }

        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
}
}