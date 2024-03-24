import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class CalendarTab extends JFrame {
    private JScrollPane scrollPane;
    private JPanel eventsPanel;
    private InteractiveCalendar interactiveCalendar;
    public CalendarTab() {
        setTitle("Calendar Tab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(null);

        // Load and resize the background image
        BufferedImage resizedImage = resizeImage("calbackground.png", 400, 600);
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


        // Create events panel with horizontal scrolling
        eventsPanel = new JPanel();
        eventsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        eventsPanel.setPreferredSize(new Dimension(600, 150));
        eventsPanel.setOpaque(false);
        background.add(eventsPanel);

        JPanel eventPanel = new JPanel();
        eventPanel.setPreferredSize(new Dimension(100, 150));
        eventPanel.setLayout(new BorderLayout());

        // Add image to the top half
        BufferedImage resizedtrackImage = resizeImage("Trackmeet.jpeg", 100, 75);
        ImageIcon trackImage = new ImageIcon(resizedtrackImage);
        JLabel imageLabel = new JLabel(trackImage);
        imageLabel.setPreferredSize(new Dimension(100, 75));
        eventPanel.add(imageLabel, BorderLayout.NORTH);

        // Add description to the bottom half
        JTextArea descriptionArea = new JTextArea("Colgate University Men's Track vs Maryland Invitational");
        descriptionArea.setPreferredSize(new Dimension(100, 75));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionArea.setAlignmentY(Component.CENTER_ALIGNMENT);
        eventPanel.add(descriptionArea, BorderLayout.SOUTH);

        eventPanel.setBackground(Color.WHITE);
        eventsPanel.add(eventPanel);

        // Suess Panel
        eventPanel = new JPanel();
        eventPanel.setPreferredSize(new Dimension(100, 150));
        eventPanel.setLayout(new BorderLayout());

        // Add image to the top half
        BufferedImage resizedsuessImage = resizeImage("DrSuess.jpeg", 100, 75);
        ImageIcon suessImage = new ImageIcon(resizedsuessImage);
        imageLabel = new JLabel(suessImage);
        imageLabel.setPreferredSize(new Dimension(100, 75));
        eventPanel.add(imageLabel, BorderLayout.NORTH);

        // Add description to the bottom half
        descriptionArea = new JTextArea("11th Annual Seuss Saturday");
        descriptionArea.setPreferredSize(new Dimension(100, 75));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionArea.setAlignmentY(Component.CENTER_ALIGNMENT);
        eventPanel.add(descriptionArea, BorderLayout.SOUTH);

        eventPanel.setBackground(Color.WHITE);
        eventsPanel.add(eventPanel);

        // Art Panel

        eventPanel = new JPanel();
        eventPanel.setPreferredSize(new Dimension(100, 150));
        eventPanel.setLayout(new BorderLayout());

        // Add image to the top half
        BufferedImage resizedartImage = resizeImage("art.jpeg", 100, 75);
        ImageIcon artImage = new ImageIcon(resizedartImage);
        imageLabel = new JLabel(artImage);
        imageLabel.setPreferredSize(new Dimension(100, 75));
        eventPanel.add(imageLabel, BorderLayout.NORTH);

        // Add description to the bottom half
        descriptionArea = new JTextArea("Grafters X Change 2024: Anguish and Glory");
        descriptionArea.setPreferredSize(new Dimension(100, 75));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionArea.setAlignmentY(Component.CENTER_ALIGNMENT);
        eventPanel.add(descriptionArea, BorderLayout.SOUTH);

        eventPanel.setBackground(Color.WHITE);
        eventsPanel.add(eventPanel);

        // LinkedIn Panel

        eventPanel = new JPanel();
        eventPanel.setPreferredSize(new Dimension(100, 150));
        eventPanel.setLayout(new BorderLayout());

        // Add image to the top half
        BufferedImage resizedLinkedInImage = resizeImage("LinkedIn.jpeg", 100, 75);
        ImageIcon LinkedInImage = new ImageIcon(resizedLinkedInImage);
        imageLabel = new JLabel(LinkedInImage);
        imageLabel.setPreferredSize(new Dimension(100, 75));
        eventPanel.add(imageLabel, BorderLayout.NORTH);

        // Add description to the bottom half
        descriptionArea = new JTextArea("How to Set Goals When Everything Feels Like a Priority (Self Paced / LinkedIn Learning)");
        descriptionArea.setPreferredSize(new Dimension(100, 75));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionArea.setAlignmentY(Component.CENTER_ALIGNMENT);
        eventPanel.add(descriptionArea, BorderLayout.SOUTH);

        eventPanel.setBackground(Color.WHITE);
        eventsPanel.add(eventPanel);

        // LinkedIn Panel

        eventPanel = new JPanel();
        eventPanel.setPreferredSize(new Dimension(100, 150));
        eventPanel.setLayout(new BorderLayout());

        // Add image to the top half
        BufferedImage resizedeclipseImage = resizeImage("eclipse.jpeg", 100, 75);
        ImageIcon eclipseImage = new ImageIcon(resizedeclipseImage);
        imageLabel = new JLabel(eclipseImage);
        imageLabel.setPreferredSize(new Dimension(100, 75));
        eventPanel.add(imageLabel, BorderLayout.NORTH);

        // Add description to the bottom half
        descriptionArea = new JTextArea("Eclipse Art");
        descriptionArea.setPreferredSize(new Dimension(100, 75));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionArea.setAlignmentY(Component.CENTER_ALIGNMENT);
        eventPanel.add(descriptionArea, BorderLayout.SOUTH);

        eventPanel.setBackground(Color.WHITE);
        eventsPanel.add(eventPanel);

        scrollPane = new JScrollPane(eventsPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(30, 25, 340, 170);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        background.add(scrollPane);

        // Add listener to adjust scroll position
        scrollPane.getHorizontalScrollBar().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                adjustScrollPosition();
            }
        });

        // Interactive calendar


        JPanel calendarPanel = new JPanel();
        calendarPanel.setBounds(0, 220, 400, 275);
        calendarPanel.setBackground(new Color(255, 255, 255, 150));
        calendarPanel.setOpaque(false);
        background.add(calendarPanel);

        interactiveCalendar = new InteractiveCalendar();
        interactiveCalendar.setBounds(30, 220, 340, 300);
        background.add(interactiveCalendar);

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
                dispose();
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



    private void adjustScrollPosition() {
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        int scrollValue = horizontalScrollBar.getValue();

        if (scrollValue < 40) {
            horizontalScrollBar.setValue(40);
        } else if (scrollValue > 360) {
            horizontalScrollBar.setValue(360);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalendarTab();
            }
        });
    }
}

