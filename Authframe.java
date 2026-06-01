import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Authframe extends JFrame {
    private JTextField idField = new JTextField(15);
    private JPasswordField passField = new JPasswordField(15);
    private JButton logBtn = new JButton("LOGIN");
    private JButton regBtn = new JButton("Registration");
    JButton forgotBtn = new JButton("Forgot Credentials?");
    JLabel name = new JLabel("Name:");
    JLabel Password = new JLabel("Pasword:");
    JLabel forgot = new JLabel("Help:");
    JLabel Role = new JLabel("Role:");
    String[] role = { "Admin", "Voter" };
    private JComboBox roleCheck = new JComboBox(role);

    public Authframe() {

        this.setTitle("Online Voting System : Reduce the chaotic process of manual voting system");
        this.setSize(450, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel mainBackgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draws your specific election image verbatim
                ImageIcon imageIcon = new ImageIcon("online voting.png");
                Image img = imageIcon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                
                // Dark tint layer overlay so your input boxes and labels pop out sharply
                g.setColor(new Color(0, 0, 0, 180)); 
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainBackgroundPanel.setLayout(new GridLayout(5, 2, 15, 15));
        mainBackgroundPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        this.setContentPane(mainBackgroundPanel);
        

        // 2. LABELS: Transparent background, sharp White text
        name.setOpaque(false);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Arial", Font.BOLD, 16));

        Password.setOpaque(false);
        Password.setForeground(Color.WHITE);
        Password.setFont(new Font("Arial", Font.BOLD, 16));

        forgot.setOpaque(false);
        forgot.setForeground(Color.WHITE);
        forgot.setFont(new Font("Arial", Font.BOLD, 16));

        Role.setOpaque(false);
        Role.setForeground(Color.WHITE);
        Role.setFont(new Font("Arial", Font.BOLD, 16));

        // 3. TEXT FIELDS: Black background, White typing/caret color
        idField.setBackground(new Color( 248, 248, 255));
        idField.setForeground(Color.BLACK);
        idField.setCaretColor(Color.BLACK); // Ensures the flashing text cursor is also visible
        idField.setFont(new Font("Arial", Font.PLAIN, 14));
        idField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));

        passField.setBackground(new Color( 248, 248, 255));
        passField.setForeground(Color.BLACK);
        passField.setCaretColor(Color.BLACK);
        passField.setFont(new Font("Arial", Font.PLAIN, 14));
        passField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));

        // 4. BUTTONS: Classic Muted Gray background, Bold White text
        logBtn.setBackground(new Color( 248, 248, 255)); 
        logBtn.setForeground(Color.BLACK);
        logBtn.setFont(new Font("Arial", Font.BOLD, 14));
        logBtn.setFocusPainted(false);
        logBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logBtn.setBackground(new Color(130, 140, 150)); // Lighter gray on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                logBtn.setBackground(new Color( 248, 248, 255)); // Original color when leaving
            }
        });

        regBtn.setBackground(new Color( 248, 248, 255));
        regBtn.setForeground(Color.BLACK);
        regBtn.setFont(new Font("Arial", Font.BOLD, 14));
        regBtn.setFocusPainted(false);
         regBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regBtn.setBackground(new Color(130, 140, 150)); 
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                regBtn.setBackground(new Color( 248, 248, 255)); // Original color when leaving
            }
        });

        forgotBtn.setBackground(new Color( 248, 248, 255));
        forgotBtn.setForeground(Color.BLACK);
        forgotBtn.setFont(new Font("Arial", Font.BOLD, 12));
        forgotBtn.setFocusPainted(false);
         forgotBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotBtn.setBackground(new Color(130, 140, 150)); 
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotBtn.setBackground(new Color( 248, 248, 255)); // Original color when leaving
            }
        });

        roleCheck.setBackground(new Color( 248, 248, 255));
        roleCheck.setForeground(Color.BLACK);
        roleCheck.setFont(new Font("Arial", Font.PLAIN, 14));
        roleCheck.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        roleCheck.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // UI Components
        add(name);
        add(idField);
        add(Password);
        add(passField);
         add(Role);
        add(roleCheck);
        add(logBtn);
        add(regBtn);
        add(forgot);
        add(forgotBtn);
       

        // --- LOGIN LOGIC ---
        logBtn.addActionListener(e -> {
            try {
                ArrayList<User> users = Filehandler.loadUsers();
                String id = idField.getText();
                String pass = new String(passField.getPassword());
                boolean found = false;

                if (users == null || users.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No users registered yet!");
                    return;
                }

                for (User u : users) {
                    if (u.getId().equals(id) && u.getPasword().equals(pass)) {
                        found = true;

                        // Check role and open appropriate window
                        if (u.getRoll().equalsIgnoreCase("admin")) {
                            new AdminService();
                        } else {
                            new VoterDashboard(u);
                        }

                        this.dispose(); // Close login window
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(this, "Invalid ID or Password!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error during login: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // --- REGISTRATION LOGIC ---
        regBtn.addActionListener(e -> {
            try {
                ArrayList<User> users = Filehandler.loadUsers();
                String id = idField.getText();
                String pass = new String(passField.getPassword());

                if (id.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all fields!");
                    return;
                }

                if (pass.length() != 7) {
                    JOptionPane.showMessageDialog(this, "Password must be exactly 7 characters long!");
                    return;
                }
                if (!pass.contains("@") && !pass.contains("&") && !pass.contains("#") && !pass.contains("$")) {
                    JOptionPane.showMessageDialog(this,
                            "Password must contain at least one special character (e.g., @, &, #, $)");
                    return;
                }

                // Check if ID already exists
                for (User u : users) {
                    if (u.getId().equals(id)) {
                        JOptionPane.showMessageDialog(this, "User ID already exists!");
                        return;
                    }
                }

                String selectedRole = ((String) roleCheck.getSelectedItem()).toLowerCase();

                User newuser = new User("User", id, pass, selectedRole, false);

                users.add(newuser);
                Filehandler.saveUsers(users);

                JOptionPane.showMessageDialog(this, "Registered Successfully as " + selectedRole + "!");

                idField.setText("");
                passField.setText("");

                JOptionPane.showMessageDialog(this,
                        "Please enter your credentials above and click LOGIN to access your dashboard.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Registration Error: " + ex.getMessage());
            }

        });
        forgotBtn.addActionListener(e -> {
            try {
                ArrayList<User> users = Filehandler.loadUsers();
                if (users == null || users.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No registered accounts found in the system.");
                    return;
                }

                // Prompt the user to enter their User ID to look up the password
                String searchId = JOptionPane.showInputDialog(this,
                        "Enter your User ID to recover your account details:");

                if (searchId == null || searchId.trim().isEmpty()) {
                    return; // User cancelled or left it blank
                }

                boolean accountFound = false;

                for (User u : users) {
                    if (u.getId().equalsIgnoreCase(searchId.trim())) {
                        accountFound = true;

                        // Safety block: Do not let regular users recover the Admin account details this
                        // way
                        if (u.getRoll().equalsIgnoreCase("admin")) {
                            JOptionPane.showMessageDialog(this,
                                    "Security Error: Master Admin credentials cannot be recovered dynamically. Contact system maintenance.");
                            return;
                        }

                        // Display the recovered password to the voter
                        JOptionPane.showMessageDialog(this,
                                "Account Found!\n\nUser ID: " + u.getId() + "\nPassword: " + u.getPasword());

                        // Automatically fill the fields to save them time typing
                        idField.setText(u.getId());
                        passField.setText(u.getPasword());
                        break;
                    }
                }

                if (!accountFound) {
                    JOptionPane.showMessageDialog(this, "Error: No registered account matches that User ID.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Recovery Error: " + ex.getMessage());
            }
        });

        this.setLocationRelativeTo(null); // Center on screen

        this.setResizable(false);
        this.setVisible(true);
    }
}