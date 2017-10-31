package patterns.nonull;

import java.math.BigDecimal;

/**
 */
public class BetterCalc {
  private TaxCalc tax;

  private BetterCalc(TaxCalc tax) {
    this.tax = tax;
  }

  public static BetterCalc createWithoutTaxes() {
    return new BetterCalc(null);
  }

  public static BetterCalc createWithTaxes(TaxCalc tax) {
    return new BetterCalc(tax);
  }

  private BigDecimal loan(Employee emp, Frequency freq) {
    return BigDecimal.TEN;
  }

  public BigDecimal monthlyLoan(Employee emp) {
    return loan(emp, Frequency.MONTHLY);
  }
}
