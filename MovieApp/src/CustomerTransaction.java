import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

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
    private BigDecimal taxRate1; // bad design?
    private BigDecimal taxRate2; // bad design?
    private BigDecimal taxRate3; // bad design?
    private BigDecimal taxRate4; // bad design?
    private BigDecimal totalTax; // tax1 + tax2 + tax3 + tax4
    private BigDecimal total; // price + tax1 + tax2 + tax3 + tax4

    // constructor
    public CustomerTransaction(String transactionNo, String customerId, String customerName, Date transactionDate,
            Time transactionTime, BigDecimal price, BigDecimal taxRate1, BigDecimal taxRate2,
            BigDecimal taxRate3, BigDecimal taxRate4) {
        this.transactionNo = transactionNo;
        this.customerId = customerId;
        this.customerName = customerName;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.price = price;
        this.taxRate1 = taxRate1;
        this.taxRate2 = taxRate2;
        this.taxRate3 = taxRate3;
        this.taxRate4 = taxRate4;
        this.tax1 = price.multiply(this.taxRate1);
        this.tax2 = price.multiply(this.taxRate2);
        this.tax3 = price.multiply(this.taxRate3);
        this.tax4 = price.multiply(this.taxRate4);
        this.totalTax = tax1.add(tax2).add(tax3).add(tax4);
        this.total = this.price.add(totalTax);
    }

    public CustomerTransaction(String transactionNo, String customerId, String customerName, Date transactionDate,
            Time transactionTime, BigDecimal price, BigDecimal taxRate1, BigDecimal taxRate2,
            BigDecimal taxRate3, BigDecimal taxRate4, BigDecimal tax1, BigDecimal tax2,
            BigDecimal tax3, BigDecimal tax4, BigDecimal total) {
        this.transactionNo = transactionNo;
        this.customerId = customerId;
        this.customerName = customerName;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.price = price;
        this.taxRate1 = taxRate1;
        this.taxRate2 = taxRate2;
        this.taxRate3 = taxRate3;
        this.taxRate4 = taxRate4;
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
