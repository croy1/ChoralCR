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
    public void processCustomers()
    {
        setupcustomerList();
        CountMethod();
        CountTotal();
        ShowYear();
        SaveFridayNightFile();
    }
    
    public void setupcustomerList()
    {
    }
    
    public void CountMethod()
    {
    }
    
    public void CountTotal()
    {
    }
    
    public void ShowYear()
    {
    }
    
    public void SaveFridayNightFile()
    {
    }
}