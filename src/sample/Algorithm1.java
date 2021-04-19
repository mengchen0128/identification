package sample;

import bianshi.Class1;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class Algorithm1 {

    public static void start(){
        Class1 class1;
        Object[] result = null;
        TxtRead txtRead=new TxtRead();
        MWNumericArray y=txtRead.y;
        if(y==null)
        {return;}
        try {
            class1= new Class1();
            result=class1.bianshi(1,y);
            System.out.println("the result is "+result[0]);
            MWArray.disposeArray(result);
            txtRead.y1.clear();
            MWArray.disposeArray(txtRead.y);
            MWArray.disposeArray(y);
        } catch (MWException e) {
            e.printStackTrace();
        }
    }
}
