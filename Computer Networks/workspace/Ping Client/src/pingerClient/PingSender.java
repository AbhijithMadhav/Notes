package pingerClient;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.TimerTask;

class PingSender extends TimerTask {
	private static final String CRLF = "\r\n";
	private static int seqno = 0;
	private DatagramSocket clientSocket;
	private static int port;
	private static String host;
	private static int npktsRcvd = 0; // No. of packets received
	private static int npktsDrpd = 0; // No. of packets Dropped
	private static long time = 0; // sum of all rtt's
	private static long minRtt = Long.MAX_VALUE;
	private static long maxRtt = 0;

	PingSender(String host, int port) throws SocketException {
		PingSender.host = host;
		PingSender.port = port;

		// Create a datagram socket for receiving and sending UDP packets
		// through the port specified on the command line.
		clientSocket = new DatagramSocket();
		clientSocket.setSoTimeout(1000); // receive timeout of the socket to 1

	}

	public void run() {
		try {
			String data = "PING " + seqno + " " + new Date() + CRLF;

			// Send packet
			byte[] sendData = data.getBytes();
			InetAddress IPAddress = InetAddress.getByName(host);
			long start = System.currentTimeMillis();
			clientSocket.send(new DatagramPacket(sendData, sendData.length,
					IPAddress, port));

			byte[] receiveData = new byte[1024];

			clientSocket.receive(new DatagramPacket(receiveData,
					receiveData.length));
			seqno++;
			long end = System.currentTimeMillis();
			long rtt = end - start;
			time += rtt;
			if (rtt < minRtt)
				minRtt = rtt;
			if (rtt > maxRtt)
				maxRtt = rtt;
			npktsRcvd++;

			System.out.println(sendData.length + " bytes from "
					+ IPAddress.toString() + ": seq=" + seqno + " time=" + rtt
					+ " ms");
			if (seqno == 10)
				statistics();

		} catch (SocketTimeoutException e) {
			seqno++;
			npktsDrpd++;
			if (seqno == 10)
				statistics();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

	}

	public void statistics() {
		System.out.println("--- " + host + " ping statistics ---");
		System.out.println((npktsRcvd + npktsDrpd) + " transmitted, "
				+ npktsRcvd + " recieved, " + (double) npktsDrpd
				/ (npktsRcvd + npktsDrpd) * 100 + "% packet loss, time " + time
				+ "ms");
		System.out.println("rtt min/avg/max = " + minRtt + "/" + (double) time
				/ npktsRcvd + "/" + maxRtt + " ms");
		System.exit(0);
	}

}