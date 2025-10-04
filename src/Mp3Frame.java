import java.awt.CardLayout;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.DefaultListModel;
import java.util.Collections;
import java.awt.Color;

/**
 * This class was partially created with the NetBeans IDE.
 * GUI components were added and edited in the NetBeans Swing interface.
 * @author ryandielhenn
 */
public class Mp3Frame extends javax.swing.JFrame {
    private static final Color BG_1 = new Color(43, 51, 57);       // #2b3339 - main background
    private static final Color BG_2 = new Color(57, 66, 72);       // Slightly lighter for buttons/inputs
    private static final Color FG = new Color(211, 198, 170);      // #d3c6aa - text
    private static final Color GREEN = new Color(167, 192, 128);   // #a7c080 - accent
    private static final String UI_FONT = "Fira Code Nerd Font";
    /**
     * Creates new form Mp3Frame
     */
    public Mp3Frame() {
        initComponents();
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                stop();
                System.exit(0);
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {
        // Initialize components
        mainPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        absPathSubmit = new javax.swing.JButton();
        absPathTextField = new javax.swing.JTextField();
        panelTwo = new javax.swing.JPanel();
        artistBtn = new javax.swing.JButton();
        songBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panelThree = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        songListPane = new javax.swing.JList<>();
        playBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        menuBtn = new javax.swing.JButton();
        
        // Window settings
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(BG_1);
        
        // Main panel setup
        mainPanel.setLayout(new java.awt.CardLayout());
        
        // ===== MENU PANEL =====
        setupMenuPanel();
        
        // ===== SORT PANEL =====
        setupSortPanel();
        
        // ===== PLAYLIST PANEL =====
        setupPlaylistPanel();
        
        // ===== MENU BUTTON =====
        setupMenuButton();
        
        // ===== MAIN LAYOUT =====
        setupMainLayout();
        
        pack();
    }

    private void setupMenuPanel() {
        menuPanel.setBackground(BG_1);
        
        jLabel1.setFont(new java.awt.Font(UI_FONT, 0, 22));
        jLabel1.setForeground(GREEN);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MP3 Player");
        
        absPathSubmit.setText("Search");
        absPathSubmit.setBackground(BG_2);
        absPathSubmit.setForeground(FG);
        absPathSubmit.setFont(new java.awt.Font(UI_FONT, 0, 13));
        absPathSubmit.addActionListener(evt -> absPathSubmitActionPerformed(evt));
        
        absPathTextField.setText(currentPath);
        absPathTextField.setBackground(BG_2);
        absPathTextField.setForeground(FG);
        absPathTextField.setFont(new java.awt.Font(UI_FONT, 0, 13));
        
        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(absPathSubmit))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(absPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(absPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(absPathSubmit)
                .addGap(50, 50, 50))
        );
        
        mainPanel.add(menuPanel, "menuPanel");
    }

    private void setupSortPanel() {
        panelTwo.setBackground(BG_1);
        
        artistBtn.setText("Artists");
        artistBtn.setFont(new java.awt.Font(UI_FONT, 0, 13));
        artistBtn.setBackground(BG_2);
        artistBtn.setForeground(FG);
        artistBtn.addActionListener(evt -> artistBtnActionPerformed(evt));
        
        songBtn.setText("Songs");
        songBtn.setFont(new java.awt.Font(UI_FONT, 0, 13));
        songBtn.setBackground(BG_2);
        songBtn.setForeground(FG);
        songBtn.addActionListener(evt -> songBtnActionPerformed(evt));
        
        jLabel2.setFont(new java.awt.Font(UI_FONT, 0, 18));
        jLabel2.setForeground(FG);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sort By...");
        
        javax.swing.GroupLayout panelTwoLayout = new javax.swing.GroupLayout(panelTwo);
        panelTwo.setLayout(panelTwoLayout);
        panelTwoLayout.setHorizontalGroup(
            panelTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTwoLayout.createSequentialGroup()
                .addGroup(panelTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTwoLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(artistBtn)
                        .addGap(60, 60, 60)
                        .addComponent(songBtn))
                    .addGroup(panelTwoLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        panelTwoLayout.setVerticalGroup(
            panelTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTwoLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(panelTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistBtn)
                    .addComponent(songBtn))
                .addGap(75, 75, 75))
        );
        
        mainPanel.add(panelTwo, "panelTwo");
    }

    private void setupPlaylistPanel() {
        panelThree.setBackground(BG_1);
        
        songListPane.setBackground(BG_2);
        songListPane.setForeground(FG);
        songListPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                songListPaneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(songListPane);
        
        playBtn.setText("Play");
        playBtn.setFont(new java.awt.Font(UI_FONT, 0, 13));
        playBtn.setBackground(BG_1);
        playBtn.setForeground(FG);
        playBtn.addActionListener(evt -> playBtnActionPerformed(evt));
        
        stopBtn.setText("Stop");
        stopBtn.setFont(new java.awt.Font(UI_FONT, 0, 13));
        stopBtn.setBackground(BG_1);
        stopBtn.setForeground(FG);
        stopBtn.addActionListener(evt -> stopBtnActionPerformed(evt));
        
        javax.swing.GroupLayout panelThreeLayout = new javax.swing.GroupLayout(panelThree);
        panelThree.setLayout(panelThreeLayout);
        panelThreeLayout.setHorizontalGroup(
            panelThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThreeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panelThreeLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(playBtn)
                .addGap(87, 87, 87)
                .addComponent(stopBtn)
                .addGap(84, 84, 84))
        );
        panelThreeLayout.setVerticalGroup(
            panelThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThreeLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(panelThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playBtn)
                    .addComponent(stopBtn))
                .addGap(24, 24, 24))
        );
        
        mainPanel.add(panelThree, "panelThree");
    }

    private void setupMenuButton() {
        menuBtn.setText("Menu");
        menuBtn.setFont(new java.awt.Font(UI_FONT, 0, 13));
        menuBtn.setBackground(BG_1);
        menuBtn.setForeground(FG);
        menuBtn.addActionListener(evt -> menuBtnActionPerformed(evt));
    }

    private void setupMainLayout() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(menuBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menuBtn)
                .addGap(14, 14, 14))
        );
    }
    /**
     * Method to handle user pressing the Submit button
    */
    private void absPathSubmitActionPerformed(java.awt.event.ActionEvent evt) {                                              

        //create a file object from the user inputed string and see if it exists, if it doesn't, do nothing
        File absPath = new File(absPathTextField.getText());
        if (absPath.exists()){
            try{
                //build a song list by recursing through inputed directory
                songList = Recurse.findFiles(absPath.getAbsolutePath());
                //show next panel
                CardLayout card = (CardLayout)mainPanel.getLayout();
                card.show(mainPanel, "panelTwo");
            }catch (FileNotFoundException fnf){
                System.out.println(fnf.getStackTrace());
            }
        }

    }  

    /**
     * Method to handle user pressing the Menu button
    */
    private void menuBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        //show the menu panel
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "menuPanel");
    } 

    /**
     * Method to handle user pressing the Song button
    */
    private void songBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        

        //sort the songList by song name
        Collections.sort(songList, new SortBySong());

        //create a new deafult list model that will populate the Jlist
        model = new DefaultListModel<>();

        //add the items in the songList to the model
        for (MP3File f : songList) {
            model.addElement(f.toString());
        }

        //populate Jlist
        songListPane.setModel(model);

        //show next panel
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "panelThree");
    }                                       


    /**
     * Method to handle user pressing the Artists button
    */
    private void artistBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          

        //sort the songList by artist name
        Collections.sort(songList, new SortByArtist());

        //create a new deafult list model that will populate the Jlist
        model = new DefaultListModel<>();

        //add the items in the songList to the model
        for (MP3File f : songList) {
            model.addElement(f.toString());
        }

        //populate Jlist
        songListPane.setModel(model);

        //show next panel
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "panelThree");
    }                                         

    /**
     * Method to handle user pressing the Play button
    */
    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) { 
        stop();                                  
        playSong();
    }    

    private void songListPaneMouseClicked(java.awt.event.MouseEvent evt) { 
        if (evt.getClickCount() == 2) {
            stop();
            playSong();
        }  
    }         


    // Add this as a class field at the top with your other variables
    private java.lang.Process currentProcess = null;

    // Your playSong method
    private void playSong() {  
        stop();

        index = songListPane.getSelectedIndex();
        
        if (index == -1) {
            System.out.println("No song selected");
            return;
        }
        
        Thread t = new Thread() {
            public void run() {
                isRunning = true;
                
                while (isRunning && index < songList.size()){
                    try { 
                        MP3File fileAtIndex = songList.get(index);
                        String path = fileAtIndex.getAbsPath();
                        
                        System.out.println("Playing: " + path);
                        
                        // Use mpg123 to play the file
                        ProcessBuilder pb = new ProcessBuilder("mpg123", "-q", path);
                        currentProcess = pb.start();
                        
                        // Wait for the process to finish
                        int exitCode = currentProcess.waitFor();
                        System.out.println("Finished playing (exit code: " + exitCode + ")");
                        
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    
                    if (isRunning) {
                        index++;
                    }
                }
            }
        };
        t.start();         
    }

    /**
    * Method to handle user pressing the Stop button
    */
    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {
        stop();
    }

    // Updated stop method
    private void stop() {
        isRunning = false;
        if (currentProcess != null && currentProcess.isAlive()) {
            currentProcess.destroy();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        if (args.length == 1) {
        	currentPath = args[0];
        }else {
        	currentPath = System.getProperty("user.home") + "/Music";
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mp3Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mp3Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mp3Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mp3Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mp3Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private int index;
    private boolean isRunning;
    private DefaultListModel<String> model;
    private ArrayList<MP3File> songList;
    private static String currentPath;                     
    private javax.swing.JButton absPathSubmit;
    private javax.swing.JTextField absPathTextField;
    private javax.swing.JButton artistBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton menuBtn;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel panelThree;
    private javax.swing.JPanel panelTwo;
    private javax.swing.JButton playBtn;
    private javax.swing.JButton songBtn;
    private javax.swing.JList<String> songListPane;
    private javax.swing.JButton stopBtn;
    // End of variables declaration                   
}
