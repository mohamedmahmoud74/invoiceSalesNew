
package ProjectModel.model;

import java.util.ArrayList;


public class LData {
    private String Item;
    private int Count;
    private double Price;
    private InvData invo;

    public LData() {
    }

    public LData(String item, double price, int count, InvData invoice) {
        this.Item = item;
        this.Count = count;
        this.Price = price;
    }
    public double getTotalLine()
    {
        return Price * Count;
    }

    public LData( String Item, int Count, double Price, InvData Invoice) {
        this.Item = Item;
        this.Count = Count;
        this.Price = Price;
        this.invo = Invoice;
    }

    public InvData getInvoice() {
        return invo;
    }

  
    public String getItem() {
        return Item;
    }

    public int getCount() {
        return Count;
    }

    public double getPrice() {
        return Price;
    }

  
    public void setItem(String Item) {
        this.Item = Item;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "LineClass{" + "Number=" + invo.getNumber() + ", Item=" + Item + ", Count=" + Count + ", Price=" + Price + '}';
    }
    
    public String getCsvFile()
    {
        return invo.getNumber() + "," + Item + "," + Count+ "," + Price;
    }
    
}
