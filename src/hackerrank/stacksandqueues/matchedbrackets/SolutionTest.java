package hackerrank.stacksandqueues.matchedbrackets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    String s = "";
    @Test
    void basicCases(){

        s="{";
        Assertions.assertEquals("NO",Solution.isBalanced(s));

        s=")";
        Assertions.assertEquals("NO",Solution.isBalanced(s));

        s="{()";
        Assertions.assertEquals("NO",Solution.isBalanced(s));

    }

    @Test
    void intermediateCases(){
        s ="{[()]}";
        Assertions.assertEquals("YES",Solution.isBalanced(s));

        s = "{[(])}";
        Assertions.assertEquals("NO",Solution.isBalanced(s));
    }

    @Test
    void complexCases(){
        s = "{{[[(())]]}}";
        Assertions.assertEquals("YES",Solution.isBalanced(s));

        s="{{({[]})[()[{()}]{}(){}]()}()}";
        Assertions.assertEquals("YES",Solution.isBalanced(s));

        s="{{({[]})[()[{()}]{}(){]()}()}";
        Assertions.assertEquals("NO",Solution.isBalanced(s));

    }
}
