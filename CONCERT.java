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
    }
    
}