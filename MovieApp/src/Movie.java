public class Movie {
    private String title;
    private String year;
    private String length;
    private String genre;
    private String studioName;
    private String producerCertNum;

    public Movie(final String title, final String year, final String length, final String genre,
            final String studioName, final String producerCertNum) {
        this.title = title;
        this.year = year;
        this.length = length;
        this.genre = genre;
        this.studioName = studioName;
        this.producerCertNum = producerCertNum;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getLength() {
        return length;
    }

    public String getGenre() {
        return genre;
    }

    public String getStudioName() {
        return studioName;
    }

    public String getProducerCertNum() {
        return producerCertNum;
    }
}
