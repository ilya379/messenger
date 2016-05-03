package arhangel.dim.lections.socket;

import arhangel.dim.core.messages.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;


/**
 * Обработка подключений
 */
public class Server {

    public static final int PORT = 19000;

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);

            System.out.println("Started, waiting for connection");

            Socket socket = serverSocket.accept();

            System.out.println("Accepted. " + socket.getInetAddress());

            try (
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                String inputLine;
                String outputLine;

                final byte[] buf = new byte[1024 * 64];
                //log.info("Starting listener thread...");
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        // Здесь поток блокируется на ожидании данных
                        /*int read = in.read(buf);

                        if (read > 0) {
                            inputLine = new String(buf, 0 ,read);
                            System.out.println("Принял: " + inputLine);

                            out.write(("HAHA "+ inputLine).getBytes());
                            if (inputLine.equals("Bye."))
                                break;

                        } else
                            System.out.println("Nothing to read: "+ read);*/
                        inputLine = (String) in.readObject();
                        System.out.println("Принял: " + inputLine);
                        out.writeObject(inputLine+ "haha");
                        if (inputLine.equals("Bye."))
                            break;
                    } catch (Exception e) {
                        //log.error("Failed to process connection: {}", e);
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
                out.writeObject("Bye.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtil.closeQuietly(serverSocket);
        }
    }
}
