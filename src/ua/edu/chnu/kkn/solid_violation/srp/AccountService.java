package ua.edu.chnu.kkn.solid_violation.srp;



public class AccountService {
    private TransactionRepository transactionRepository;
    private Clock clock;
    private StatementPrinter statementPrinter;

    public AccountService(TransactionRepository repository, Clock clock, StatementPrinter printer) {
        this.transactionRepository = repository;
        this.clock = clock;
        this.statementPrinter = printer;
    }

    public void deposit(int amount) {
        transactionRepository.add(new Transaction(clock.today(), amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(new Transaction(clock.today(), -amount));
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.all());
    }
}
