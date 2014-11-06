package myPackage;

import java.net.ServerSocket;
import java.net.Socket;
import myPackage.HttpRequest;

public class WebServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Set the port number.
		int port = 6789;
		
		// Establish the listen socket.
		ServerSocket welcomeSocket = new ServerSocket(port);
		
		// Process HTTP service requests in an infinite loop.
		while (true) {
			// Listen for a TCP connection request.
			Socket connectionSocket = welcomeSocket.accept();
			
			// Construct an object to process the HTTP request message.
			HttpRequest request = new HttpRequest(connectionSocket);
			
			// Create a new thread to process the request.
			Thread thread = new Thread(request);

			// Start the thread.
			thread.start();
			
			// obfusticated code
			// new Thread(HttpRequest(welcomeSocket.accept())).start;

		}
		





	}

}
