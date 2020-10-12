package test.defaultmethods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckMain {
    @Test
    public void checkDefaultMethods (){
        Assertions.assertEquals("static method", CheckInterface.checkStaticMethod());
        CheckInterface inst = () ->  "function method";
        Assertions.assertEquals("default method", inst.checkMethod() );
        Assertions.assertEquals("function method",inst.functionMethod());

    }

    @Test
    public void checkOverrideDefault() {
        CheckInterface inst2 = new CheckInterface() {
            @Override
            public String functionMethod() {
                return "function method";
            }

            @Override
            public String checkMethod() {
                return CheckInterface.super.checkMethod();
            }
        };

        Assertions.assertEquals("default method", inst2.checkMethod() );
        Assertions.assertEquals("function method",inst2.functionMethod());
    }
}
