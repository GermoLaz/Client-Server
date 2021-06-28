package com.company;

import com.company.Client;
import java.io.IOException;
import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) {
        Boolean flag = true;
        String hostName;
        int portNumber;
        while(flag)
        try {
            flag=false;
            Scanner in = new Scanner(System.in);
            System.out.println("Ingrese Host->");
            hostName = in.nextLine();
            System.out.println("Ingrese Puerto->");
            portNumber = in.nextInt();
            Client client = new Client(hostName, portNumber);
            client.run();
        }catch (IOException e){
            flag = true;
            System.out.println("\u001B[31m Datos de Host o Puerto invalidos, intente nuevamente \u001B[0m");
        }
    }
}
