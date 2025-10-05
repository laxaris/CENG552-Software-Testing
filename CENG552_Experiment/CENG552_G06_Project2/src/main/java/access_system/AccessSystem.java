package access_system;

import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class AccessSystem {

    private static final LocalTime START_TIME = LocalTime.of(9, 0); // 09:00
    private static final LocalTime END_TIME = LocalTime.of(17, 0);  // 17:00

    public static boolean Access(PersonStatus personStatus, LocalDateTime currentDateTime) {
        if (currentDateTime == null) {
            throw new IllegalArgumentException("Current date time cannot be null!");
        }

        if (personStatus == null) {
            throw new IllegalArgumentException("Person status cannot be null!");
        }

        LocalTime currentTime = currentDateTime.toLocalTime();
        boolean isWeekDay = !(currentDateTime.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                           currentDateTime.getDayOfWeek().equals(DayOfWeek.SUNDAY));

        boolean isWithinWorkHours = (currentTime.isAfter(START_TIME) || currentTime.equals(START_TIME)) && 
                                  (currentTime.isBefore(END_TIME) || currentTime.equals(END_TIME));

        boolean isAccess = false;

        switch (personStatus) {

            case EMPLOYEE:
                if (isWithinWorkHours && isWeekDay) {
                    isAccess = true;
                }
                break;

            case SPECIAL_EMPLOYEE:
                isAccess = true;
                break;

            case AUDITOR:
                if (isWithinWorkHours) {
                    isAccess = true;
                }
                break;
        }

        return isAccess;
    }
}