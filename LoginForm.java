import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;
import java.util.Arrays;


public class LoginForm extends JFrame{


    JPasswordField pfPassword;
    JTextField tfEmail;
    final private Font mainFont = new Font("Times New Roman", Font.BOLD, 18);
    public void initalize(){
        /*************************** */
        JLabel lbLoginForm = new JLabel("Login Form", SwingConstants.CENTER);
        lbLoginForm.setFont(mainFont);
        
        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        /*************** */

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainFont);
        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){

                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());
                String file = "test.txt";

                String[] user = getAuthenticatedUser(file,email,password);
            
                if (user != null){
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(LoginForm.this,"Email or Password Invalid", "Try again", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(mainFont);
        btnCancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();


            }

        });
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout((new GridLayout(1,2,10,0)));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnCancel);

        /* -------------------------------------- */
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);
        
        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);
    }

        // Function to read a file, split its contents by spaces, and print each word
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
    private String[] getAuthenticatedUser(String file , String email, String password){
        String[] test = validateFile(file,email,password);
        return test;
    }

    public static void main(String[] args){
       // String[] meow = validateFile("test.txt","lcambisaca","meow");
        LoginForm loginForm = new LoginForm();
        loginForm.initalize();
    }




    
}


