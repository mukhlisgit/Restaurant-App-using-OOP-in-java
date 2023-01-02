public class Customer
{
    private int CustomersId;
    private Order Orders;
    private String CustomersName;

    public Customer()
    {
        CustomersId = 0;
        Orders = new Order(CustomersId);
    }



    public void setCustomerId(int mCustomerId)
    {
        this.CustomersId = mCustomerId;
    }

    public void giveOrder(WaiterForFood waiterforFood, int numberOfPlates)
    {
        WaiterForOrder newItemOrder = new WaiterForOrder(waiterforFood,  numberOfPlates);
        Orders.addOrder(newItemOrder);
    }

    public Order getOrder()
    {
        return Orders;
    }


    public String getCustomerName()
    {
        return CustomersName;
    }

    public void setCustomerName(String mCustomerName)
    {
        this.CustomersName = mCustomerName;
    }

}

