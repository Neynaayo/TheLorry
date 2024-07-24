public class Van extends Vehicle{
    private double maxWeight;
    private int distance;
    private int quantity;
    //default & normal
    public Van(){
        super();
        maxWeight = 0.0;
        distance=0;
        quantity=0;
    }
    public Van(String vt,String pua,double maxWeight,int distance,int quantity){
        super(vt, pua);
        this.maxWeight = maxWeight;
        this.distance=distance;
        this.quantity=quantity;
    }
    //mutator @ setter
    public void setAll(double maxWeight, int distance,int quantity){
        this.maxWeight = maxWeight;
        this.distance=distance;
        this.quantity=quantity;
    }
    //accessor @ getter
    public double getMaxWeight(){return maxWeight;}
    public int getDistance(){return distance;}
    public int getQuantity(){return quantity;}
    
    public double calculateCharge(){
        double price=0;
        if(maxWeight<500){
            price=55*quantity;
        }
        else if (maxWeight>=500)
            price=72*quantity;
            
        if (distance<10)
            price+=50;
        else if (distance>=10&&distance<50)
            price+=50+(distance-10)*5;
        else if (distance>=50)
             price+=200;
            
        return price;
    }
}