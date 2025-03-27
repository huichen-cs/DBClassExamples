
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents an invoice with details such as store number, customer information,
 * transaction details, and a list of invoice items.
 */
public class Invoice implements Iterable<InvoiceItem> {
  private String storeNo;
  private String customerName;
  private String customerId;
  private String transNo;
  private Date transDate;
  private Time transTime;
  private List<InvoiceItem> items;
  private BigDecimal tax;
  private BigDecimal tax1; // bad design?
  private BigDecimal tax2;
  private BigDecimal tax3;
  private BigDecimal tax4;
  private BigDecimal tax1Rate; // bad design?
  private BigDecimal tax2Rate;
  private BigDecimal tax3Rate;
  private BigDecimal tax4Rate;
  private BigDecimal total;

  /**
   * Constructs an Invoice with the specified store number, customer ID, and transaction number.
   *
   * @param storeNo the store number
   * @param customerId the customer ID
   * @param transactionNo the transaction number
   */
  public Invoice(String storeNo, String customerId, String transactionNo) {
    this.storeNo = storeNo;
    this.customerId = customerId;
    this.transNo = transactionNo;
    items = new LinkedList<InvoiceItem>();
  }

  public String getStoreNo() {
    return storeNo;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerId() {
    return customerId;
  }

  public String getTransactionNumber() {
    return transNo;
  }

  public void setTransno(String transNo) {
    this.transNo = transNo;
  }

  public Date getTransDate() {
    return transDate;
  }

  public void setTransDate(Date transDate) {
    this.transDate = transDate;
  }


  public Time getTransTime() {
    return transTime;
  }

  public void setTransTime(Time transTime) {
    this.transTime = transTime;
  }

  public BigDecimal getTax() {
    return tax;
  }


  /**
   * Sets the tax details for the invoice.
   *
   * @param tax1 the first tax amount
   * @param tax1Rate the rate for the first tax
   * @param tax2 the second tax amount
   * @param tax2Rate the rate for the second tax
   * @param tax3 the third tax amount
   * @param tax3Rate the rate for the third tax
   * @param tax4 the fourth tax amount
   * @param tax4Rate the rate for the fourth tax
   */
  public void setTax(BigDecimal tax1, BigDecimal tax1Rate, BigDecimal tax2, BigDecimal tax2Rate,
      BigDecimal tax3, BigDecimal tax3Rate, BigDecimal tax4, BigDecimal tax4Rate) {
    this.tax1 = tax1;
    this.tax2 = tax2;
    this.tax3 = tax3;
    this.tax4 = tax4;
    this.tax1Rate = tax1Rate;
    this.tax2Rate = tax2Rate;
    this.tax3Rate = tax3Rate;
    this.tax4Rate = tax4Rate;
    this.tax = tax1.add(tax2).add(tax3).add(tax4);
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

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public void addItem(InvoiceItem item) {
    items.add(new InvoiceItem(item));
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  public Iterator<InvoiceItem> iterator() {
    return items.iterator();
  }
}
