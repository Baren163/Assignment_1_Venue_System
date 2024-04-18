package nz.ac.auckland.se281;

public abstract class Service {

  // This is my abstract class which will be extended by the 3 different types of services and it is these
  //classes that will also contain the booking reference they are for which will then be used in the invoice
  //calculation

  String bookingReference;

  public Service(String bookingReference) {
    this.bookingReference = bookingReference;
  }

  public abstract String getBookingReference();
  
}