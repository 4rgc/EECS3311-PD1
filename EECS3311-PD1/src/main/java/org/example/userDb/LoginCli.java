package org.example.userDb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginCli {
    private static String readLine() throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String input = "";
        while (input.length() < 1) {
            System.out.print(">");
            input = reader.readLine();
        }
        return input;
    }

    public static void main(String[] args) {
        ISingleTableDatabase<IUser> db = new UserSingleTableDatabase(
                new LocalJsonTableDataSourceFactory(
                        "src/main/resources/userdb.json"
                )
        );

        String username, password;

        System.out.print("Enter your username: ");

        try{
            username = readLine();
        } catch(IOException e) {
            System.out.println("Exception when reading username: " + e.getMessage());
        }

        System.out.print("Enter your password: ");

        try{
            password = readLine();
        } catch(IOException e) {
            System.out.println("Exception when reading password: " + e.getMessage());
        }
    }
}
