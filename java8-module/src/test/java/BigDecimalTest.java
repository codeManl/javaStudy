import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {

        String s = null ;
        BigDecimal bigDecimal = new BigDecimal("0");
        System.out.println(bigDecimal);
//        double v = new BigDecimal(null);
//        System.out.println(v);


  /*      BigDecimal bd1 = new BigDecimal("3");
        BigDecimal bd2 = bd1.subtract(null);
        System.out.println(bd1);
        System.out.println(bd2);
        */
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal bd3 = new BigDecimal("0.0");
        System.out.println(bigDecimal.compareTo(bd3) ==0);
        System.out.println(bigDecimal.compareTo(zero) ==0);

    }
}
