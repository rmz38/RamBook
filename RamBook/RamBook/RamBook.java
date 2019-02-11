import java.util.*;

public class RamBook
{
    //INSTANCE FIELD
    private ArrayList<User> allUsers;


    //CONSTRUCTOR
    public RamBook()
    {
        allUsers = new ArrayList<User>();
        
         //Add Users (Info only, no friends in friendsList yet)
        allUsers.add(new User("Ben", 20, "Syracuse", new String[]{"JDHS", "SU", null}, "", "b"));
        allUsers.add(new User("Maya", 21, "Los Angeles", new String[]{"Beverly Hills High", "UCLA", "USC"}, "", "m"));
        allUsers.add(new User("Brendan", 30, "DeWitt", new String[]{"JDHS", "Rutgers", null}, "", "br"));
        allUsers.add(new User("Willa", 43, "Cleveland", new String[]{null, null, null}, "", "w"));
        allUsers.add(new User("Jeff", 68, "NYC", new String[]{"PS999", "NYU", null}, "", "j"));
        allUsers.add(new User("Kangbo", 16, "Syracuse", new String[]{"FM", "LeMoyne", "University of Phoenix"}, "", "k"));
        allUsers.add(new User("Everett", 50, "NYC", new String[]{"PS101", "NYU", null}, "", "e"));
        allUsers.add(new User("Rose", 66, "Los Angeles", new String[]{"MBHS", null, null}, "", "r"));
        allUsers.add(new User("Colin", 22, "Cincinnati", new String[]{"Bengal HS", "Ohio St.", null}, "", "c"));
        allUsers.add(new User("Albert", 28, "Los Angeles", new String[]{"LA HS", "UCSB", "Stanford"}, "", "a"));
        allUsers.add(new User("Muhammad", 39, "Syracuse", new String[]{"Corcoran", "Oneonta", "Stanford"}, "", "mu"));
        allUsers.add(new User("Hayden", 19, "Syracuse", new String[]{"Corcoran", null, null}, "", "ha"));
        allUsers.add(new User("Max", 20, "Syracuse", new String[]{"Corcoran", "SU", null}, "", "ma"));
        allUsers.add(new User("Anthony", 21, "Los Angeles", new String[]{"Beverly Hills High", "UCLA", "USC"}, "", "a"));
        allUsers.add(new User("Owen", 30, "DeWitt", new String[]{"F-P", null, null}, "", "o"));
        allUsers.add(new User("Rebecca", 39, "Syracuse", new String[]{"Marcellus HS", "Bucknell U", "Binghamton U"}, "", "re"));

        
        
        //Randomly Generate Friends
        for (int x=0; x < allUsers.size(); x++)
        {
            int friends = (int)(Math.random()*allUsers.size());
            ArrayList<User> addList = new ArrayList<User>();
            
            
            for (int i = 0; i < friends; i++)
            {
                User u = allUsers.get((int)(Math.random()*allUsers.size()));
                if (!addList.contains(u) && !u.equals(allUsers.get(x)))
                {    
                    addList.add(u);
                }
            }
            
            allUsers.get(x).bulkAddFriends(addList);
            
        }
        
        
    }//END CONSTRUCTOR
    public ArrayList<User> getAllUsers()
    {
        return allUsers;
    }
    public User addUser(User x)
    {
        allUsers.add(x);
        return x;
    }
    // Prints out all the users
    public void printAllUsers()
    {
        for (User u : allUsers)
        {   
            System.out.println(u);
           
        }
    }//END printUsers
        
    
    
    
}//END CLASS