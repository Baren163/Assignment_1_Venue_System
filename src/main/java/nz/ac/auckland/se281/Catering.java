package nz.ac.auckland.se281;

public class Catering extends Service{

  private String cateringTypeName;
  private int cateringTypeCPP;

  public Catering(String bookingReference, String cateringTypeName, int cateringTypeCPP) {
    super(bookingReference); // Call the constructor of the superclass

    // Additional logic for the catering class
    this.cateringTypeName = cateringTypeName;
    this.cateringTypeCPP = cateringTypeCPP;
}
  
  public String getCateringTypeName(){
    return this.cateringTypeName;
  }

  public int getCateringTypeCPP(){
    return this.cateringTypeCPP;
  }

  public String getBookingReference(){
    return this.bookingReference;
  }

}
