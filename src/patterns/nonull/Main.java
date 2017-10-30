package patterns.nonull;

import java.math.BigDecimal;

/**
 */
public class Main {
  public void run() {
    BigDecimal loan;
    loan = new Calc(null).loan(new Employee(), null);

    loan = BetterCalc.noTaxes().monthlyLoan(new Employee());
  }
}
