package com.cativointing.business.retail;

import com.cativointing.userdata.retail.RetailData;
import com.cativointing.userdata.CustomerData;

public class Customer extends javax.swing.JPanel {

    private javax.swing.GroupLayout productLayout;
    javax.swing.table.DefaultTableModel model;

    public Customer() {
        initComponents();

        model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        for (CustomerData c : RetailData.getCUSTOMERS().values()) {
            model.addRow(new Object[]{c.getID(), c.getName(), c.getContact(), c.getEmail()});
        }
    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel3 = new javax.swing.JPanel();
                jLabel5 = new javax.swing.JLabel();
                searchField = new javax.swing.JTextField();
                jPanel4 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                nameField = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                idField = new javax.swing.JTextField();
                jPanel5 = new javax.swing.JPanel();
                updateButton = new javax.swing.JButton();
                removeButton = new javax.swing.JButton();
                addButton = new javax.swing.JButton();
                searchButton = new javax.swing.JButton();
                jLabel4 = new javax.swing.JLabel();
                conField = new javax.swing.JTextField();
                jLabel3 = new javax.swing.JLabel();
                emailField = new javax.swing.JTextField();
                jPanel2 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable() {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                                return false;
                        };
                };

                setPreferredSize(new java.awt.Dimension(1090, 559));

                jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                jLabel5.setText("Search ID:");

                searchField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                113,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(searchField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                300,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                97,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(searchField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap()));

                jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Info",
                                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                jLabel1.setText("Name:");

                nameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                jLabel2.setText("ID:");

                idField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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
                                                                .addGap(80, 80, 80)
                                                                .addGroup(jPanel5Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(updateButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(addButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                89,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel5Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(removeButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(searchButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(80, 80, 80)));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(addButton)
                                                                                .addComponent(searchButton))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(updateButton)
                                                                                .addComponent(removeButton))
                                                                .addContainerGap(20, Short.MAX_VALUE)));

                jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                jLabel4.setText("Contact:");

                conField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                jLabel3.setText("Email:");

                emailField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanel5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanel4Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(jLabel4,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                113,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel1,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel2,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel3,
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(jPanel4Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(nameField,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                300,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(conField)
                                                                                                                .addComponent(idField)
                                                                                                                .addComponent(emailField))
                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(idField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(nameField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(conField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(emailField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jPanel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPanel3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jPanel4,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel4,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                jPanel2.setPreferredSize(new java.awt.Dimension(526, 559));

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "ID", "Name", "Contact", "Email"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class,
                                        java.lang.String.class
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }
                });
                jTable1.setShowGrid(true);
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
                                                String name = (String) jTable1.getValueAt(selectedRow, 1);
                                                int contact = (int) jTable1.getValueAt(selectedRow, 2);
                                                String email = (String) jTable1.getValueAt(selectedRow, 3);

                                                System.out.println("Selected: " + id + ", " + name + ", " + contact
                                                                + ", " + email);
                                        }
                                }
                        }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                584, Short.MAX_VALUE)
                                                                .addContainerGap()));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                547, Short.MAX_VALUE)
                                                                .addContainerGap()));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                596, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                productLayout = layout;
        }// </editor-fold>//GEN-END:initComponents

        public void refresh() {
            model.setRowCount(0);
            for (CustomerData c : RetailData.getCUSTOMERS().values()) {
                model.addRow(new Object[]{c.getID(), c.getName(), c.getContact(), c.getEmail()});
            }
        }

        private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
            int id = idField.getText().matches("^[0-9]+$") ? Integer.parseInt(idField.getText()) : 0;
            String name = nameField.getText();
            int contact = conField.getText().matches("^[0-9]+$") ? Integer.parseInt(conField.getText()) : 0;
            String email = emailField.getText();

            // checking if ID already exists
            for (int i = 0; i < model.getRowCount(); i++) {
                if (id == (int) model.getValueAt(i, 0)) {
                    javax.swing.JOptionPane.showMessageDialog(null, "This product already exists");
                    return;
                }
            }

            if (id == 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "ADD: Please enter an ID");
                return;
            }

            if (name.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "ADD: Please enter a valid name");
                return;
            }

            if (contact <= 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "ADD: Please enter a valid contact");
                return;
            }

            if (email.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "ADD: Please enter a valid email");
                return;
            }

            model.addRow(new Object[]{id, name, contact, email});
            RetailData.addCustomer(new CustomerData(id, name, contact, email));

            idField.setText("");
            nameField.setText("");
            conField.setText("");
            emailField.setText("");
        }//GEN-LAST:event_addButtonActionPerformed

        private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
            int searchedID = searchField.getText().matches("^[0-9]+$") ? Integer.parseInt(searchField.getText())
                    : 0;
            String name;
            int contact;
            String email;

            if (searchedID == 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "SEARCH: Please enter an ID");
                return;
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                if (searchedID == (int) model.getValueAt(i, 0)) {
                    name = (String) model.getValueAt(i, 1);
                    contact = (int) model.getValueAt(i, 2);
                    email = (String) model.getValueAt(i, 3);

                    idField.setText(Integer.toString(searchedID));
                    nameField.setText(name);
                    conField.setText(Integer.toString(contact));
                    emailField.setText(email);

                    jTable1.clearSelection();
                    jTable1.addRowSelectionInterval(i, i);

                    searchField.setText("");
                    return;
                }
            }

            javax.swing.JOptionPane.showMessageDialog(null, "Product not found");
        }//GEN-LAST:event_searchButtonActionPerformed

        private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
            int id = idField.getText().matches("^[0-9]+$") ? Integer.parseInt(idField.getText()) : 0;
            String name = nameField.getText();
            int contact = conField.getText().matches("^[0-9]+$") ? Integer.parseInt(conField.getText()) : 0;
            String email = emailField.getText();

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

            if (name.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "UPDATE: Please enter a valid name");
                return;
            }

            if (contact <= 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "UPDATE: Please enter a valid contact");
                return;
            }

            if (email.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "UPDATE: Please enter a valid email");
                return;
            }

            if (name.equals(model.getValueAt(row, 1)) && contact == (int) model.getValueAt(row, 2)
                    && email.equals(model.getValueAt(row, 3))) {
                return;
            }

            int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to update this product?",
                    "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

            if (confirm == javax.swing.JOptionPane.NO_OPTION) {
                jTable1.clearSelection();
                idField.setText("");
                nameField.setText("");
                conField.setText("");
                emailField.setText("");
                return;
            }

            model.setValueAt(name, row, 1);
            model.setValueAt(contact, row, 2);
            model.setValueAt(email, row, 3);
            RetailData.getCustomer(id).setName(name);
            RetailData.getCustomer(id).setContact(contact);
            RetailData.getCustomer(id).setEmail(email);

            jTable1.clearSelection();
            jTable1.addRowSelectionInterval(row, row);

            idField.setText("");
            nameField.setText("");
            conField.setText("");
            emailField.setText("");
        }//GEN-LAST:event_updateButtonActionPerformed

        private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
            int id = idField.getText().matches("^[0-9]+$") ? Integer.parseInt(idField.getText()) : 0;
            String name = nameField.getText();
            int contact = conField.getText().matches("^[0-9]+$") ? Integer.parseInt(conField.getText()) : 0;
            String email = emailField.getText();

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

            if (name.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "REMOVE: Please enter a valid name");
                return;
            }

            if (contact <= 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "REMOVE: Please enter a valid contact");
                return;
            }

            if (email.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "REMOVE: Please enter a valid email");
                return;
            }

            int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to remove this product?",
                    "Confirm", javax.swing.JOptionPane.YES_NO_OPTION);

            if (confirm == javax.swing.JOptionPane.NO_OPTION) {
                jTable1.clearSelection();
                idField.setText("");
                nameField.setText("");
                conField.setText("");
                emailField.setText("");
                return;
            }

            model.removeRow(row);
            RetailData.removeCustomer(id);

            idField.setText("");
            nameField.setText("");
            conField.setText("");
            emailField.setText("");
        }//GEN-LAST:event_removeButtonActionPerformed

    public javax.swing.GroupLayout getGroupLayout() {
        return productLayout;
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
        private javax.swing.JTextField conField;
        private javax.swing.JTextField emailField;
        private javax.swing.JTextField idField;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;
        private javax.swing.JTextField nameField;
        private javax.swing.JButton removeButton;
        private javax.swing.JButton searchButton;
        private javax.swing.JTextField searchField;
        private javax.swing.JButton updateButton;
        // End of variables declaration//GEN-END:variables
}
