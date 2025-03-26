public class Studio {
    private String name;
    private String addressId;
    private String presCertNum;

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
