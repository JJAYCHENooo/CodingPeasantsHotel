import java.time.LocalDateTime;

public class Clock {
    public static final int UTCOffset_BeiJing = 8;
    public static final int UTCOffset_Moscow = 4;
    public static final int UTCOffset_Sydney = 10;
    public static final int UTCOffset_NewYork = -5;


    /* protected 可以被继承的子类看到 */
    protected int UTCOffset;
    protected LocalDateTime localDateTime;

    public Clock(int UTCOffset){
        this.UTCOffset = UTCOffset;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}