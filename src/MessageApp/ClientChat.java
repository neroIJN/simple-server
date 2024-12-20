package MessageApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    static int PORT = 9999;
    public static void main(String[] args) throws IOException {
        System.out.println("\t\t Simple Client");
        System.out.println("\t\t ====================");

        var scannerInput = new Scanner(System.in);
        String input,output;


        // Get the local host's IP address
        var ipAddress = InetAddress.getLocalHost();
        // Create a socket and connect to the server at the specified port
        var socket = new Socket(ipAddress,PORT);

        var out = new PrintWriter(socket.getOutputStream(),true);
        var in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));

        try{
            while (true){
                input = in.readLine();
                System.out.println("Server Says "+ input );

                System.out.println("Server :");
                output = scannerInput.nextLine();
                out.println(output);
            }
        }
        finally {
            out.close();
            in.close();
            socket.close();
        }
    }
}
