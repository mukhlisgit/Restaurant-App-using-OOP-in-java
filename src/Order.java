import java.util.Scanner;

public class Order
{
    public static Scanner input = new Scanner(System.in);
    public static String add;
    public static int choose, foodQuantity = 0;
    public static double total = 0;
    private static String st;


    public static void order() {
        System.out.println("Please enter the number of the meal you want order");
        choose = input.nextInt();



        if (choose == 1) {
            System.out.println( Main.getK() + "The price of mexican chicken wrap is 35TL" );
            System.out.println("How many would you like to buy");
            foodQuantity = input.nextInt();
            total = total + (foodQuantity * 35);
            System.out.println("Great! now press yes if you want to order something else or no if you are done");
            add = input.next();
            if (add.equalsIgnoreCase("yes")) {
                order();
            } else {
                System.out.println("your total is " + String.format("%.2f", total));
            }
        }
        else if (choose == 2) {
            System.out.println("The price of bulgur and chicken wings is 29TL");
            System.out.println("How many would you like to buy");
            foodQuantity = input.nextInt();
            total = total + (foodQuantity * 29);
            System.out.println("Great! now press yes if you want to order something else or no if you are done");
            add = input.next();
            if (add.equalsIgnoreCase("yes")) {
                order();
            } else {
                System.out.println("your total is " + String.format("%.2f", total));
            }
        }
        else if (choose == 3) {
            System.out.println("The price of dallas steak is 65TL");
            System.out.println("How many would you like to buy");
            foodQuantity = input.nextInt();
            total = total + (foodQuantity * 65);
            System.out.println("Great! now press yes if you want to order something else or no if you are done");
            add = input.next();
            if (add.equalsIgnoreCase("yes")) {
                order();
            } else {
                System.out.println("your total is " + String.format("%.2f", total));
            }
        }
        else if (choose == 4) {
            System.out.println("The price of ramen noodles is 40TL");
            System.out.println("How many would you like to buy");
            foodQuantity = input.nextInt();
            total = total + (foodQuantity * 40);
            System.out.println("Great! now press yes if you want to order something else or no if you are done");
            add = input.next();
            if (add.equalsIgnoreCase("yes")) {
                order();
            } else {
                System.out.println("your total is " + String.format("%.2f", total));
            }
        }
        else if (choose == 5) {
            System.out.println("The price of bolognese spaghetti is 42TL");
            System.out.println("How many would you like to buy");
            foodQuantity = input.nextInt();
            total = total + (foodQuantity * 42);
            System.out.println("Great! now press yes if you want to order something else or no if you are done");
            add = input.next();
            if (add.equalsIgnoreCase("yes")) {
                order();
            } else {
                System.out.println("your total is " + String.format("%.2f", total));
            }
        }











        else if (choose == 6) {
            System.exit(0);
        } else {
            System.out.println("Wrong input! Please try again");
            order();
        }
    }
}
