package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class CollectionTest {
    List<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new LinkedList<>(Arrays.asList(new Integer [] {1,2,3,4}));
    }

    @Test
    void testFailSafeIterator(){
        System.out.println("Size:" + numbers.size());
        ListIterator listItr = numbers.listIterator();
        Iterator itr = numbers.iterator();
        numbers.add(5);
        Assertions.assertThrows(ConcurrentModificationException.class,()->{
        while (listItr.hasNext()){
            System.out.println(listItr.next());
        }
        },"Concurrent Modification exception");

        Assertions.assertThrows(ConcurrentModificationException.class,()->{
            while (itr.hasNext()){
                    System.out.println(itr.next());
            }
        },"Concurrent Modification exception");

        CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList(numbers);

    }

    @Test
    void testUnmodifiableArrayException(){
        Assertions.assertThrows(UnsupportedOperationException.class,()->{
            List unmodifiableList=  Collections.unmodifiableList(numbers);
            unmodifiableList.add(5);
        });
    }

    @Test
    void copyOnWriteException(){
        Assertions.assertDoesNotThrow(()->{
            CopyOnWriteArrayList carr = new CopyOnWriteArrayList(numbers);
            ListIterator listItr = carr.listIterator();
            Iterator itr = carr.iterator();

            carr.add(5);

            System.out.println(itr.next());
        });


    }
    @Test
    void syncCollections(){
            Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
    }
}
