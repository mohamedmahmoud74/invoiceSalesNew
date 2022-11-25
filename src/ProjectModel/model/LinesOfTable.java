
package ProjectModel.model;

import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;


public class LinesOfTable extends AbstractTableModel{
      private ArrayList<LData>Lines ;
      private String[] columns = {"Number", "Item Name", "Item Price", "Count", "Item Total"};

    public ArrayList<LData> getLine() {
        return Lines;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public LinesOfTable(ArrayList<LData> Lines) {
        this.Lines = Lines;
    }
      
      

    @Override
    public int getRowCount() {
       return Lines.size();
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
         
         LData line = Lines.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return line.getInvoice().getNumber();
            case 1: return line.getItem();
            case 2: return line.getPrice();
            case 3: return line.getCount();
            case 4: return line.getTotalLine();
            default : return "";
        }
    }
    
}
