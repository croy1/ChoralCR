import javax.swing.JOptionPane;
import java.io.*;
import java.time.*;
public class CONCERT
{

    //array of CUSTOMER objects
    private CUSTOMER customerList[];
    //number of customers to be calculated after reading
    int NoOfCustomers;
    FILEREADCSV customerFile;
    FILEWRITECSV resultFile;

    private String year;
    public CONCERT() throws IOException
    {
        customerFile = new FILEREADCSV();
        resultFile = new FILEWRITECSV();

    }
    //top level algorithm
    public void processCustomers() throws IOException
    {
        showyear();
        countmethod();
        counttotal();
        fridayfile();
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

    public void counttotal()
    {
        float total = 0.00f;
        for (int i = 0; i < NoOfCustomers; i++)
        { if (customerList[i].getNight() == 'W')
            {
                total = total + customerList[i].getNoOfTickets()*5;
            }
            if (customerList[i].getNight() == 'T')
            {
                total = total + customerList[i].getNoOfTickets()*5;
            }
            if (customerList[i].getNight() == 'F')
            {
                total = total + customerList[i].getNoOfTickets()*10;
            }
        }
        {
            System.out.println("The total money raised for charity is £" + total);
        }
    }

    public void showyear()
    {
        System.out.println("\n Essell Academy Choral Shield " + Year.now().getValue());
    }

    public void fridayfile() throws IOException
    {
        String filecontent = "";
        int count = 0;
        for (int i = 0; i < NoOfCustomers; i++)
        {
            if (customerList[i].getNight() == 'F')
          {
             count = count + 1;
             if (count>1)
            {
                filecontent = filecontent.concat("\n");
            }
            filecontent = filecontent.concat(customerList[i].writeDetails());
          }
        } 
        System.out.println("***Preparing to write data file.");
        resultFile.writeCSVtable(filecontent);
        System.out.print("***File written and closed.");
    }

}
