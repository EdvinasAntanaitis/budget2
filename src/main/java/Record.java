import java.math.BigDecimal;
import java.time.LocalDateTime;


public abstract class Record {

    private static int counter = 0;
    private final int id;
    private final BigDecimal amount;
    private final LocalDateTime date;
    private final String info;

    public Record(int id, BigDecimal amount, LocalDateTime date, String info) {
        this.id = getCounter();
        this.amount = amount;
        this.date = date;
        this.info = info;
    }

    public static int getCounter() {
        return counter++;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", info='" + info + '\'' +
                '}';
    }
}
