/**
 * Represents a movie studio with a name, address ID, and president certificate number.
 */
public class Studio {
  private String name;
  private String addressId;
  private String presCertNum;

  /**
   * Constructs a new Studio with the specified name, address ID, and president certificate number.
   *
   * @param name the name of the studio
   * @param addressId the address ID of the studio
   * @param presCertNum the president certificate number of the studio
   */
  public Studio(final String name, final String addressId, final String presCertNum) {
    this.name = name;
    this.addressId = addressId;
    this.presCertNum = presCertNum;
  }

  public String getName() {
    return name;
  }

  public String getAddressId() {
    return addressId;
  }

  public String getPresCertNum() {
    return presCertNum;
  }
}
