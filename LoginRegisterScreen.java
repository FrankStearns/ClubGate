import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class LoginRegisterScreen extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel emailLine;
    private JLabel passwordLine;
    public static String Name;

    public LoginRegisterScreen() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setResizable(false);

        try {
            // Load the background image
            File backgroundFile = new File("background.png");
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

        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        welcomeLabel.setBounds(150, 40, 200, 30); // Positioned at the top of the screen

        JLabel backLabel = new JLabel("Back!");
        backLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        backLabel.setBounds(170, 70, 100, 30); // Positioned below the "Welcome" label

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.LIGHT_GRAY);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Larger and bold
        emailLabel.setBounds(50, 280, 80, 30); // Positioned slightly below the middle

        emailField = new JTextField();
        emailField.setOpaque(false); // Make text field transparent
        emailField.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        emailField.setBounds(50, 280, 300, 30); // Positioned below the email label

        emailLine = new JLabel();
        emailLine.setBackground(Color.LIGHT_GRAY);
        emailLine.setOpaque(true);
        emailLine.setBounds(50, 310, 300, 1);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.LIGHT_GRAY);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Larger and bold
        passwordLabel.setBounds(50, 360, 100, 30); // Positioned below the email field

        passwordField = new JPasswordField();
        passwordField.setOpaque(false); // Make text field transparent
        passwordField.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        passwordField.setBounds(50, 360, 300, 30); // Positioned below the password label

        passwordLine = new JLabel();
        passwordLine.setBackground(Color.LIGHT_GRAY);
        passwordLine.setOpaque(true);
        passwordLine.setBounds(50, 390, 300, 1);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the actions you want to perform when the button is clicked here
                String email = emailField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String file = "test.txt";

                System.out.println(email);
                System.out.println(password);

                System.out.println("Login clicked");


                String[] test = validateFile(file,email,password);
                if (test != null){
                    System.out.println("Valid");
                    Name = test[0];
                    new HomeScreen();
                   dispose();
                }
                else{
                    System.out.println("Invalid");
                    JOptionPane.showMessageDialog(LoginRegisterScreen.this,"Email or Password Invalid", "Try again", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        loginButton.setBounds(150, 410, 100, 30); // Positioned below the password field

        JButton createAccountButton = new JButton("Don't have an account yet? Create One.");
        createAccountButton.setBounds(50, 460, 300, 30); // Positioned below the login button

        add(welcomeLabel);
        add(backLabel);
        add(emailLabel);
        add(emailField);
        add(emailLine);
        add(passwordLabel);
        add(passwordField);
        add(passwordLine);
        add(loginButton);
        add(createAccountButton);

        emailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                emailLine.setBackground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                emailLine.setBackground(Color.LIGHT_GRAY);
            }
        });

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordLine.setBackground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                passwordLine.setBackground(Color.LIGHT_GRAY);
            }
        });

        emailField.addFocusListener(new FocusListener() {
            private final int deltaY = 30; // Amount to move the label up
            private final int animationDuration = 300; // Duration of the animation in milliseconds
            private Timer timer;
            private boolean isFieldEmpty = true;

            @Override
            public void focusGained(FocusEvent e) {
                if (timer != null && timer.isRunning()) {
                    return; // Animation already in progress
                }

                isFieldEmpty = emailField.getText().isEmpty();
                if (isFieldEmpty) {
                    emailLabel.setForeground(Color.BLACK);
                    int startY = emailLabel.getY();
                    int endY = startY - deltaY;

                    timer = new Timer(10, new ActionListener() {
                        private long startTime = -1;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (startTime < 0) {
                                startTime = System.currentTimeMillis();
                            }

                            long now = System.currentTimeMillis();
                            long elapsedTime = now - startTime;
                            double progress = (double) elapsedTime / animationDuration;
                            if (progress >= 1.0) {
                                // Animation finished
                                timer.stop();
                                emailLabel.setLocation(emailLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY - (deltaY * progress));
                                emailLabel.setLocation(emailLabel.getX(), currentY);
                            }
                        }
                    });

                    timer.start();
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (timer != null && timer.isRunning()) {
                    return; // Animation already in progress
                }

                // Check if the email field is empty
                isFieldEmpty = emailField.getText().isEmpty();
                if (isFieldEmpty) {
                    emailLabel.setForeground(Color.LIGHT_GRAY);
                    int startY = emailLabel.getY();
                    int endY = startY + deltaY;

                    timer = new Timer(10, new ActionListener() {
                        private long startTime = -1;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (startTime < 0) {
                                startTime = System.currentTimeMillis();
                            }

                            long now = System.currentTimeMillis();
                            long elapsedTime = now - startTime;
                            double progress = (double) elapsedTime / animationDuration;
                            if (progress >= 1.0) {
                                // Animation finished
                                timer.stop();
                                emailLabel.setLocation(emailLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY + (deltaY * progress));
                                emailLabel.setLocation(emailLabel.getX(), currentY);
                            }
                        }
                    });

                    timer.start();
                }
            }
        });


        passwordField.addFocusListener(new FocusListener() {
            private final int deltaY = 30; // Amount to move the label up
            private final int animationDuration = 300; // Duration of the animation in milliseconds
            private Timer timer;
            private boolean isFieldEmpty = true;

            @Override
            public void focusGained(FocusEvent e) {
                if (timer != null && timer.isRunning()) {
                    return; // Animation already in progress
                }

                isFieldEmpty = passwordField.getText().isEmpty();
                if (isFieldEmpty) {
                    passwordLabel.setForeground(Color.BLACK);

                    int startY = passwordLabel.getY();
                    int endY = startY - deltaY;

                    timer = new Timer(10, new ActionListener() {
                        private long startTime = -1;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (startTime < 0) {
                                startTime = System.currentTimeMillis();
                            }

                            long now = System.currentTimeMillis();
                            long elapsedTime = now - startTime;
                            double progress = (double) elapsedTime / animationDuration;
                            if (progress >= 1.0) {
                                // Animation finished
                                timer.stop();
                                passwordLabel.setLocation(passwordLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY - (deltaY * progress));
                                passwordLabel.setLocation(passwordLabel.getX(), currentY);
                            }
                        }
                    });

                    timer.start();
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (timer != null && timer.isRunning()) {
                    return; // Animation already in progress
                }

                // Check if the password field is empty
                isFieldEmpty = passwordField.getText().isEmpty();
                if (isFieldEmpty) {
                    passwordLabel.setForeground(Color.LIGHT_GRAY);
                    int startY = passwordLabel.getY();
                    int endY = startY + deltaY;

                    timer = new Timer(10, new ActionListener() {
                        private long startTime = -1;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (startTime < 0) {
                                startTime = System.currentTimeMillis();
                            }

                            long now = System.currentTimeMillis();
                            long elapsedTime = now - startTime;
                            double progress = (double) elapsedTime / animationDuration;
                            if (progress >= 1.0) {
                                // Animation finished
                                timer.stop();
                                passwordLabel.setLocation(passwordLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY + (deltaY * progress));
                                passwordLabel.setLocation(passwordLabel.getX(), currentY);
                            }
                        }
                    });

                    timer.start();
                }
            }
        });



        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement action to switch to register screen here
                new RegistrationTab();
                // Add necessary components for registration
            }
        });

        setVisible(true);
    }

    public static String[] validateFile(String fileName,String email,String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("")){
                    continue;
                }
                // Split the line by spaces
                String[] words = line.split("\\s+");
                System.out.println(Arrays.toString(words));
                if (words[1].equals(email) && words[2].equals(password)){
                    System.out.println("Valid");
                    return words;

                }
                else{
                    System.out.println("BAD ");
                }


            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return null;
    }

    public static String getFirstName(){
        return Name;
    }

    public static void main(String[] args) {
        new LoginRegisterScreen();
    }
}