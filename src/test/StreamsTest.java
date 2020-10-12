package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;


public class StreamsTest {
    public class Trader{

        private final String name;
        private final String city;

        public Trader(String n, String c){
            this.name = n;
            this.city = c;
        }

        public String getName(){
            return this.name;
        }

        public String getCity(){
            return this.city;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Trader trader = (Trader) o;
            return Objects.equals(name, trader.name) &&
                    Objects.equals(city, trader.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, city);
        }

        public String toString(){
            return "Trader:"+this.name + " in " + this.city;
        }
    }

    public class Transaction{

        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value){
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader(){
            return this.trader;
        }

        public int getYear(){
            return this.year;
        }

        public int getValue(){
            return this.value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Transaction that = (Transaction) o;
            return year == that.year &&
                    value == that.value &&
                    Objects.equals(trader, that.trader);
        }

        @Override
        public int hashCode() {
            return Objects.hash(trader, year, value);
        }

        public String toString(){
            return "{" + this.trader + ", " +
                    "year: "+this.year+", " +
                    "value:" + this.value +"}";
        }
    }
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );
    @Test
    //Find all transactions in the year 2011 and sort them by value
    public void sort2011TrxByValueAsc(){
        List<Transaction> trxs =
                transactions.stream()
                    .filter(trx -> trx.getYear()==2011)
                    .sorted(comparing(Transaction::getValue))
                    .collect(Collectors.toList());
        List<Transaction> expectedList = new ArrayList<>(Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2011, 400)
                ));
        Assertions.assertEquals(trxs,expectedList);
    }

    @Test
    public void uniqueCitiesWhereTradersLive(){
        List<String> uniqueCities = transactions.stream().map(transaction -> transaction.trader)
                .map(trader -> trader.city).distinct().collect(Collectors.toList());
        List<String> expectedCities = Arrays.asList("Cambridge","Milan");
        Assertions.assertEquals(uniqueCities,expectedCities);
    }

    @Test
    public void alphabeticListOfCambridgeTraders(){
        String alphabeticList=
                transactions.stream().map(transaction -> transaction.trader)
                        .filter(trader -> "Cambridge".equals(trader.city))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .map(trader -> trader.name)
                        .collect(joining(", "));
        Assertions.assertEquals("Alan, Brian, Raoul",alphabeticList);
    }

    @Test
    public void iterateUsingIntStream(){
        IntStream.range(0,transactions.size())
                .forEach(i -> System.out.println(i+": "+transactions.get(i).getTrader().getName()));
        int[] years = transactions.stream().mapToInt(transaction -> transaction.getYear()).toArray();
        IntStream.range(0,years.length).forEach(i -> System.out.println(i+": "+years[i]));

    }
    @Test
    public void sortingArrays(){
        // Sort
        int[] unsortedArray = new int[] {5,3,2,0,7,8,9};
        int [] sortedArray = IntStream.of(unsortedArray).boxed().sorted(Comparator.reverseOrder()).mapToInt(i->i).toArray();

        Function<int[],String> printIntegerArray = integers ->
                Arrays.stream(integers).mapToObj(String::valueOf).collect(joining(", "));

        System.out.println("Unsorted");
        System.out.println(printIntegerArray.apply(unsortedArray));
        System.out.println("Sorted");
        System.out.println(printIntegerArray.apply(sortedArray));
        System.out.println("After Sorting");
        Arrays.sort(unsortedArray);
        System.out.println(printIntegerArray.apply(unsortedArray));


    }
}
