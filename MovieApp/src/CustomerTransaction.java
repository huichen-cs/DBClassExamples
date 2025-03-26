import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

/**
 * Represents a customer transaction with details such as transaction number, customer ID, 
 * customer name, transaction date, transaction time, price, tax rates, and total amounts.
 */
public class CustomerTransaction {
  private String transactionNo;
  private String customerId;
  private String customerName;
  private Date transactionDate;
  private Time transactionTime;
  private BigDecimal price; // price without tax
  private BigDecimal tax1; // bad design?
  private BigDecimal tax2; // bad design?
  private BigDecimal tax3; // bad design?
  private BigDecimal tax4; // bad design?
  private BigDecimal tax1Rate; // bad design?
  private BigDecimal tax2Rate; // bad design?
  private BigDecimal tax3Rate; // bad design?
  private BigDecimal tax4Rate; // bad design?
  private BigDecimal totalTax; // tax1 + tax2 + tax3 + tax4
  private BigDecimal total; // price + tax1 + tax2 + tax3 + tax4

  /**
   * Constructs a new CustomerTransaction with the specified details.
   *
   * @param transactionNo the transaction number
   * @param customerId the customer ID
   * @param customerName the customer name
   * @param transactionDate the transaction date
   * @param transactionTime the transaction time
   * @param price the price without tax
   * @param tax1Rate the first tax rate
   * @param tax2Rate the second tax rate
   * @param tax3Rate the third tax rate
   * @param tax4Rate the fourth tax rate
   * @param tax1 the first tax amount
   * @param tax2 the second tax amount
   * @param tax3 the third tax amount
   * @param tax4 the fourth tax amount
   * @param total the total amount (price + all taxes)
   */
  public CustomerTransaction(String transactionNo, String customerId, String customerName,
      Date transactionDate, Time transactionTime, BigDecimal price, BigDecimal tax1Rate,
      BigDecimal tax2Rate, BigDecimal tax3Rate, BigDecimal tax4Rate, BigDecimal tax1,
      BigDecimal tax2, BigDecimal tax3, BigDecimal tax4, BigDecimal total) {
    this.transactionNo = transactionNo;
    this.customerId = customerId;
    this.customerName = customerName;
    this.transactionDate = transactionDate;
    this.transactionTime = transactionTime;
    this.price = price;
    this.tax1Rate = tax1Rate;
    this.tax2Rate = tax2Rate;
    this.tax3Rate = tax3Rate;
    this.tax4Rate = tax4Rate;
    this.tax1 = tax1;
    this.tax2 = tax2;
    this.tax3 = tax3;
    this.tax4 = tax4;
    this.totalTax = tax1.add(tax2).add(tax3).add(tax4);
    this.total = total;
  }

  public String getTransactionNo() {
    return transactionNo;
  }

  public String getCustomerId() {
    return customerId;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public Time getTransactionTime() {
    return transactionTime;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getTax1() {
    return tax1;
  }

  public BigDecimal getTax2() {
    return tax2;
  }
  
  public BigDecimal getTax3() {
    return tax3;
  }

  public BigDecimal getTax4() {
    return tax4;
  }

  public BigDecimal getTax1Rate() {
    return tax1Rate;
  }

  public BigDecimal getTax2Rate() {
    return tax2Rate;
  }

  public BigDecimal getTax3Rate() {
    return tax3Rate;
  }

  public BigDecimal getTax4Rate() {
    return tax4Rate;
  }

  public BigDecimal getTotalTax() {
    return totalTax;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public String getCustomerName() {
    return customerName;
  }
}
