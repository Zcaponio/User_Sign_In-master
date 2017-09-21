package home;
;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Zack on 2017-09-20.
 */
public class UserDB {


    private static ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        UserDB.users = users;
    }
}