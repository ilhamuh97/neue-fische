package enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaysOfWeekTest {

    @Test
    void getLabel() {
        assertEquals("Saturday", DaysOfWeek.SATURDAY.getLabel());
    }

    @Test
    void getDayOrWeekend_shouldReturnWeekend_whenCalledWithSaturday() {
        assertEquals("Weekend", DaysOfWeek.SATURDAY.getDayOrWeekend());
    }

    @Test
    void getDayOrWeekend_shouldReturnWednesday_whenCalledWithWednesday() {
        assertEquals("Wednesday", DaysOfWeek.WEDNESDAY.getDayOrWeekend());
    }
}