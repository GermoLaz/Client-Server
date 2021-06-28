package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int portNumber;

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true){
            //espera se conecte algun cliente
            Socket clientSocket = serverSocket.accept();

            Thread cThread = new Thread(()-> {
                try {
                    try (
                            PrintWriter out =
                                    new PrintWriter(clientSocket.getOutputStream(), true);
                            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(clientSocket.getInputStream()))
                    ){
                        String inputLine, outputLine;

                        // Initiate conversation with client
                        Protocol protocol = new Protocol();
                        outputLine = protocol.input(null);//-> recibo un string y devuelvo un string
                        out.println(outputLine);
                        System.out.println("\u001B[31mServidor >>> "+ outputLine);

                        while ((inputLine = in.readLine()) != null) {
                            System.out.println("\u001B[32mCliente >>>\u001B[0m"+ inputLine);
                            outputLine = protocol.input(inputLine);
                            out.println(outputLine);
                            System.out.println("\u001B[31mServidor >>> "+ outputLine);
                            if (inputLine.equals("x") || outputLine.equals("x")){

                                break;
                            }
                        }
                    }
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            });
            cThread.start();
        }
    }
}
