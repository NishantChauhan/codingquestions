package test;

public class StringTest {
    public static void main(String[] args) {
        String s = "1";
        String s1 = "1".intern();

        System.out.println(s.intern());
        System.out.println(s1==s);
        System.out.println(s1.equals(s));
        s="1";
        System.out.println(s.intern());
        System.out.println(s1==s);
        System.out.println(s1.equals(s));

    }
}
