
package ProjectView.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InvoiceInterface extends JDialog {
    private JTextField customerNameField;
    private JTextField invoiceDateField;
    private JLabel customerNameLbl;
    private JLabel invoiceDateLbl;
    private JButton okButton;
    private JButton cancelButton;

    public InvoiceInterface(SIGFrame invframe) {
        customerNameLbl = new JLabel("Customer Name:");
        customerNameField = new JTextField(20);
        invoiceDateLbl = new JLabel("Invoice Date:");
        invoiceDateField = new JTextField(20);
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        
        okButton.setActionCommand("createNewInvoiceOK");
        cancelButton.setActionCommand("createNewInvoiceCancel");
        
        okButton.addActionListener(invframe.getInvoiceController());
        cancelButton.addActionListener(invframe.getInvoiceController());
        setLayout(new GridLayout(3, 2));
        
        add(invoiceDateLbl);
        add(invoiceDateField);
        add(customerNameLbl);
        add(customerNameField);
        add(okButton);
        add(cancelButton);
        
        pack();
        
    }

    public JTextField getCustNameField() {
        return customerNameField;
    }

    public JTextField getInvDateField() {
        return invoiceDateField;
    }
    
}
