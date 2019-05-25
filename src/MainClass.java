import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 *
 */
public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        Transaction t1 = new Transaction(1, TransactionType.GROCERY);
        Transaction t2 = new Transaction(2, TransactionType.GROCERY);
        Transaction t3 = new Transaction(3, TransactionType.SOMETHING_ELSE);

        mainClass.oldWay(t1, t2, t3);

        mainClass.newWay(asList(t1, t2, t3));
    }

    private void newWay(List<Transaction> transactions) {
        List<Integer> transactionIds =
                transactions
                        .stream()
                        .filter(t -> t.getType() == TransactionType.GROCERY)
                        .map(t -> t.getId())
                        .collect(Collectors.toList());
        System.out.println(transactionIds + "New Way! Streams are awesome");
    }

    private void oldWay(Transaction... transactions) {
        List<Transaction> groceryTransactions = new ArrayList<>();
        List<Integer> transactionIds = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.GROCERY) {
                groceryTransactions.add(t);
            }
        }
        for (Transaction t : groceryTransactions) {
            transactionIds.add(t.getId());
        }
        System.out.println(groceryTransactions);
        System.out.println(transactionIds);
    }
}
