package DChatUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DChatSocket.Connection;
import DChatSocket.DClient;
import DChatSocket.DServer;
import DChatUtilities.DNetWork;
import DChatUtilities.VoiceMessageHandler;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 *
 * @author K.SakthiMahendran
 */
public class MainUi extends javax.swing.JFrame {

    /**
     * Creates new form DChatMainUi
     */
    public MainUi() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        internalPanel = new javax.swing.JPanel();
        chatList = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        mainFrame = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        messageBox = new javax.swing.JTextField();
        sendBtn = new javax.swing.JButton();
        sendFileBtn = new javax.swing.JButton();
        sendVoiceMessageBtn = new javax.swing.JButton();
        dialBox = new javax.swing.JTextField();
        dialBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DChat");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);

        internalPanel.setBackground(new java.awt.Color(0, 204, 255));
        internalPanel.setToolTipText("");
        internalPanel.setName("MainFrame"); // NOI18N

        chatList.setBackground(new java.awt.Color(255, 0, 153));
        chatList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chatList.setToolTipText("I am your ChatList");
        chatList.setName("chatList"); // NOI18N

        mainPanel.setBackground(new java.awt.Color(255, 0, 102));

        chatArea.setColumns(20);
        chatArea.setRows(5);
        chatArea.setToolTipText("I am Your Chat Area");
        mainFrame.setViewportView(chatArea);

        messageBox.setToolTipText("Enter Your Message on Me");

        sendBtn.setText("send");
        sendBtn.setToolTipText("Click me to send message");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    sendMessageBtnActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        sendFileBtn.setText("Send File");
        sendFileBtn.setToolTipText("Click Me To Send A File");
        sendFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    sendFileBtnActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        sendVoiceMessageBtn.setText("Voice Message");
        sendVoiceMessageBtn.setToolTipText("Click Me To Send Voice Message");
        sendVoiceMessageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendVoiceMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(sendFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(123, 123, 123)
                                                .addComponent(sendVoiceMessageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                                .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28))
                                        .addComponent(messageBox, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(mainFrame, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mainFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(messageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sendVoiceMessageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sendFileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(116, 116, 116))
        );

        messageBox.getAccessibleContext().setAccessibleName("MessageBox");
        sendFileBtn.getAccessibleContext().setAccessibleName("SendFile");

        dialBox.setToolTipText("Enter The Dnumber To Be Dialed");

        dialBtn.setText("Dial");
        dialBtn.setToolTipText("Click Me To Dial");
        dialBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(internalPanel);
        internalPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(dialBox, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dialBtn))
                                        .addComponent(chatList))
                                .addGap(18, 18, 18)
                                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dialBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dialBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chatList, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        dialBtn.getAccessibleContext().setAccessibleDescription("Click Me To Dial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 791, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(internalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 548, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(internalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        internalPanel.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>

    private void sendMessageBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        //SendMessage
        var txt = messageBox.getText();
        messageBox.setText("");

        if(!txt.equals("")) {
            var message = "You: "+txt+"\n";
            connection.writeString(message);
            chatArea.append(message);
        }
    }

    private void sendFileBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        //SendFileButton
        var fileChooser = new JFileChooser();

        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.showOpenDialog(mainFrame);
        chatArea.append("You: Sending File "+fileChooser.getSelectedFile().getName()+"......."+"\n");
        connection.writeFile(fileChooser.getSelectedFile(), fileChooser.getName(), fileChooser.getName().split(".")[1]);
        chatArea.append("File Sent SuccessFully!");
    }

    private void dialBtnActionPerformed(java.awt.event.ActionEvent evt) {
        //Dial
        var dNumber = dialBox.getText();
        dialBox.setText("");

        JOptionPane.showMessageDialog(mainFrame, "Dialing To "+dNumber);

        this.connection = new DClient().dialTo(dNumber);

        chatList.add(new JPanel());
    }

    private void sendVoiceMessageActionPerformed(java.awt.event.ActionEvent evt) {
        //SendVoiceMessage
        JOptionPane.showMessageDialog(mainFrame, "Click Ok To send");
        new VoiceMessageHandler(connection).startAudioRecording();
    }

    /**
     * @param
     */
    public static void main() {
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
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                var m = new MainUi();
                m.startServer();
                try {
                    m.chatArea.setText("YourDNumber: "+DNetWork.getMyDNumber()+"\n");
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                m.setVisible(true);
                m.startMessaging();
                m.btnController();
            }
        });
    }
    private void startMessaging() {
        var messagingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (connection != null) {
                        try {
                            if(!connection.isFileData())
                                chatArea.append(connection.getFromDNumber()+": "+connection.readString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "MessagingThread");
        messagingThread.start();
    }

    private void startServer() {
        var serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    var s = new DServer().listenForCon();
                    connection = s;
                    while (true) {
                        chatArea.append(s.getFromDNumber()+": "+s.readString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, "ServerThread");
        serverThread.start();
    }

    private void btnController() {
        var btnControllerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(messageBox.getText().equals(""))
                        sendBtn.setEnabled(false);
                    else
                        sendBtn.setEnabled(true);

                    if (dialBox.getText().length() != 11)
                        dialBtn.setEnabled(false);
                    else
                        dialBtn.setEnabled(true);
                }
            }
        }, "BtnControllerThread");
        btnControllerThread.start();
    }

    // Variables declaration - do not modify
    private Connection connection;
    private javax.swing.JButton sendBtn;
    private javax.swing.JButton sendFileBtn;
    private javax.swing.JButton dialBtn;
    private javax.swing.JButton sendVoiceMessageBtn;
    private javax.swing.JPanel internalPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane chatList;
    private javax.swing.JScrollPane mainFrame;
    private javax.swing.JTextArea chatArea;
    private javax.swing.JTextField dialBox;
    private javax.swing.JTextField messageBox;
    // End of variables declaration
}
