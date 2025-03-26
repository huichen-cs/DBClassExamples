/**
 * Represents a movie with a title, year, length, genre, studio name, and
 * producer certificate number.
 */
public class Movie {
  private String title;
  private String year;
  private String length;
  private String genre;
  private String studioName;
  private String producerCertNum;

  /**
   * Constructs a new Movie instance with the specified details.
   *
   * @param title the title of the movie
   * @param year the release year of the movie
   * @param length the length of the movie
   * @param genre the genre of the movie
   * @param studioName the name of the studio that produced the movie
   * @param producerCertNum the producer's certificate number
   */
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
