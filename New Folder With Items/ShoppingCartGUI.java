/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.shoppingcartgui;

import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 90's style GUI for Christmas shopping wish list
 * @author noraosmanova
 */
public class ShoppingCartGUI extends javax.swing.JFrame {
        private Catalog catalog;
        private JTextField[] quantityInputFields;
        
    /**
     * Creates new form ShoppingCartGUI
     * @param catalog 
     */
    public ShoppingCartGUI(Catalog catalog) {    
        this.catalog = catalog;
        quantityInputFields = new JTextField[catalog.size()];
        initComponents();
        // add catalog items to GUI
        updateCatalogView();
    }

    /**
     * Show shopping cart GUI
     */
    public void showGUI(){
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShoppingCartGUI(catalog).setVisible(true);
            }
        });
        
    }
    
    /**
     * Adds catalog items to GUI.
     */
    public void updateCatalogView(){
        for (int i = 0; i < catalog.size(); i++){
            // create new label for item 
            Item item = catalog.getIndex(i);
            
            // create quantity input
            JLabel label = new JLabel(item.toString());
             JTextField input = new JTextField();
             quantityInputFields[i]= input;
             
             // add to GUI
             itemListPanel.add(label);
             quantityPanel.add(input);
             
        }
         itemListPanel.revalidate();
        itemListPanel.repaint();
        quantityPanel.revalidate();
        quantityPanel.repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderTotalLabel = new javax.swing.JLabel();
        orderTotalField = new javax.swing.JTextField();
        catalogPanel = new javax.swing.JPanel();
        quantityPanel = new javax.swing.JPanel();
        itemListPanel = new javax.swing.JPanel();
        discountCheckBox = new javax.swing.JCheckBox();
        calcTotalButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(catalog.getName());

        orderTotalLabel.setBackground(new java.awt.Color(102, 255, 102));
        orderTotalLabel.setText("order total ");

        orderTotalField.setEnabled(false);

        catalogPanel.setLayout(new java.awt.GridLayout(1, 2));

        quantityPanel.setLayout(new java.awt.GridLayout(catalog.size(), 1));
        catalogPanel.add(quantityPanel);

        itemListPanel.setLayout(new java.awt.GridLayout(catalog.size(), 1));
        catalogPanel.add(itemListPanel);

        discountCheckBox.setText("qualify for discount");
        discountCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountCheckBoxActionPerformed(evt);
            }
        });

        calcTotalButton.setText("Calculate Total");
        calcTotalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcTotalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(orderTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(catalogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(discountCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(calcTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(catalogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountCheckBox)
                    .addComponent(calcTotalButton))
                .addContainerGap(376, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void discountCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountCheckBoxActionPerformed

    /**
     * calculates total and displays the amount 
     * @param evt 
     */
    private void calcTotalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcTotalButtonActionPerformed
        ShoppingCart cart = new ShoppingCart(catalog.size());
        
        // adding items to the shopping cart 
        for (int i = 0; i < catalog.size(); i++ ){      
             Item item = catalog.getIndex(i);
             JTextField field = quantityInputFields[i];
             // will skip if no quantity added
             if(field.getText().equals("")){
                 continue;
             }
             int quantity = Integer.parseInt(field.getText());      
             ItemOrder order = new ItemOrder(item, quantity);
             cart.add(order);
        }
        
        // applies a discount
        boolean shouldDiscount = discountCheckBox.isSelected();
        cart.setDiscount(shouldDiscount);
        
        // calculate total and display
         double total = cart.getTotal();
         NumberFormat nf = NumberFormat.getCurrencyInstance();
         String text = nf.format(total);
         orderTotalField.setText(text);
    }//GEN-LAST:event_calcTotalButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcTotalButton;
    private javax.swing.JPanel catalogPanel;
    private javax.swing.JCheckBox discountCheckBox;
    private javax.swing.JPanel itemListPanel;
    private javax.swing.JTextField orderTotalField;
    private javax.swing.JLabel orderTotalLabel;
    private javax.swing.JPanel quantityPanel;
    // End of variables declaration//GEN-END:variables

}
