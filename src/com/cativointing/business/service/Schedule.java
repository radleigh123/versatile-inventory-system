package com.cativointing.business.service;

import com.cativointing.userdata.CustomerData;
import com.cativointing.userdata.service.ServiceData;
import com.cativointing.userdata.service.schedule;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedule extends javax.swing.JPanel {

    private javax.swing.GroupLayout schedLayout;
    private javax.swing.table.DefaultTableModel model;
    private javax.swing.DefaultComboBoxModel nameModel;

    public Schedule() {
        initComponents();
        
        model = (javax.swing.table.DefaultTableModel) jTable1.getModel();

        for (schedule s : ServiceData.tempSchedules) {
            model.addRow(new Object[]{ s.getID(), s.getName(), s.getDate() });
        }
        
        setToCurrentDate();

        nameModel = (javax.swing.DefaultComboBoxModel) nameCombo.getModel();
        loadNames();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        rightPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        checkButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        statLabel = new javax.swing.JLabel();
        nameCombo = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Date"
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
                        String name = (String) jTable1.getValueAt(selectedRow, 1);
                        String date = (String) jTable1.getValueAt(selectedRow, 2);

                        System.out.println("Selected: " + id + ", "
                            + name+ ", "
                            + date + ", ");
                    }
                }
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        rightPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setText("Scheduler");

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        removeButton.setForeground(new java.awt.Color(204, 0, 0));
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        checkButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        checkButton.setText("Done");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(checkButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeButton)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Date:");

        dateField.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        dateField.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Status:");

        statLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        statLabel.setForeground(new java.awt.Color(0, 204, 0));
        statLabel.setText("Available");

        nameCombo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateField)
                            .addComponent(statLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(nameCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(statLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jCalendar1.addPropertyChangeListener("calendar", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("calendar")) {
                    updateLabels();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        schedLayout = layout;
    }// </editor-fold>//GEN-END:initComponents

    public void refresh() {
        nameModel.removeAllElements();
        loadNames();

        model.setRowCount(0);
        for (schedule s : ServiceData.tempSchedules) {
            model.addRow(new Object[]{ s.getID(), s.getName(), s.getDate() });
        }
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (ServiceData.getCUSTOMERS().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "ADD: No customers available");
            return;
        }
        
        int id = -1;
        String name = nameCombo.getSelectedItem().toString() != null ? nameCombo.getSelectedItem().toString() : "";
        String date = dateField.getText();

        for (CustomerData cd : ServiceData.getCUSTOMERS().values()) {
            if (cd.getName().equals(name)) {
                id = cd.getID();
                break;
            }
        }

        if (statLabel.getText().equals("Occupied")) {
            javax.swing.JOptionPane.showMessageDialog(null, "ADD: Date is already taken");
            return;
        }

        model.addRow(new Object[]{ id, name, date });
        // ServiceData.addSchedule(new schedule(id, name, date));
        ServiceData.tempSchedules.add(new schedule(id, name, date));
        updateLabels();

    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (ServiceData.getCUSTOMERS().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "REMOVE: Nothing to remove");
            return;
        }
        
        int id = -1;
        String name = nameCombo.getSelectedItem().toString();
        String date = dateField.getText();

        int row = jTable1.getSelectedRow();

        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "REMOVE: Use Check button to select a row");
            return;
        }

        model.removeRow(row);
        // ServiceData.removeSchedule(id);
        for (int i = 0; i < ServiceData.tempSchedules.size(); i++) {
            if (ServiceData.tempSchedules.get(i).getName().equals(name) && ServiceData.tempSchedules.get(i).getDate().equals(date)) {
                ServiceData.tempSchedules.remove(i);
                break;
            }
        }

    }//GEN-LAST:event_removeButtonActionPerformed

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        if (ServiceData.getCUSTOMERS().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "CHECK: No customers available");
            return;
        }

        int row = jTable1.getSelectedRow();

        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "CHECK: Select a row");
            return;
        }

        int dialogResult = javax.swing.JOptionPane.showConfirmDialog(null, "CHECK: Are you sure you want to record this schedule?", "Warning", javax.swing.JOptionPane.YES_NO_OPTION);

        if (dialogResult == javax.swing.JOptionPane.NO_OPTION) {
            jTable1.clearSelection();
            return;
        }

        int id = -1;
        String date = jTable1.getValueAt(row, 2).toString();
        String name = jTable1.getValueAt(row, 1).toString();
        schedule sched = null;

        for (schedule s : ServiceData.tempSchedules) {
            if (s.getDate().equals(date)) {
                id = s.getID();
                sched = s;
                break;
            }
        }

        model.removeRow(row);
        // ServiceData.removeSchedule(id);
        for (int i = 0; i < ServiceData.tempSchedules.size(); i++) {
            if (ServiceData.tempSchedules.get(i).getName().equals(name) && ServiceData.tempSchedules.get(i).getDate().equals(date)) {
                ServiceData.tempSchedules.remove(i);
                break;
            }
        }
        ServiceData.addDoneSchedule(sched);

        updateLabels();

    }//GEN-LAST:event_checkButtonActionPerformed

    private void updateLabels() {
        Date selectedDate = jCalendar1.getDate();

        // Format the date to display in the JTextField
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        
        String dateString = monthFormat.format(selectedDate) + " " + dayFormat.format(selectedDate) + " " + yearFormat.format(selectedDate);
        System.out.println("Date selected: " + dateString);

        dateField.setText(dateString);

        // change statLabel, if "Available" color green, if "Taken" color red
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 2).equals(dateString)) {
                statLabel.setText("Occupied");
                statLabel.setForeground(new java.awt.Color(255, 0, 0));
                return;
            } else {
                statLabel.setText("Available");
                statLabel.setForeground(new java.awt.Color(0, 204, 0));
            }
        }
    }

    private void loadNames() {
        for (CustomerData c : ServiceData.getCUSTOMERS().values()) {
            nameModel.addElement(c.getName());
        }
    }
    
    private void setToCurrentDate() {
        // set dateField to current date
        Date currentDate = new Date();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

        String dateString = monthFormat.format(currentDate) + " " + dayFormat.format(currentDate) + " " + yearFormat.format(currentDate);
        dateField.setText(dateString);
    }

    public javax.swing.GroupLayout getGroupLayout() {
        return schedLayout;
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
    private javax.swing.JButton checkButton;
    private javax.swing.JTextField dateField;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JComboBox<String> nameCombo;
    private javax.swing.JButton removeButton;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel statLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
