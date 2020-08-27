package ExceptionExerciseEntitities;

public class Account {

    private Integer accNumber;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer accNumber, String holder, Double balance, Double withdrawLimit) {
        this.accNumber = accNumber;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getAccNumber() {
        return accNumber;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount){
        balance+=amount;
    }

    public void withdraw(double amount) throws DomainException {
        if (amount>balance){
            throw new DomainException("The amount surpasses balance,please enter a value within "+String.format("%.2f",balance)+"€");
        }
        if (amount>withdrawLimit){
            throw new DomainException("The amount surpasses the account defined withdraw limit,please enter a value within "+String.format("%.2f",withdrawLimit)+"€");
        }
        balance-=amount;
    }
}

