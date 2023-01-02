import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner myScan = new Scanner(System.in);
        String s;            //create a string to be used in determining the input of the user (if it's yes)
        Database database = Database.getDatabase();  //generate a 'database'
        System.out.println("\n====================WELCOME TO HANGS RESTAURANT================");

        do
            {
            int tableId = 0;  //initialise the id of the table
            Customer customer;

            System.out.println("Do you want to add a customer?");
            String ans = myScan.nextLine();   //take input

            if(ans.equalsIgnoreCase("Yes")) //if input is yes
            {
                customer = new Customer();

                System.out.println("Enter the name of the customer");
                String customerName = myScan.nextLine();  //read the name of the customer

                customer.setCustomerName(customerName);  // set or save the customer name
                database.putNewCustomer(customer);      //puts the customer at the front of the deque list

                if(database.isAllTableFull() == false) //if there is an empty table
                {

                    database.bookATable(); //setting up a table for a new customer
                    database.getMenu().display(); //display the menu

                    System.out.println("look at the menu above and make your choices");

                    System.out.println("Now enter how many items you want to order?");
                    int number_of_items = myScan.nextInt(); //take the value of number of food items

                    for (int i = 0; i<number_of_items; i++)
                    {
                        System.out.println("choose a meal by entering the number at the left of that meal");
                        int foodId = myScan.nextInt(); //take the food id to know which meal was ordered

                        System.out.println("How many plates of food no " + foodId + " do you want to order");
                        int number_of_plates = myScan.nextInt(); //take the number of plates

                        if(i == number_of_items - 1) //the computer counts from zero so we need to deduct one
                            //to make it convenient fot the program to calculate the exact number of food items
                        {
                            myScan.nextLine();  //then we take the input
                        }

                        WaiterForFood item = database.getMenu().getMenu().get(foodId);  //pass all food ids to item
                        customer.giveOrder(item, number_of_plates);  //generate an order using the giveOrder method
                    }
                    System.out.println("Your order has been noted, please wait in your seats");

                }

                else {

                    System.out.println("unfortunately all tables are occupied..please stand by :)");
                    System.out.println("is any customer going to check out?");
                    System.out.println("enter the number of a table to check out the customer:");

                    Database.getDatabase().displayOccupiedTable(); //show the tables that are occupied

                    System.out.println("Enter -9 if no customer is going to check out..");
                    tableId = Integer.parseInt(myScan.nextLine());

                    if(tableId != -9 )
                    {
                        Bill smallBill=database.makeBill(tableId); //generate the bill with tableId as an argument
                        float toPay = smallBill.retTotal;        //retrieve the total money to be paid
                        System.out.println("you are to pay "+ toPay);

                        System.out.println("please enter a payment");
                        Scanner input = new Scanner(System.in);
                        float pay = input.nextInt();
                        if (pay < toPay ) System.out.println("insufficient funds, please retry payment");
                        else {
                            toPay = pay - toPay;
                            System.out.println("your balance is " + String.format("%.2f", toPay));
                            System.out.println("Thank you for eating at hangs restaurant! Have a nice day!");
                            database.emptyTheTable(tableId);
                        }
                    }

                }

            }

            else //If no customer is to be added
                {

                if(database.isAnyTableFull() == true) { //if any table is occupied at all

                   System.out.println("Has any customer finished?");
                   System.out.println("Enter -9 if no customer has finished..");
                   System.out.println("enter the number of a table to deque the customer");

                    Database.getDatabase().displayOccupiedTable(); //display the tables that are full

                    int numberOfTable = myScan.nextInt();
                    myScan.nextLine();

                    if(numberOfTable != -9)
                    {
                        Bill smallBilly=database.makeBill(numberOfTable);
                        float toPayIs = smallBilly.retTotal;
                        System.out.println("you are to pay " +toPayIs);

                        System.out.println("please enter a payment");
                        Scanner input = new Scanner(System.in);
                        float pay = input.nextInt();
                        if (pay < toPayIs ) System.out.println("insufficient funds, please retry payment");
                        else
                            {
                            toPayIs = pay - toPayIs;
                            System.out.println("your balance is " + String.format("%.2f", toPayIs));
                            System.out.println("Thank you for eating at hangs restaurant! Have a nice day!");
                            database.emptyTheTable(numberOfTable); //empty the table after the payment is successful
                            }


                    }

                }

            }

            System.out.println("Do you wish to continue?");

            s = myScan.nextLine();

            if(s.equalsIgnoreCase("No")){
                System.exit(0);
            }

        } while (s.equalsIgnoreCase("Yes"));

    }

}
