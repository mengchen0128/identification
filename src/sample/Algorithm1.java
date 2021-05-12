package sample;

import bianshi.Class1;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;

public class Algorithm1 {
    static Class1 class1;
    static {
        try {
            class1= new Class1();//matlab计算对象
        } catch (MWException e) {
            e.printStackTrace();
        }
    }
    public static void start(){
        TxtRead txtRead=new TxtRead();
       // MWNumericArray y=txtRead.y;
        if(txtRead.y==null)
        {return;}
/*        try {
            Class1 class1= new Class1();
            //MWArray.disposeArray(txtRead.y);
            //txtRead.y.dispose();
            //txtRead.y2.dispose();
        } catch (MWException e) {
            e.printStackTrace();
        }*/
        try {

            Object[] result = class1.bianshi(1,txtRead.y);
            System.out.println("the result is "+result[0]);
            MWArray.disposeArray(result);
        } catch (MWException e) {
            e.printStackTrace();
        }

    }
}
