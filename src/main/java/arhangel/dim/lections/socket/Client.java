package arhangel.dim.lections.socket;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.net.Socket;

/**
 * Клиентская часть
 */
public class Client {

    public static final int PORT = 19000;
    public static final String HOST = "localhost";

    public static void main(String[] args) {

        BufferedReader stdIn =
                new BufferedReader(
                        new InputStreamReader(System.in));
        Socket socket = null;
        try {
            socket = new Socket(HOST, PORT);
            socket.getOutputStream();
            socket.getOutputStream();
            try (
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    InputStream in = socket.getInputStream()) {

                String inputLine;
                String outputLine;

                out.writeObject("Hello");

                final byte[] buf = new byte[1024 * 64];
                //log.info("Starting listener thread...");
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        // Здесь поток блокируется на ожидании данных
                        int read = in.read(buf);
                        if (read > 0) {
                            inputLine = new String(buf, 0 ,read);

                            System.out.println("Client received: "+ inputLine);
                            String fromUser = stdIn.readLine();
                            if (fromUser != null && !fromUser.equals("")) {

                                System.out.println("Client: " + fromUser);
                                out.writeObject(fromUser);
                            }

                        }
                    } catch (Exception e) {
                        //log.error("Failed to process connection: {}", e);
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
            // exit, failed to open socket
        } finally {
            IoUtil.closeQuietly(socket);
        }
    }



}
