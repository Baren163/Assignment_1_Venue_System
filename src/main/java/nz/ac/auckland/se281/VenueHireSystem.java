package nz.ac.auckland.se281;

// Declaring these imports so I can use lists
import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

// Venue list
List<Venue> venueList = new ArrayList<Venue>();

  public VenueHireSystem() {}

  public void printVenues() {
      // I want this method to print all of the venues in the system and a selection of its details

      // Firstly check if there are any venues to print
      if (venueList.isEmpty()){
        MessageCli.NO_VENUES.printMessage();
        return;
      }

      switch (venueList.size()) {
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
        
        MessageCli.NUMBER_VENUES.printMessage("are", Integer.toString(venueList.size()), "s");
          break;
      }

      for (int i = 0; i < venueList.size(); i++){
        
        MessageCli.VENUE_ENTRY.printMessage(venueList.get(i).getName(), venueList.get(i).getCode(), venueList.get(i).getCapacity(), venueList.get(i).gethireFee());
        
      }

  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    
        // I want this method to create a new instance of the venue class with the 'identifier' of the string entered in
        // venueName parameter. Then I want it to store on it the 3 other parameters entered with the createVenue method.
        // And add it to 'the system'

        // Check if venueName parameter is blank
        if (venueName.isBlank()){
          MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
          return;
        }

        // Check if the venueCode is already being used
        for (int i = 0; i < venueList.size(); i++){
          if (venueCode.equals(venueList.get(i).getCode())){

            MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venueList.get(i).getName());
            
            return;
          }
        }
        
        int capacityInput_int;
        int hireFeeInput_int;

        // Check if the capacityInput and hireFeeInput is a string with just a number
        try{
          capacityInput_int = Integer.parseInt(capacityInput);
        } catch(Exception e) {
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
          return;
        }

        try{
          hireFeeInput_int = Integer.parseInt(hireFeeInput);
        } catch(Exception e) {
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
          return;
        }



        // Check if capacity and hireFee are positive numbers
        if(capacityInput_int < 0){
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
          return;
        }
        if(hireFeeInput_int < 0){
          MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
          return;
        }

        
        // Create the new venue instance with the specified parameters and add it straight to the list
        venueList.add(new Venue(venueName, venueCode, capacityInput, hireFeeInput));
        MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
  }

                // -------------------------------  CP 2  ------------------------------- \\

  String systemDate = " ";

  public void setSystemDate(String dateInput) {

    String[] dateParts = dateInput.split("/");

    String day = dateParts[0];
    String month = dateParts[1];
    String year = dateParts[2];

    systemDate = day + "/" + month + "/" + year;

    MessageCli.DATE_SET.printMessage(systemDate);

  }

  public void printSystemDate() {

    if (systemDate.isBlank()){
      MessageCli.CURRENT_DATE.printMessage("not set");
      return;
    }
    
    MessageCli.CURRENT_DATE.printMessage(systemDate);

  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  //The venue must be available on the specified date, and
  //The booking date must not be in the past (today or later is OK in terms of the current system date).
    boolean codeExists = false;

    if (systemDate.isEmpty()){
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
    }

    if (venueList.isEmpty()){
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
    }

    for (int i = 0; i < venueList.size(); i++){
      if (options[0].equals(venueList.get(i).getCode())){
        codeExists = true;
      }
    }

    if (codeExists == false){
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
    }
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
