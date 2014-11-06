public class BoundedBuffer {

	private int buffer[];
	private int in = 0, out = 0, counter = 0;
	private Thread p, c;

	private static final int N = 10;
	private static final int MAXSLEEP = 2000;

	private class Producer implements Runnable {
		public void run() {
			while (true)
				try {
					Thread.sleep((int) (Math.random() * MAXSLEEP));
					insertItem();
				} catch (InterruptedException e) {
					System.out.println(e);
					System.exit(1);
				}
		}
	}

	private class Consumer implements Runnable {
		public void run() {
			while (true)
				try {
					Thread.sleep((int) (Math.random() * MAXSLEEP));
					removeItem();
				} catch (InterruptedException e) {
					System.out.println(e);
					System.exit(1);
				}
		}
	}

	BoundedBuffer() {
		buffer = new int[N];
		p = new Thread(new Producer());
		c = new Thread(new Consumer());
	}

	public void runThreads() {
		p.start();
		c.start();
	}

	public synchronized void insertItem() throws InterruptedException {
		while (counter == N)
			wait();

		buffer[in] = in;
		System.out.println("Produced " + buffer[in]);
		in = (in + 1) % N;
		counter++;

		notifyAll();
	}

	public synchronized void removeItem() throws InterruptedException {
		while (counter == 0)
			wait();

		System.out.println("Consumed " + buffer[out]);
		out = (out + 1) % N;
		counter--;

		notifyAll();
	}

	public static void main(String s[]) {
		BoundedBuffer b = new BoundedBuffer();
		b.runThreads();
	}
}