package patterns.nonull;

import java.math.BigDecimal;

/**
 * Loan calculator based on given TaxCalc. tax is optional, defaults to none.
 */
public class Calc {
  private TaxCalc tax;

  public Calc(TaxCalc tax) {
    if(tax == null){
      tax = new EmptyTax();
    }
    this.tax = tax;
  }

  /*
  * Calculate loan for given employee. freq is optional and defaults to monthly.
  * */
  public BigDecimal loan(Employee emp, Frequency freq) {
    if(freq == null){
      freq = Frequency.MONTHLY;
    }
    return BigDecimal.TEN;
  }
}
