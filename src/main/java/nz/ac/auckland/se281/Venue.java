package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Venue {

  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;

  private String nextAvailableDate = " ";

  private List<String> datesBooked = new ArrayList<String>();
  private List<String> bookingReferences = new ArrayList<String>();

  Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // Constructing the object
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;
  }

  public void printVenueBookings() {
    // If there are no booking references in the bookings
    //list then print error messsage and exit method
    if (bookingReferences.isEmpty()) {
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(this.venueName);
      return;
    }

    // Print the contents of the bookings list
    for (int i = 0; i < bookingReferences.size(); i++) {
      MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(bookingReferences.get(i), datesBooked.get(i));
    }
  }

  public void updateNextAvailableDate(String currentDate) {
    // Changes the next available date on this venue object

    // current date in form DD/MM/YYYY

    nextAvailableDate = currentDate;

    if (datesBooked.isEmpty()) {
      return;
    }

    int i = 0;
    while (i != datesBooked.size()) {
      // While we havn't made it to the end of the datesBooked list keep executing

      for (i = 0; i < datesBooked.size(); i++) {
        if (datesBooked.get(i).equals(nextAvailableDate)) {
          // If today is booked then increment day by one

          String[] dateParts = nextAvailableDate.split("/");
          String dateDay = dateParts[0];
          String dateMonth = dateParts[1];
          String dateYear = dateParts[2];
          int dateDayInt = Integer.parseInt(dateDay);
          int dateMonthInt = Integer.parseInt(dateMonth);
          int dateYearInt = Integer.parseInt(dateYear);

          dateDayInt ++;

          dateDay = String.format("%02d", dateDayInt);
          dateMonth = String.format("%02d", dateMonthInt);
          dateYear = String.format("%02d", dateYearInt);

          nextAvailableDate = dateDay + "/" + dateMonth + "/" + dateYear;
          
          break;
        }
      }
  }
  }


  public String getNextAvailableDate() {
    return this.nextAvailableDate;
  }

  public void bookDate(String date, String bookingReference) {
    this.datesBooked.add(date);
    this.bookingReferences.add(bookingReference);
  }

  public boolean checkIfBookedOnThisDate(String date) {
    for (int i = 0; i < datesBooked.size(); i++) {
      if (date.equals(datesBooked.get(i))) {
        return true;
      }
    }
    return false;
  }


  public boolean doesReferenceExist(String bookingReference) {

    for (int i = 0; i < bookingReferences.size(); i++) {
      if (bookingReference.equalsIgnoreCase(bookingReferences.get(i))) {
        return true;
      }
    }


    return false;
  }


  // The getter methods
  public String getCode() {

    return this.venueCode;
  }

  public String getName() {

    return this.venueName;
  }

  public String getCapacity() {
    return this.capacityInput;
  }

  public String gethireFee() {
    return this.hireFeeInput;
  }
}