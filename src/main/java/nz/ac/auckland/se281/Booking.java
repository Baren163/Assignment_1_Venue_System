package nz.ac.auckland.se281;

public class Booking {

  private Catering cateringService;
  private Music musicService;
  private Floral floralService;

  private String bookingCode;
  private String email;
  private Venue venue;
  private String dateBookingMade;
  private String dateOfEvent;
  private String numGuests;

  public Booking(String code, String email, Venue venue, String dateBookingMade, String dateOfEvent, String numGuests){
    // Setting all of this objects values to the given ones in the constructor
    this.bookingCode = code;
    this.email = email;
    this.venue = venue;
    this.dateBookingMade = dateBookingMade;
    this.dateOfEvent = dateOfEvent;
    this.numGuests = numGuests;
  }

  public String getCode(){
    return this.bookingCode;
  }

  public String getEmail(){
    return this.email;
  }

  public Venue getVenue(){
    return this.venue;
  }

  public String getDateBookingMade(){
    return this.dateBookingMade;
  }

  public String getDateOfEvent(){
    return this.dateOfEvent;
  }

  public String getNumGuests(){
    return this.numGuests;
  }

  public Catering getCatering(){
    return this.cateringService;
  }

  public Music getMusic(){
    return this.musicService;
  }

  public Floral getFloral(){
    return this.floralService;
  }

  public boolean hasCatering(){
    return this.cateringService != null;
  }

  public boolean hasMusic(){
    return this.musicService != null;
  }

  public boolean hasFloral(){
    return this.floralService != null;
  }

  public void addCatering(String bookingReference, String cateringTypeName, int cateringTypeCPP){

    this.cateringService = new Catering(bookingReference, cateringTypeName, cateringTypeCPP);
  }

  public void addMusic(String bookingReference){

    this.musicService = new Music(bookingReference);
  }

  public void addFloral(String bookingReference, String floralTypeName, int floralTypeCost){

    this.floralService = new Floral(bookingReference, floralTypeName, floralTypeCost);
  }
}