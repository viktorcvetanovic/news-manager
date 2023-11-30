package org.newsmanager.util;

import org.newsmanager.data.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class FileParser {

    public static User parseUser() {
        InputStream is = FileParser.class.getClassLoader().getResourceAsStream("UsernameAndPassword.txt");
        String data = "";
        Scanner myReader = new Scanner(is);
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();

        return new User(data.split(",")[0], data.split(",")[1]);
    }

}
