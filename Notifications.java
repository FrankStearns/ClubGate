import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class Notifications extends JFrame {
    public Notifications() {
        setTitle("Messages");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(null);

        // Load and resize the background image
        BufferedImage resizedImage = resizeImage("notificationsbg.png", 400, 600);
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
        leftButton.setPreferredSize(new Dimension(80, 60));
        leftButton.setOpaque(true);
        leftButton.setContentAreaFilled(true);
        leftButton.setBorderPainted(true);
        topBar.add(leftButton, BorderLayout.WEST);

        // Right button
        JButton rightButton = new JButton();
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the actions you want to perform when the button is clicked here
                System.out.println("Compose clicked");
            }
        });
        rightButton.setPreferredSize(new Dimension(40, 20));
        rightButton.setOpaque(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setBorderPainted(false);
        topBar.add(rightButton, BorderLayout.EAST);

        JPanel messagesPanel = new JPanel();
        messagesPanel.setLayout(new GridLayout(0, 1, 0, 10));
        messagesPanel.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(messagesPanel);
        scrollPane.setBounds(30, 30, 340, 500);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        background.add(scrollPane);

        // Funny emails from club leaders
        addEmail(messagesPanel, "Hey! Looking to Audition?", "Sarah Smith - Dance Captain", "Hi!,\nDon't forget Auditions are next week! Would love to see you there!");
                addEmail(messagesPanel, "Daniel Jones", "Hey! How are you?", "Would you still want to join our club?,\nWe be havin' an emergency meeting to discuss our next plunderin' adventure! Arrr!");
                addEmail(messagesPanel, "Secret Mission Briefing - Carl", "Agent 007 - Spy Club", "Greetings agents,\n If you would like to join our club please fill out this form, ASAP!");
                addEmail(messagesPanel, "Caroline Johnson", "Alien Overlord - UFO Club", "Greetings earthlings,\n We would love to see you at our next meeting on April 10th!");
                addEmail(messagesPanel, "Robot Revolution", "Robotics Meeting", "Thank you for coming to our last meeting!,\n We would love to see you at our next meeting again.");
                addEmail(messagesPanel, "Christina Stine", "Wizarding Wiz - Harry Potter Club", "Hey again!,\n It was so nice tos ee you at our last club meeting. Please consider running for an officer position!");
                addEmail(messagesPanel, "Sam Jameson", "Thank you!", "It was so great to see you yesterday,\n Let me know if you'd like to talk more about the club sometime!");
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
                new HomeScreen();
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
                new MyClubsTab();
            }
        });

        tab5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the actions you want to perform when the button is clicked here
                System.out.println("Inbox clicked");
                new InboxTab();
            }
        });

        setVisible(true);
    }

    private void addEmail(JPanel panel, String subject, String sender, String sneakPeak) {
        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new BorderLayout());
        emailPanel.setPreferredSize(new Dimension(340, 100));
        emailPanel.setBackground(Color.WHITE);
        emailPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel subjectLabel = new JLabel(subject);
        subjectLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailPanel.add(subjectLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridLayout(2, 1));
        contentPanel.setOpaque(false);

        JLabel senderLabel = new JLabel(sender);
        senderLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(senderLabel);

        JLabel sneakPeakLabel = new JLabel("<html><p style='width:280px'>" + sneakPeak + "</p></html>");
        sneakPeakLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(sneakPeakLabel);

        emailPanel.add(contentPanel, BorderLayout.CENTER);

        panel.add(emailPanel);
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Notifications();
            }
        });
    }
}

