/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.antipattern.htmleditor.views;

import edu.rit.se.antipattern.htmleditor.controllers.MainController;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Adam
 */
public class MainScreen extends javax.swing.JFrame {

    private static final int MAX_FILENAME_CHARS_LONG = 15;
    private static final int MAX_FILENAME_CHARS_SHORT = 8;
    private MainController c;
    private int currentTabButton, firstAvailableButton;
    
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        c = new MainController();
        currentTabButton = -1;
        firstAvailableButton = 0;
        initComponents();
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        jButton7.setVisible(false);
        jButton8.setVisible(false);
        jButton9.setVisible(false);
        jButton10.setVisible(false);
        if ( c.createBuffer() ) {
                createAndGoToNewTab("Untitled.html");
            } else {
                // TODO: Write error message to some designated error spot (bottom status bar?)
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        closeCurrentTabButton = new javax.swing.JButton();
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

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setMaximumSize(new java.awt.Dimension(500, 800));
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Courier", 0, 14)); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        closeCurrentTabButton.setText("X");
        closeCurrentTabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeCurrentTabButtonActionPerformed(evt);
            }
        });

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
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });

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

        indentItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, 0));
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

        prefItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, 0));
        prefItem.setText("Auto-wrap");
        prefItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prefItemActionPerformed(evt);
            }
        });
        editMenu.add(prefItem);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(closeCurrentTabButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeCurrentTabButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
        
        int returnVal = fc.showOpenDialog(jTextArea1);
        if ( returnVal == javax.swing.JFileChooser.APPROVE_OPTION ) {
            File openedFile = fc.getSelectedFile();
            if ( c.createBuffer(openedFile) ) {
                createAndGoToNewTab( openedFile.getName() );
            } else {
                // TODO: Write error message to some designated error spot (bottom status bar?)
            }
        }
    }//GEN-LAST:event_openItemActionPerformed
    
    private void createAndGoToNewTab( String filename ) {
        getButton(firstAvailableButton).setVisible(true);
        getButton(firstAvailableButton).setText(filename);
        currentTabButton = firstAvailableButton++;
        switchToCurrentTab();
    }
    
    private String truncateActive( String name ) {
        return truncateToLastNChars( name, MAX_FILENAME_CHARS_LONG );
    }
    
    private String truncateInactive( String name ) {
        return truncateToLastNChars( name, MAX_FILENAME_CHARS_SHORT );
    }
    
    private String truncateToLastNChars( String text, int n ) {
        if ( text.length() > n ) {
            return String.format("...%s", text.substring(text.length() - n + 3));
        } else return text;
    }
    
    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
        int returnVal = fc.showSaveDialog(jTextArea1);
        if ( returnVal == JFileChooser.APPROVE_OPTION ) {
            boolean valid = c.validate(currentTabButton);
            if ( valid || (!valid && warnForValidation() == 0) )
                if ( !c.saveBuffer(currentTabButton, fc.getSelectedFile() ) ) {
                    String msg = "File failed to save: %s";
                    String formatted = String.format(msg, fc.getSelectedFile().getName() );
                    javax.swing.JOptionPane.showMessageDialog(null, formatted );
                }
        }
    }//GEN-LAST:event_saveItemActionPerformed

    private void prefItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prefItemActionPerformed
        if(jTextArea1.getLineWrap()){
            jTextArea1.setLineWrap(false);
        }
        else{
            jTextArea1.setLineWrap(true);
        }
    }//GEN-LAST:event_prefItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switchToTab(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        switchToTab(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        switchToTab(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        switchToTab(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        switchToTab(4);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        switchToTab(5);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        switchToTab(6);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        switchToTab(7);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        switchToTab(8);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        switchToTab(9);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void switchToCurrentTab() {
        if ( currentTabButton > -1 )
            switchToTab( currentTabButton );
        else
            jTextArea1.setText("");
    }
    
    private void switchToTab( int index ) {
        System.out.println(String.format("Switching to tab: %d", index));
        if ( !getButton(index).isVisible() ) return;
        
        c.setBufferText(currentTabButton, c.getBufferText(currentTabButton));
        jTextArea1.setText( c.getBufferText(index) );
        currentTabButton = index;
    }
    
    private void pasteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pasteItemActionPerformed

    private void quitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quitItemActionPerformed

    private void emTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emTagItemActionPerformed
        c.insert(currentTabButton, "em", jTextArea1.getCaretPosition());
        jTextArea1.setText(c.getBufferText(currentTabButton));
    }//GEN-LAST:event_emTagItemActionPerformed

    private void bTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTagItemActionPerformed
        c.insert(currentTabButton, "b", jTextArea1.getCaretPosition());
        jTextArea1.setText(c.getBufferText(currentTabButton));
    }//GEN-LAST:event_bTagItemActionPerformed

    private void ulTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ulTagItemActionPerformed
        ULPopup temp = new ULPopup(this,c,currentTabButton,jTextArea1.getCaretPosition());
        temp.setVisible(true);
    }//GEN-LAST:event_ulTagItemActionPerformed

    private void cutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cutItemActionPerformed

    private void closeCurrentTabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeCurrentTabButtonActionPerformed
        if ( currentTabButton != -1 && c.bufferIsModified(currentTabButton) ) {
            int result = fc.showSaveDialog(jTextArea1);
            if ( result == JFileChooser.APPROVE_OPTION ) {
                boolean valid = c.validate(currentTabButton);
                if ( valid || (!valid && warnForValidation() == 0) ) {
                    if ( c.saveBuffer(currentTabButton, fc.getSelectedFile() ) ) {
                        closeCurrentTab();
                    } else {
                        String msg = "Failed to save file: %s";
                        String formatted = String.format(msg, fc.getSelectedFile().getName());
                        javax.swing.JOptionPane.showMessageDialog(null, formatted);
                    }
                }
            }
        } else {
            closeCurrentTab();
        }
    }//GEN-LAST:event_closeCurrentTabButtonActionPerformed

    private int warnForValidation() {
        String msg = "This file contains badly-formed HTML. Do you still want " +
                "to save it?";
        String[] choices = { "Save anyway", "Abort mission" };
        int r = javax.swing.JOptionPane.showOptionDialog( null, msg, "Uh oh!",
                javax.swing.JOptionPane.OK_CANCEL_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE, null, choices, choices[0] );
        return r;
    }
    
    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        System.out.println( "This is working." );
        c.bufferModified(currentTabButton);
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void validateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateItemActionPerformed
        System.out.println( "Getting here." );
        String alertMsg = "Document is %svalid HTML";
        
        updateCurrentBuffer();
        String result = c.validate(currentTabButton) ? "" : "NOT ";
        String formattedAlertMsg = String.format(alertMsg, result);
        System.out.println( formattedAlertMsg );
        javax.swing.JOptionPane.showMessageDialog(getContentPane(), formattedAlertMsg);
    }//GEN-LAST:event_validateItemActionPerformed

    private void updateCurrentBuffer() {
        c.setBufferText(currentTabButton, jTextArea1.getText());
    }
    
    private void hTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hTagItemActionPerformed
        HeaderPopup hp = new HeaderPopup(this,c,currentTabButton,jTextArea1.getCaretPosition());
        hp.setVisible(true);
    }//GEN-LAST:event_hTagItemActionPerformed

    private void tableTagItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableTagItemActionPerformed
        TablePopup temp = new TablePopup(this,c,currentTabButton,jTextArea1.getCaretPosition());
        temp.setVisible(true);
    }//GEN-LAST:event_tableTagItemActionPerformed

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMenuActionPerformed

    private void indentItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indentItemActionPerformed
        c.indent(currentTabButton, jTextArea1.getSelectionStart(), jTextArea1.getSelectionEnd());
        jTextArea1.setText(c.getBufferText(currentTabButton));
    }//GEN-LAST:event_indentItemActionPerformed

    private void newItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemActionPerformed
            if ( c.createBuffer() ) {
                createAndGoToNewTab("Untitled.html");
            } else {
                // TODO: Write error message to some designated error spot (bottom status bar?)
            }
    }//GEN-LAST:event_newItemActionPerformed

    private void closeCurrentTab() {
        System.out.println(String.format("firstAvailableButton: %d", firstAvailableButton));
        System.out.println( String.format( "currentTabButton: %d", currentTabButton ));
        if ( firstAvailableButton != 0 && c.removeBuffer(currentTabButton) ) {
            getButton(firstAvailableButton - 1).setVisible(false);
            changeActiveButtonTabClosed(currentTabButton);
        }
    }
    
    private void changeActiveButtonTabClosed( int index ) {
        if ( currentTabButton == --firstAvailableButton ) currentTabButton--;
        shiftButtonsDownStartingWith(index);
        switchToCurrentTab();
    }
    
    private void shiftButtonsDownStartingWith( int index ) {
        while( index < c.MAX_NUM_TABS - 1 ) {
            getButton(index).setText(getButton(index+1).getText());
            index++;
        }
    }
    
    public void updateText () {
        jTextArea1.setText(c.getBufferText(currentTabButton));
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
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
                new MainScreen().setVisible(true);
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bTagItem;
    private javax.swing.JButton closeCurrentTabButton;
    private javax.swing.JMenuItem cutItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem emTagItem;
    private javax.swing.JFileChooser fc;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem hTagItem;
    private javax.swing.JMenuItem indentItem;
    private javax.swing.JMenu insertItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
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
    
    private javax.swing.JButton getButton( int index ) {
        switch (index) {
            case 0:
                return jButton1;
            case 1:
                return jButton2;
            case 2:
                return jButton3;
            case 3:
                return jButton4;
            case 4:
                return jButton5;
            case 5:
                return jButton6;
            case 6:
                return jButton7;
            case 7:
                return jButton8;
            case 8:
                return jButton9;
            case 9:
                return jButton10;
            default:
                return null;
        }
    }
    
}
