package Lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8189;
    private static ServerSocket server;
    private static Socket socket;
    private static Thread thread;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");
            thread = new Thread(new SocketReader(socket));
            thread.start();

            Scanner sc = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String str = sc.nextLine();
                out.println(str);
                if (str.equals("/end")) {
                    System.out.println("Server disconnected");
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            thread.interrupt();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static class SocketReader implements Runnable{
        private final Socket socket;

        private SocketReader(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            Scanner sc;
            try {
                sc = new Scanner(socket.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (true){
                String s = sc.nextLine();

                if (s.equals("/end") || Thread.currentThread().isInterrupted()) {
                    System.out.println("Server disconnected");
                    System.exit(0);
                }
                System.out.println("Client: " + s);
            }
        }
    }
}