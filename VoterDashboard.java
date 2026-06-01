import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VoterDashboard extends JFrame {
    private JComboBox<String> candidateBox = new JComboBox<>();
    private JButton voteBtn = new JButton("Cast Vote");
    private JLabel statusLabel = new JLabel("Please select a candidate");
    private User currentUser;

    public VoterDashboard(User user) {
        this.currentUser = user;
        this.setTitle("Voter DashBoard - " + user.getName());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(450, 250); 
        JPanel mainBackgroundPanel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon("online voting.png"); 
        Image img = imageIcon.getImage();
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        
        // Dark tint layer overlay so text remains readable
        g.setColor(new Color(0, 0, 0, 195)); 
        g.fillRect(0, 0, getWidth(), getHeight());
    }
};
        
        mainBackgroundPanel.setOpaque(true);
        SpringLayout layout = new SpringLayout();
        mainBackgroundPanel.setLayout(layout);
        this.setContentPane(mainBackgroundPanel);
        
        

        // --- 2. LOAD CANDIDATES ---
        ArrayList<Candidate> candidates = Filehandler.loadCandidates();
        if (candidates != null) {
            for (Candidate c : candidates) {
                candidateBox.addItem(c.getName() + " (" + c.getParty() + ")");
            }
        }

        // --- 3. APPLY STYLING CODES  ---
        JLabel promptLabel = new JLabel("Select Candidate:");
        promptLabel.setForeground(Color.WHITE);
        promptLabel.setFont(new Font("Arial", Font.BOLD, 14));
        promptLabel.setOpaque(false);

        candidateBox.setBackground(Color.WHITE);
        candidateBox.setForeground(Color.BLACK);
        candidateBox.setFont(new Font("Arial", Font.PLAIN, 14));

        voteBtn.setBackground(new Color( 248, 248, 255)); 
        voteBtn.setForeground(Color.BLACK);
        voteBtn.setFont(new Font("Arial", Font.BOLD, 14));
        voteBtn.setFocusPainted(false);
        voteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (voteBtn.isEnabled()) {
                    voteBtn.setBackground(new Color(100, 110, 120)); 
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (voteBtn.isEnabled()) {
                    voteBtn.setBackground(new Color( 248, 248, 255)); 
                }
            }
        });

       
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        statusLabel.setOpaque(false);

        // Add components to container
        mainBackgroundPanel.add(promptLabel);
        mainBackgroundPanel.add(candidateBox);
        mainBackgroundPanel.add(voteBtn);
        mainBackgroundPanel.add(statusLabel);

        // --- 4. SPRING LAYOUT CONSTRAINTS (Position Mapping) ---
        
        // Position Prompt Label (Top Left)
        layout.putConstraint(SpringLayout.WEST, promptLabel, 25, SpringLayout.WEST, mainBackgroundPanel);
        layout.putConstraint(SpringLayout.NORTH, promptLabel, 40, SpringLayout.NORTH, mainBackgroundPanel);

        // Position Dropdown (Right side of the Prompt Label)
        layout.putConstraint(SpringLayout.WEST, candidateBox, 15, SpringLayout.EAST, promptLabel);
        layout.putConstraint(SpringLayout.NORTH, candidateBox, 38, SpringLayout.NORTH, mainBackgroundPanel);
        layout.putConstraint(SpringLayout.EAST, candidateBox, -25, SpringLayout.EAST, mainBackgroundPanel);

        // Position Cast Vote Button (Centered horizontally, below the dropdown area)
        layout.putConstraint(SpringLayout.WEST, voteBtn, 150, SpringLayout.WEST, mainBackgroundPanel);
        layout.putConstraint(SpringLayout.EAST, voteBtn, -150, SpringLayout.EAST, mainBackgroundPanel);
        layout.putConstraint(SpringLayout.NORTH, voteBtn, 40, SpringLayout.SOUTH, candidateBox);

        // Position Status Message Label (Centered smoothly near the bottom)
        layout.putConstraint(SpringLayout.WEST, statusLabel, 25, SpringLayout.WEST, mainBackgroundPanel);
        layout.putConstraint(SpringLayout.EAST, statusLabel, -25, SpringLayout.EAST, mainBackgroundPanel);
        layout.putConstraint(SpringLayout.NORTH, statusLabel, 30, SpringLayout.SOUTH, voteBtn);

        // --- 5. CHECK IF USER ALREADY VOTED ---
        if (user.gethasVoted()) {
            voteBtn.setEnabled(false);
            statusLabel.setText("You have already cast your vote!");
            statusLabel.setForeground(Color.RED); // Highlight the restriction text clearly
        }

        // --- 6. VOTE ACTION LISTENER ---
        voteBtn.addActionListener(e -> {
            int selectindex = candidateBox.getSelectedIndex();

            if (selectindex != -1) {
                ArrayList<Candidate> allCandidates = Filehandler.loadCandidates();
                Candidate selected = allCandidates.get(selectindex);
                selected.addvote(); 
                Filehandler.saveCandidates(allCandidates);

                ArrayList<User> allUsers = Filehandler.loadUsers();
                for (User u : allUsers) {
                    if (u.getId().equals(currentUser.getId())) {
                        u.sethasVoted(true);
                        break;
                    }
                }
                Filehandler.saveUsers(allUsers);

                currentUser.sethasVoted(true);

                JOptionPane.showMessageDialog(this, "Vote cast successfully for " + selected.getName());
                voteBtn.setEnabled(false);
                statusLabel.setText("Vote Successful!");
                this.dispose();
            }
        });

        this.setLocationRelativeTo(null); 
        this.setResizable(false);
        this.setVisible(true);
    }
}




