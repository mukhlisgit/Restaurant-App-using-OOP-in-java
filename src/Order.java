import java.util.ArrayList;
import java.util.List;

public class Order
{
    private int OrderId;
    private List<WaiterForOrder> addWaiterForOrder = new ArrayList<WaiterForOrder>();



    public Order(int orderId)
    {
        OrderId = orderId;
    }

    public List<WaiterForOrder> getItemOrder()
    {
        return addWaiterForOrder;
    }


    public void setOrderId(int mOrderId)
    {
        this.OrderId = mOrderId;
    }

    public void addOrder(WaiterForOrder itemOrder)
    {
        addWaiterForOrder.add(itemOrder);
    }

}
