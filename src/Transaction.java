import lombok.AllArgsConstructor;
/**
 *
 */
@AllArgsConstructor
public class Transaction {

    int id;

    TransactionType type;
    public TransactionType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                '}';
    }
}

