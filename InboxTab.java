import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class InboxTab extends JFrame {
    public InboxTab() {
        setTitle("Inbox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(null);

        // Load and resize the background image
        BufferedImage resizedImage = resizeImage("inboxbackground.png", 400, 600);
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
                System.out.println("Back clicked");
                new Profile();
            }
        });
        leftButton.setPreferredSize(new Dimension(40, 20));
        leftButton.setOpaque(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setBorderPainted(false);
        topBar.add(leftButton, BorderLayout.WEST);

        // Right button
        JButton rightButton = new JButton();
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the actions you want to perform when the button is clicked here
                System.out.println("Compose clicked");
                new Notifications();
            }
        });
        rightButton.setPreferredSize(new Dimension(40, 20));
        rightButton.setOpaque(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setBorderPainted(false);
        topBar.add(rightButton, BorderLayout.EAST);

        JPanel emailsPanel = new JPanel();
        emailsPanel.setLayout(new GridLayout(0, 1, 0, 10));
        emailsPanel.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(emailsPanel);
        scrollPane.setBounds(30, 30, 340, 500);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        background.add(scrollPane);

        // Funny emails from club leaders
        addEmail(emailsPanel, "Important Announcement", "John Doe - Math Club", "Hey everyone,\nOur next meeting will be held on a roller coaster. Don't forget your math hats!");
                addEmail(emailsPanel, "Emergency Meeting", "Captain Jack - Pirate Club", "Ahoy mateys,\nWe be havin' an emergency meeting to discuss our next plunderin' adventure! Arrr!");
                addEmail(emailsPanel, "Secret Mission Briefing", "Agent 007 - Spy Club", "Greetings agents,\nYour mission, should you choose to accept it, involves infiltrating the cafeteria to uncover the mystery of the disappearing cookies.");
                addEmail(emailsPanel, "Extraterrestrial Encounter", "Alien Overlord - UFO Club", "Greetings earthlings,\nWe've detected unusual activity near Area 51. Prepare for an extraterrestrial encounter at our next club meeting!");
                addEmail(emailsPanel, "Robot Revolution", "Tech Guru - Robotics Club", "Hello fellow inventors,\nOur latest creation, RoboChef, has gone rogue and is cooking up trouble in the school cafeteria. It's time to stop the robot revolution!");
                addEmail(emailsPanel, "Magical Mishaps", "Wizarding Wiz - Harry Potter Club", "Wands at the ready,\nDue to a magical mishap, the school corridors have turned into a maze of trick staircases. Beware of Peeves the poltergeist!");
                addEmail(emailsPanel, "Zombie Apocalypse Preparedness", "Survivor Sam - Zombie Defense League", "Attention survivors,\nThe zombie apocalypse is upon us. Join us for a survival training session and learn how to fend off the undead!");
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
                new InboxTab();
            }
        });
    }
}
