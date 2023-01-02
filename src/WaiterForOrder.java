public class WaiterForOrder
{
    private WaiterForFood theItem;
    private int mNumberOfPlates;

    public WaiterForOrder(WaiterForFood waiterforFood, int numberOfPlates)
    {
        theItem = waiterforFood;
        mNumberOfPlates = numberOfPlates;
    }

    public WaiterForFood getItem()
    {
        return theItem;
    }

    public int getNumberOfPlates()
    {
        return mNumberOfPlates;
    }
}
