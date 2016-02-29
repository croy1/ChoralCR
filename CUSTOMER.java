public class CUSTOMER
{
    //list of properties
    private String CustomerID;
    private char TicketID;
    private int NoOfTickets;
    private char method;
    private float total;
    private char night;
    private String SeatSelection;
    
    public CUSTOMER()
    {
        //constructor
        //initialise instance var
        CustomerID = "";
        TicketID = 0;
        NoOfTickets = 0;
        method = 0;
    }
    
    public void readCustomerDetails (String dataItems)
    {
        //unpack string of row data into fields
        String[] rowItems = dataItems.split(",");
        CustomerID = rowItems [0];
        TicketID = (rowItems[1]).charAt(0);
        SeatSelection = (rowItems[1]);
        NoOfTickets = Integer.parseInt(rowItems[2]);
        method = (rowItems[3]).charAt(0);
    }
}
