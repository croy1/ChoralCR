import javax.swing.JOptionPane;
import java.io.*;
import java.util.Calendar;
public class CONCERT
{

    //array of CUSTOMER objects
    private CUSTOMER customerList[];
    //number of customers to be calculated after reading
    int NoOfCustomers;
    FILEREADCSV customerFile;
    FILEREADCSV resultFile;
    private int year;
   

    public CONCERT()
    {
        customerFile = new FILEREADCSV();
        resultFile = new FILEREADCSV();
        year= 0;
    }

    //top level algorithm
    public void processCustomers() throws IOException
    {
        setupcustomerList();
        countmethod();
        counttotal();
        showyear();
        fridayfile();
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
            //decide if current item
            if (customerList[i].getmethod() =='S')
            {
                countS = countS +1;
            }
            else if (customerList[i].getmethod()=='W')
            {
                countW = countW +1;
            }
            if (countS < countW)
            {
                System.out.println("\n Most customers bought their tickets on the website");
            }
            else if (countS > countW)
            {
                System.out.println("\n Most customers bought their tickets at school");
            }
            else
            {
                System.out.println("\n The same anount of people bought tickets in school and on the website");
            }
        }
    }

    public void counttotal()
    {
        float total = 0.00f;
        for (int i = 0; i < NoOfCustomers; i++)
        { if (customerList[i].getNight() == 'F')
            {
                total = total + customerList[i].getNoOfTickets()*10;
            }
            {
            }
        }
    }
    
    public void showyear()
    {
        year = Calendar.getInstance().get(Calendar.YEAR);
    }
    
    public void fridayfile()
    {
    }

       
}
