package graphic.test;

import graphic.Message;
import graphic.Pos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",9990);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            Pos pos = new Pos(3,3);
            out.writeObject(pos);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
