import java.math.BigDecimal;

public class InvoiceItem {
    private int itemNum;
    private String movieTitle;
    private int movieYear;
    private String mediaType;
    private BigDecimal itemPrice;
    private int quantity;
    private BigDecimal lineTotal;

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

    public InvoiceItem(MovieItem item, int qtyToOrder) {
        this.itemNum = item.getItemNum();
        this.movieTitle = item.getMovieTitle();
        this.movieYear = item.getMovieYear();
        this.mediaType = item.getMediaType();
        this.itemPrice = item.getItemPrice();
        this.quantity = qtyToOrder;
        this.lineTotal = item.getItemPrice().multiply(new BigDecimal(qtyToOrder));  
    }

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
