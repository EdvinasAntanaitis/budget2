import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class IncomeRecord {

        private final BigDecimal amount;
        private final String category;
        private final LocalDateTime date;
        private final boolean isBankTransfer;
        private final String otherInfo;

    public IncomeRecord(BigDecimal amount, String category, LocalDateTime date, boolean isBankTransfer, String otherInfo)
        {
            this.amount = amount;
            this.category = category;
            this.date = date;
            this.isBankTransfer = isBankTransfer;
            this.otherInfo = otherInfo;
        }

        public BigDecimal getAmount () {
            return amount;
        }

        public String getCategory () {
            return category;
        }

        public LocalDateTime getDate () {
            return date;
        }

        public boolean isBankTransfer () {
            return isBankTransfer;
        }

        public String getOtherInfo () {
            return otherInfo;
        }

        @Override
        public String toString () {
            final StringBuffer sb = new StringBuffer("IncomeRecord{");
            sb.append("amount=").append(amount);
            sb.append(", category='").append(category).append('\'');
            sb.append(", date=").append(date);
            sb.append(", isBankTransfer=").append(isBankTransfer);
            sb.append(", otherInfo='").append(otherInfo).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
