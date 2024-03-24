import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class InteractiveCalendar extends JPanel {
    private JLabel monthLabel;
    private JButton prevButton;
    private JButton nextButton;
    private JPanel calendarPanel;
    private YearMonth currentMonth;

    public InteractiveCalendar() {
        setLayout(new BorderLayout());

        // Panel for month label and navigation buttons
        JPanel topPanel = new JPanel(new FlowLayout());
        monthLabel = new JLabel("", SwingConstants.CENTER);
        topPanel.add(monthLabel);

        prevButton = new JButton("<< Prev");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMonth = currentMonth.minusMonths(1);
                updateCalendar();
            }
        });
        topPanel.add(prevButton);

        nextButton = new JButton("Next >>");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentMonth = currentMonth.plusMonths(1);
                updateCalendar();
            }
        });
        topPanel.add(nextButton);

        add(topPanel, BorderLayout.NORTH);

        // Create calendar panel
        calendarPanel = new JPanel(new GridLayout(0, 7));
        calendarPanel.setBackground(Color.WHITE); // Set background color to white
        add(calendarPanel, BorderLayout.CENTER);

        // Initialize calendar with current month
        currentMonth = YearMonth.now();
        updateCalendar();
    }

    private void updateCalendar() {
        // Update month label
        monthLabel.setText(currentMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + currentMonth.getYear());

        // Clear previous calendar
        calendarPanel.removeAll();

        // Add day labels
        LocalDate date = currentMonth.atDay(1);
        int daysInMonth = currentMonth.lengthOfMonth();
        int firstDayOfWeek = date.getDayOfWeek().getValue(); // 1 = Monday, 7 = Sunday

        // Fill empty cells before the first day of the month
        for (int i = 1; i < firstDayOfWeek; i++) {
            JLabel emptyLabel = new JLabel("");
            emptyLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            calendarPanel.add(emptyLabel);
        }

        // Add day panels with rectangles for events
        Random random = new Random();
        for (int day = 1; day <= daysInMonth; day++) {
            JPanel dayPanel = new JPanel(new BorderLayout());
            dayPanel.setBackground(Color.WHITE); // Set background color to white
            dayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JLabel dayLabel = new JLabel(String.valueOf(day));
            dayLabel.setHorizontalAlignment(SwingConstants.LEFT);
            dayLabel.setVerticalAlignment(SwingConstants.TOP);
            dayPanel.add(dayLabel, BorderLayout.NORTH);

            // Add random number of rectangles for events (maximum 3)
            int numEvents = random.nextInt(4); // Random number of events (0 to 3)
            for (int i = 0; i < numEvents && i < 3; i++) {
                Color eventColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Random color
                int eventHeight = random.nextInt(20) + 5; // Random height (5 to 24)
                JPanel eventPanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(eventColor);
                        g.fillRect(0, getHeight() - eventHeight, getWidth(), eventHeight);
                    }
                };
                eventPanel.setPreferredSize(new Dimension(20, 20)); // Set event panel size
                dayPanel.add(eventPanel, BorderLayout.SOUTH);
            }

            calendarPanel.add(dayPanel);
        }

        // Refresh UI
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Interactive Calendar");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setContentPane(new InteractiveCalendar());
                frame.setVisible(true);
            }
        });
    }
}
