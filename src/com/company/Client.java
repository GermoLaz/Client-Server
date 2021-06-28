package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final String hostName;
    private final int portNumber;

    public Client(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }
    public void run() throws IOException {
        Socket serverSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));

        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("\u001B[31mServidor >>> " + inputLine);
            outputLine = systemIn.readLine();

            if (outputLine != null) {
                out.println(outputLine);
            }

            if (outputLine.equals("x") || inputLine.equals("x")) {
                inputLine = in.readLine();
                System.out.println("\u001B[31mServidor >>> " + inputLine);
                break;
            }
        }
        serverSocket.close();
    }
}
