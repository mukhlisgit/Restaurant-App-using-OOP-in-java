import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private List<WaiterForFood> addMenu;

    public Menu()
    {
        addMenu = new ArrayList<>(); //make a list

        //declare food details
        addMenu.add(new WaiterForFood(11,"Rice and chicken", 35));
        addMenu.add(new WaiterForFood(22, "bolognese pasta", 30));
        addMenu.add(new WaiterForFood(33, "Bread", 7));
        addMenu.add(new WaiterForFood(44, "coke", 6));
        addMenu.add(new WaiterForFood(55, "water", 4));
    }

    public List<WaiterForFood> getMenu()
    {
        return addMenu;
    }

    public void display()
    {
        int i = 0;

        for (WaiterForFood currentWaiterForFood : addMenu) {
            System.out.println(i + ": " + currentWaiterForFood.getItemName() + "  price: " + currentWaiterForFood.getItemPrice() );
            i++;

        }

    }
}
