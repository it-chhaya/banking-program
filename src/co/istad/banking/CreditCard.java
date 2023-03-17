package co.istad.banking;

import co.istad.banking.database.Database;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class CreditCard extends Account {
    private Integer pin;
    private Double limitAmount;
    private LocalDate thruDate;

    public CreditCard() {

    }

    public CreditCard(Integer number, String name, Double balance) {
        super(number, name, balance);
        // TODO
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public Double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Double limitAmount) {
        this.limitAmount = limitAmount;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    @Override
    protected final void deposit(Double amount) {
        if (isExpired(thruDate)) {
            System.out.println("Card is expired..!");
            return;
        }
        super.deposit(amount);
    }

    @Override
    protected final void withdrawal(Double amount) {
        if (amount > limitAmount) {
            System.out.println("Over the limit amount..!");
            return;
        }

        if (isExpired(thruDate)) {
            System.out.println("Card is expired..!");
            return;
        }
        super.withdrawal(amount);
    }

    // Overload method
    // Withdrawal entire balance
    protected final void withdrawal() {
        withdrawal(getBalance());
    }

    @Override
    protected void showBalance() {
        System.out.println("||||||||||||||||||||||||||||||");
        System.out.println("Act No: " + getNumber());
        System.out.println("Act Name: " + getName());
        System.out.println("Balance: $" + getBalance());
        System.out.println("Pin: " + pin);
        System.out.println("Thru Date: " + thruDate);
        System.out.println("Limit Amount: $" + limitAmount);
        System.out.println("|||||||||||||||||||||||||||||");
    }

    private boolean isExpired(LocalDate date) {
        // What day is today?
        LocalDate now = LocalDate.now();
        return now.isAfter(date);
    }

}
