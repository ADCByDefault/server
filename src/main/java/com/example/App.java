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
            ServerSocket serverSocket = null;
            Socket client = null;
            while(true){

                // accendo il server
                serverSocket = new ServerSocket(3000);

                // metto in ascolto
                System.out.println("sono in ascolto");
                client = serverSocket.accept();
                BufferedReader inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String stringRicevuta = inDalClient.readLine();

                // invio al client
                String daRitornare = stringRicevuta.toUpperCase();
                DataOutputStream outVersoClient = new DataOutputStream(client.getOutputStream());
                stringRicevuta =  stringRicevuta.trim();
                if(stringRicevuta.equals("q")){
                    System.out.println(stringRicevuta);
                    outVersoClient.writeBytes("chiudo il server");
                    serverSocket.close();
                    client.close();
                    break;
                }

                outVersoClient.writeBytes(daRitornare+"\n");
                

                System.out.println("ritornato : " + daRitornare);
                serverSocket.close();
                client.close();
            }
            
        } catch (Exception e) {
            System.out.println("Errore");
        }
    }
}
