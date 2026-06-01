import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JWindow {
    
    public WelcomeScreen() {

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                // Load your election image file here (make sure the image is in your main project folder!)
                ImageIcon imageIcon = new ImageIcon("election_bg.jpg"); 
                Image img = imageIcon.getImage();
                
                // This stretches the image to fit your exact window size
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                
                // BEAUTIFICATION: Adds a dark tint layer so your white and blue text stands out perfectly
                g.setColor(new Color(0, 0, 0, 160)); // The 160 sets the image darkness (0 to 255)
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
       
       panel.setBorder(BorderFactory.createLineBorder(new Color(0, 150, 255), 3));
  

        // 2. Top Label: Using simple HTML <u> tags for the underline highlight
        JLabel titleLabel = new JLabel("ONLINE VOTING SYSTEM", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE); // Bright white text
        

        // 4. Bottom Label: Simple footer text with an italic font
        JLabel footerLabel = new JLabel("Loading security portal... Please wait.", SwingConstants.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 13));
        footerLabel.setForeground(new Color(0, 200, 255)); // Bright cyan highlight color

        // Add components to our simple grid layout
        panel.add(titleLabel);
         panel.add(footerLabel);
        // panel.add(logoLabel);
        panel.add(footerLabel);

        // Window configuration properties
        add(panel);
        setSize(400, 280);
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);

        // 5. Clean 3-second delay timer
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close down and switch to Authframe
        setVisible(false);
        dispose(); 
    }}
