package com.cativointing.business.food;

import com.cativointing.userdata.food.FoodData;
import com.cativointing.userdata.food.Status;
import com.cativointing.userdata.food.wip;

public class WIP extends javax.swing.JPanel {

    private javax.swing.GroupLayout WIPLayout;
    private javax.swing.table.DefaultTableModel model;
    private javax.swing.DefaultComboBoxModel statModel;

    public WIP() {
        initComponents();

        model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        for (wip w : FoodData.getWIPS().values()) {
            model.addRow(new Object[]{
                w.getID(), 
                w.getProduct(), 
                w.getStatus()
            });
        }

        statModel = (javax.swing.DefaultComboBoxModel) statComboBox.getModel();
        for (Status s : Status.values()) {
            statModel.addElement(s.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        prodField = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        statComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1090, 559));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Search ID:");

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "WIP Products", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Product:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Status:");

        idField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        prodField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        removeButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(searchButton))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(removeButton))
                .addGap(30, 30, 30))
        );

        statComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(prodField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statComboBox, 0, 217, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(prodField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(statComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        setCellsAlignment(jTable1, javax.swing.SwingConstants.LEADING);

        javax.swing.ListSelectionModel selectionModel = jTable1.getSelectionModel();
        selectionModel.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        int id = (int) jTable1.getValueAt(selectedRow, 0);
                        String product = (String) jTable1.getValueAt(selectedRow, 1);
                        String status = (String) jTable1.getValueAt(selectedRow, 2);

                        System.out.println("Selected: " + id + ", " + product + ", " + status);
                    }
                }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        WIPLayout = layout;
    }// </editor-fold>//GEN-END:initComponents

    public void refresh() {
        model.setRowCount(0);

        for (wip w : FoodData.getWIPS().values()) {
            if(!w.getStatus().equals(Status.DONE.toString())) {
                model.addRow(new Object[]{
                    w.getID(), 
                    w.getProduct(), 
                    w.getStatus()
                });
            }
        }
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        int id = idField.getText().matches("^[0-9]+$") ? Integer.parseInt(idField.getText()) : 0;
        String product = prodField.getText();
        String status = statComboBox.getSelectedIndex() == 0 ? Status.REQUESTED.toString() : statComboBox.getSelectedIndex() == 1 ? Status.PENDING.toString() : Status.DONE.toString();

        if (id <= 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "ADD: Please enter an ID");
            return;
        }

        if (FoodData.getWIPS().containsKey(id)) {
            javax.swing.JOptionPane.showMessageDialog(null, "ADD: ID already exists");
            return;
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            if (id == (int) model.getValueAt(i, 0)) {
                javax.swing.JOptionPane.showMessageDialog(null, "ADD: ID already exists");
                return;
            }
        }

        if (product.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "ADD: Please enter a valid name");
            return;
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            if (product.equals((String) model.getValueAt(i, 1))) {
                javax.swing.JOptionPane.showMessageDialog(null, "ADD: Product already exists");
                return;
            }
        }

        model.addRow(new Object[]{id, product, status});
        FoodData.addWip(new wip(id, product, status));
        
        if (status.equals(Status.DONE.toString())) {
            int row = -1;

            for (int i = 0; i < model.getRowCount(); i++) {
                if (id == (int) model.getValueAt(i, 0)) {
                    row = i;
                    break;
                }
            }

            model.removeRow(row);
            javax.swing.JOptionPane.showMessageDialog(null, "ADD: Product moved to Finished Goods");
        }

        idField.setText("");
        prodField.setText("");
        statComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_addButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        int id = searchField.getText().matches("^[0-9]+$") ? Integer.parseInt(searchField.getText()) : 0;
        String product;
        // String status = statComboBox.getSelectedIndex() == 0 ? Status.REQUESTED.toString() : statComboBox.getSelectedIndex() == 1 ? Status.PENDING.toString() : Status.DONE.toString();
        int status = statComboBox.getSelectedIndex();

        if (id == 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "SEARCH: Please enter an ID");
            return;
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            if (id == (int) model.getValueAt(i, 0)) {
                product = (String) model.getValueAt(i, 1);
                String str = (String) model.getValueAt(i, 2);
                status = str.equals(Status.REQUESTED.toString()) ? 0 : str.equals(Status.PENDING.toString()) ? 1 : 2;

                idField.setText(Integer.toString(id));
                prodField.setText(product);
                statComboBox.setSelectedIndex(status);

                jTable1.clearSelection();
                jTable1.addRowSelectionInterval(i, i);

                searchField.setText("");
                return;
            }
        }

        javax.swing.JOptionPane.showMessageDialog(null, "SEARCH: WIP product not found");

    }//GEN-LAST:event_searchButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int id = idField.getText().matches("^[0-9]+$") ? Integer.parseInt(idField.getText()) : 0;
        String product = prodField.getText();
        String status = statComboBox.getSelectedIndex() == 0 ? Status.REQUESTED.toString() : statComboBox.getSelectedIndex() == 1 ? Status.PENDING.toString() : Status.DONE.toString();

        int row = -1;

        for (int i = 0; i < model.getRowCount(); i++) {
            if (id == (int) model.getValueAt(i, 0)) {
                row = i;
                break;
            }
        }

        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "UPDATE: Please use the SearchID first");
            return;
        }

        if (product.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "UPDATE: Please enter a valid name");
            return;
        }

        if (product.equals(model.getValueAt(row, 1)) && status.equals(model.getValueAt(row, 2))) {
            return;
        }

        int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to update this product?",
                    "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.NO_OPTION) {
            jTable1.clearSelection();
            idField.setText("");
            prodField.setText("");
            statComboBox.setSelectedIndex(0);
            return;
        }

        model.setValueAt(product, row, 1);
        model.setValueAt(status, row, 2);
        FoodData.getWip(id).setProduct(product);
        FoodData.getWip(id).setStatus(status);

        if (status.equals(Status.DONE.toString())) {
            model.removeRow(row);
            javax.swing.JOptionPane.showMessageDialog(null, "UPDATE: Product moved to Finished Goods");
        }

        jTable1.clearSelection();

        idField.setText("");
        prodField.setText("");
        statComboBox.setSelectedIndex(0);

    }//GEN-LAST:event_updateButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int id = idField.getText().matches("^[0-9]+$") ? Integer.parseInt(idField.getText()) : 0;
        String product = prodField.getText();
        String status = statComboBox.getSelectedIndex() == 0 ? Status.REQUESTED.toString() : statComboBox.getSelectedIndex() == 1 ? Status.PENDING.toString() : Status.DONE.toString();

        int row = -1;

        for (int i = 0; i < model.getRowCount(); i++) {
            if (id == (int) model.getValueAt(i, 0)) {
                row = i;
                break;
            }
        }

        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "REMOVE: Please use the SearchID first");
            return;
        }

        if (product.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "REMOVE: Please enter a valid name");
            return;
        }

        int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to remove this product?",
                    "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.NO_OPTION) {
            jTable1.clearSelection();
            idField.setText("");
            prodField.setText("");
            statComboBox.setSelectedIndex(0);
            return;
        }

        model.removeRow(row);
        FoodData.removeWip(id);

        jTable1.clearSelection();
        jTable1.addRowSelectionInterval(row, row);
        
        idField.setText("");
        prodField.setText("");
        statComboBox.setSelectedIndex(0);

    }//GEN-LAST:event_removeButtonActionPerformed

    public javax.swing.GroupLayout getGroupLayout() {
        return WIPLayout;
    }

    public void setCellsAlignment(javax.swing.JTable table, int alignment) {
        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        javax.swing.table.TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField prodField;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> statComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
