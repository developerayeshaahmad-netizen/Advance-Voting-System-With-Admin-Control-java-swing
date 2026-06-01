
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.ArrayList;

public class AdminService extends JFrame {

    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField partyField = new JTextField();

    private JButton logoutButton = new JButton("Logout");
    private JButton addButton = new JButton("Add Candidate");
    private JButton resultsButton = new JButton("Calculate Results");
    private JButton delete = new JButton("Remove Candidate"); // Original name 'delete'

    private JTextArea displayArea = new JTextArea();
    private JProgressBar progressBar = new JProgressBar(0, 100);

    public AdminService() {
        this.setTitle("Admin Dashboard - Manage Candidates");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 550);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        // ((JPanel) this.getContentPane()).setBorder(null);
        

        JPanel mainGroundPanel = new JPanel(){
 
            protected void paintComponent(Graphics g){
                super.paintComponent(g);

                ImageIcon image = new ImageIcon("online voting.png");
                Image img = image.getImage();
                g.drawImage(img, 0, 0,getWidth(),getHeight(),this);

                g.setColor(new Color(0,0,0,180));
                g.fillRect(0, 0, getWidth(), getHeight());
            }


        };

        mainGroundPanel.setLayout(new BorderLayout(10,10));
        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false); // Allows the mainGroundPanel background image to show through!
        inputPanel.setLayout(new GridLayout(5, 2, 8, 8));
       

        // Elegant Titled Border with White text lines
        TitledBorder inputBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE, 1),
                "Candidate Management");
        inputBorder.setTitleColor(Color.WHITE);
        inputBorder.setTitleFont(new Font("Arial", Font.BOLD, 12));
        inputPanel.setBorder(BorderFactory.createCompoundBorder(inputBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // --- 3. TEXT FIELDS: Color.BLACK background with Color.WHITE text ---
        Font textFont = new Font("Arial", Font.PLAIN, 14);

        idField.setBackground(new Color( 248, 248, 255));
        idField.setForeground(Color.BLACK);
        idField.setCaretColor(Color.BLACK);
        idField.setFont(textFont);
        idField.setFont(new Font("Arial", Font.PLAIN, 14));
        idField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));

        nameField.setBackground(new Color( 248, 248, 255));
        nameField.setForeground(Color.BLACK);
        nameField.setCaretColor(Color.BLACK);
        nameField.setFont(textFont);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        partyField.setBackground(new Color( 248, 248, 255));
        partyField.setForeground(Color.BLACK);
        partyField.setCaretColor(Color.BLACK);
        partyField.setFont(textFont);
        partyField.setFont(new Font("Arial", Font.PLAIN, 14));
        partyField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));

       
        Font btnFont = new Font("Arial", Font.BOLD, 13);

        logoutButton.setBackground(new Color( 248, 248, 255));
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFont(btnFont);
        logoutButton.setFocusPainted(false);
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButton.setBackground(new Color(130, 140, 150)); // Lighter gray on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButton.setBackground(new Color( 248, 248, 255)); // Original color when leaving
            }
        });
        addButton.setBackground(new Color( 248, 248, 255));
        addButton.setForeground(Color.BLACK);
        addButton.setFont(btnFont);
        addButton.setFocusPainted(false);
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButton.setBackground(new Color(130, 140, 150)); // Lighter gray on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButton.setBackground(new Color( 248, 248, 255)); // Original color when leaving
            }
        });
        resultsButton.setBackground(new Color( 248, 248, 255));
        resultsButton.setForeground(Color.BLACK);
        resultsButton.setFont(btnFont);
        resultsButton.setFocusPainted(false);
        resultsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resultsButton.setBackground(new Color(130, 140, 150)); // Lighter gray on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                resultsButton.setBackground(new Color( 248, 248, 255)); // Original color when leaving
            }
        });

        // Properly override the white background setting that was breaking things
        delete.setOpaque(true);
        delete.setBorderPainted(false);
        delete.setBackground(new Color( 248, 248, 255));
        delete.setForeground(Color.BLACK);
        delete.setFont(btnFont);
        delete.setFocusPainted(false);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete.setBackground(new Color(130, 140, 150)); // Lighter gray on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete.setBackground(new Color( 248, 248, 255)); // Original color when leaving
            }
        });

        // --- 5. GRID PLACEMENT: EXACT ORIGINAL SEQUENCE WITH WHITE LABELS ---
        // Row 1
        JLabel lblId = new JLabel("ID:");
        lblId.setForeground(Color.WHITE);
        inputPanel.add(lblId);
        inputPanel.add(idField);

        // Row 2
        JLabel lblName = new JLabel("Name:");
        lblName.setForeground(Color.WHITE);
        inputPanel.add(lblName);
        inputPanel.add(nameField);

        // Row 3
        JLabel lblParty = new JLabel("Party:");
        lblParty.setForeground(Color.WHITE);
       inputPanel.add(lblParty);
       inputPanel.add(partyField);

        // Row 4
        inputPanel.add(logoutButton);
        inputPanel.add(addButton);
        inputPanel.add(resultsButton);
        inputPanel.add(delete);

        mainGroundPanel.add(inputPanel , BorderLayout.NORTH);

        // JLabel lblAction = new JLabel("Action:");
        // lblAction.setForeground(Color.WHITE);
        // mainGroundPanel.add(lblAction);
        // mainGroundPanel.add(resultsButton);
        // mainGroundPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel lowerContainer = new JPanel();
        lowerContainer.setOpaque(false);
        lowerContainer.setLayout(new BorderLayout(5, 5));
        lowerContainer.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        // --- PROGRESS BAR DARK THEME STYLING ---

        progressBar.setBackground(Color.BLACK);
        progressBar.setForeground(new Color(0, 150, 255)); // Bright blue loading indicator line
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Arial", Font.BOLD, 11));
       
        // --- 6. JTEXTAREA LOGS: Color.BLACK Background with Color.WHITE Text ---
        displayArea.setBackground(new Color( 248, 248, 255));
        displayArea.setForeground(Color.BLACK);
        displayArea.setCaretColor(Color.BLACK);
        displayArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        displayArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        scrollPane.setPreferredSize(new Dimension(460, 250));
        // scrollPane.setBackground(new Color( 248, 248, 255));
lowerContainer.add(progressBar, BorderLayout.NORTH);
        lowerContainer.add(scrollPane, BorderLayout.SOUTH);

       mainGroundPanel.add(lowerContainer, BorderLayout.CENTER);


        this.add(mainGroundPanel , BorderLayout.CENTER);
        
refreshCandidateList();

        // --- Button Actions ---

        addButton.addActionListener(e -> {
            ArrayList<Candidate> candidates = Filehandler.loadCandidates();

            if (candidates == null) {
                candidates = new ArrayList<>(); // Safety check in case file is completely new
            }

            // 2. Extract values from input fields and trim spaces
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String party = partyField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || party.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Add by name and id! Fields cannot be blank.");
                return; // STOPS the execution right here
            }

            for (Candidate c : candidates) {
                if (c.getId().equals(idField.getText())) {
                    JOptionPane.showMessageDialog(this, "Error: Candidate ID already exists!");
                    return; // Stops the code from adding the duplicate
                }
            }
            // candidates.add(new Candidate(id, name, party, 0));

            candidates.add(new Candidate(idField.getText(), nameField.getText(), partyField.getText(), 0));

            Filehandler.saveCandidates(candidates);
            refreshCandidateList();

            idField.setText("");
            nameField.setText("");
            partyField.setText("");
            JOptionPane.showMessageDialog(this, "Candidate Added!");

        });

        // remove duplicate candidate
        delete.addActionListener(e -> {
            // 1. Ask the Admin which ID to delete
            String idToRemove = JOptionPane.showInputDialog(this, "Enter the Candidate ID to remove:");

            if (idToRemove == null || idToRemove.trim().isEmpty()) {
                return; // User cancelled or left it blank
            }

            // 2. Load the current list
            ArrayList<Candidate> allCandidates = Filehandler.loadCandidates();
            boolean found = false;

            // Find and remove the candidate

            found = allCandidates.removeIf(c -> c.getId().equals(idToRemove));

            if (found) {
                // 4. Save the new list (without the deleted candidate)
                Filehandler.saveCandidates(allCandidates);

                // 5. Update the UI text area
                refreshCandidateList();
                JOptionPane.showMessageDialog(this, "Candidate " + idToRemove + " removed successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Candidate ID not found.");
            }
        });

       

        // THE CALCULATION LOGIC
        resultsButton.addActionListener(e -> {

            calculateResults();
        });

        logoutButton.addActionListener(e -> {
            new Authframe();
            this.dispose();
        });

        this.setVisible(true);
    }

    private void calculateResults() {

        // Start a new thread so the UI doesn't freeze
        new Thread(() -> {

            ArrayList<Candidate> candidates = Filehandler.loadCandidates();

            // 2. CHECK FIRST: If the list is null or empty, stop immediately
            if (candidates == null || candidates.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: No candidates available to calculate results!");
                return; // STOPS the execution safely inside the thread
            }
            int totalVotesCast = 0;
            for (Candidate c : candidates) {
                totalVotesCast += c.getVoteCount();
            }

            if (totalVotesCast == 0) {
                JOptionPane.showMessageDialog(this, "No votes have been cast yet. Cannot calculate election winner!",
                        "Calculation Blocked", JOptionPane.WARNING_MESSAGE);
                return;
            }

            resultsButton.setEnabled(false); // Disable during calc
            for (int i = 0; i <= 100; i += 5) {
                try {
                    Thread.sleep(100); // 100ms * 20 steps = 2 seconds
                    final int currentProgress = i;
                    // Update progress bar on the Event Dispatch Thread
                    SwingUtilities.invokeLater(() -> progressBar.setValue(currentProgress));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            // Once finished, find the winner
            candidates = Filehandler.loadCandidates();
            if (candidates.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No candidates found!");
                resultsButton.setEnabled(true);
                return;
            }

            Candidate winner = candidates.get(0);
            StringBuilder tallies = new StringBuilder("--- Final Vote Counts ---\n");

            for (Candidate c : candidates) {
                tallies.append(c.getName()).append(" (").append(c.getParty()).append("): ")
                        .append(c.getVoteCount()).append(" votes\n");

                if (c.getVoteCount() > winner.getVoteCount()) {
                    winner = c;
                }
            }

            // Show Result
            String resultMsg = tallies.toString() + " THE WINNER IS: " + winner.getName().toUpperCase();
            JOptionPane.showMessageDialog(this, resultMsg, "Election Results", JOptionPane.INFORMATION_MESSAGE);

            resultsButton.setEnabled(true);
            progressBar.setValue(0); // Reset for next time
        }).start();
    }

    private void refreshCandidateList() {
        displayArea.setText("");
        ArrayList<Candidate> candidates = Filehandler.loadCandidates();
        for (Candidate c : candidates) {
            displayArea
                    .append("ID: " + c.getId() + " | Name: " + c.getName() +"|Party: " + c.getParty() + " | Votes: " + c.getVoteCount() + "\n");
        }
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    
}