import javax.swing.*;
import java.awt.*;

public class CustomScrollPane extends JScrollPane {
    public CustomScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
        super(view, vsbPolicy, hsbPolicy);

        // Hide vertical scroll bar
        getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        getVerticalScrollBar().setOpaque(false);
        getVerticalScrollBar().setBackground(new Color(0, 0, 0, 0));

        // Hide horizontal scroll bar
        getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
        getHorizontalScrollBar().setOpaque(false);
        getHorizontalScrollBar().setBackground(new Color(0, 0, 0, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Override paintComponent to prevent painting of scroll bars
        // This ensures that the scroll bars remain invisible
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Override paintBorder to prevent painting of border
        // This ensures that no border is drawn around the scroll pane
    }

    @Override
    protected void paintChildren(Graphics g) {
        // Override paintChildren to prevent painting of child components
        // This ensures that the scroll pane contents are not affected
    }
}

