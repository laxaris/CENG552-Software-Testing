package access_system_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import access_system.AccessSystem;
import access_system.PersonStatus;

import java.time.LocalDateTime;

public class AccessSystemDTT {
	
	

	
	@Test
    public void givenNullPersonStatus_whenAccessCalled_thenThrowsIllegalArgumentException() {
        LocalDateTime validTime = LocalDateTime.of(2024, 12, 9, 10, 0);
        assertThrows(IllegalArgumentException.class, () -> AccessSystem.Access(null, validTime));
    }

    @Test
    public void givenNullDateTime_whenAccessCalled_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> AccessSystem.Access(PersonStatus.EMPLOYEE, null));
    }
    
    

    @Test
    public void givenEmployeeAndWeekdayAndWorkHours_whenAccessCalled_thenAccessGranted() {
        LocalDateTime workHoursWeekday = LocalDateTime.of(2024, 12, 9, 10, 0);
        assertEquals(true, AccessSystem.Access(PersonStatus.EMPLOYEE, workHoursWeekday));
    }

    @Test
    public void givenEmployeeAndWeekdayAndNonWorkHours_whenAccessCalled_thenAccessDenied() {
        LocalDateTime nonWorkHoursWeekday = LocalDateTime.of(2024, 12, 9, 18, 0);
        assertEquals(false, AccessSystem.Access(PersonStatus.EMPLOYEE, nonWorkHoursWeekday));
    }

    @Test
    public void givenEmployeeAndWeekend_whenAccessCalled_thenAccessDenied() {
        LocalDateTime weekend = LocalDateTime.of(2024, 12, 7, 10, 0);
        assertEquals(false, AccessSystem.Access(PersonStatus.EMPLOYEE, weekend));
    }

    @Test
    public void givenSpecialEmployee_whenAccessCalled_thenAccessGranted() {
        LocalDateTime anyTime = LocalDateTime.of(2024, 12, 7, 10, 0); 
        assertEquals(true, AccessSystem.Access(PersonStatus.SPECIAL_EMPLOYEE, anyTime));
    }

    @Test
    public void givenAuditorAndWeekdayAndWorkHours_whenAccessCalled_thenAccessGranted() {
        LocalDateTime workHoursWeekday = LocalDateTime.of(2024, 12, 9, 10, 0);
        assertEquals(true, AccessSystem.Access(PersonStatus.AUDITOR, workHoursWeekday));
    }

    @Test
    public void givenAuditorAndWeekdayAndNonWorkHours_whenAccessCalled_thenAccessDenied() {
        LocalDateTime nonWorkHoursWeekday = LocalDateTime.of(2024, 12, 9, 18, 0); 
        assertEquals(false, AccessSystem.Access(PersonStatus.AUDITOR, nonWorkHoursWeekday));
    }

    @Test
    public void givenAuditorAndWeekendAndWorkHours_whenAccessCalled_thenAccessGranted() {
        LocalDateTime workHoursWeekend = LocalDateTime.of(2024, 12, 7, 10, 0);
        assertEquals(true, AccessSystem.Access(PersonStatus.AUDITOR, workHoursWeekend));
    }

    @Test
    public void givenAuditorAndWeekendAndNonWorkHours_whenAccessCalled_thenAccessDenied() {
        LocalDateTime nonWorkHoursWeekend = LocalDateTime.of(2024, 12, 7, 18, 0); 
        assertEquals(false, AccessSystem.Access(PersonStatus.AUDITOR, nonWorkHoursWeekend));
    }
}
