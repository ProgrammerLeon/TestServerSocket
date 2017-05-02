import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Created by Leon on 2017/5/2.
 */
public class CharSocket extends Thread {
    Socket socket;
    public CharSocket(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            int count = 0;
            while (true){
                bufferedWriter.write("loop:"+count);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
