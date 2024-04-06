package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Booking {

  List<Catering> cateringServices = new ArrayList<Catering>();
  List<Music> musicServices = new ArrayList<Music>();
  List<Floral> floralServices = new ArrayList<Floral>();

  private String bookingCode;
  private String email;
  private Venue venue;
  private String dateBookingMade;
  private String dateOfEvent;
  private String numGuests;

  public Booking(String code, String email, Venue venue, String dateBookingMade, String dateOfEvent, String numGuests){
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

  public void addCatering(String bookingReference, String cateringTypeName){

    this.cateringServices.add(new Catering(bookingReference, cateringTypeName));
  }

  public void addMusic(String bookingReference){

    this.musicServices.add(new Music(bookingReference));
  }

  public void addFloral(String bookingReference, String floralTypeName){

    this.floralServices.add(new Floral(bookingReference, floralTypeName));
  }
}