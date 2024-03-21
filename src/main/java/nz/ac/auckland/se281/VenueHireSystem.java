package nz.ac.auckland.se281;

// Declaring these imports so I can use lists
import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

// Venue codes list
List<String> venueCodesList = new ArrayList<String>();
List<String> venueNamesList = new ArrayList<String>();

  public VenueHireSystem() {}

  public void printVenues() {
    // TODO implement this method

      // I want this method to print all of the venues in the system and a selection of its details
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method
        // I want this method to create a new instance of the venue class with the 'identifier' of the string entered in
        // venueName parameter. Then I want it to store on it the 3 other parameters entered with the createVenue method.
        // And add it to 'the system'


        if (venueName.isBlank()){
          System.out.println("Venue not created: venue name must not be empty.");
          return;
        }

        for (int i = 0; i < venueCodesList.size(); i++){
          if (venueCode.equals(venueCodesList.get(i))){
            System.out.println("Venue not created: code " + venueCode + " is already used for " + venueNamesList.get(i) + ".");
            return;
          }
        }
        
        try{
          int capacityInput_int = Integer.parseInt(capacityInput);
        } catch(Exception e) {
          System.out.println("Venue not created: capacity must be a number.");
          return;
        }

        try{
          int hireFeeInput_int = Integer.parseInt(hireFeeInput);
        } catch(Exception e) {
          System.out.println("Venue not created: hire fee must be a number.");
          return;
        }

        int capacityInput_int = Integer.parseInt(capacityInput);
        int hireFeeInput_int = Integer.parseInt(hireFeeInput);

        if(capacityInput_int < 0){
          System.out.println("Venue not created: capacity must be a positive number.");
          return;
        }
        if(hireFeeInput_int < 0){
          System.out.println("Venue not created: hire fee must be a positive number.");
          return;
        }

        Venue v1 = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
        System.out.println("Successfully created venue '" + venueName + "' " + venueCode + ".");

  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
