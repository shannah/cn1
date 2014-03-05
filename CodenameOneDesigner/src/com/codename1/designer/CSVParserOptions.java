/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *  
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Please contact Codename One through http://www.codenameone.com/ if you 
 * need additional information or have any questions.
 */

package com.codename1.designer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Shai Almog
 */
public class CSVParserOptions extends javax.swing.JDialog {
    private boolean canceled;
    
    /** Creates new form CSVParserOptions */
    public CSVParserOptions(java.awt.Component parent) {
        super((JFrame)SwingUtilities.windowForComponent(parent), true);
        initComponents();
        ModifiableJOptionPane.reverseOKCancel(ok, cancel);       
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public boolean isCanceled() {
        return canceled;
    }
    
    public String getEncoding() {
        return (String)encoding.getSelectedItem();
    }
    
    public char getDelimiter() {
        return ((String)delimiter.getSelectedItem()).charAt(0);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        delimiter = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        encoding = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ok = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Import CSV");
        setModal(true);

        jLabel1.setText("Delimiter Character");

        delimiter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ";", ",", ":" }));

        jLabel2.setText("Encoding");

        encoding.setEditable(true);
        encoding.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UTF-8", "Cp858", "IBM437", "Cp437", "IBM775", "Cp775", "IBM850", "Cp850", "IBM852", "Cp852", "IBM855", "Cp855", "IBM857", "Cp857", "IBM862", "Cp862", "IBM866", "Cp866", "ISO-8859-1", "ISO8859_1", "ISO-8859-2", "ISO8859_2", "ISO-8859-4", "ISO8859_4", "ISO-8859-5", "ISO8859_5", "ISO-8859-7", "ISO8859_7", "ISO-8859-9", "ISO8859_9", "ISO-8859-13", "ISO8859_13", "ISO-8859-15", "ISO8859_15", "KOI8-R", "KOI8_R", "KOI8-U", "KOI8_U", "US-ASCII", "ASCII", "UTF8", "UTF-16", "UTF-16", "UTF-16BE", "UnicodeBigUnmarked", "UTF-16LE", "UnicodeLittleUnmarked", "UTF-32", "UTF_32", "UTF-32BE", "UTF_32BE", "UTF-32LE", "UTF_32LE", "x-UTF-32BE-BOM", "UTF_32BE_BOM", "x-UTF-32LE-BOM", "UTF_32LE_BOM", "windows-1250", "Cp1250", "windows-1251", "Cp1251", "windows-1252", "Cp1252", "windows-1253", "Cp1253", "windows-1254", "Cp1254", "windows-1257", "Cp1257", "UnicodeBig", "x-IBM737", "Cp737", "x-IBM874", "Cp874", "x-UTF-16LE-BOM" }));

        jPanel2.setLayout(new java.awt.GridLayout());

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        jPanel2.add(ok);

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel);

        jPanel1.add(jPanel2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(encoding, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(delimiter, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(delimiter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(encoding, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        dispose();
    }//GEN-LAST:event_okActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        canceled = true;
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox delimiter;
    private javax.swing.JComboBox encoding;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton ok;
    // End of variables declaration//GEN-END:variables

}
