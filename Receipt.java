public class Receipt {
    private Customers customer;
    private Vehicle vehicle;
    private Time_Date timeDate;

    public Receipt(Customers customer, Vehicle vehicle, Time_Date timeDate) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.timeDate = timeDate;
    }

    public void displayReceipt() {
        System.out.println("\n=============Receipt Order <3==============");
        System.out.println("Name: " + customer.getName());
        System.out.println("Phone Number: " + customer.getPhoneNum());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Date: " + timeDate.getDay() + "/" + timeDate.getMonth() + "/" + timeDate.getYear());
        System.out.println("Time: " + timeDate.getHour() + ":" + timeDate.getMinute());
        System.out.println(vehicle.toString());
    }
}
