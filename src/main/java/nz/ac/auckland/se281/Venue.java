package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Venue {

  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;

  List<String> datesBooked = new ArrayList<String>();

  Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput){

    this.venueName = venueName;
    this.venueCode = venueCode;
    this. capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;
  }

  public String getCode(){

    return this.venueCode;
  }

  public String getName(){

    return this.venueName;
  }

  public String getCapacity(){
    return this.capacityInput;
  }

  public String gethireFee(){
    return this.hireFeeInput;
  }

  public void bookDate(String date){
    this.datesBooked.add(date);
  }

  public boolean isBookedOnThisDate(String date){
    for (int i = 0; i < datesBooked.size(); i++){
      if (date.equals(datesBooked.get(i))){
        return true;
      }
    }
    return false;
  }
}