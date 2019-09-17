import java.time.LocalDateTime;

public class Clock {

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





//    public static void main(String[] args) {
////        LocalDate date = LocalDate.now();
////        date = date.plusDays(20);
////        System.out.println(date.toString());
//        LocalDateTime localDateTime = LocalDateTime.now();
//        localDateTime = localDateTime.plusHours(-1);
//        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
//    }