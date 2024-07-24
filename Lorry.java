public class Lorry extends Vehicle{
    private String size;
    private int distance;
    private int quantity;
    //default & normal
    public Lorry(){
        super();
        size = " ";
        distance=0;
        quantity=0;
    }
    public Lorry(String pua,String doa, String size,int distance, int quantity){
        super(pua, doa);
        this.size = size;
        this.distance=distance;
        this.quantity=quantity;
    }
    //mutator @ setter
    public void setSizeCap(String size, int quantity){
        this.size = size;
        this.quantity = quantity;
    }
    public void setDistance(int distance){this.distance=distance;}
    //accessor @ getter
    public String getSize(){return size;}
    public int getQuantity(){return quantity;}
    public int getDistance(){return distance;}
    public double calculateCharge(){
        double price=0;
        if (size.equalsIgnoreCase("S")){
            price =60*quantity;
        }else if (size.equalsIgnoreCase("M")){
            price =65*quantity;
        }else if (size.equalsIgnoreCase("L")){
            price =70*quantity;
        }else if (size.equalsIgnoreCase("XL")){
            price =75*quantity;
        }
        
        if (distance<10)
            price+=50;
        else if (distance>=10&&distance<50)
            price+=50+(distance-10)*5;
        else if (distance>=50)
             price+=200;
             
        return price;
    }
}