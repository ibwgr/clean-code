package format;

/**
 * A model for representing a postal address.
 *
 * @author First version by <a href="mailto:alma@finnova.ch">Manuel Alabor</a>
 */
public class PostalAddress {

  /**
   * address street
   */
  private String street;

  /**
   * address zipcode
   */
  private String zipCode;

  /**
   * address city
   */
  private String city;


  /**
   * Default constructor creating an empty {@link PostalAddress}.
   */
  public PostalAddress() {
    this("", "", "");
  }

  /**
   * Constructor for creating a filled in {@link PostalAddress}.
   *
   * @param street
   * @param zipCode
   * @param city
   */
  public PostalAddress(final String street, final String zipCode, final String city) {
    this.street = street;
    this.zipCode = zipCode;
    this.city = city;
  }

  /**
   * Returns the {@link PostalAddress} street.
   *
   * @return
   */
  public String getStreet() {
    return street;
  }

  /**
   * Sets the {@link PostalAddress} street.
   *
   * @param street
   */
  public void setStreet(final String street) {
    this.street = street;
  }

  /**
   * Returns the {@link PostalAddress} zip code.
   *
   * @return
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Sets the {@link PostalAddress} zip code.
   *
   * @param zipCode
   */
  public void setZipCode(final String zipCode) {
    this.zipCode = zipCode;
  }

  /**
   * Returns the {@link PostalAddress} city.
   *
   * @return
   */
  public String getCity() {
    return city;
  }

  /**
   * Sets the {@link PostalAddress} city.
   *
   * @param city
   */
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

    PostalAddress that = (PostalAddress) o;

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
