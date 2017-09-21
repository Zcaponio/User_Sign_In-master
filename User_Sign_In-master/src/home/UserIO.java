package home;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Zack on 2017-09-20.
 */
public class UserIO {

    public static void writeUsers(ArrayList<User> user) throws Exception {
        try {
            ObjectOutputStream output = new ObjectOutputStream((new FileOutputStream("Users.dat")));
            output.writeObject(user);
            output.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object readUsers(ArrayList<User> users) throws Exception {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("Users.dat"));
        return input.readObject();
    }
}