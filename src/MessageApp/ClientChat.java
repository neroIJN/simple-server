package MessageApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientChat {
    static int PORT = 9999;
    public static void main(String[] args) throws IOException {
        System.out.println("\t\t Simple Client");
        System.out.println("\t\t ====================");

        // Get the local host's IP address
        var ipAddress = InetAddress.getLocalHost();
        // Create a socket and connect to the server at the specified port
        var socket = new Socket(ipAddress,PORT);
        System.out.println("\t\t server is connected");

        // Create a BufferedReader to read input from the server's input stream
        var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // store in the input
        String input = in.readLine();
        //print
        System.out.println("Server says:" + input);

        System.out.println("Closing the connection");
        socket.close();
        in.close();

        System.exit(0);

    }
}
