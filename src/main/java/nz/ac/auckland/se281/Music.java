package nz.ac.auckland.se281;

public class Music extends Service{

  String cateringType;

  public Music(String bookingReference) {
    super(bookingReference); // Call the constructor of the superclass

  }

  public String getBookingReference() {
    return this.bookingReference;
  }

}

