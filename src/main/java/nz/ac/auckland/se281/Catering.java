package nz.ac.auckland.se281;

public class Catering extends Service{

  String cateringType;

  public Catering(String bookingReference, String cateringType) {
    super(bookingReference); // Call the constructor of the superclass

    // Additional logic for the catering class
    this.cateringType = cateringType;
}
  
  public String getBookingReference(){
    return this.bookingReference;
  }

}
