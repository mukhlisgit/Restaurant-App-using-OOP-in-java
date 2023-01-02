import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static String add;
    public static int choose, foodQuantity = 0;
    public static double total = 0, pay;
    public static String k,s;



    public static void showMenu(String[][] menu)
    {
        for (int i=0; i<menu.length; i++)
        {
            for (int j=0;j<menu[i].length; j++)
            {
                System.out.print(menu[i][j]);
            }
            System.out.println("");
        }
    }


    public static String getK() {
        return k;
    }

    public static void setK(String k) {
        Main.k = k;
    }

    public static void main(String[] args) {

        System.out.println("\t\t\t\t\t                WELCOME TO HANGS RESTAURANT                   \n" +
                "\t\t\t\t ===============================================================");


        do
            {
                System.out.println("enter 1 to get a table\n" +
                        "enter 10 to exit\n");
            Scanner input = new Scanner(System.in);
            choose= input.nextInt();
            Menu menu = new Menu();


            switch (choose)
            {
                case 1 : Table.arrayList();

            }
        }
        while (choose!=10);




    }
}