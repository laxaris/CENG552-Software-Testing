package access_system_test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import access_system.AccessSystem;
import access_system.PersonStatus;

import java.time.LocalDateTime;

public class AccessSystemECT {

    private LocalDateTime weekdayWorkHours;    // Weekday work hours
    private LocalDateTime weekdayNonWorkHours; // Weekday non-work hours
    private LocalDateTime weekendWorkHours;    // Weekend work hours
    private LocalDateTime weekendNonWorkHours; // Weekend non-work hours

    @Before
    public void setUp() {
        weekdayWorkHours = LocalDateTime.of(2024, 12, 9, 10, 0);    // Monday 10:00
        weekdayNonWorkHours = LocalDateTime.of(2024, 12, 9, 18, 0); // Monday 18:00
        weekendWorkHours = LocalDateTime.of(2024, 12, 7, 10, 0);    // Saturday 10:00
        weekendNonWorkHours = LocalDateTime.of(2024, 12, 7, 18, 0); // Saturday 18:00
    }

    // 1. Employee - Weekday during work hours
    @Test
    public void Given_Employee_When_WeekdayDuringWorkHours_Then_AccessIsAllowed() {
        assertTrue("Employee should access during weekday work hours",
            AccessSystem.Access(PersonStatus.EMPLOYEE, weekdayWorkHours));
    }

    // 2. Special Employee - Weekday outside work hours
    @Test
    public void Given_SpecialEmployee_When_WeekdayOutsideWorkHours_Then_AccessIsAllowed() {
        assertTrue("Special Employee should access during weekday non-work hours",
            AccessSystem.Access(PersonStatus.SPECIAL_EMPLOYEE, weekdayNonWorkHours));
    }

    // 3. Auditor - Weekend during work hours
    @Test
    public void Given_Auditor_When_WeekendDuringWorkHours_Then_AccessIsAllowed() {
        assertTrue("Auditor should access during weekend work hours",
            AccessSystem.Access(PersonStatus.AUDITOR, weekendWorkHours));
    }

    // 4. Employee - Weekend outside work hours
    @Test
    public void Given_Employee_When_WeekendOutsideWorkHours_Then_AccessIsDenied() {
        assertFalse("Employee should not access during weekend non-work hours",
            AccessSystem.Access(PersonStatus.EMPLOYEE, weekendNonWorkHours));
    }
}
