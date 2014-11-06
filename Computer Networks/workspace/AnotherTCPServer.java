import java.io.*;
import java.net.*;

class TCPServer implements Runnable {

	public Socket connectionSocket;

	public TCPServer(Socket s) {
		connectionSocket = s;
	}
  public void run() {
        String clientSentence;
      String capitalizedSentence;
      try {
           BufferedReader inFromClient =
             new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
System.out.println(inFromClient.readLine());
      }
      catch (Exception E)
      {}
        }
}

class AnotherTCPServer {
  public static void main(String argv[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);
      while(true) {
             Socket connectionSocket = welcomeSocket.accept();
	     Thread Server = new Thread(new TCPServer(connectionSocket));
	     System.out.println(Server.getName());
	     Server.start();
      }
  }

}

