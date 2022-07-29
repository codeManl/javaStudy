import java.nio.charset.Charset;

/**
 * @author 刘乐乐
 * @description
 * @date 2022-05-26 09:20:54
 */
public class Demo2 {
    public static void main(String[] args) {

        Parent parent = new Son();
        parent.method1();
    }

    static class Son extends Parent {

        public void method1(){
            System.out.println("method Son");
        }
    }
   static class Parent{


        public void method1(){
            System.out.println("method Parent");
        }
    }
}
