import java.time.LocalDateTime;

public class PhoneClock extends Clock {

    private HotelClockSystem hotelClockSystem;

    public PhoneClock(int UTCOffset) {
        super(UTCOffset);
    }

    @Override
    public void setLocalDateTime(LocalDateTime localDateTime) {
        super.localDateTime = localDateTime;
        if (hotelClockSystem != null) {
            hotelClockSystem.updateCityClocksWithUTCZeroTime(localDateTime.plusHours(-1 * super.UTCOffset));
        }
    }

    public void setHotelClockSystem(HotelClockSystem hotelClockSystem) {
        this.hotelClockSystem = hotelClockSystem;
    }
}
