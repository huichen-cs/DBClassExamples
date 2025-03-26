import java.math.BigDecimal;

public class MovieItem {
    private int itemNum;
    private String movieTitle;
    private int movieYear;
    private String mediaType;
    private int quantity;
    private BigDecimal itemPrice;

    public MovieItem(int num, String title, int year, String type, int qty, BigDecimal price) {
        this.itemNum = num;
        this.movieTitle = title;
        this.movieYear = year;
        this.mediaType = type;
        this.quantity = qty;
        this.itemPrice = price;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int qty) {
        this.quantity = qty;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }
}
