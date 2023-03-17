package co.istad.banking;

import co.istad.banking.database.Database;

public class BankProgram {
    public static void main(String[] args) {

        CreditCard creditCard = new CreditCard();
        creditCard.setNumber(88889999);
        creditCard.setPin(1213);

        // Check credit card exists or not
        if (Database.creditCard().getNumber()
                .equals(creditCard.getNumber())) {
            creditCard = Database.creditCard();
        } else {
            System.out.println("Invalid Card..!");
            return;
        }

        creditCard.deposit(500.0);
        //creditCard.withdrawal(1000.0);
        creditCard.withdrawal(); // Entire amount
        creditCard.showBalance();

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setInterestI(new RielRate());
        savingAccount.showBalance();

        SavingAccount mySaving = Database.saving();
        mySaving.setInterestI(new RielRate());
        mySaving.calculateInterest();
        System.out.println(mySaving.getInterest());

    }
}
