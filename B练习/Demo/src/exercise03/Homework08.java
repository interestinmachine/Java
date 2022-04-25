package exercise03;

public class Homework08 {
    public static void main(String[] args) {

    }
}

class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }
}

class CheckingAccount extends BankAccount{
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount-1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount-1);
    }
}

class SavingAccount extends BankAccount{
    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    public void earnMonthlyInsert(){

    }
}


