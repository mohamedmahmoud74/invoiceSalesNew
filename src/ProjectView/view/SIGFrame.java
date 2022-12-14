/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ProjectView.view;

import java.util.ArrayList;
import java.math.BigDecimal;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.JLabel;
import javax.swing.JTable;
import ProjectController.controller.Controller;
import ProjectModel.model.InvData;
import ProjectModel.model.InvTable;
import ProjectModel.model.LinesOfTable;


public class SIGFrame extends javax.swing.JFrame {

    public SIGFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableOfInvoice = new javax.swing.JTable();
        tableOfInvoice.getSelectionModel().addListSelectionListener(InvoiceController);
        createNewIvoice = new javax.swing.JButton();
        createNewIvoice.addActionListener(InvoiceController);
        deleteInvoice = new javax.swing.JButton();
        deleteInvoice.addActionListener(InvoiceController);
        invoiceNumber = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        totalOfInvoice = new javax.swing.JLabel();
        InvoiceNumLable = new javax.swing.JLabel();
        invoiceDateLable = new javax.swing.JLabel();
        customerNameLable = new javax.swing.JLabel();
        totalOfInvoiceLable = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTable();
        createNewItem = new javax.swing.JButton();
        createNewItem.addActionListener(InvoiceController);
        deleteItem = new javax.swing.JButton();
        deleteItem.addActionListener(InvoiceController);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFile = new javax.swing.JMenuItem();
        loadFile.addActionListener(InvoiceController);
        saveFile = new javax.swing.JMenuItem();
        saveFile.addActionListener(InvoiceController);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableOfInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableOfInvoice);

        createNewIvoice.setText("Create New Invoice");

        deleteInvoice.setText("Delete Invoice");

        invoiceNumber.setText("InvoiceNumber");

        invoiceDate.setText("InvoiceDate");

        customerName.setText("CustomerName");

        totalOfInvoice.setText("TotalOfInvoice");

        invoiceDateLable.setText("jLabel6");

        customerNameLable.setText("jLabel7");

        totalOfInvoiceLable.setText("jLabel8");

        lineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(lineTable);

        createNewItem.setText("Create New Item");

        deleteItem.setText("Delete Item");

        jMenu1.setText("File");

        loadFile.setText("Load File");
        jMenu1.add(loadFile);

        saveFile.setText("Save File");
        jMenu1.add(saveFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createNewIvoice)
                        .addGap(90, 90, 90)
                        .addComponent(deleteInvoice))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createNewItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addComponent(deleteItem))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(226, 226, 226))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(invoiceNumber)
                                .addGap(18, 18, 18)
                                .addComponent(InvoiceNumLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(customerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(customerNameLable))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(totalOfInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(totalOfInvoiceLable))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(invoiceDateLable)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceNumber)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(InvoiceNumLable, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invoiceDate)
                            .addComponent(invoiceDateLable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerName)
                            .addComponent(customerNameLable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalOfInvoice)
                            .addComponent(totalOfInvoiceLable))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteItem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createNewItem)
                        .addComponent(deleteInvoice)
                        .addComponent(createNewIvoice)))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SIGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SIGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SIGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SIGFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SIGFrame().setVisible(true);
            }
        });
       
    }

    private javax.swing.JLabel InvoiceNumLable;
    private javax.swing.JButton createNewItem;
    private javax.swing.JButton createNewIvoice;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel customerNameLable;
    private javax.swing.JButton deleteInvoice;
    private javax.swing.JButton deleteItem;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JLabel invoiceDateLable;
    private javax.swing.JLabel invoiceNumber;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable lineTable;
    private javax.swing.JMenuItem loadFile;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JTable tableOfInvoice;
    private javax.swing.JLabel totalOfInvoice;
    private javax.swing.JLabel totalOfInvoiceLable;
    private ArrayList<InvData>Invoices;
    private Controller InvoiceController = new Controller(this) ;
    private InvTable tableofinvoicemodel;
    private LinesOfTable tableoflinesmodel;

    public InvTable getTableofinvoicemodel() {
        if(tableofinvoicemodel==null)
        {
           tableofinvoicemodel = new InvTable(getInvoices());
        }
        return tableofinvoicemodel;
    }
    public void setTableofinvoicemodel(InvTable tableofinvoicemodel) {
        this.tableofinvoicemodel = tableofinvoicemodel;
    }
    public LinesOfTable getTableoflinesmodel() {
        return tableoflinesmodel;
    }
    public JTable getTableOfInvoice() {
        return tableOfInvoice;
    }
    public JTable getLineTable() {
        return lineTable;
    }
    public JLabel getInvoiceNumLable() {
        return InvoiceNumLable;
    }
    public JLabel getCustomerName() {
        return customerName;
    }
    public JLabel getCustomerNameLable() {
        return customerNameLable;
    }
    public JLabel getInvoiceDate() {
        return invoiceDate;
    }
    public JLabel getInvoiceDateLable() {
        return invoiceDateLable;
    }
    public JLabel getInvoiceNumber() {
        return invoiceNumber;
    }
    public JLabel getTotalOfInvoice() {
        return totalOfInvoice;
    }
    public JLabel getTotalOfInvoiceLable() {
        return totalOfInvoiceLable;
    }
    public Controller getInvoiceController() {
        return InvoiceController;
    }  
    public ArrayList<InvData> getInvoices() {
        if(Invoices == null)
            Invoices=new ArrayList<>();
        return Invoices;
    }
    public void setInvoices(ArrayList<InvData> Invoices) {
        this.Invoices = Invoices;
    }
    public int getNextInvoiceNumber()
    {
       int number=0;
       for(InvData invoice : getInvoices())
       {
          if(invoice.getNumber() > number)
              number=invoice.getNumber();
       }
       return ++number;
    }
    
}


