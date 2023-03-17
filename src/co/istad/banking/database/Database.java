package co.istad.banking.database;

import co.istad.banking.CreditCard;
import co.istad.banking.SavingAccount;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Database {
    public static CreditCard creditCard() {
        CreditCard creditCard = new CreditCard(88889999,
                "CHAN CHHAYA",
                1000.0);

        creditCard.setPin(1213);
        creditCard.setLimitAmount(10000.0);
        creditCard.setThruDate(LocalDate.now()
                .plus(1, ChronoUnit.DAYS));

        return creditCard;
    }

    public static SavingAccount saving() {
        SavingAccount saving = new SavingAccount(12345, "DARA", 100.0);
        return saving;
    }
}
