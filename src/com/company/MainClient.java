package com.company;

import java.io.IOException;
import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String hostName = in.nextLine();
        int portNumber = in.nextInt();

        Client client = new Client(hostName, portNumber);
        try {
            client.run();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
