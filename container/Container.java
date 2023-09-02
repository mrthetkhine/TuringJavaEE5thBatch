import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Client extends Thread
{
    Socket socket;
    Client(Socket socket)
    {
        this.socket = socket;
        
    }
    public void run()
    {
        System.out.println("Process client");
        try
        {
            String response = "<h1>Hello</h1>";
            DataOutputStream out = new DataOutputStream(this.socket.getOutputStream());
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write(("Content-Length:"+response.length()+"\r\n\r\n").getBytes());
            out.write(response.getBytes());
            out.flush();
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
public class Container
{

    static int PORT = 8080;
    ServerSocket socket;

    Container()throws Exception
    {
        this.socket = new ServerSocket(PORT);

    }
    void start()throws Exception
    {
        while(true)
        {
            Socket clientSocket = this.socket.accept();
            Client client = new Client(clientSocket);
            client.start();
        }
    }
    public static void main(String[]args)throws Exception
    {
        System.out.println("Container run");
        new Container().start();
    }   
}