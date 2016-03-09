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

    public String writeDetails()
    {
        //join up data into a string to output as a row
        String customerData = "";
        customerData = customerData.concat(CustomerID);
        customerData = customerData.concat(",");
        customerData = customerData.concat(SeatSelection);
        customerData = customerData.concat(",");
        customerData = customerData.concat(Integer.toString(NoOfTickets));
        customerData = customerData.concat(",");
        customerData = customerData.concat(Character.toString(method));
        return customerData;  
    }

    public char getNight()
    {
        return TicketID;
    }
    
    public int getNoOfTickets()
    {
        return NoOfTickets;
    }
    
    public char getmethod()
    {
        return method;
    }
    
    public void displayDetails()
    {
        //output basic details
        System.out.print("The most popular method of sales is");
        System.out.print("The total money raised for the charity");
        System.out.println();
    }
}
