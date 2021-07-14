package threadsPrac;

public class Deadlock {

	public static void main(String[] args) throws InterruptedException {
		String a = "String A";
		String b = "String B";
		Thread t1 = new Thread() {
			
			public void run() {
				synchronized (a) {
					System.out.println("Thread 1 a" );

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (b) {
						System.out.println("Thread 1 b" );
					}
				}
			}
		};
		Thread t2 = new Thread() {
		
			public void run() {
				synchronized (b) {
					System.out.println("Thread 2 b" );

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (a) {
						System.out.println("Thread 2 a" );
					}
				}
			}
		};
		t1.start();
		
		t2.start();

	}

}
