import javax.swing.JOptionPane;
import java.io.*;
public class CONCERT
{

    //array of CUSTOMER objects
    private CUSTOMER customerList[];
    //number of customers to be calculated after reading
    int NoOfCustomers;
    FILEREADCSV customerFile;
    FILEREADCSV resultFile;

    public CONCERT()
    {
        customerFile = new FILEREADCSV();
        resultFile = new FILEREADCSV();
    }

    //top level algorithm
    public void processCustomers() throws IOException
    {
        setupcustomerList();
        countmethod();
    }

    public void setupcustomerList() throws IOException
    {
        //First user message
        System.out.println("Concert Sales: Update on customer");
        System.out.println("*** Preparing to read data file ***");

        //read file, fetch data as string array containg the rows
        String[] dataRows = customerFile.readCSVtable();
        NoOfCustomers = dataRows.length;
        System.out.println("***" + NoOfCustomers + "rows read.\n\n");

        //prepare array for new customers
        customerList = new CUSTOMER[NoOfCustomers];
        //create member objects and copy data
        for (int i = 0; i< NoOfCustomers; i++) {
            customerList[i] = new CUSTOMER();
            //adjust to skip headings
            customerList[i].readCustomerDetails (dataRows[i]);
        }
    }

    public void countmethod()
    {
        //user message
        System.out.println("The method that was used the most was");
        //start the count of the methods
        int countW = 0;
        int countS = 0;
        //loop
        for (int i = 0; i < NoOfCustomers; i++)
        {
            
        }
    }
}
