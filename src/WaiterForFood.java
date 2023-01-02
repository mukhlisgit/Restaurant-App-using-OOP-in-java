public class WaiterForFood
{
    private int foodItemId;
    private String foodName;
    private float foodPrice;

    public WaiterForFood(int id, String name, float price)
    {
        foodItemId = id;
        foodName = name;
        foodPrice = price;
    }

    public String getItemName()
    {
        return foodName;
    }

    public float getItemPrice()
    {
        return foodPrice;
    }

}
