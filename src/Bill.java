public class Bill
{
    private int mBillId;
    float retTotal = 0;
    private Customer newCustomer;

    public Bill(int Id, Customer customer)
    {
        mBillId = Id;
        newCustomer = customer;
    }

    public float calculateTotal()
    {
        for (WaiterForOrder element : newCustomer.getOrder().getItemOrder())
        {
            retTotal += (element.getItem().getItemPrice()) * (element.getNumberOfPlates());
        }
        return retTotal;
    }

    public int getBillId()
    {
        return mBillId;
    }

    public void setBillId(int mBillId)
    {
        this.mBillId = mBillId;
    }

}
