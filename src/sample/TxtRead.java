package sample;

import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public  class TxtRead {
    public static  MWNumericArray y;
    public  static List<Double> y1 = new ArrayList<Double>();
    public static void readFile1(String filePath1)
    {
        String filePath = filePath1;
        readFile2(filePath);
        int size=y1.size();
        //  y = new MWNumericArray(y1,MWClassID.DOUBLE);
        Double[] array = y1.toArray(new Double[size]);
        //    y = new MWNumericArray(y1,MWClassID.DOUBLE);
        for (Double aDouble : array) {
            System.out.println(aDouble);
        }

        y = new MWNumericArray(array, MWClassID.DOUBLE);
        y1.clear();
    }
    public static void readFile2(String filePath)
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
