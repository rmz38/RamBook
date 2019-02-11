//Rose and Rebeccas' project
import java.lang.Object.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JComponent.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import cs1.*;

public class Interface extends JFrame implements ActionListener, KeyListener
{
    private RamBook jd;
    private static User currUser; 
    //Create the frame.
    private JFrame frame;
    private JPanel answerPanel = new JPanel();
    private JPanel pagePanel = new JPanel();
    //Input textbox 1
    private JTextField user;

    //Input textbox 2
    private JTextField pass;

    //Input name,age,hometown, and 3 schools textboxes
    private JTextField age_input;
    private JTextField name_input;
    private JTextField hometown_input;
    private JTextField school1;
    private JTextField school2;
    private JTextField school3;
    private JTextField inputField;
    private JTextField addInput;
    private JTextField unInput;
    //Buttons
    private JButton login;
    private JButton createAcc;
    private JButton returnToLogin;
    private JButton goToMsg;
    private JButton goToFriends;
    private JButton back;
    private JButton addFriend;
    private JButton unfriend;

    private JButton getAFriend;

    private JButton logout;

    private JTextField name1;
    private ArrayList<JButton> toMsg = new ArrayList<JButton>();
    //Labels
    private JLabel username;
    private JLabel password;
    private JLabel feedback;
    private JLabel name;
    private JLabel age;
    private JLabel hometown;
    private JLabel schools;
    private String[] schoolList = new String[3];
    private JPanel friendsPanel = new JPanel();
    private ArrayList<ArrayList<String>> messages = new ArrayList<ArrayList<String>>();

    //DEFAULT CONSTRUCTOR
    public Interface()
    {
        frame = new JFrame();
        jd = new RamBook();
        user = new JTextField("", 15);
        pass = new JTextField("", 15);
        age_input = new JTextField("", 15);
        addInput = new JTextField("", 10);
        unInput = new JTextField("", 10);
        name_input = new JTextField("", 15);
        inputField = new JTextField("", 15);
        hometown_input = new JTextField("", 15);
        school1 = new JTextField("", 15);
        school2 = new JTextField("", 15);
        school3 = new JTextField("", 15);
        username = new JLabel("Username: ");
        password = new JLabel("Password: ");
        feedback = new JLabel("Login Please");
        name = new JLabel("Name: ");
        age = new JLabel("Age: ");
        hometown = new JLabel("Hometown: ");
        schools = new JLabel("Schools: ");
        ArrayList<JButton> toMsg = new ArrayList<JButton>();
        JPanel friendsPanel = new JPanel();
        friendsPanel.setSize(1000,700);
        friendsPanel.setLocation(87, 25);
        friendsPanel.setBackground(Color.red);
        frame.add(friendsPanel);
        friendsPanel.setVisible(false);
        // rebeccas stuff
        back = new JButton("HOME");
        addFriend = new JButton("Add Friend");
        unfriend = new JButton("Unfriend");
        getAFriend = new JButton("Get a Friend");
        logout = new JButton("LOGOUT");
        goToMsg = new JButton("Messages");
        goToFriends = new JButton("Friends");

        frame.add(goToMsg);
        frame.add(goToFriends);
        frame.add(back);
        frame.add(logout);
        frame.add(getAFriend);
        frame.add(addFriend);
        frame.add(unfriend);
        frame.add(goToMsg);
        frame.add(goToFriends);
        back.setSize(75,40);
        back.setLocation(500,70);

        logout.setSize(90,40);
        logout.setLocation(490,20);

        addFriend.setSize(100,50);
        addFriend.setLocation(50,30);

        getAFriend.setSize(125,50);
        getAFriend.setLocation(175,30);

        unfriend.setSize(100,50);
        unfriend.setLocation(325,30);

        goToMsg.setSize(125,50);
        goToMsg.setLocation(175,30);

        goToFriends.setSize(100,50);
        goToFriends.setLocation(325,30);

        //answerField.setEnabled(false); might be useful later ~~~~
        login = new JButton("Login");
        createAcc = new JButton("Create New Account");
        returnToLogin = new JButton("Back");
        JButton createNewMsg = new JButton("New");

        //Sets Background Color of Frame
        frame.getContentPane().setBackground(Color.cyan);

        frame.setLayout(null);

        //Size the frame.
        frame.pack();

        //Sets size of window
        frame.setSize(1000, 900);

        //Sets title of window
        frame.setTitle("Hello World!");

        setLocationRelativeTo(null);

        //Adding things to the frame
        frame.add(login);
        frame.add(createAcc);
        frame.add(returnToLogin);
        frame.add(createNewMsg);

        frame.add(username);
        frame.add(password);
        frame.add(feedback);
        frame.add(name);
        frame.add(age);
        frame.add(hometown);
        frame.add(schools);
        JPanel answerPanel = new JPanel(new FlowLayout()); 
        answerPanel.setSize(200, 400);
        answerPanel.add(user);
        answerPanel.add(pass);
        answerPanel.add(name_input);
        answerPanel.add(age_input);
        answerPanel.add(hometown_input);
        answerPanel.add(school1);
        answerPanel.add(school2);
        answerPanel.add(school3);
        answerPanel.setLocation(87, 25);
        answerPanel.setBackground(Color.red);
        frame.add(answerPanel);
        JPanel pagePanel = new JPanel(new FlowLayout());
        pagePanel.setSize(300, 25);
        pagePanel.add(addInput);
        pagePanel.add(unInput);

        pagePanel.setBackground(Color.red);
        addInput.setVisible(true);
        pagePanel.setLocation(100, 100);
        pagePanel.setVisible(false);
        frame.add(pagePanel);
        loginPage();

        //What happens when the frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //FINAL STEP: SET WINDOW TO VISIBLE
        frame.setVisible(true); // important!!! ~~~~~~~

        login.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    if(login.getText().equals("Login"))
                    {
                        for(User x : jd.getAllUsers())
                        {
                            if(user.getText().equals(x.getUsername()) && pass.getText().equals(x.getPassword()))
                            {                    
                                answerPanel.setVisible(false);
                                pagePanel.setVisible(false);
                                currUser = x;
                                age_input.setVisible(false);
                                name_input.setVisible(false);
                                hometown_input.setVisible(false);
                                school1.setVisible(false);//setting things visible
                                school2.setVisible(false);
                                school3.setVisible(false);
                                name.setVisible(false);
                                age.setVisible(false);
                                hometown.setVisible(false);
                                schools.setVisible(false);
                                feedback.setVisible(false);
                                createAcc.setVisible(false);
                                login.setVisible(false);

                                username.setVisible(false);
                                password.setVisible(false);
                                home();
                                //proceeds to profile page
                            }
                            else
                            {
                                feedback.setText("Wrong username or password, fool.");
                                feedback.setLocation(90,170);
                            }
                        }

                    }
                    else if(user.getText().length() ==0 || pass.getText().length()==0 
                    || age_input.getText().length() == 0 || name_input.getText().length() == 0 
                    || hometown_input.getText().length() == 0 && login.getText().equals("Done"))
                    {

                        feedback.setLocation(50,236);
                        feedback.setText("Fill out all fields idiot. Except for Schools, you're so stupid that you never went to one.");
                    }
                    else 
                    {
                        int x= 0;
                        int y=0;
                        for(User i: jd.getAllUsers())
                        {
                            if (user.getText().equals(i.getUsername()))
                            {
                                x++;
                                feedback.setText("Your username is taken");
                            }
                        }
                        for(User i : jd.getAllUsers())
                        {
                            if (user.getText().equals(i.getName()))
                            {
                                y++;
                                feedback.setText("Your name is taken");
                            }
                        }
                        if(x == 0 && y == 0)
                        {

                            schoolList[0] = school1.getText();
                            schoolList[1] = school2.getText();
                            schoolList[2] = school3.getText();
                            jd.getAllUsers().add(new User(name_input.getText(),(int)Double.parseDouble(age_input.getText()), hometown_input.getText(),schoolList,user.getText(),pass.getText()));
                            currUser = jd.getAllUsers().get(jd.getAllUsers().size()-1);
                            answerPanel.setVisible(false);
                            pagePanel.setVisible(false);
                            age_input.setVisible(false);
                            name_input.setVisible(false);
                            hometown_input.setVisible(false);
                            school1.setVisible(false);//setting things visible
                            school2.setVisible(false);
                            school3.setVisible(false);
                            name.setVisible(false);
                            age.setVisible(false);
                            hometown.setVisible(false);
                            schools.setVisible(false);
                            feedback.setVisible(false);
                            createAcc.setVisible(false);
                            login.setVisible(false);
                            createAcc.setVisible(false);
                            username.setVisible(false);
                            password.setVisible(false);
                            home();
                        }//proceed to profile page
                    }
                }
            });

        createAcc.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    age_input.setVisible(true);
                    name_input.setVisible(true);
                    hometown_input.setVisible(true);
                    school1.setVisible(true);//setting things visible
                    school2.setVisible(true);
                    school3.setVisible(true);
                    name.setVisible(true);
                    age.setVisible(true);
                    hometown.setVisible(true);
                    schools.setVisible(true);
                    feedback.setLocation(125, 236);
                    feedback.setText("Create Your Account");
                    createAcc.setVisible(false);
                    login.setText("Done");
                    login.setLocation(100,300);
                }
            });
        getAFriend.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    if(currUser.suggestAFriend() == null)
                    {
                        feedback.setText("404 error no friends found");
                    }
                    else
                    {
                        currUser.getFriendsList().add(currUser.suggestAFriend());
                    }
                    //takes suggested friend from suggestAFriend method and adds them to friendsList
                    //if no one is suggested 404 error
                }
            });

        logout.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    currUser = null;
                    loginPage();
                    answerPanel.setVisible(true);
                    pagePanel.setVisible(false);
                    user.setVisible(true);
                    pass.setVisible(true);
                }

            });   
        back.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    pagePanel.setVisible(false);
                    home();
                }

            });
        goToMsg.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    message();
                }

            });   
        goToFriends.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    pagePanel.setVisible(true);
                    friendsPage();
                }

            });

        // friendsList should be printed 

        /*clearAllBtn.addActionListener(new ActionListener()
        {
        private void actionPerformed(ActionEvent arg0)
        { 
        input1.setText("");
        input2.setText("");
        answerField.setText("");
        input1.requestFocusInWindow();
        }
        }); */

        /*user.addKeyListener(new KeyAdapter()
        {
        private void keyPressed(KeyEvent ke)
        {
        if(!(ke.getKeyChar()==27||ke.getKeyChar()==65535))//this section will execute only when user is editing the JTextField
        {
        answerField.setText("");
        }
        }
        }); */

        //         //Maps Up Arrow to AnswerBtn, USE UP ARROW AS ENTER KEY
        //         answerBtn.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        //         put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_UP,0), "UpArrow_pressed");
        //         answerBtn.getActionMap().put("UpArrow_pressed", answerPressed);

    }

    public void friendsPage()
    {
        back.setVisible(true);
        addFriend.setVisible(true);
        getAFriend.setVisible(true);
        unfriend.setVisible(true);
        pagePanel.setVisible(true);
        feedback.setVisible(true);
        goToMsg.setVisible(false);
        goToFriends.setVisible(false);
        feedback.setLocation(130,170);
        feedback.setForeground(Color.WHITE);
        System.out.println("\f");
        for(User x:currUser.getFriendsList())
        {
            System.out.println(x+"\n");
        }
        feedback.setText("Press Add Friends to add the name of the person in the left text field, and press Unfriend to unfriend the name of the person in the right text field.");
        addFriend.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    int b = 0;
                    for (User x : jd.getAllUsers())
                    {
                        if (x.getName().equals(addInput.getText()))
                        {
                            if(currUser.addFriend(x))
                            {
                                System.out.print("\f");
                                for(User c:currUser.getFriendsList())
                                {
                                    System.out.println(c+"\n");
                                }
                                feedback.setText("Success adding");
                                b = 10;
                            }
                        }

                    }
                    if(b !=10)
                    {
                        for(User c:currUser.getFriendsList())
                        {
                            System.out.println(c+"\n");
                        }
                    }
                }
            });
        getAFriend.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    if(currUser.suggestAFriend() == null)
                    {
                        feedback.setText("404 error no friends found");
                    }
                    else
                    {
                        currUser.getFriendsList().add(currUser.suggestAFriend());

                        System.out.print("\fSuggested friend added.\n");
                        for(User c:currUser.getFriendsList())
                        {
                            System.out.println(c+"\n");
                        }
                    }
                    //takes suggested friend from suggestAFriend method and adds them to friendsList
                    //if no one is suggested 404 error
                }
            });
        unfriend.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                { 
                    int b = 0;
                    ArrayList<User> n = currUser.getFriendsList();
                    for (int x = 0; x < n.size(); x++)
                    {
                        if (n.get(x).getName().equals(unInput.getText()))
                        {
                            currUser.unfriend(n.get(x).getName());
                            x=n.size();
                        }
                        if(currUser.getFriendsList().size() > 0)
                        {
                            for(User c:currUser.getFriendsList())
                            {
                                System.out.println(c+"\n");
                            }
                            System.out.print("\fUnfriended " + unInput.getText());
                            b=10;
                        }
                        else 
                            {System.out.print("\fUnfriended " + unInput.getText());
                            b=10;}
                    }
                    if(b !=10)
                    {
                        feedback.setText("That person isnt on your list.");

                    }
                }

            });
    }

    public void loginPage()
    {
        System.out.print("\f");
        frame.getContentPane().setBackground(Color.red);
        login.setBackground(Color.white);  
        login.setText("Login");
        createAcc.setBackground(Color.white);   
        createAcc.setText("Create New Account");
        createAcc.setVisible(true);

        login.setSize(100,50);
        login.setLocation(130, 120);
        feedback.setText("Please Login");
        returnToLogin.setBackground(Color.white);
        returnToLogin.setVisible(false);
        returnToLogin.setSize(100,50);
        returnToLogin.setLocation(87,400);
        returnToLogin.setVisible(false);
        createAcc.setSize(200,50);
        createAcc.setLocation(87, 208);

        username.setSize(70,50);
        username.setLocation(27, 10);
        username.setForeground(Color.WHITE);

        password.setSize(70,50);
        password.setLocation(27, 37);
        password.setForeground(Color.WHITE);

        feedback.setSize(900,20);
        feedback.setLocation(140, 93);
        feedback.setForeground(Color.BLACK);

        name.setSize(70,50);
        name.setLocation(27, 64);
        name.setForeground(Color.WHITE);
        name.setVisible(false);

        age.setSize(70,50);
        age.setLocation(27, 91);
        age.setForeground(Color.WHITE);
        age.setVisible(false);

        hometown.setSize(70,50);
        hometown.setLocation(27, 108);
        hometown.setForeground(Color.WHITE);
        hometown.setVisible(false);

        schools.setSize(70,50);
        schools.setLocation(27, 135);
        schools.setForeground(Color.WHITE);
        schools.setVisible(false);

        //setting visible jtextfields
        age_input.setVisible(false);
        name_input.setVisible(false);
        hometown_input.setVisible(false);
        school1.setVisible(false);
        school2.setVisible(false);
        school3.setVisible(false);
        //making stuff from friends and messages disappear
        friendsPanel.setVisible(false);
        back.setVisible(false);
        logout.setVisible(false);
        unfriend.setVisible(false);
        addFriend.setVisible(false);
        getAFriend.setVisible(false);
        goToMsg.setVisible(false);
        goToFriends.setVisible(false);
        //setting visible jtextfields
        age_input.setVisible(false);
        name_input.setVisible(false);
        hometown_input.setVisible(false);
        school1.setVisible(false);
        school2.setVisible(false);
        school3.setVisible(false);
        answerPanel.setVisible(true);
        pagePanel.setVisible(false);
        username.setVisible(true);
        password.setVisible(true);
        feedback.setVisible(true);
        user.setVisible(true);
        pass.setVisible(true);
        pagePanel.setVisible(false);
        login.setVisible(true);
        createAcc.setVisible(true);
        //setting and adding answerPanel
        user.requestFocusInWindow();
    } 

    public void home()
    {
        inputField.setText("");
        feedback.setVisible(false);
        System.out.print("\fNew Messages:");
        for(String c:currUser.getMsgs())
        {
            System.out.print(c);
        }
        friendsPanel.setVisible(false);
        goToMsg.setVisible(true);
        goToFriends.setVisible(true);
        logout.setVisible(true);
        back.setVisible(false);
        addFriend.setVisible(false);
        getAFriend.setVisible(false);
        pagePanel.setVisible(false);
        unfriend.setVisible(false);

    }

    public void message()
    {
        goToMsg.setVisible(false);
        goToFriends.setVisible(false);
        back.setVisible(true);
        friendsPanel = new JPanel();
        friendsPanel.setSize(200,1000);
        friendsPanel.setLocation(87, 25);
        friendsPanel.setBackground(Color.red);
        frame.add(friendsPanel);
        friendsPanel.setVisible(true);
        feedback.setVisible(true);
        feedback.setText("Send a message by typing it in the text field then pressing the name of the person.");
        toMsg = new ArrayList<JButton>();
        pagePanel.setVisible(false);
        for(int n = 0; n < currUser.getFriendsList().size(); n++)
        {
            toMsg.add(new JButton(currUser.getFriendsList().get(n).getName()));
            friendsPanel.add(toMsg.get(n));
        }
        friendsPanel.add(inputField);
        friendsPanel.setVisible(false);
        friendsPanel.setVisible(true);
        for(JButton b : toMsg)
        {
            b.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent arg0)
                    {

                        for(User x : currUser.getFriendsList())
                        {
                            if(inputField.getText().length() > 0 && x.getName().equals(b.getText()))
                            {
                                x.addMsgs("\n"+inputField.getText() + " - " + currUser.getName()+ "\n");
                            }
                        }
                        System.out.print("\fMessage Sent");
                    }
                });
        }

    }

    /***Takes JTextField and returns
     *  value of text in JTextField***/

    private static double convertToDouble(JTextField jtf)
    {
        String hold = jtf.getText();
        double returnDouble = Double.parseDouble(hold);
        return returnDouble;
    }
    //ALL METHODS BELOW DO NOT DO ANYTHING, THEY ARE ONLY PRESENT BECAUSE THE METHODS ARE ABSTRACT
    /***Method is required only because actionPerformed
     *  is an abstract method in ActionListener***/
    public void actionPerformed(ActionEvent e){}

    /***Method is required only because keyPressed
     *  is an abstract method in KeyListener***/
    public void keyPressed(KeyEvent e){}

    /***Method is required only because keyReleased
     *  is an abstract method in KeyListener***/
    public void keyReleased(KeyEvent e){}

    /***Method is required only because keyTyped
     *  is an abstract method in KeyListener***/
    public void keyTyped(KeyEvent e){}

    //FINALLY, THE MAIN!!!
    public static void main(String[] args)
    {
        new Interface();
    }

}//END CLASS