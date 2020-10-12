package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    @Test
    void subStringTest(){
        String large="Webster";
        String inner="Web";
        Assertions.assertEquals(inner,large.substring(0,inner.length()));
        Assertions.assertTrue(large.startsWith(inner));

    }
    @Test
    void checkObjectSuperClass(){
        System.out.println(Object.class.getSuperclass());
        System.out.println(Object.class.getClass());
        Assertions.assertEquals(Object.class.getSuperclass(),Object.class);
    }

    @Test
    void stringInternTest(){
        String s1 = new String("String");
        String s2 = "String";
        String s3 = "String";
        String s4 = new String("String");
        Assertions.assertEquals(true,s1.equals(s2)); // String represented by the instance is equal
        Assertions.assertEquals(false,s1==s2); // Instances are not equal
        Assertions.assertEquals(true,s1.intern()==s2.intern()); // String represented by the instance is equal
        Assertions.assertEquals(true,s3==s2); // String pool returns reference to same object.
        Assertions.assertEquals(false,s4==s1); // New instance created
        Assertions.assertEquals(true,s4.intern()==s1.intern());// Interned string still represents same string from pool.
    }
}
