import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Profile extends JFrame {
    //private JTextField emailField;
    private JPasswordField passwordField;
    private JButton event2button;
    private JButton event3button;
    private JButton event4button;
    private JButton event1button;
    private JButton event5button;
    private JLabel eventline;


    public Profile() {
        setTitle("My Info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setResizable(false);

        // Load and resize the background image
        BufferedImage resizedImage = resizeImage("profilebg.png", 400, 600);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);

        // Set background image
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 400, 600);
        setContentPane(background);

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBounds(0, 0, 400, 20);
        topBar.setOpaque(false);
        background.add(topBar);

        // Left button
        JButton leftButton = new JButton("<< Back");
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the actions you want to perform when the button is clicked here
                System.out.println("Back clicked");
                new HomeScreen();
            }
        });
        leftButton.setPreferredSize(new Dimension(60, 200));
        leftButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
        leftButton.setOpaque(false);
        leftButton.setContentAreaFilled(true);
        leftButton.setBorderPainted(true);
        topBar.add(leftButton, BorderLayout.WEST);

        setLayout(null);

        JLabel welcomeLabel = new JLabel("Profile");
        welcomeLabel.setFont(new Font("Comfortaa", Font.BOLD, 30));
        welcomeLabel.setBounds(155, 40, 200, 30); // Positioned at the top of the screen
        
        JLabel name = new JLabel(LoginRegisterScreen.getFirstName());
        name.setFont(new Font("Comfortaa", Font.BOLD, 30));
        name.setBounds(135, 340, 200, 30); // Positioned at the top of the screen
    
        add(welcomeLabel);
        add(name);

// Bottom bar with tab buttons

JButton tab1Button = new JButton();
tab1Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add the actions you want to perform when the button is clicked here
        System.out.println("Home clicked");
    }
});



JButton logout = new JButton("Log Out");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the actions you want to perform when the button is clicked here
                System.out.println("Profile clicked");
                new LoginRegisterScreen();
            }
        });
        logout.setFont(new Font("Times New Roman", Font.BOLD, 24));
        logout.setOpaque(false);
        logout.setContentAreaFilled(true);
        logout.setBorderPainted(true);
        logout.setBounds(130, 420, 140, 30); // Positioned at the top of the screen


logout.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add the actions you want to perform when the button is clicked here
        System.out.println("Inbox clicked");
    }
});

add(logout);

setVisible(true);
}

private BufferedImage resizeImage(String imagePath, int width, int height) {
try {
    BufferedImage originalImage = ImageIO.read(new File(imagePath));
    Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    BufferedImage bufferedResizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = bufferedResizedImage.createGraphics();
    g2d.drawImage(resizedImage, 0, 0, null);
    g2d.dispose();
    return bufferedResizedImage;
} catch (IOException e) {
    e.printStackTrace();
    return null;
}
}

    public static void main(String[] args) {
        new Profile();
    }
}