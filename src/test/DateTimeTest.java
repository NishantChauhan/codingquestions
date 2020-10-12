package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;

public class DateTimeTest {

    @Test
    void checkNow(){
        long date = new Date().getTime();
        long instantDate = Instant.now().getEpochSecond();
        System.out.println("Date: "+date/1000);
        System.out.println("Local Date " + instantDate);
        Assertions.assertEquals(date/1000,instantDate);
    }
    @Test
    void checkDuration() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();
        Duration difference = Duration.between(start,end);
        Assertions.assertTrue(difference.getSeconds() >= 1 && difference.getSeconds() < 2);
    }

    @Test
    void timeZoneConversion(){
        ZoneId indiaId =ZoneId.of(ZoneId.SHORT_IDS.get("IST"));
        ZoneId localId = ZoneId.systemDefault();
        Instant now = Instant.now();

        ZonedDateTime localTime = now.atZone(localId);
        ZonedDateTime indiaTime = now.atZone(indiaId);
        Duration diff = Duration.between(localTime,indiaTime);
        Assertions.assertEquals(diff.getSeconds(),0);
    }

    @Test
    void italianDateFormat(){
        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(italianFormatter);
        Assertions.assertEquals(formattedDate,"18. marzo 2014");
    }
}
