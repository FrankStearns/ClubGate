import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class HomeScreen extends JFrame {
    //private JTextField emailField;
    private JPasswordField passwordField;
    private JButton event2button;
    private JButton event3button;
    private JButton event4button;
    private JButton event1button;
    private JButton event5button;
    private JLabel eventline;


    public HomeScreen() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setResizable(false);

        // Load and resize the background image
        BufferedImage resizedImage = resizeImage("backgroundwicons.png", 400, 600);
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
        JButton leftButton = new JButton();
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the actions you want to perform when the button is clicked here
                System.out.println("Profile clicked");
                new Profile();
            }
        });
        leftButton.setPreferredSize(new Dimension(40, 20));
        leftButton.setOpaque(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setBorderPainted(false);
        topBar.add(leftButton, BorderLayout.WEST);

        JLabel logo = new JLabel("CLUBGATE");
        logo.setFont(new Font("Impact", Font.BOLD, 20));
        logo.setForeground(Color.BLACK);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        topBar.add(logo, BorderLayout.CENTER);

        // Notifications button
        JButton notificationsButton = new JButton();
        notificationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the actions you want to perform when the button is clicked here
                System.out.println("Notifications clicked");
                new Notifications();
            }
        });
        notificationsButton.setPreferredSize(new Dimension(40, 20));
        notificationsButton.setOpaque(false);
        notificationsButton.setContentAreaFilled(false);
        notificationsButton.setBorderPainted(false);
        topBar.add(notificationsButton, BorderLayout.EAST);

        /*try {
            // Load the background image
            File backgroundFile = new File("backgroundwicons.png");
            if (!backgroundFile.exists()) {
                System.out.println("Background image not found!");
                System.exit(1); // Exit the program if the image is not found
            }
            Image backgroundImage = ImageIO.read(backgroundFile);

            // Resize image to fit the screen
            backgroundImage = backgroundImage.getScaledInstance(400, 600, Image.SCALE_SMOOTH);

            setContentPane(new JLabel(new ImageIcon(backgroundImage)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Colgate Clubs");
        welcomeLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        welcomeLabel.setBounds(110, 70, 200, 30); // Positioned at the top of the screen

        JLabel emailLabel = new JLabel("Upcoming Events");
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(new Font("Comfortaa", Font.BOLD, 16)); // Larger and bold
        emailLabel.setBounds(130, 150, 200, 30); // Positioned slightly below the middle

        JLabel date1 = new JLabel("3/26 |");
        date1.setForeground(Color.BLACK);
        date1.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Larger and bold
        date1.setBounds(65, 195, 200, 60); // Positioned slightly below the middle

        JLabel date2 = new JLabel(" 4/1  |");
        date2.setForeground(Color.BLACK);
        date2.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Larger and bold
        date2.setBounds(65, 255, 200, 60); // Positioned slightly below the middle

        JLabel date3 = new JLabel(" 4/7  |");
        date3.setForeground(Color.BLACK);
        date3.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Larger and bold
        date3.setBounds(65, 315, 200, 60); // Positioned slightly below the middle

        JLabel date4 = new JLabel("4/23  |");
        date4.setForeground(Color.BLACK);
        date4.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Larger and bold
        date4.setBounds(65, 375, 200, 60); // Positioned slightly below the middle

        JLabel date5 = new JLabel("4/27  |");
        date5.setForeground(Color.BLACK);
        date5.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Larger and bold
        date5.setBounds(65, 435, 200, 60); // Positioned slightly below the middle


        eventline = new JLabel();
        eventline.setBackground(Color.BLACK);
        eventline.setOpaque(true);
        eventline.setBounds(50, 180, 300, 1);
        
        JButton event1button = new JButton("      Dance Auditions");
        event1button.setBounds(50, 200, 245, 50); // Positioned below the login button 

        JButton event2button = new JButton("      Basketball Game");
        event2button.setBounds(50, 260, 245, 50); // Positioned below the login button 

        JButton event3button = new JButton("      Ice Cream Social");
        event3button.setBounds(50, 320, 245, 50); // Positioned below the login button 

        JButton event4button = new JButton("      Wags for Wellness");
        event4button.setBounds(50, 380, 245, 50); // Positioned below the login button

        JButton event5button = new JButton("      Bingo");
        event5button.setBounds(50, 440, 245, 50); // Positioned below the login button

        add(welcomeLabel);
        add(emailLabel);
        add(eventline);
        add(date1);
        add(date2);
        add(date3);
        add(date4);
        add(date5);
        add(event1button);
        add(event2button);
        add(event3button);
        add(event4button);
        add(event5button);

        setVisible(true);

// Bottom bar with tab buttons
JPanel bottomBar = new JPanel();
bottomBar.setBounds(0, 530, 400, 45);
bottomBar.setOpaque(false);
bottomBar.setLayout(new GridLayout(1, 5));
background.add(bottomBar);


JButton tab1Button = new JButton();
tab1Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add the actions you want to perform when the button is clicked here
        System.out.println("Home clicked");
    }
});

tab1Button.setPreferredSize(new Dimension(80, 45));
tab1Button.setOpaque(false);
tab1Button.setContentAreaFilled(false);
tab1Button.setBorderPainted(false);
bottomBar.add(tab1Button);

JButton tab2Button = new JButton();
tab2Button.setPreferredSize(new Dimension(80, 45));
tab2Button.setOpaque(false);
tab2Button.setContentAreaFilled(false);
tab2Button.setBorderPainted(false);
bottomBar.add(tab2Button);

JButton tab3Button = new JButton();
tab3Button.setPreferredSize(new Dimension(80, 45));
tab3Button.setOpaque(false);
tab3Button.setContentAreaFilled(false);
tab3Button.setBorderPainted(false);
bottomBar.add(tab3Button);

JButton tab4Button = new JButton();
tab4Button.setPreferredSize(new Dimension(80, 45));
tab4Button.setOpaque(false);
tab4Button.setContentAreaFilled(false);
tab4Button.setBorderPainted(false);
bottomBar.add(tab4Button);

JButton tab5Button = new JButton();
tab5Button.setPreferredSize(new Dimension(80, 45));
tab5Button.setOpaque(false);
tab5Button.setContentAreaFilled(false);
tab5Button.setBorderPainted(false);
bottomBar.add(tab5Button);


tab2Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add the actions you want to perform when the button is clicked here
        System.out.println("Clubs clicked");
        new ClubsTab();
    }
});

tab3Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add the actions you want to perform when the button is clicked here
        System.out.println("Calendar clicked");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalendarTab();
            }
        });
    }

});

tab4Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add the actions you want to perform when the button is clicked here
        System.out.println("My Clubs clicked");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyClubsTab();
            }
        });
    }
});

tab5Button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add the actions you want to perform when the button is clicked here
        System.out.println("Inbox clicked");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InboxTab();
            }
        });
    }
});


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

}
