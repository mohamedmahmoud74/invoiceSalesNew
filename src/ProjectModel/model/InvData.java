
package ProjectModel.model;

import java.util.ArrayList;


public class InvData {
    private int number;
    private String date;
    private String customerName;
    private ArrayList<LData> lines ;

    public InvData() {
        
    }

    public InvData(int num, String date, String customer) {
        this.number = num;
        this.date = date;
        this.customerName = customer;
    }

    
    public double getInvoiceTotal()
    {
        double total =0.0;
        for(LData line : getLine())
        {
            total +=line.getTotalLine();
        }
        return total;
    }

    public ArrayList<LData> getLine() {
        if(lines == null)
        {
            lines=new ArrayList<>();
        }
        return lines;
    }
    

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getCustomer() {
        return customerName;
    }

    public void setNumber(int num) {
        this.number = num;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public void setCustomer(String Customer) {
        this.customerName = Customer;
    }

    @Override
    public String toString() {
        return "InvoiceClass{" + "Number=" + number + ", Date=" + date + ", Customer=" + customerName + ", Line=" + lines + '}';
    }
    
    public String getCsvFile()
    {
        return number + "," + date + "," + customerName;
    }
}
