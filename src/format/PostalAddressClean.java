package format;

public class PostalAddressClean {
  private String street;
  private String zipCode;
  private String city;

  public PostalAddressClean() {
    this("", "", "");
  }

  public PostalAddressClean(final String street, final String zipCode, final String city) {
    this.street = street;
    this.zipCode = zipCode;
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(final String street) {
    this.street = street;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(final String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "PostalAddress [street=" + street + ", zipCode=" + zipCode + ", city=" + city + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PostalAddressClean that = (PostalAddressClean) o;

    if (street != null ? !street.equals(that.street) : that.street != null) return false;
    if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
    return city != null ? city.equals(that.city) : that.city == null;
  }

  @Override
  public int hashCode() {
    int result = street != null ? street.hashCode() : 0;
    result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
    result = 31 * result + (city != null ? city.hashCode() : 0);
    return result;
  }
}
