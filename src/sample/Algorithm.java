package sample;

import java.math.BigDecimal;

public class Algorithm {
    public static void start() {
        Algorithm newton = new Algorithm();
        TxtRead txtRead=new TxtRead();
        double omega = 0.6;
        double alpha = 0.05;
        double eps = 0.0001;
        int iter = 0;
        double j = 0;
        double[] T = new double[40];
       // double[] Y = new double[txtRead.array.length];
        double[] Y = txtRead.y1.stream().mapToDouble(Double::doubleValue).toArray();
        //      BigDecimal Y=new BigDecimal(String.valueOf(Y1));
        for (int i = 0; i < 40; i++) {
            T[i] = j;
            j = j + 0.5;
            Y[i]=txtRead.array[i];
        }
        while(alpha*Math.abs(newton.D_MyFun(omega,T,Y))>eps)
        {
            if(newton.DD_MyFun(omega,T,Y)>0) {
                omega = round( -(newton.D_MyFun(omega, T, Y) - omega * newton.DD_MyFun(omega, T, Y)) / newton.DD_MyFun(omega, T, Y),5);
            }else if(newton.DD_MyFun(omega,T,Y)<=0)
            {
                omega=round( omega-alpha*newton.D_MyFun(omega,T,Y),5);
            }
            iter++;
            System.out.println(omega);
        }
        System.out.println(iter);
    }
    public double D_MyFun(double omega,double[] T,double []Y) {

        return round( (-2)*((sum1(Dot3(T,subtract(Y,s1(omega,T)),c1(omega,T))))/T.length),5);
    }
    public double DD_MyFun(double omega,double[] T,double []Y) {
        return  round(2*sum1( Dot(Dot2(T),  sum2(Dot2(c1(omega,T)),Dot( subtract(Y,s1(omega,T)) ,  s1(omega,T) ))    )  )/T.length,5);

    }
    public static double round(double v,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public static double[] s1(double omega, double[] a)
    {   double product[] = new double[a.length];
        for(int i = 0; i< a.length; i++)
        {
            //   System.out.println(Math.sin(omega*a[i]));
            BigDecimal b1 = new BigDecimal(Double.toString(Math.sin(omega*a[i])));
            product[i]= round( b1.doubleValue(),4) ;
            //     System.out.println(a[i]);
        }
        return product;
    }
    public static double[] c1(double omega, double[] a)
    {double product[] = new double[a.length];
        for(int i=0;i<a.length;i++)
        {
            BigDecimal b1 = new BigDecimal(Double.toString(Math.cos(omega*a[i])));
            product[i]= round( b1.doubleValue(),4) ;
        }
        return product;
    }
    public static double[] subtract(double[] a, double[] b){
        double product[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            BigDecimal b1 = new BigDecimal(Double.toString(a[i]));
            BigDecimal b2 = new BigDecimal(Double.toString(b[i]));
            product[i] =round( b1.subtract(b2).doubleValue(),4);
            //    System.out.println(product[i]);
        }
        return product;
    }
    public double sum1(double[]T)
    {   double product=0;
        for(int i=0;i<T.length;i++)
        {
            BigDecimal b1 = new BigDecimal(Double.toString(T[i]));
            //   product+=b1.doubleValue();
            product+= round( b1.doubleValue(),4) ;
        }
        return product;
    }
    public double[] sum2(double[] a, double[] b)
    {   double product[] = new double[a.length];
        for(int i=0;i<a.length;i++)
        {
            BigDecimal b1 = new BigDecimal(Double.toString(a[i]));
            BigDecimal b2 = new BigDecimal(Double.toString(b[i]));
            //   product[i] = b1.add(b2).doubleValue();
            product[i]= round(b1.add(b2).doubleValue(),4);
        }
        return product;
    }
    public static double[] Dot(double[] a, double[] b){
        double [] product = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            BigDecimal b1 = new BigDecimal(Double.toString(a[i]));
            BigDecimal b2 = new BigDecimal(Double.toString(b[i]));
            product[i]=round(b1.multiply(b2).doubleValue(),4);
            //      System.out.println( product[i]);
        }
        return product;
    }
    public static double[] Dot2(double[] a){
        double product[] = new double[a.length];
        //检测ab列数是否相同（数组长度）
        //数组名.length计算的是数组获取空间的大小，与元素个数无关
        for (int i = 0; i < a.length; i++) {
            BigDecimal b = new BigDecimal(Double.toString(Math.pow(a[i],2)));
            //   product[i] =b.doubleValue();
            product[i]=round(b.doubleValue(),4);
        }
        return product;
    }
    public static double[] Dot3(double[] a, double[] b,double[]c){
        double product[] = new double[a.length];
        //检测ab列数是否相同（数组长度）
        //数组名.length计算的是数组获取空间的大小，与元素个数无关
        for (int i = 0; i < a.length; i++) {
            BigDecimal b1 = new BigDecimal(Double.toString(a[i]));
            BigDecimal b2 = new BigDecimal(Double.toString(b[i]));
            BigDecimal b3 = new BigDecimal(Double.toString(c[i]));
            //   product[i]= b1.multiply(b2).multiply(b3).doubleValue();
            product[i]=round(b1.multiply(b2).multiply(b3).doubleValue(),4);
            //        System.out.println(product[i]);
        }
        return product;
    }
}
