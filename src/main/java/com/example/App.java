package com.example;

import java.io.*;
import java.net.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            // accendo il server
            ServerSocket serverSocket = new ServerSocket(3000);

            // metto in ascolto
            Socket client = serverSocket.accept();
            BufferedReader inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String stringRicevuta = inDalClient.readLine();

            // invio al client
            String daRitornare = stringRicevuta.toUpperCase();
            DataOutputStream outVersoClient = new DataOutputStream(client.getOutputStream());
            outVersoClient.writeBytes(daRitornare+"\n");
            
            System.out.println("ritornato : " + daRitornare);
            serverSocket.close();
            client.close();
        } catch (Exception e) {
            System.out.println("Errore");
        }
    }
}
