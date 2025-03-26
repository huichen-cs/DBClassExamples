import java.math.BigDecimal;

/**
 * Represents an item in the shopping cart.
 */
public class CartItem {
  private int itemNum;
  private String movieTitle;
  private int movieYear;
  private String mediaType;
  private BigDecimal itemPrice;
  private int qtyToOrder;
  private BigDecimal lineTotal;

  /**
   * Constructs a CartItem with the specified movie item and quantity to order.
   *
   * @param item the movie item
   * @param qtyToOrder the quantity to order
   */
  public CartItem(MovieItem item, int qtyToOrder) {
    this.itemNum = item.getItemNum();
    this.movieTitle = item.getMovieTitle();
    this.movieYear = item.getMovieYear();
    this.mediaType = item.getMediaType();
    this.itemPrice = item.getItemPrice();
    this.qtyToOrder = qtyToOrder;
    this.lineTotal = item.getItemPrice().multiply(new BigDecimal(qtyToOrder));
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

  public int getQtyToOrder() {
    return qtyToOrder;
  }

  public void setQtyToOrder(int qty) {
    qtyToOrder = qty;
    lineTotal = itemPrice.multiply(new BigDecimal(qtyToOrder));
  }

  public BigDecimal getLineTotal() {
    return lineTotal;
  }

}
