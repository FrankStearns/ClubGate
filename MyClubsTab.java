import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class MyClubsTab extends JFrame {
    private JPanel clubListPanel;

    public MyClubsTab() {
        setTitle("Clubs Tab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(null);

        // Load and resize the background image
        BufferedImage resizedImage = resizeImage("myclubsbackground.png", 400, 600);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);

        // Set background image
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 400, 600);
        setContentPane(background);

        // Top bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBounds(0, 0, 400, 20);
        topBar.setOpaque(false);
        background.add(topBar);

        // Left button
        JButton leftButton = new JButton();
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add actions for tab button 1
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
                new Notifications();
            }
        });
        notificationsButton.setPreferredSize(new Dimension(40, 20));
        notificationsButton.setOpaque(false);
        notificationsButton.setContentAreaFilled(false);
        notificationsButton.setBorderPainted(false);
        topBar.add(notificationsButton, BorderLayout.EAST);

        // Club list
        clubListPanel = new JPanel();
        clubListPanel.setLayout(new BoxLayout(clubListPanel, BoxLayout.Y_AXIS));
        clubListPanel.setBounds(20, 40, 360, 480);
        clubListPanel.setOpaque(false);
        add(clubListPanel);

        // Populate club list
        for (Club club : Club.getMyClubs()){
            JPanel clubPanel = new JPanel(new GridLayout(3, 1));
            clubPanel.setPreferredSize(new Dimension(360, 100));
            clubPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            clubPanel.setBackground(Color.WHITE);

            JLabel nameLabel = new JLabel("Name: " + club.getName());
            JLabel typeLabel = new JLabel("Type: " + club.getType());
            JLabel meetingLabel = new JLabel("Meeting: " + club.getMeetingDays() + " at " + club.getMeetingTimes());

            clubPanel.add(nameLabel);
            clubPanel.add(typeLabel);
            clubPanel.add(meetingLabel);

            // Add ActionListener to open ClubPage for this club
            clubPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ClubPage clubPage = new ClubPage(club);
                    clubPage.setVisible(true);
                }
            });

            clubListPanel.add(clubPanel);
        }

        // Scroll pane for club list
        JScrollPane scrollPane = new JScrollPane(clubListPanel);
        scrollPane.setBounds(20, 60, 360, 450);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        // Bottom bar with tab buttons
        JPanel bottomBar = new JPanel();
        bottomBar.setBounds(0, 530, 400, 45);
        bottomBar.setOpaque(false);
        bottomBar.setLayout(new GridLayout(1, 5));
        background.add(bottomBar);

        JButton tab1Button = new JButton();
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

        // Add action listeners to tab buttons
        tab1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add actions for tab button 1
                new HomeScreen();
            }
        });

        tab2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new ClubsTab();
                    }
                });
            }
        });

        tab3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CalendarTab();
            }
        });

        tab4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add actions for tab button 4
            }
        });

        tab5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add actions for tab button 5
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyClubsTab();
            }
        });
    }
}
