import java.math.BigDecimal;

/**
 * Represents an item in an invoice.
 */
public class InvoiceItem {
  private int itemNum;
  private String movieTitle;
  private int movieYear;
  private String mediaType;
  private BigDecimal itemPrice;
  private int quantity;
  private BigDecimal lineTotal;

  /**
   * Constructs an InvoiceItem with the specified details.
   *
   * @param itemNum the item number
   * @param movieTitle the title of the movie
   * @param movieYear the release year of the movie
   * @param mediaType the type of media (e.g., DVD, Blu-ray)
   * @param itemPrice the price of the item
   * @param qtyOrdered the quantity ordered
   */
  public InvoiceItem(int itemNum, String movieTitle, int movieYear, String mediaType,
      BigDecimal itemPrice, int qtyOrdered) {
    this.itemNum = itemNum;
    this.movieTitle = movieTitle;
    this.movieYear = movieYear;
    this.mediaType = mediaType;
    this.itemPrice = itemPrice;
    this.quantity = qtyOrdered;
    this.lineTotal = itemPrice.multiply(new BigDecimal(qtyOrdered));
  }

  /**
   * Constructs a new InvoiceItem by copying another InvoiceItem.
   *
   * @param other the InvoiceItem to copy
   */
  public InvoiceItem(InvoiceItem other) {
    this.itemNum = other.itemNum;
    this.movieTitle = other.movieTitle;
    this.movieYear = other.movieYear;
    this.mediaType = other.mediaType;
    this.itemPrice = other.itemPrice;
    this.quantity = other.quantity;
    this.lineTotal = other.lineTotal;
  }


  public int getItemNum() {
    return itemNum;
  }

  public String getMovieTitle() {
    return movieTitle;
  }

  public int getMovieYear() {
    return movieYear;
  }

  public String getMediaType() {
    return mediaType;
  }

  public BigDecimal getItemPrice() {
    return itemPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public BigDecimal getLineTotal() {
    return lineTotal;
  }
}
