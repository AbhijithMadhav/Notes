package mailUserAgent;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetSocketAddress;

/**
 * Open an SMTP connection to a mailserver and send one mail.
 * 
 */
public class SMTPConnection {
	/* The SSL socket to the server */
	private SSLSocket connection;

	/* Streams for reading and writing the socket */
	private BufferedReader fromServer;
	private DataOutputStream toServer;

	private static final int SMTP_PORT = 465;
	private static final String CRLF = "\r\n";

	/* Are we connected? Used in close() to determine what to do. */
	private boolean isConnected = false;

	/*
	 * Create an SMTPConnection object. Create the socket and the associated
	 * streams. Initialize SMTP connection.
	 */
	public SMTPConnection(Envelope envelope) throws IOException {
		SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory
				.getDefault();
		
		connection = (SSLSocket) sslSocketFactory.createSocket();
		connection.setUseClientMode(true);
		System.out.println("connecting...");
		connection.connect(new InetSocketAddress(envelope.DestAddr, SMTP_PORT));
		fromServer = new BufferedReader(new InputStreamReader(connection
				.getInputStream()));
		toServer = new DataOutputStream(connection.getOutputStream());

		/*
		 * Read a line from server and check that the reply code is 220. If not,
		 * throw an IOException.
		 */
		System.out.println("Waiting for reply from server...");
		String reply = fromServer.readLine();
		System.out.println("Reply: " + reply + "\n");
		System.out.flush();
		if (!reply.trim().startsWith("220")) {
			System.out.println("220 not recieved");
			System.out.flush();
			throw new IOException();
		}

		/*
		 * SMTP handshake. We need the name of the local machine. Send the
		 * appropriate SMTP handshake command.
		 */
		sendCommand("EHLO" + CRLF, 250);
		sendCommand("AUTH LOGIN", 334);
		sendCommand("YnJvd3NlYW5kZG93bmxvYWRAZ21haWwuY29t", 334);
		sendCommand("cXdlcnR5XzEy", 235);
		isConnected = true;
	}

	/*
	 * Send the message. Write the correct SMTP-commands in the correct order.
	 * No checking for errors, just throw them to the caller.
	 */
	public void send(Envelope envelope) throws IOException {
		/*
		 * Send all the necessary commands to send a message. Call sendCommand()
		 * to do the dirty work. Do _not_ catch the exception thrown from
		 * sendCommand().
		 */
		System.out.println("Writing headers");
		System.out.flush();
		sendCommand("MAIL FROM: " + envelope.Sender + CRLF, 250);
		sendCommand("RCPT TO: " + envelope.Recipient + CRLF, 250);
		sendCommand("DATA" + CRLF, 354);
		toServer.writeBytes(envelope.Message.Body + CRLF);
		sendCommand("." + CRLF, 250);
	}

	/*
	 * Close the connection. First, terminate on SMTP level, then close the
	 * socket.
	 */
	public void close() {
		isConnected = false;
		try {
	//		sendCommand("QUIT" + CRLF, 221);
			connection.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			isConnected = true;
		}
	}

	/*
	 * Send an SMTP command to the server. Check that the reply code is what is
	 * is supposed to be according to RFC 821.
	 */
	private void sendCommand(String command, int rc) throws IOException {
		/* Write command to server and read reply from server. */
		toServer.writeBytes(command + CRLF);
		System.out.print("Command: " + command);
		String reply = fromServer.readLine();
		System.out.println("Reply(1): " + reply);
		System.out.flush();
		int i = 2;
		while (command.equalsIgnoreCase("EHLO") && i < 6) {
			reply = fromServer.readLine();
			System.out.println("Reply(" + i + "): " + reply);
			System.out.flush();
			i++;
		}
		

		/*
		 * Check that the server's reply code is the same as the parameter rc.
		 * If not, throw an IOException.
		 */
		if (!reply.trim().startsWith(Integer.toString(rc))) {
			System.out.println("Invalid response code: " + reply.trim().substring(0, 3) + ", Expected: " + rc);
			throw new IOException();
		}
		System.out.println("Finished sending command\n");
	}

	/* Parse the reply line from the server. Returns the reply code. */
	private int parseReply(String reply) {
		return Integer.parseInt(new StringTokenizer(reply).nextToken());
	}

	/* Destructor. Closes the connection if something bad happens. */
	protected void finalize() throws Throwable {
		if (isConnected) {
			close();
		}
		super.finalize();
	}

}
