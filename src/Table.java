public class Table
{
    private boolean tableIsOccupied;

    public Table()
    {
        tableIsOccupied = false;
    }

    public boolean ifTableIsFull()
    {
        return tableIsOccupied == true;
    }

    public void bookTable()
    {
        tableIsOccupied = true;
    }

    public void releaseTable()
    {
        tableIsOccupied = false;
    }

}

