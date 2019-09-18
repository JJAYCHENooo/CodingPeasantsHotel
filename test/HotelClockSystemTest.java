import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HotelClockSystemTest {

    @Test
    void addClock() {
        HotelClockSystem hotelClockSystem = new HotelClockSystem();
        Clock clock_BeiJing = new Clock(Clock.UTCOffset_BeiJing);
        hotelClockSystem.addClock("北京", clock_BeiJing);

        /* 保证 cityClocks 不为空（添加成功） */
        assertNotNull(hotelClockSystem.getCityClocks());
        /* 保证 cityClocks 成功加入北京时钟 */
        assertEquals(clock_BeiJing, hotelClockSystem.getCityClocks().get("北京"));
    }

    @Test
    void updateCityClocksWithUTCZeroTime() {
        HotelClockSystem hotelClockSystem = new HotelClockSystem();
        Clock clock_BeiJing = new Clock(Clock.UTCOffset_BeiJing);
        hotelClockSystem.addClock("北京", clock_BeiJing);
        Clock clock_Moscow = new Clock(Clock.UTCOffset_Moscow);
        hotelClockSystem.addClock("莫斯科", clock_Moscow);
        Clock clock_Sydney = new Clock(Clock.UTCOffset_Sydney);
        hotelClockSystem.addClock("悉尼", clock_Sydney);
        Clock clock_NewYork = new Clock(Clock.UTCOffset_NewYork);
        hotelClockSystem.addClock("纽约", clock_NewYork);

        LocalDateTime UTCDateTime = LocalDateTime.now(); // 取现在的时间为一个 UTCDateTime，尽管测试时 now 是北京时区的时间，但是不影响函数功能的判断
        hotelClockSystem.updateCityClocksWithUTCZeroTime(UTCDateTime);

        assertEquals(UTCDateTime.plusHours(Clock.UTCOffset_BeiJing), hotelClockSystem.getCityClocks().get("北京").localDateTime);
        assertEquals(UTCDateTime.plusHours(Clock.UTCOffset_Moscow), hotelClockSystem.getCityClocks().get("莫斯科").localDateTime);
        assertEquals(UTCDateTime.plusHours(Clock.UTCOffset_Sydney), hotelClockSystem.getCityClocks().get("悉尼").localDateTime);
        assertEquals(UTCDateTime.plusHours(Clock.UTCOffset_NewYork), hotelClockSystem.getCityClocks().get("纽约").localDateTime);
    }
}