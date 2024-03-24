package nz.ac.auckland.se281;

public class Venue {

  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;


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
}