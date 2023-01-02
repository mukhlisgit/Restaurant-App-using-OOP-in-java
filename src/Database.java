import java.util.*;

public class Database
{
        private static final int MAX_NUM_TABLE = 3;
        private List<Table> foodTables;
        private Deque<Customer> editCustomerQueue;
        private Menu foodMenu;
        private List <Bill> billStore;
        private static Database makeDatabaseObject = null;
        private Customer currentCustomer;
        private List<Customer> customerArray;
        Scanner myScan = new Scanner(System.in);

        private Database()
        {
            foodTables = new ArrayList <Table> ();
            foodMenu = new Menu();
            billStore = new ArrayList <Bill> ();
            editCustomerQueue = new ArrayDeque <Customer> (5);
            customerArray = new ArrayList <Customer> ();
            currentCustomer = null;

            for(int i = 0; i < MAX_NUM_TABLE; i++)
            {
                Table t = new Table();
                foodTables.add(t);
            }
        }

        public boolean isAnyTableFull(){
            for(int i = 0; i < MAX_NUM_TABLE; i++)
            {
                if (foodTables.get(i).ifTableIsFull()){
                    return true;
                }
            }
            return false;
        }

        private int findEmptyTable(){

            for(int i = 0; i < MAX_NUM_TABLE; i++){
                if(!foodTables.get(i).ifTableIsFull()){
                    return i;
                }
            }
            return -1;
        }

        public void displayOccupiedTable(){
            for (int i = 0; i < MAX_NUM_TABLE; i++){
                if(foodTables.get(i).ifTableIsFull()){
                    System.out.println("Table No. " + i + " is occupied");
                }
            }
        }

        public boolean isAllTableFull(){
            int val = findEmptyTable();
            return val == -1;
        }

        public void bookATable()
        {
            if(!isAllTableFull())
            {
                int tableNumber = findEmptyTable();
                currentCustomer = editCustomerQueue.pollLast();
                currentCustomer.setCustomerId(tableNumber);
                currentCustomer.getOrder().setOrderId(tableNumber);
                customerArray.add(tableNumber, currentCustomer);
                foodTables.get(tableNumber).bookTable();
                System.out.println(currentCustomer.getCustomerName() + " should go to table number: "+ tableNumber);


            }
        }

        public Bill makeBill(int id){
            Customer customer = getCustomer(id);
            Bill newBill = new Bill(id,customer);
            newBill.calculateTotal();
            return newBill;
        }

        public Menu getMenu() {
            return foodMenu;
        }


        public void putNewCustomer(Customer customer) {
            editCustomerQueue.offerFirst(customer); /* this uses the deque library to call the boolean method
            offerFirst which inserts the specified element at the front of this deque unless it would
            violate capacity restrictions */
        }

        public static Database getDatabase()
        {
            if(makeDatabaseObject == null)
                makeDatabaseObject = new Database();
            return makeDatabaseObject;
        }

        public Customer getCustomer(int id){
            return customerArray.get(id);
        }

        public void emptyTheTable(int tableId){


            if (foodTables.get(tableId).ifTableIsFull()){
                foodTables.get(tableId).releaseTable();
                System.out.println("Table No. " + tableId + " is available now...");
            }
            
            if(!editCustomerQueue.isEmpty())
            {

                bookATable();
                getMenu().display(); //display the menu

                System.out.println("look at the menu above and make your choices");

                System.out.println("Now enter how many items you want to order?");
                int number_of_items = myScan.nextInt(); //take the value of number of food items


                for (int i = 0; i < number_of_items; i++) {
                    Customer customer;
                    customer = new Customer();

                    System.out.println("choose a meal by entering the number at the left of that meal");
                    int foodId = myScan.nextInt(); //take the food id to know which meal was ordered

                    System.out.println("How many plates of food no " + foodId + " do you want to order");
                    int number_of_plates = myScan.nextInt(); //take the number of plates

                    if (i == number_of_items - 1) //the computer counts from zero so we need to deduct one
                    //to make it convenient fot the program to calculate the exact number of food items
                    {
                        myScan.nextLine();  //then we take the input
                    }

                    WaiterForFood item = getMenu().getMenu().get(foodId);  //pass all food ids to item
                    customer.giveOrder(item, number_of_plates);  //generate an order using the giveOrder method

                }

            }

            if ((editCustomerQueue.isEmpty()) && (isAnyTableFull())){
                System.out.println("There are still some customers...");
            }

            if ((editCustomerQueue.isEmpty()) && (!isAnyTableFull())) {
                System.out.println("All customers were served");
            }
        }


    }

