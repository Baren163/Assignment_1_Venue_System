package nz.ac.auckland.se281;

public class Floral extends Service{

  private String floralTypeName;
  private int floralTypeCost;

  public Floral(String bookingReference, String floralTypeName, int floralTypeCost) {
    super(bookingReference); // Call the constructor of the superclass

    // Additional logic for the floral class
    this.floralTypeName = floralTypeName;
    this.floralTypeCost = floralTypeCost;
  }

  public String getFloralTypeName(){
    return this.floralTypeName;
  }

  public int getFloralTypeCost(){
    return this.floralTypeCost;
  }


  public String getBookingReference(){
    return this.bookingReference;
  }
}

