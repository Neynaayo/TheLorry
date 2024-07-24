public abstract class Vehicle{
    private String pickUpAdd;
    private String dropOffAdd;
    //default & normal
    public Vehicle(){
        pickUpAdd=null;
        dropOffAdd=null;
    }
    public Vehicle(String pua,String doa){
        pickUpAdd=pua;
        dropOffAdd=doa;
    }
    //mutator
    public void setAll(String pua,String doa){
        pickUpAdd=pua;
        dropOffAdd=doa;
    }
    //accessor
    public String getPickUpAdd(){return pickUpAdd;}
    public String getDropOffAdd(){return dropOffAdd;}
    //abstract method
    public abstract double calculateCharge();
    //toString method
    public String toString(){
        return "Pick up Address : "+pickUpAdd+"\nDrop Off Address : "+dropOffAdd+"\nTotal Amount to be paid :RM "+calculateCharge();
    }
}