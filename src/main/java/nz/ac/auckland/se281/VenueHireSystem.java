package nz.ac.auckland.se281;

// Declaring these imports so I can use lists
import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

// Venue codes list
List<String> venueCodesList = new ArrayList<String>();

// Venue names list
List<String> venueNamesList = new ArrayList<String>();

  public VenueHireSystem() {}

  public void printVenues() {
      // I want this method to print all of the venues in the system and a selection of its details

      // Firstly check if there are any venues to print
      if (venueNamesList.isEmpty()){
        MessageCli.NO_VENUES.printMessage();
      }

      switch (venueNamesList.size()) {
        case 1:
        MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
          break;
      
          case 2:
          MessageCli.NUMBER_VENUES.printMessage("are", "two", "s");
          break;

          case 3:
          MessageCli.NUMBER_VENUES.printMessage("are", "three", "s");
          break;
                
          case 4:
          MessageCli.NUMBER_VENUES.printMessage("are", "four", "s");
          break;

          case 5:
          MessageCli.NUMBER_VENUES.printMessage("are", "five", "s");
          break;
                
          case 6:
          MessageCli.NUMBER_VENUES.printMessage("are", "six", "s");
          break;

          case 7:
          MessageCli.NUMBER_VENUES.printMessage("are", "seven", "s");
          break;
                
          case 8:
          MessageCli.NUMBER_VENUES.printMessage("are", "eight", "s");
          break;

          case 9:
          MessageCli.NUMBER_VENUES.printMessage("are", "nine", "s");
          break;
        default:
        
        MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(venueNamesList.size()), "s");
          break;
      }

  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    
        // I want this method to create a new instance of the venue class with the 'identifier' of the string entered in
        // venueName parameter. Then I want it to store on it the 3 other parameters entered with the createVenue method.
        // And add it to 'the system'

        // Check if venueName parameter is blank
        if (venueName.isBlank()){
          System.out.println("Venue not created: venue name must not be empty.");
          return;
        }

        // Check if the venueCode is already being used
        for (int i = 0; i < venueCodesList.size(); i++){
          if (venueCode.equals(venueCodesList.get(i))){
            System.out.println("Venue not created: code " + venueCode + " is already used for " + venueNamesList.get(i) + ".");
            return;
          }
        }
        
        // Check if the capacityInput and hireFeeInput is a string with just a number
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

        // Check if capacity and hireFee are positive numbers
        if(capacityInput_int < 0){
          System.out.println("Venue not created: capacity must be a positive number.");
          return;
        }
        if(hireFeeInput_int < 0){
          System.out.println("Venue not created: hire fee must be a positive number.");
          return;
        }

        // Create the new venue instance with the specified parameters
        Venue v1 = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
        System.out.println("Successfully created venue '" + venueName + "' (" + venueCode + ").");

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
