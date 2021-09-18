package som.hks.oom;

public class ReferenceTest {

    public static void main(String[] args){
        String a = "1";
        String b = "2";
        String c = "3";
        a=b;
        System.out.println(a+"\n");
        a=c;
        System.out.println(a+"\n");
        c=null;
        System.out.println(a+"\n");
        a=null;
        System.out.println(a+"\n");
    }

}
