package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int portNumber = Integer.parseInt(args[0]);

        Server server = new Server(portNumber);
        try {
            server.startConversation();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
