package dsa.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ArrayUtility {
    public static boolean compareArrays(int [] array1, int [] array2){
        Comparator<int[]> arrayComparator = (int[] integerArray1, int[] integerArray2) -> {
            if(integerArray1.length<integerArray2.length){
                return -1;
            }
            if(integerArray1.length>integerArray2.length){
                return 1;
            }

            Integer length = integerArray1.length;

            for (int i = 0; i < length; i++) {
                if(integerArray1[i] < integerArray2[i]){
                    return -1;
                }
                if(integerArray1[i] > integerArray2[i]){
                    return 1;
                }
            }
            return 0;
        };
        return arrayComparator.compare(array1,array2)==0;
    }
    public static  String arrayAsString(int [] array){
        return Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }
}
