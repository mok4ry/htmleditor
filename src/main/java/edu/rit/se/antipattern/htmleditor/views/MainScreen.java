package edu.rit.se.antipattern.htmleditor.views;

import edu.rit.se.antipattern.htmleditor.controllers.MainController;

/**
 * The main screen for our program
 * @author Team Anti-Pattern
 */
public class MainScreen extends javax.swing.JFrame {
    private MainController c = null;
    private java.util.ArrayList<javax.swing.JTextArea> textAreas = null;
    private int numOfUntitledPagesOpened = 0;
    
    public static final int DEFAULT_FONT_SIZE = 14;
    public static final int CANCELED = 0;
    public static final int CONFIRMED = 1;
    public static final int DISCARD = 2;
    
    /**
     * Creates new form MainScreen
     */
    public MainScreen(MainController controller) {
        c = controller;
        textAreas = new java.util.ArrayList<javax.swing.JTextArea>();
        initComponents();
        newItemActionPerformed(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        fc = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        quitItem = new javax.swing.JMenuItem();
        newItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        insertItem = new javax.swing.JMenu();
        tagMenu = new javax.swing.JMenu();
        hTagItem = new javax.swing.JMenuItem();
        emTagItem = new javax.swing.JMenuItem();
        bTagItem = new javax.swing.JMenuItem();
        ulTagItem = new javax.swing.JMenuItem();
        tableTagItem = new javax.swing.JMenuItem();
        indentItem = new javax.swing.JMenuItem();
        cutItem = new javax.swing.JMenuItem();
        pasteItem = new javax.swing.JMenuItem();
        validateItem = new javax.swing.JMenuItem();
        prefItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setText("File");

        openItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openItem.setText("Open");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });
        fileMenu.add(openItem);

        saveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveItem);

        quitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        quitItem.setText("Quit");
        quitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitItemActionPerformed(evt);
            }
        });
        fileMenu.add(quitItem);

        newItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newItem.setText("New");
        newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });
        fileMenu.add(newItem);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");

        insertItem.setText("Insert");

        tagMenu.setText("Tag");

        hTagItem.setText("<h#>");
        hTagItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hTagItemActionPerformed(evt);
            }
        });
        tagMenu.add(hTagItem);

        emTagItem.setText("<em>");
        emTagItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emTagItemActionPerformed(evt);
            }
        });
        tagMenu.add(emTagItem);

        bTagItem.setText("<b>");
        bTagItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTagItemActionPerformed(evt);
            }
        });
        tagMenu.add(bTagItem);

        ulTagItem.setText("<ul>");
        ulTagItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ulTagItemActionPerformed(evt);
            }
        });
        tagMenu.add(ulTagItem);

        tableTagItem.setText("<table>");
        tableTagItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableTagItemActionPerformed(evt);
            }
        });
        tagMenu.add(tableTagItem);

        insertItem.add(tagMenu);

        editMenu.add(insertItem);

        indentItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        indentItem.setText("Indent");
        indentItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indentItemActionPerformed(evt);
            }
        });
        editMenu.add(indentItem);

        cutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutItem.setText("Cut");
        cutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutItemActionPerformed(evt);
            }
        });
        editMenu.add(cutItem);

        pasteItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteItem.setText("Paste");
        pasteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteItemActionPerformed(evt);
            }
        });
        editMenu.add(pasteItem);

        validateItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        validateItem.setText("Validate");
        validateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateItemActionPerformed(evt);
            }
        });
        editMenu.add(validateItem);

        prefItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        prefItem.setText("Auto-wrap");
        editMenu.add(prefItem);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
        int fcResult = fc.showOpenDialog(this);
        if ( fcResult == javax.swing.JFileChooser.APPROVE_OPTION ) {
            if ( c.createBuffer(fc.getSelectedFile()) ) {
                int index = textAreas.size();
                createAndSwitchToNewTab( index );
                if ( !c.validate(index) ) {
                    String errmsg = "The file %s contains badly-formed HTML";
                    String formattedMsg = String.format( errmsg, c.getBufferFilename(index) );
                    javax.swing.JOptionPane.showMessageDialog(this, formattedMsg);
                }
            }
        } else {
            // TODO: write to some error place that a new file could not be opened
        }
    }//GEN-LAST:event_openItemActionPerformed

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
        attemptSaveBuffer( jTabbedPane1.getSelectedIndex() );
    }//GEN-LAST:event_saveItemActionPerformed

    private void quitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitItemActionPerformed
        for ( int i = textAreas.size() - 1; i > -1; i-- ) {
            if ( attemptCloseBuffer(i) == CANCELED ) return;
        }
        System.exit(0);
    }//GEN-LAST:event_quitItemActionPerformed

    // TODO: rename these functions
    private int attemptCloseBuffer( int index ) {
        if ( c.bufferIsModified(index) ) {
            if ( discardChangesWarning() == CANCELED ) {
                removeBuffer(index);
                return CONFIRMED;
            }
        }
        c.setBufferText(index, textAreas.get(index).getText());
        return closeBuffer(index);
    }
    
    private int closeBuffer( int index ) {
        if ( attemptSaveBuffer(index) == CONFIRMED ) {
            removeBuffer(index);
            return CONFIRMED;
        } else return CANCELED;
    }
    
    private void removeBuffer( int index ) {
        if ( index == 0 ) setEditorMenuEnabled(false);
        jTabbedPane1.remove(index);
        c.removeBuffer(index);
        textAreas.remove(index);
    }
    
    private int attemptSaveBuffer( int index ) {
        c.setBufferText(index, textAreas.get(index).getText());
        if ( c.validate(index) ) {
            return saveBuffer(index);
        } else {
            if ( warnForValidation() == CONFIRMED ) {
                return saveBuffer(index);
            } else return CANCELED;
        }
    }
    
    private int saveBuffer( int index ) {
        if ( c.bufferIsNamed(index) ) {
            java.io.File outFile = new java.io.File(c.getBufferFilepath(index));
            return c.saveBuffer(index, outFile) ? CONFIRMED : CANCELED;
        } else {
            int result = fc.showSaveDialog(this);
            if ( result == javax.swing.JFileChooser.APPROVE_OPTION ) {
                return c.saveBuffer(index, fc.getSelectedFile()) ?
                        CONFIRMED : CANCELED;
            } else return CANCELED;
        }
    }
    
    private void newItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemActionPerformed
        if ( c.createBuffer( ++numOfUntitledPagesOpened ) ) {
            createAndSwitchToNewTab( textAreas.size() );
        } else {
            // TODO: write to some error place that a new file could not be opened
        }
    }//GEN-LAST:event_newItemActionPerformed

    private void createAndSwitchToNewTab( int index ) {
        setEditorMenuEnabled(true);
        textAreas.add(getNewTextArea(index));
        textAreas.get(index).setText( c.getBufferText(index) );
        jTabbedPane1.add(c.getBufferFilename(index), textAreas.get(index));
        jTabbedPane1.setSelectedIndex(index);
    }
    
    private javax.swing.JTextArea getNewTextArea( final int index ) {
        javax.swing.JTextArea jta = new javax.swing.JTextArea();
        java.awt.Font f = new java.awt.Font("Courier New", java.awt.Font.PLAIN,
                DEFAULT_FONT_SIZE);
        jta.setFont(f);
        jta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                int currentIndex = jTabbedPane1.getSelectedIndex();
                javax.swing.JTextArea j = textAreas.get(currentIndex);
                if (evt.getKeyChar() == '\n') {
                    c.setBufferText(currentIndex, j.getText());
                    int i = c.autoIndent(currentIndex, j.getCaretPosition());
                    j.setText(c.getBufferText(currentIndex));
                    j.setCaretPosition(i);
                }
                c.bufferModified(index);
            }
        });
        return jta;
    }
    
    private void hTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hTagItemActionPerformed
        updateCurrentBuffer();
        int index = jTabbedPane1.getSelectedIndex();
        HeaderPopup hp = new HeaderPopup(this,c,index,
                textAreas.get(index).getCaretPosition());
        hp.setVisible(true);
    }//GEN-LAST:event_hTagItemActionPerformed

    private void emTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emTagItemActionPerformed
        updateCurrentBuffer();
        int index = jTabbedPane1.getSelectedIndex();
        c.insert(index, "em");
        updateCurrentTextArea();
    }//GEN-LAST:event_emTagItemActionPerformed

    private void bTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTagItemActionPerformed
        updateCurrentBuffer();
        int index = getCurrentIndex();
        c.insert(index, "b");
        updateCurrentTextArea();
    }//GEN-LAST:event_bTagItemActionPerformed

    private void ulTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulTagItemActionPerformed
        updateCurrentBuffer();
        int index = getCurrentIndex();
        ULPopup temp = new ULPopup(this,c,index,
                textAreas.get(index).getCaretPosition());
        temp.setVisible(true);
    }//GEN-LAST:event_ulTagItemActionPerformed

    private void tableTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableTagItemActionPerformed
        updateCurrentBuffer();
        int index = getCurrentIndex();
        TablePopup temp = new TablePopup(this,c,index,
                textAreas.get(index).getCaretPosition());
        temp.setVisible(true);
    }//GEN-LAST:event_tableTagItemActionPerformed

    private void indentItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indentItemActionPerformed
        updateCurrentBuffer();
        int index = getCurrentIndex();
        javax.swing.JTextArea j = textAreas.get(index);
        int start = j.getSelectionStart();
        int end = j.getSelectionEnd()-1;
        c.indent(index, start, end);
        updateCurrentTextArea();
        j.setSelectionStart(start);
        j.setSelectionEnd(end);
    }//GEN-LAST:event_indentItemActionPerformed

    private void cutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutItemActionPerformed
        updateCurrentBuffer();
        // TODO: Implement this
        updateCurrentTextArea();
    }//GEN-LAST:event_cutItemActionPerformed

    private void pasteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteItemActionPerformed
        updateCurrentBuffer();
        // TODO: Implement this
        updateCurrentTextArea();
    }//GEN-LAST:event_pasteItemActionPerformed

    private void validateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateItemActionPerformed
        updateCurrentBuffer();
        String alertMsg = "Document is %svalid HTML";
        String result = c.validate(getCurrentIndex()) ? "" : "NOT ";
        String formattedAlertMsg = String.format(alertMsg, result);
        System.out.println( formattedAlertMsg );
        javax.swing.JOptionPane.showMessageDialog(getContentPane(), formattedAlertMsg);
    }//GEN-LAST:event_validateItemActionPerformed

    private int getCurrentIndex() {
        return jTabbedPane1.getSelectedIndex();
    }
    
    private void updateCurrentTextArea() {
        updateTextArea( jTabbedPane1.getSelectedIndex() );
    }
    
    private void updateTextArea( int index ) {
        textAreas.get(index).setText(c.getBufferText(index));
    }
    
    private void updateCurrentBuffer() {
        updateBuffer(jTabbedPane1.getSelectedIndex());
    }
    
    private void updateBuffer( int index ) {
        javax.swing.JTextArea jta = textAreas.get(index);
        c.setBufferText(index, jta.getText());
        c.setBufferCursorPosition( index,
                jta.getSelectionStart(), jta.getSelectionEnd() );
    }
    
    private void setEditorMenuEnabled( boolean onOrOff ) {
        editMenu.setEnabled(onOrOff);
    }
    
    private int warnForValidation() {
        String msg = "This file contains badly-formed HTML. Do you still want " +
                "to save it?";
        String[] choices = new String[2];
        choices[CONFIRMED] = "Save anyway";
        choices[CANCELED] = "Don't save";
        int r = javax.swing.JOptionPane.showOptionDialog( null, msg, "Uh oh!",
                javax.swing.JOptionPane.OK_CANCEL_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null, choices, choices[CONFIRMED] );
        return r;
    }
    
    private int discardChangesWarning() {
        String msg = "There are unsaved changes in the current document.  "
                + "Save changes?";
        String[] choices = new String[2];
        choices[CONFIRMED] = "Save";
        choices[CANCELED] = "Discard Changes";
        int r = javax.swing.JOptionPane.showOptionDialog( null, msg, "Uh oh!",
                javax.swing.JOptionPane.OK_CANCEL_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null, choices, choices[CONFIRMED] );
        return r;
    }
    
    public void updateText () {
        int index = jTabbedPane1.getSelectedIndex();
        textAreas.get(index).setText(c.getBufferText(index));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen(null).setVisible(true);
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bTagItem;
    private javax.swing.JMenuItem cutItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem emTagItem;
    private javax.swing.JFileChooser fc;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem hTagItem;
    private javax.swing.JMenuItem indentItem;
    private javax.swing.JMenu insertItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem newItem;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JMenuItem pasteItem;
    private javax.swing.JMenuItem prefItem;
    private javax.swing.JMenuItem quitItem;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JMenuItem tableTagItem;
    private javax.swing.JMenu tagMenu;
    private javax.swing.JMenuItem ulTagItem;
    private javax.swing.JMenuItem validateItem;
    // End of variables declaration//GEN-END:variables

}
