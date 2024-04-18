package nz.ac.auckland.se281;

public class Catering extends Service {

  private String cateringTypeName;
  private int cateringTypeCostPerPerson;

  public Catering(String bookingReference, String cateringTypeName, int cateringTypeCostPerPerson) {
    super(bookingReference); // Call the constructor of the superclass

    // Additional logic for the catering class
    this.cateringTypeName = cateringTypeName;
    this.cateringTypeCostPerPerson = cateringTypeCostPerPerson;
}
  
  public String getCateringTypeName() {
    return this.cateringTypeName;
  }

  public int getCateringTypeCostPerPerson() {
    return this.cateringTypeCostPerPerson;
  }

  public String getBookingReference() {
    return this.bookingReference;
  }

}
