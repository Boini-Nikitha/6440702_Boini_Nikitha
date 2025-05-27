package TCP;

import java.io.*;
import java.net.*;

public class Client {
public static void main(String[] args) throws Exception {
Socket socket = new Socket("localhost", 12345);
System.out.println("Connected to server!");

    BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    String clientMsg, serverMsg;

    while (true) {
        System.out.print("Client: ");
        clientMsg = keyboard.readLine();
        outToServer.println(clientMsg);

        if (clientMsg.equalsIgnoreCase("exit")) {
            System.out.println("Disconnected from server.");
            break;
        }

        serverMsg = inFromServer.readLine();
        System.out.println("Server: " + serverMsg);
    }

    socket.close();
}
}