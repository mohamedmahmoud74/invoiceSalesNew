
package ProjectController.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ProjectModel.model.InvData;
import ProjectModel.model.LData;
import ProjectModel.model.InvTable;
import ProjectModel.model.LinesOfTable;
import ProjectView.view.SIGFrame;
import ProjectView.view.InvoiceInterface;
import ProjectView.view.LineInterface;

         
public class Controller implements ActionListener, ListSelectionListener{
    private SIGFrame invframe;
    private InvoiceInterface invDialog;
    private LineInterface lineDialog;
    public Controller(SIGFrame invframe)
    {
        this.invframe=invframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
       String ActionCommand = e.getActionCommand();
       System.out.println("Please fill the implement " + ActionCommand);
       
       switch (ActionCommand){
           case"Create New Invoice":
               createNewInvoice();
               break;
            case"Delete Invoice":
                deleteInvoice();
               break;
            case"Create New Item":
                createNewItem();
               break;
            case"Delete Item":
                deleteItem();
               break;
            case"Load File":
                loadFile();
               break;
            case"Save File":
                saveFile();
               break;
            case"createNewInvoiceOK":
                createNewInvoiceOK();
                break;
            case"createNewInvoiceCancel":
                createInvoiceCancel();
                break;
            case"createNewLineOK":
                createLineOK();
                break;
            case"createNewLineCancel":
                createLineCancel();
                break;
            
       }
           
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectIndex= invframe.getTableOfInvoice().getSelectedRow(); 
        if(selectIndex !=-1)
        {
        System.out.println("You have selected row " +invframe.getTableOfInvoice().getSelectedRow() );
        InvData current = invframe.getInvoices().get(selectIndex);
        invframe.getInvoiceNumLable().setText(""+current.getNumber());
        invframe.getInvoiceDateLable().setText(current.getDate());
        invframe.getCustomerNameLable().setText(current.getCustomer());
        invframe.getTotalOfInvoiceLable().setText(""+current.getInvoiceTotal());
        LinesOfTable tableOfLinesModel = new LinesOfTable (current.getLine());
        invframe.getLineTable().setModel(tableOfLinesModel);
        tableOfLinesModel.fireTableDataChanged();
        }
    }

    private void createNewInvoice() {
        
        invDialog =new InvoiceInterface(invframe);
        invDialog.setVisible(true);
        
    }

    private void deleteInvoice() {
       int selectRow= invframe.getTableOfInvoice().getSelectedRow();
       if(selectRow !=-1)
       {
         invframe.getInvoices().remove(selectRow);
         invframe.getTableofinvoicemodel().fireTableDataChanged();
       }
        
      
    }

    private void createNewItem() {
       lineDialog = new LineInterface(invframe);
       lineDialog.setVisible(true);
        
    }

    private void deleteItem() {
        int selectInvoice=invframe.getTableOfInvoice().getSelectedRow();
        int selectRow= invframe.getLineTable().getSelectedRow();
       if(selectInvoice !=-1 && selectRow !=-1)
       {
           InvData invoice = invframe.getInvoices().get(selectInvoice);
           invoice.getLine().remove(selectRow);
           LinesOfTable tableoflinesmodel = new LinesOfTable(invoice.getLine());
           invframe.getLineTable().setModel(tableoflinesmodel);
         
         tableoflinesmodel.fireTableDataChanged();
         invframe.getTableofinvoicemodel().fireTableDataChanged();
       }
    }
    
     

    private void loadFile() {
         
         JFileChooser jfc =new JFileChooser();
         try{
         int action =jfc.showOpenDialog(invframe);
         if(action == JFileChooser.APPROVE_OPTION)
         {
             File hFile =jfc.getSelectedFile();
            Path hpath= Paths.get(hFile.getAbsolutePath());
           List<String> hLines= Files.readAllLines(hpath);
           System.out.println("File Invoices have been read ");
           ArrayList<InvData> arrOfInvoices= new ArrayList<>();
          
           for( String hLine : hLines )
           {
             String [] hparts =  hLine.split(","); 
             int invoiceNum = Integer.parseInt(hparts[0]);
             String invoiceDate = hparts[1];
             String cumName= hparts[2];
             InvData invoice = new InvData(invoiceNum,invoiceDate,cumName);
                arrOfInvoices.add(invoice);
           }
           System.out.println("Check Action");
           action=jfc.showOpenDialog(invframe);
           if(action == JFileChooser.APPROVE_OPTION)
           {
             File lFile =jfc.getSelectedFile();
            Path hline= Paths.get(lFile.getAbsolutePath());
           List<String> invoiceLines= Files.readAllLines(hline);
           for (String invoiceLine : invoiceLines) {
                        String []lineParts = invoiceLine.split(",");
                        int invoiceNum = Integer.parseInt(lineParts[0]);
                        String itemName = lineParts[1];
                        double itemPrice = Double.parseDouble(lineParts[2]);
                        int count = Integer.parseInt(lineParts[3]);
                        InvData invoices;
                 invoices = null;
                        for (InvData invoice : arrOfInvoices) {
                            if (invoice.getNumber() == invoiceNum) {
                                invoices = invoice;
                                break;
                            }
                        }


                      LData line=new LData( itemName, count, itemPrice, invoices);
                      invoices.getLine().add(line);
                      
                    }
           System.out.println("Check point");
           
           }
           invframe.setInvoices(arrOfInvoices);
           InvTable tableOfInvoiceModel=new InvTable(arrOfInvoices);
           invframe.setTableofinvoicemodel(tableOfInvoiceModel);
           invframe.getTableOfInvoice().setModel(tableOfInvoiceModel);
           invframe.getTableofinvoicemodel().fireTableDataChanged();
         }
    } catch(IOException ex)
    {
        ex.printStackTrace();
    }
    }

    private void saveFile() {
        
    ArrayList<InvData> invoices = invframe.getInvoices();
        String headers = "";
        String lines = "";
        for (InvData Invo : invoices) {
            String csvInvoice = Invo.getCsvFile();
            headers += csvInvoice;
            headers += "\n";

            for (LData line : Invo.getLine()) {
                String csvLine = line.getCsvFile();
                lines += csvLine;
                lines += "\n";
            }
        }
        System.out.println("Check point");
        try {
            JFileChooser jfc = new JFileChooser();
            int result = jfc.showSaveDialog(invframe);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = jfc.getSelectedFile();
                FileWriter headerFW = new FileWriter(headerFile);
                headerFW.write(headers);
                headerFW.flush();
                headerFW.close();
                result = jfc.showSaveDialog(invframe);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = jfc.getSelectedFile();
                    FileWriter lineFW = new FileWriter(lineFile);
                    lineFW.write(lines);
                    lineFW.flush();
                    lineFW.close();
                }
            }
        } catch (Exception ex) {

        }
    }

    private void createNewInvoiceOK() {
       String date= invDialog.getInvDateField().getText();
       String customer= invDialog.getCustNameField().getText();
       int number = invframe.getNextInvoiceNumber();
       InvData Invoice= new InvData(number, date,customer);
       invframe.getInvoices().add(Invoice);
       invframe.getTableofinvoicemodel().fireTableDataChanged();
       invDialog.setVisible(false);
       invDialog.dispose();
       invDialog =null;
    }

    private void createInvoiceCancel() {
      invDialog.setVisible(false);
      invDialog.dispose();
      invDialog =null;
    }

    private void createLineOK() {
        String item = lineDialog.getItemNameField().getText();
        String countString = lineDialog.getItemCountField().getText();
        String priceString = lineDialog.getItemPriceField().getText();
        int count =Integer.parseInt(countString);
        double price = Double.parseDouble(priceString);
        int selectInvoice=invframe.getTableOfInvoice().getSelectedRow();
        if(selectInvoice!=-1){
              InvData invoice = invframe.getInvoices().get(selectInvoice);
              LData line= new LData(item, count, price,invoice);
              invoice.getLine().add(line);
              LinesOfTable tableOfLinesModel = (LinesOfTable) invframe.getLineTable().getModel();
              //tableOfLinesModel.getLines().add(line);
              tableOfLinesModel.fireTableDataChanged();
              invframe.getTableofinvoicemodel().fireTableDataChanged();
        }
       lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
        
      
    }

    private void createLineCancel() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
    }

   

    
}
