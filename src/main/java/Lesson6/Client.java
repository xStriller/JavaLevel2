package Lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8189;
    private static Socket socket;
    private static Thread thread;
    public static void main(String[] args) {

        try {
            socket = new Socket("localhost", PORT);
            thread = new Thread(new SocketReader(socket));
            thread.start();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String s = scanner.nextLine();
                out.println(s);
                if (s.equals("/end")) {
                    System.out.println("Client disconnected");
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
                    System.out.println("Client disconnected");
                    System.exit(0);
                }
                System.out.println("Server: " + s);
            }
        }
    }
}