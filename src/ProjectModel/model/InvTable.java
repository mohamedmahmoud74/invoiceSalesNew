
package ProjectModel.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class InvTable extends AbstractTableModel {
    private ArrayList<InvData>Invoices ;
    
    private String[] columns = {"Number", "Date", "Customer", "Total"};

    public InvTable(ArrayList<InvData> Invoices) {
        this.Invoices = Invoices;
    }
    

    @Override
    public int getRowCount() {
        
        
        return Invoices.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
   public String getColumnName(int column)
   {
       return columns[column];
   }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvData invoice = Invoices.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return invoice.getNumber();
            case 1: return invoice.getDate();
            case 2: return invoice.getCustomer();
            case 3: return invoice.getInvoiceTotal();
            default : return "";
        }
    
    
    }
    public void setRowSelectionInterval(int headerRow, int headerRow1) {
        
    }
}
