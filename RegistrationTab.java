import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class RegistrationTab extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneNumber;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel nameLine;
    private JLabel emailLine;
    private JLabel phoneNumberLine;
    private JLabel passwordLine;
    private JLabel confirmPasswordLine;

    public RegistrationTab() {
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

        JLabel welcomeLabel = new JLabel("Registration");
        welcomeLabel.setFont(new Font("Comfortaa", Font.BOLD, 24));
        welcomeLabel.setBounds(125, 60, 200, 30); // Positioned at the top of the screen

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.LIGHT_GRAY);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Larger and bold
        emailLabel.setBounds(50, 200, 80, 30); // Positioned slightly below the middle

        emailField = new JTextField();
        emailField.setOpaque(false); // Make text field transparent
        emailField.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        emailField.setBounds(50, 200, 300, 30); // Positioned below the email label

        emailLine = new JLabel();
        emailLine.setBackground(Color.LIGHT_GRAY);
        emailLine.setOpaque(true);
        emailLine.setBounds(50, 230, 300, 1);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.LIGHT_GRAY);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Larger and bold
        nameLabel.setBounds(50, 270, 80, 30); // Positioned slightly below the middle

        nameField = new JTextField();
        nameField.setOpaque(false); // Make text field transparent
        nameField.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        nameField.setBounds(50, 270, 300, 30); // Positioned below the email label

        nameLine = new JLabel();
        nameLine.setBackground(Color.LIGHT_GRAY);
        nameLine.setOpaque(true);
        nameLine.setBounds(50, 300, 300, 1);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setForeground(Color.LIGHT_GRAY);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Larger and bold
        phoneLabel.setBounds(50, 340, 200, 30); // Positioned slightly below the middle

        phoneNumber = new JTextField();
        phoneNumber.setOpaque(false); // Make text field transparent
        phoneNumber.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        phoneNumber.setBounds(50, 340, 300, 30); // Positioned below the email label

        phoneNumberLine = new JLabel();
        phoneNumberLine.setBackground(Color.LIGHT_GRAY);
        phoneNumberLine.setOpaque(true);
        phoneNumberLine.setBounds(50, 370, 300, 1);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.LIGHT_GRAY);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Larger and bold
        passwordLabel.setBounds(50, 410, 100, 30); // Positioned below the email field

        passwordField = new JPasswordField();
        passwordField.setOpaque(false); // Make text field transparent
        passwordField.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        passwordField.setBounds(50, 410, 300, 30); // Positioned below the password label

        passwordLine = new JLabel();
        passwordLine.setBackground(Color.LIGHT_GRAY);
        passwordLine.setOpaque(true);
        passwordLine.setBounds(50, 440, 300, 1);

        JLabel confirmpasswordLabel = new JLabel("Confirm Password:");
        confirmpasswordLabel.setForeground(Color.LIGHT_GRAY);
        confirmpasswordLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Larger and bold
        confirmpasswordLabel.setBounds(50, 480, 200, 30); // Positioned below the email field

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setOpaque(false); // Make text field transparent
        confirmPasswordField.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        confirmPasswordField.setBounds(50, 480, 300, 30); // Positioned below the password label

        confirmPasswordLine = new JLabel();
        confirmPasswordLine.setBackground(Color.LIGHT_GRAY);
        confirmPasswordLine.setOpaque(true);
        confirmPasswordLine.setBounds(50, 510, 300, 1);


        JButton createAccountButton = new JButton("Register");
        createAccountButton.setBounds(50, 540, 300, 30); // Positioned below the login button

        add(welcomeLabel);
        add(emailLabel);
        add(emailField);
        add(emailLine);
        add(nameLabel);
        add(nameField);
        add(nameLine);
        add(phoneLabel);
        add(phoneNumber);
        add(phoneNumberLine);
        add(passwordLabel);
        add(passwordField);
        add(passwordLine);
        add(confirmpasswordLabel);
        add(confirmPasswordField);
        add(confirmPasswordLine);
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

        nameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                nameLine.setBackground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                nameLine.setBackground(Color.LIGHT_GRAY);
            }
        });

        phoneNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                phoneNumberLine.setBackground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                phoneNumberLine.setBackground(Color.LIGHT_GRAY);
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

        confirmPasswordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                confirmPasswordLine.setBackground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                confirmPasswordLine.setBackground(Color.LIGHT_GRAY);
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

        nameField.addFocusListener(new FocusListener() {
            private final int deltaY = 30; // Amount to move the label up
            private final int animationDuration = 300; // Duration of the animation in milliseconds
            private Timer timer;
            private boolean isFieldEmpty = true;

            @Override
            public void focusGained(FocusEvent e) {
                if (timer != null && timer.isRunning()) {
                    return; // Animation already in progress
                }

                isFieldEmpty = nameField.getText().isEmpty();
                if (isFieldEmpty) {
                    nameLabel.setForeground(Color.BLACK);

                    int startY = nameLabel.getY();
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
                                nameLabel.setLocation(nameLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY - (deltaY * progress));
                                nameLabel.setLocation(nameLabel.getX(), currentY);
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

                // Check if the name field is empty
                isFieldEmpty = nameField.getText().isEmpty();
                if (isFieldEmpty) {
                    nameLabel.setForeground(Color.LIGHT_GRAY);
                    int startY = nameLabel.getY();
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
                                nameLabel.setLocation(nameLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY + (deltaY * progress));
                                nameLabel.setLocation(nameLabel.getX(), currentY);
                            }
                        }
                    });

                    timer.start();
                }
            }
        });

phoneNumber.addFocusListener(new FocusListener() {
            private final int deltaY = 30; // Amount to move the label up
            private final int animationDuration = 300; // Duration of the animation in milliseconds
            private Timer timer;
            private boolean isFieldEmpty = true;

            @Override
            public void focusGained(FocusEvent e) {
                if (timer != null && timer.isRunning()) {
                    return; // Animation already in progress
                }

                isFieldEmpty = phoneNumber.getText().isEmpty();
                if (isFieldEmpty) {
                    phoneLabel.setForeground(Color.BLACK);

                    int startY = phoneLabel.getY();
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
                                phoneLabel.setLocation(phoneLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY - (deltaY * progress));
                                phoneLabel.setLocation(phoneLabel.getX(), currentY);
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

                // Check if the phone number field is empty
                isFieldEmpty = phoneNumber.getText().isEmpty();
                if (isFieldEmpty) {
                    phoneLabel.setForeground(Color.LIGHT_GRAY);
                    int startY = phoneLabel.getY();
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
                                phoneLabel.setLocation(phoneLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY + (deltaY * progress));
                                phoneLabel.setLocation(phoneLabel.getX(), currentY);
                            }
                        }
                    });

                    timer.start();
                }
            }
        });

        confirmPasswordField.addFocusListener(new FocusListener() {
            private final int deltaY = 30; // Amount to move the label up
            private final int animationDuration = 300; // Duration of the animation in milliseconds
            private Timer timer;
            private boolean isFieldEmpty = true;

            @Override
            public void focusGained(FocusEvent e) {
                if (timer != null && timer.isRunning()) {
                    return; // Animation already in progress
                }

                isFieldEmpty = confirmPasswordField.getText().isEmpty();
                if (isFieldEmpty) {
                    confirmpasswordLabel.setForeground(Color.BLACK);

                    int startY = confirmpasswordLabel.getY();
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
                                confirmpasswordLabel.setLocation(confirmpasswordLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY - (deltaY * progress));
                                confirmpasswordLabel.setLocation(confirmpasswordLabel.getX(), currentY);
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
                isFieldEmpty = confirmPasswordField.getText().isEmpty();
                if (isFieldEmpty) {
                    confirmpasswordLabel.setForeground(Color.LIGHT_GRAY);
                    int startY = confirmpasswordLabel.getY();
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
                                confirmpasswordLabel.setLocation(confirmpasswordLabel.getX(), endY);
                            } else {
                                // Update label position based on progress
                                int currentY = (int) (startY + (deltaY * progress));
                                confirmpasswordLabel.setLocation(confirmpasswordLabel.getX(), currentY);
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
                String EMAIL = emailField.getText();
                String NAME = nameField.getText();
                String PHONE = phoneNumber.getText();
                String CONFIRM = String.valueOf(confirmPasswordField.getPassword());
                String PASSWORD = String.valueOf(passwordField.getPassword());

                if (PASSWORD.equals(CONFIRM)) {
                    // Add user to database
                    System.out.println("User added to database");
                    String data = NAME + " " + EMAIL  + " " + PASSWORD;
                    FileReadWriteExample.appendToFile("test.txt", data);
                    FileReadWriteExample.appendToFile("test.txt", "a a a");
                    JOptionPane.showMessageDialog(null, "Account created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new HomeScreen();
                } else {
                    // Display error message
                    JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                }






                // Add necessary components for registration
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistrationTab();
    }
}
