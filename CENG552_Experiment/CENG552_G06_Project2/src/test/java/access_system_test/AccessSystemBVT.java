package access_system_test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import access_system.AccessSystem;
import access_system.PersonStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AccessSystemBVT {

    private static LocalDateTime weekDay;
    private static LocalDateTime weekendDay;

    private final String personStatus;
    private final String dayType;
    private final int hour;
    private final int minute;
    private final boolean expectedAccess;

    public AccessSystemBVT(String personStatus, String dayType, int hour, int minute, boolean expectedAccess) {
        this.personStatus = personStatus;
        this.dayType = dayType;
        this.hour = hour;
        this.minute = minute;
        this.expectedAccess = expectedAccess;
    }

    @BeforeClass
    public static void setup() {
 
        weekDay = LocalDateTime.of(2024, 12, 9, 0, 0); 
        weekendDay = LocalDateTime.of(2024, 12, 7, 0, 0); 
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{


            // EMPLOYEE Test Cases - Weekday
            {"EMPLOYEE", "WEEKDAY", 8, 59, false},
            {"EMPLOYEE", "WEEKDAY", 9, 0, true},
            {"EMPLOYEE", "WEEKDAY", 9, 1, true},
            {"EMPLOYEE", "WEEKDAY", 16, 59, true},
            {"EMPLOYEE", "WEEKDAY", 17, 0, true},
            {"EMPLOYEE", "WEEKDAY", 17, 1, false},

            // EMPLOYEE Test Cases - Weekend
            {"EMPLOYEE", "WEEKEND", 8, 59, false},
            {"EMPLOYEE", "WEEKEND", 9, 0, false},
            {"EMPLOYEE", "WEEKEND", 9, 1, false},
            {"EMPLOYEE", "WEEKEND", 16, 59, false},
            {"EMPLOYEE", "WEEKEND", 17, 0, false},
            {"EMPLOYEE", "WEEKEND", 17, 1, false},

            // SPECIAL_EMPLOYEE Test Cases - Weekday
            {"SPECIAL_EMPLOYEE", "WEEKDAY", 8, 59, true},
            {"SPECIAL_EMPLOYEE", "WEEKDAY", 9, 0, true},
            {"SPECIAL_EMPLOYEE", "WEEKDAY", 9, 1, true},
            {"SPECIAL_EMPLOYEE", "WEEKDAY", 16, 59, true},
            {"SPECIAL_EMPLOYEE", "WEEKDAY", 17, 0, true},
            {"SPECIAL_EMPLOYEE", "WEEKDAY", 17, 1, true},

            // SPECIAL_EMPLOYEE Test Cases - Weekend
            {"SPECIAL_EMPLOYEE", "WEEKEND", 8, 59, true},
            {"SPECIAL_EMPLOYEE", "WEEKEND", 9, 0, true},
            {"SPECIAL_EMPLOYEE", "WEEKEND", 9, 1, true},
            {"SPECIAL_EMPLOYEE", "WEEKEND", 16, 59, true},
            {"SPECIAL_EMPLOYEE", "WEEKEND", 17, 0, true},
            {"SPECIAL_EMPLOYEE", "WEEKEND", 17, 1, true},

            // AUDITOR Test Cases - Weekday
            {"AUDITOR", "WEEKDAY", 8, 59, false},
            {"AUDITOR", "WEEKDAY", 9, 0, true},
            {"AUDITOR", "WEEKDAY", 9, 1, true},
            {"AUDITOR", "WEEKDAY", 16, 59, true},
            {"AUDITOR", "WEEKDAY", 17, 0, true},
            {"AUDITOR", "WEEKDAY", 17, 1, false},

            // AUDITOR Test Cases - Weekend
            {"AUDITOR", "WEEKEND", 8, 59, false},
            {"AUDITOR", "WEEKEND", 9, 0, true},
            {"AUDITOR", "WEEKEND", 9, 1, true},
            {"AUDITOR", "WEEKEND", 16, 59, true},
            {"AUDITOR", "WEEKEND", 17, 0, true},
            {"AUDITOR", "WEEKEND", 17, 1, false},
            
            
        });
    }

    @Test
    public void testBoundaryValues() {
 
        LocalDateTime testDateTime = dayType.equals("WEEKDAY") ?
                weekDay.withHour(hour).withMinute(minute) :
                weekendDay.withHour(hour).withMinute(minute);


        PersonStatus status = PersonStatus.valueOf(personStatus);


        assertEquals("Failed for: " + personStatus + " at " + testDateTime,
                expectedAccess, AccessSystem.Access(status, testDateTime));
    }
}
