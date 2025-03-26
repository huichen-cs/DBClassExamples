import java.math.BigDecimal;

public class CartItem {
    private int itemNum;
    private String movieTitle;
    private int movieYear;
    private String mediaType;
    private BigDecimal itemPrice;
    private int qtyToOrder;
    private BigDecimal lineTotal;

    public CartItem(int itemNum, String movieTitle, int movieYear, String mediaType,
            BigDecimal itemPrice, int qtyToOrder) {
        this.itemNum = itemNum;
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.mediaType = mediaType;
        this.itemPrice = itemPrice;
        this.qtyToOrder = qtyToOrder;
        this.lineTotal = itemPrice.multiply(new BigDecimal(qtyToOrder));
    }

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
