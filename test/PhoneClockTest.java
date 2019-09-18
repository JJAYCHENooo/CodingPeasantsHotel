import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PhoneClockTest {

    @Test
    void setLocalDateTime() {
        HotelClockSystem hotelClockSystem = new HotelClockSystem();
        Clock clock_BeiJing = new Clock(Clock.UTCOffset_BeiJing);
        hotelClockSystem.addClock("北京", clock_BeiJing);
        Clock clock_Moscow = new Clock(Clock.UTCOffset_Moscow);
        hotelClockSystem.addClock("莫斯科", clock_Moscow);
        Clock clock_Sydney = new Clock(Clock.UTCOffset_Sydney);
        hotelClockSystem.addClock("悉尼", clock_Sydney);
        Clock clock_NewYork = new Clock(Clock.UTCOffset_NewYork);
        hotelClockSystem.addClock("纽约", clock_NewYork);

        PhoneClock phoneClock = new PhoneClock(Clock.UTCOffset_BeiJing);
        phoneClock.setHotelClockSystem(hotelClockSystem);
        LocalDateTime now = LocalDateTime.now(); // 现在是北京时间
        LocalDateTime UTC = now.plusHours(-Clock.UTCOffset_BeiJing);
        phoneClock.setLocalDateTime(now);

        /* 一开始写了now.PlusHours 所以错了. Defect! */
        assertEquals(UTC.plusHours(Clock.UTCOffset_BeiJing), hotelClockSystem.getCityClocks().get("北京").localDateTime);
        assertEquals(UTC.plusHours(Clock.UTCOffset_Moscow), hotelClockSystem.getCityClocks().get("莫斯科").localDateTime);
        assertEquals(UTC.plusHours(Clock.UTCOffset_Sydney), hotelClockSystem.getCityClocks().get("悉尼").localDateTime);
        assertEquals(UTC.plusHours(Clock.UTCOffset_NewYork), hotelClockSystem.getCityClocks().get("纽约").localDateTime);
    }
}