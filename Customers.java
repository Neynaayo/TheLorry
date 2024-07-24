public class Customers{
    protected String name;
    protected String phoneNum;
    protected String email;
    public Customers(){
        name="unknown";
        phoneNum=" ";
        email=" ";
    }
    public Customers(String nm,String pn,String e){
        name=nm;
        phoneNum=pn;
        email=e;
    }
    //mutator
    public void setCustDetail(String nm,String pn,String e){
        name=nm;
        phoneNum=pn;
        email=e;
    }
    //accessor
    public String getName(){return name;}
    public String getPhoneNum(){return phoneNum;}
    public String getEmail(){return email;}
    
    public String toString(){
        return ("Name: "+name+"\nPhone Number: "+phoneNum+"\nEmail: "+email+"\n");
    }
}