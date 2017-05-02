import javax.swing.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Leon on 2017/5/2.
 */
public class ServerListener extends Thread {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);

            while (true){
                Socket socket = serverSocket.accept();
                JOptionPane.showMessageDialog(null,"port:12345");
                //将socket传递给新的线程
                new CharSocket(socket).start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
