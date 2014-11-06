package pingerClient;

import java.net.InetAddress;
import java.util.Timer;

/*
 * Server to process ping requests over UDP.
 */
public class PingClient {

	public static void main(String[] args) throws Exception {

		// Get command line argument.
		if (args.length != 2) {
			System.out.println("Required arguments: host and port");
			return;
		}
		String host = args[0];
		int port = Integer.parseInt(args[1]);

		System.out.println("Ping " + InetAddress.getByName(host).toString()
				+ ".");

		Timer timer = new Timer();
		PingSender p = new PingSender(host, port);
		timer.schedule(p, 0, 1000);
	}
}