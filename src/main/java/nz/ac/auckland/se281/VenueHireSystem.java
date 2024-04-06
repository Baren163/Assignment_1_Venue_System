package nz.ac.auckland.se281;

// Declaring these imports so I can use lists
import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {

// Venue list
List<Venue> venueList = new ArrayList<Venue>();

// Bookings list
List<Booking> bookingList = new ArrayList<Booking>();

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
        
        MessageCli.VENUE_ENTRY.printMessage(venueList.get(i).getName(), venueList.get(i).getCode(), venueList.get(i).getCapacity(), venueList.get(i).gethireFee(), venueList.get(i).getNAD());
        
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

    for (int i = 0; i < venueList.size(); i++){
      venueList.get(i).updateNAD(systemDate);
    }

  }


  public void printSystemDate() {

    if (systemDate.isBlank()){
      MessageCli.CURRENT_DATE.printMessage("not set");
      return;
    }
    
    MessageCli.CURRENT_DATE.printMessage(systemDate);

  }

  
  public void makeBooking(String[] options) {

    boolean codeExists = false;
    int venueIndex;
    venueIndex = -1;

    for (int i = 0; i < venueList.size(); i++){
      if (venueList.get(i).getCode().equals(options[0])){
        venueIndex = i;
        break;
      }
    }

    if (systemDate.isBlank()){
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }

    if (venueList.isEmpty()){
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }

    for (int i = 0; i < venueList.size(); i++){
      if (options[0].equals(venueList.get(i).getCode())){
        codeExists = true;
      }
    }

    if (codeExists == false){
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      return;
    }

    if (venueList.get(venueIndex).isBookedOnThisDate(options[1])){
      MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(venueList.get(venueIndex).getName(), options[1]);
      return;
    }

    // Setting up the date variables to be processed through the date logic checker
    String[] dateParts = options[1].split("/");
    String day = dateParts[0];
    String month = dateParts[1];
    String year = dateParts[2];

    int dayInt = Integer.parseInt(day);
    int monthInt = Integer.parseInt(month);
    int yearInt = Integer.parseInt(year);

    String[] systemDateParts = systemDate.split("/");
    String systemDay = systemDateParts[0];
    String systemMonth = systemDateParts[1];
    String systemYear = systemDateParts[2];

    int systemDayInt = Integer.parseInt(systemDay);
    int systemMonthInt = Integer.parseInt(systemMonth);
    int systemYearInt = Integer.parseInt(systemYear);

    boolean dateIsOk = false;


    // Logic to check if the input date is before the system date
    if (yearInt == systemYearInt){
      if (monthInt == systemMonthInt){
        if (dayInt >= systemDayInt){
          dateIsOk = true;
        } else if (dayInt < systemDayInt){
          dateIsOk = false;
        }
      } else if (monthInt > systemMonthInt){
        dateIsOk = true;
      } else if (monthInt < systemMonthInt){
        dateIsOk = false;
      }
    } else if (yearInt < systemYearInt){
      dateIsOk = false;
    } else if (yearInt > systemYearInt){
      dateIsOk = true;
    }

    if (!dateIsOk){
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], systemDate);
      return;
    }

    // When the options provided might not be ideal, but they aren’t enough to stop a booking from being made:

    // If the specified number of attendees (options[3]) is below 25% of the venue capacity or above 100% of
    //the venue capacity then change the number (options[3]) to 25% or 100% of the venue capacity respectively
    //and print that message

    // Turn options[3] (number of people attending) into integer to compare with venue capacity integer
    int numAttenders_int = Integer.parseInt(options[3]);
    int venueCapacity_int = Integer.parseInt(venueList.get(venueIndex).getCapacity());
    if (4 * numAttenders_int < venueCapacity_int){
      
      numAttenders_int = (int)(0.25*venueCapacity_int);
      String numAttenders = Integer.toString(numAttenders_int);
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(options[3], numAttenders, venueList.get(venueIndex).getCapacity());

      options[3] = numAttenders;
    } else if (numAttenders_int > venueCapacity_int){
      numAttenders_int = venueCapacity_int;
      String numAttenders = Integer.toString(numAttenders_int);
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(options[3], numAttenders, venueList.get(venueIndex).getCapacity());
      
      options[3] = numAttenders;
    }

    String bookingID = BookingReferenceGenerator.generateBookingReference();

    // Book the venue
    venueList.get(venueIndex).bookDate(options[1], bookingID);

    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(bookingID, venueList.get(venueIndex).getName(), options[1], options[3]);
  
    // Need to figure out how to update venues next available date and impement it when systemDate changes or
    //when venue gets booked for a certain day
    venueList.get(venueIndex).updateNAD(systemDate);

    // Create booking object in bookings list
    bookingList.add(new Booking(bookingID, options[2], venueList.get(venueIndex), systemDate, options[1], options[3]));
  
  }

  public void printBookings(String venueCode) {

    int venueIndex;
    venueIndex = -1;

    for (int i = 0; i < venueList.size(); i++){
      if (venueList.get(i).getCode().equals(venueCode)){
        venueIndex = i;
        break;
      }
    }

    if (venueIndex == -1){
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
      return;
    }

    MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueList.get(venueIndex).getName());

    venueList.get(venueIndex).printVenueBookings();

  }

  
                // -------------------------------  CP 3  ------------------------------- \\




  public void addCateringService(String bookingReference, CateringType cateringType) {

    // Check if bookingReference exists
    //  method name: referenceExists(bookingReference). It will be a method for the Venue class and
    //so what I will do is go through each venue and check every single booking reference on it until
    //I find it.

    int bookingIndex = -1;

    String cateringTypeName = cateringType.getName();

    boolean refCheck = false;

    for (int j = 0; j < venueList.size(); j++){
      if (venueList.get(j).referenceExists(bookingReference) == true){
        refCheck = true;
        int venueIn = j;
        break;
      }
    }

    if (refCheck == false){
      // Print the error msg
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
      return;
    }

    for (int i = 0; i < bookingList.size(); i++){
      if (bookingList.get(i).getCode().equalsIgnoreCase(bookingReference)){
        bookingIndex = i;
        break;
      }
    }

    bookingList.get(bookingIndex).addCatering(bookingReference, cateringTypeName);

    String msgEntry = "Catering (" + cateringTypeName + ")";

    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(msgEntry, bookingReference);

  }

  public void addServiceMusic(String bookingReference) {
    
    int bookingIndex = -1;

    boolean refCheck = false;

    for (int j = 0; j < venueList.size(); j++){
      if (venueList.get(j).referenceExists(bookingReference) == true){
        refCheck = true;
        int venueIn = j;
        break;
      }
    }

    if (refCheck == false){
      // Print the error msg
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
      return;
    }

    for (int i = 0; i < bookingList.size(); i++){
      if (bookingList.get(i).getCode().equalsIgnoreCase(bookingReference)){
        bookingIndex = i;
        break;
      }
    }

    bookingList.get(bookingIndex).addMusic(bookingReference);

    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);

  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {

    int bookingIndex = -1;
    
    String floralTypeName = floralType.getName();

    boolean refCheck = false;

    for (int j = 0; j < venueList.size(); j++){
      if (venueList.get(j).referenceExists(bookingReference) == true){
        refCheck = true;
        int venueIn = j;
        break;
      }
    }

    if (refCheck == false){
      // Print the error msg
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
      return;
    }

    for (int i = 0; i < bookingList.size(); i++){
      if (bookingList.get(i).getCode().equalsIgnoreCase(bookingReference)){
        bookingIndex = i;
        break;
      }
    }

    bookingList.get(bookingIndex).addCatering(bookingReference, floralTypeName);

    String msgEntry = "Floral (" + floralTypeName + ")";

    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage(msgEntry, bookingReference);

  }

  public void viewInvoice(String bookingReference) {

    int bookingIndex = -1;

    boolean refCheck = false;

    int venueIn = -1;

    for (int j = 0; j < venueList.size(); j++){
      if (venueList.get(j).referenceExists(bookingReference) == true){
        refCheck = true;
        venueIn = j;
        break;
      }
    }

    if (refCheck == false){
      // Print the error msg
      MessageCli.VIEW_INVOICE_BOOKING_NOT_FOUND.printMessage(bookingReference);
      return;
    }

    for (int i = 0; i < bookingList.size(); i++){
      if (bookingList.get(i).getCode().equalsIgnoreCase(bookingReference)){
        bookingIndex = i;
        break;
      }
    }

    MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(bookingReference, bookingList.get(bookingIndex).getEmail(), bookingList.get(bookingIndex).getDateBookingMade(), bookingList.get(bookingIndex).getDateOfEvent(), bookingList.get(bookingIndex).getNumGuests(), bookingList.get(bookingIndex).getVenue().getName());

    // INVOICE_CONTENT_TOP_HALF(
    //   "\n===============================================================\n"
    //       + "                          INVOICE\n"
    //       + "           -------------------------------------\n\n"
    //       + "Booking Reference: #%s\n\n"
    //       + "Booking Details:\n"
    //       + "Customer Email: %s\n"
    //       + "Date of Booking: %s\n\n"
    //       + "Event Details:\n"
    //       + "Party Date: %s\n"
    //       + "Number of Guests: %s\n"
    //       + "Venue: %s\n\n"
    //       + "Cost Breakdown:")

    // Venue name
    venueList.get(venueIn).getName();
    // Venue capacity
    venueList.get(venueIn).getCapacity();
    // Venue hirefee
    venueList.get(venueIn).gethireFee();



  }
}
