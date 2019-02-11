import java.util.*;

public class User
{
    //INSTANCE FIELDS
    private String name;
    private int age;
    private String hometown;
    private String[] schools;
    private ArrayList<User> friendsList;
    private String username;
    private String password;
    private ArrayList<String> messages;
    //CONSTRUCTOR - DONE FOR YOU
    //NOTE - it leaves the friendsList empty
    public User(String n, int a, String h, String[] s,String u,String p)
    {
        name = n;
        age = a;
        hometown = h;
        schools = s;
        if(schools[0] == null || schools[0].equals(""))
        {
            schools[0] = "None";
        }
        if(schools[1] == null || schools[1].equals(""))
        {
            schools[1] = "None";
        }
        if(schools[2] == null || schools[2].equals(""))
        {
            schools[2] = "None";
        }
        friendsList = new ArrayList<User>(); 
        username = u;
        password = p;
        messages = new ArrayList<String>();
        messages.add("");
    }//END Constructor

    // DONE FOR YOU
    // Accepts a List of Users that will replace the current friendsList
    public void bulkAddFriends(ArrayList<User> u)
    {
        friendsList = u;
    }//END bulkAddFriends

    // STARTED FOR YOU
    // Should print out all information for the user, nicely formatted
    public String toString()
    {
        String retStr = "";
        retStr += "Name: \t\t" + name + "\n";
        retStr += "Age: \t\t" + age + "\n";
        retStr += "Hometown: \t" + hometown + "\n";

        //Need to include schools and friendslist
        retStr += "Schools: \t" + getSchools() + "\n";
        retStr += "Friends: \t" + getFriends();

        return retStr;
    }//END toString

    // DONE FOR YOU
    // Returns the User's name
    public String getName()
    {
        return name;
    }//END getName
    public void setName(String n)
    {
        name = n;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int a)
    {
        age = a;
    }

    public String getHometown()
    {
        return hometown;  
    }

    public void setHometown(String h)
    {
        hometown = h;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getSchools()
    {
        String r = schools[0] + ", ";
        r += schools[1] + ", ";
        r += schools[2];
        return r;
    }

    public void setSchools(String one,String two, String three)
    {
        schools[0] = one;
        schools[1] = two;
        schools[2] = three;
    }

    public String getFriends()
    {
        String re = "";
        for (User x : friendsList)
        {
            re += x.getName() + ", ";
        }
        if(re.length() > 2)
        {
            return re.substring(0, re.length() - 2);
        }
        return "None";
    }

    public ArrayList<String> getMsgs()
    {
        return messages;

    }

    public void addMsgs(String msg)
    {
        messages.add(msg);
    }

    public ArrayList<User> getFriendsList()
    {
        return friendsList;
    }

    public void unfriend(String name)
    {
        for (int x = 0; x < friendsList.size(); x++)
        {
            if (friendsList.get(x).getName().equals(name))
            {
                friendsList.remove(x);
                x--;
            }
        }
    }

    public boolean equals(User other)
    {
        if(name.equals(other.name) && age == other.age && hometown.equals(other.hometown))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean addFriend(User friend)
    {
        if(friend.equals(this) || friend == null)
        {
            System.out.print("\fThat person is either yourself, or someone that doesn’t exist,soz buddy.");
            return false;
        }
        if(friendsList.contains(friend) == false)
        {
            friendsList.add(friend);
            return true;
        }
        else
        {
            System.out.print("\fThey're already on your list\n");
            return false;
        }

    }

    public int countFriends()
    {
        return friendsList.size();
    }

    public ArrayList<User> getMutualFriends(User other)
    {
        ArrayList<User> mutuals = new ArrayList<User>();
        for (User y : friendsList)
        {
            for (User z : other.friendsList)
            {
                if(y.equals(z))
                {
                    mutuals.add(y);
                }
            }
        }
        return mutuals;
    }

    public ArrayList<User> getSchoolmates()
    {
        ArrayList<User> schoolmates = new ArrayList<User>();
        for (User q : friendsList)
        {
            if(q.schools[0].equals(this.schools[0]) || q.schools[1].equals(this.schools[1]) || q.schools[2].equals(this.schools[2]))
            {
                schoolmates.add(q);
            }
        }
        return schoolmates;
    }

    public ArrayList<User> getHometownFriends()
    {
        ArrayList<User> homeTown = new ArrayList<User>();
        for (User x : friendsList)
        {
            if(x.hometown.equals(hometown))
            {
                homeTown.add(x);
            }
        }
        return homeTown;
    }

    public User suggestAFriend()
    {
        int chosen = 0;
        ArrayList<User> eligible = new ArrayList<User>();
        ArrayList<User> errorNotFound = new ArrayList<User>();
        for(User x : friendsList)
        {
            for(User i : x.friendsList)
            {
                if((!i.equals(this)) && i.hometown.equals(hometown) && (!(friendsList.contains(i))))
                {
                    eligible.add(i);
                }
            }
        }
        if(eligible.size() > 0)
        {
            chosen = (int)(Math.random() * eligible.size());
            return eligible.get(chosen);
        }
        else
        {
            for(User d : friendsList)
            {
                for (User g : d.friendsList)
                {
                    if((!g.equals(this)) && (!(friendsList.contains(g))))
                        errorNotFound.add(g);
                }
            }
            if(errorNotFound.size() > 0)
            {
                chosen = (int)(Math.random() * errorNotFound.size());
                return errorNotFound.get(chosen);
            }
        }
        return null;
    }
    
}//END CLASS
