import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class ClubPage extends JFrame {
    private Club club;

    public ClubPage(Club club) {
        this.club = club;

        setTitle("Club Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(null);

        // Load and resize the background image
        BufferedImage resizedImage = resizeImage("clubbackground.png", 400, 600);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);

        // Set background image
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 400, 600);
        setContentPane(background);

        JLabel nameLabel = new JLabel("Name: " + club.getName());
        nameLabel.setBounds(30, 30, 340, 20);
        background.add(nameLabel);

        JLabel typeLabel = new JLabel("Type: " + club.getType());
        typeLabel.setBounds(30, 60, 340, 20);
        background.add(typeLabel);

        JLabel meetingDaysLabel = new JLabel("Meeting Days: " + club.getMeetingDays());
        meetingDaysLabel.setBounds(30, 90, 340, 20);
        background.add(meetingDaysLabel);

        JLabel meetingTimesLabel = new JLabel("Meeting Times: " + club.getMeetingTimes());
        meetingTimesLabel.setBounds(30, 120, 340, 20);
        background.add(meetingTimesLabel);

        JLabel auditionLabel = new JLabel("Audition: " + (club.hasAudition() ? "Yes" : "No"));
        auditionLabel.setBounds(30, 150, 340, 20);
        background.add(auditionLabel);

        JLabel leaderLabel = new JLabel("Club Leader: " + club.getClubLeader());
        leaderLabel.setBounds(30, 180, 340, 20);
        background.add(leaderLabel);

        JLabel contactLabel = new JLabel("Contact: " + club.getContact());
        contactLabel.setBounds(30, 210, 340, 20);
        background.add(contactLabel);

        JTextArea descriptionArea = new JTextArea("Description: " + club.getDescription());
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        scrollPane.setBounds(30, 240, 340, 200);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        background.add(scrollPane);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClubsTab();
                dispose();
            }
        });
        backButton.setBounds(30, 460, 80, 30);
        background.add(backButton);

        JButton addToClubsButton = new JButton("Add to your clubs");
        addToClubsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked Add to your clubs");
                club.addtomyClub(club);
            }
        });
        addToClubsButton.setBounds(220, 10, 150, 30);
        background.add(addToClubsButton);

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
            @Override
            public void run() {
                new ClubPage(ClubsTab.DDT);
            }
        });
    }
}
