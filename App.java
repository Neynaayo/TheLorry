import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        System.out.println("\t\t\t!!Move and deliver in few clicks!!");
        System.out.println("\t\t\t!!  WELCOME TO THE LORRY APP!!");
        System.out.println("Enter number of users:");
        int user = in.nextInt();
        Customers customers[] = new Customers[user];
        Vehicle vehicle[] = new Vehicle[user];
        Time_Date timedate[] = new Time_Date[user];
        Availability availability = new Availability(); // Create an instance of Availability

        // Get customer information
        for (int i = 0; i < user; i++) {
            System.out.println("================================================================================");
            System.out.println("Let's Move!");
            timedate[i] = availability.getUniqueDate(in); // Get a unique date using the Availability class

            System.out.println("================================================================================");
            System.out.println("Enter your personal details below:");
            System.out.println("Name: ");
            String custName = in.next();
            System.out.println("Phone Number: ");
            String custPhoneNum = in.next();
            System.out.println("Email: ");
            String custEmail = in.next();
            customers[i] = new Customers(custName, custPhoneNum, custEmail);

            System.out.println("================================================================================");
            System.out.println("***House Moving***");
            System.out.println("Enter pickup address: ");
            String pickAdd = in.next();
            System.out.println("Enter drop-off address: ");
            String dropAdd = in.next();

            System.out.println("================================================================================");
            System.out.println("***Choose your type of vehicle***");
            System.out.print("\t[L]Lorry\n\t[V]Van\n[Press any key to exit the program]\nwhich vehicle do you wish to use today?: ");
            String vehicleType = in.next();
            if (!vehicleType.equalsIgnoreCase("L") && !vehicleType.equalsIgnoreCase("V")) {
                System.out.println("*********************************************\nThank you for visiting the LorryApp!. Sayonara!");
                break;
            }

            if (vehicleType.equalsIgnoreCase("L") || vehicleType.equalsIgnoreCase("Lorry")) {
                System.out.println("Choose size of lorry: \n\t[S]Small(1 Tonne Lorry-10 Feet)\n\t[M]Medium(3 Tonne Lorry-14 Feet)\n\t[L]Large(5 Tonne Lorry-17 Feet)\n\t[XL]Extra Large(5 Tonne Lorry-20 Feet)"
                        + "\nwhich size do you wish to use? :");
                String size = in.next();
                System.out.println("Enter estimated distance[KM]: ");
                int distance = in.nextInt();
                System.out.println("How many lorries do you want to use?");
                int quantity = in.nextInt();
                vehicle[i] = new Lorry(pickAdd, dropAdd, size, distance, quantity);
            } else if (vehicleType.equalsIgnoreCase("V") || vehicleType.equalsIgnoreCase("Van")) {
                System.out.print("Enter estimated weight of moving items: ");
                double weight = in.nextDouble();
                System.out.println("Enter estimated distance[KM]: ");
                int distance = in.nextInt();
                System.out.println("How many vans do you want to use?");
                int quantity = in.nextInt();
                vehicle[i] = new Van(pickAdd, dropAdd, weight, distance, quantity);
            }

            /* Check if the date is available */
            if (!availability.isDateAvailable(timedate[i])) {
                System.out.println("This date is already booked. Please choose a different date.");
                i--; // Decrement i to re-enter the loop for the same user
                continue;
            }

            availability.bookDate(timedate[i]); // Book the date
        }

        // Save receipt to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrderRecord.txt"));
             BufferedWriter cancelWriter = new BufferedWriter(new FileWriter("OrderCancel.txt"))) {
            for (int i = 0; i < user; i++) {
                // Create a Receipt object
                Receipt receipt = new Receipt(customers[i], vehicle[i], timedate[i]);
                // Display receipt through the system
                receipt.displayReceipt();

                // Write receipt to file
                writer.write("\n=============Receipt Order <3==============");
                writer.write(System.lineSeparator());
                writer.write("Name: " + customers[i].getName());
                writer.write(System.lineSeparator());
                writer.write("Phone Number: " + customers[i].getPhoneNum());
                writer.write(System.lineSeparator());
                writer.write("Email: " + customers[i].getEmail());
                writer.write(System.lineSeparator());
                writer.write("Date: " + timedate[i].getDay() + "/" + timedate[i].getMonth() + "/" + timedate[i].getYear());
                writer.write(System.lineSeparator());
                writer.write("Time: " + timedate[i].getHour() + ":" + timedate[i].getMinute());
                writer.write(System.lineSeparator());
                writer.write(vehicle[i].toString());
                writer.write(System.lineSeparator());
                writer.write("================================================================================");
                writer.write(System.lineSeparator());
                writer.write("**Receipt saved**");
                writer.write(System.lineSeparator());

                // Check if the order is canceled
                System.out.println("Do you want to cancel your order? [True|False]");
                boolean cancelOrder = in.nextBoolean();
                if (cancelOrder) {
                    receipt.displayReceipt();
                    cancelWriter.write("******ORDER CANCELED******");// Remarks
                    cancelWriter.write(System.lineSeparator());
                    // Write the cancellation receipt to the file
                    cancelWriter.write("Name: " + customers[i].getName());
                    cancelWriter.write(System.lineSeparator());
                    cancelWriter.write("Phone Number: " + customers[i].getPhoneNum());
                    cancelWriter.write(System.lineSeparator());
                    cancelWriter.write("Email: " + customers[i].getEmail());
                    cancelWriter.write(System.lineSeparator());
                    cancelWriter.write("Date: " + timedate[i].getDay() + "/" + timedate[i].getMonth() + "/" + timedate[i].getYear());
                    cancelWriter.write(System.lineSeparator());
                    cancelWriter.write("Time: " + timedate[i].getHour() + ":" + timedate[i].getMinute());
                    cancelWriter.write(System.lineSeparator());
                    cancelWriter.write(vehicle[i].toString());
                    cancelWriter.write(System.lineSeparator());
                    cancelWriter.write("Additional Information: This order has been canceled");
                    cancelWriter.write(System.lineSeparator());
                    cancelWriter.write("================================================================================");
                    cancelWriter.write(System.lineSeparator());
                    cancelWriter.write("**Cancellation receipt saved**");
                    cancelWriter.write(System.lineSeparator());
                }
            }
            System.out.println("**Receipts saved to OrderRecord.txt**");
            System.out.println("**Cancellation receipts saved to OrderCancel.txt**");

            // Change of date
            System.out.println("Do you need to change date? [True|False]");
            boolean ans = in.nextBoolean();
            if (ans) {
                System.out.println("Enter your phone number: ");
                String phoneNum = in.next();
                for (int i = 0; i < user; i++) {
                    if (customers[i].getPhoneNum().equals(phoneNum)) {
                        timedate[i] = availability.getUniqueDate(in);
                        if (!availability.isDateAvailable(timedate[i])) {
                            System.out.println("This date is already booked. Please choose a different date.");
                            i--; // Decrement i to re-enter the loop for the same user
                            continue;
                        }
                        availability.bookDate(timedate[i]);
                        Receipt receipt = new Receipt(customers[i], vehicle[i], timedate[i]);
                        receipt.displayReceipt();
                        writer.write("******CHANGE DATE AND TIME******");// Remarks
                        writer.write(System.lineSeparator());
                        // Write the updated receipt to the file
                        writer.write("Name: " + customers[i].getName());
                        writer.write(System.lineSeparator());
                        writer.write("Phone Number: " + customers[i].getPhoneNum());
                        writer.write(System.lineSeparator());
                        writer.write("Email: " + customers[i].getEmail());
                        writer.write(System.lineSeparator());
                        writer.write("Date: " + timedate[i].getDay() + "/" + timedate[i].getMonth() + "/" + timedate[i].getYear());
                        writer.write(System.lineSeparator());
                        writer.write("Time: " + timedate[i].getHour() + ":" + timedate[i].getMinute());
                        writer.write(System.lineSeparator());
                        writer.write(vehicle[i].toString());
                        writer.write(System.lineSeparator());
                        writer.write("================================================================================");
                        writer.write(System.lineSeparator());
                        writer.write("**Receipt saved**");
                        writer.write(System.lineSeparator());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("**An error occurred while writing the receipts to the file**");
        }
        
        //print out receipt from OrderRecord.txt
        System.out.println("Do you want to see all the receipts? [1-Yes || 2-No]");
        int confirmation = in.nextInt();
        if (confirmation == 1) {
            // Read and display the file contents
            try (BufferedReader reader = new BufferedReader(new FileReader("OrderRecord.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("**An error occurred while reading the receipts from the file**");
            }
        }

        // Display cancellation orders
        System.out.println("Do you want to see cancellation orders? [1-Yes || 2-No]");
        confirmation = in.nextInt();
        if (confirmation == 1) {
            // Read and display the file contents
            try (BufferedReader reader = new BufferedReader(new FileReader("OrderCancel.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("**An error occurred while reading the cancellation orders from the file**");
            }
        } else {
            System.out.println("Thank you for using the Lorry App!");
        }
    }
}
