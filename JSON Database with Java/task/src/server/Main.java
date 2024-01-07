package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    static String[] dataBase = new String[100];
    static Scanner scanner = new Scanner(System.in);

    static String address = "127.0.0.1";
    static int port = 23456;


    static void menue() {
        String input = scanner.nextLine();
        if (!input.equals("exit")) {
            String[] inputElements = input.split(" ", 3);
            String command = inputElements[0];
            int index = Integer.parseInt(inputElements[1]);
            switch (command) {
                case "get":
                    System.out.println(get(index));
                    menue();
                    break;
                case "delete":
                    System.out.println(delete(index));
                    menue();
                    break;
                case "set":
                    String text = inputElements[2];
                    System.out.println(set(index, text));
                    menue();
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address));
        System.out.println("Server started!");
        Socket socket = server.accept();
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output  = new DataOutputStream(socket.getOutputStream());
        System.out.println("Received: " + input.readUTF());


        output.writeUTF("A record # 12 was sent!");
        System.out.println("Sent: A record # 12 was sent!");



        menue();


    }

    static String get(int index) {
        if (index >= 1 && index <= 100) {
            if (dataBase[index - 1] == null) {
                return "ERROR";
            }
            return dataBase[index - 1];
        }
        return "ERROR";
    }

    static String delete(int index) {
        if (index >= 1 && index <= 100) {
            dataBase[index - 1] = null;
            return "OK";
        }
        return "ERROR";
    }

    static String set(int index, String text) {
        if (index >= 1 && index <= 100) {
            dataBase[index - 1] = text;
            return "OK";
        }
        return "ERROR";
    }
}
