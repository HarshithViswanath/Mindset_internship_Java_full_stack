import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultiThreadFileReadWrite {

    private static final String FILE_NAME = "multithread_demo.txt";

    public static void main(String[] args) {
        Thread writerThread = new Thread(new WriterTask(), "WriterThread");
        Thread readerThread = new Thread(new ReaderTask(), "ReaderThread");

        writerThread.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.err.println("Main interrupted: " + e.getMessage());
        }

        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            System.err.println("Thread join interrupted: " + e.getMessage());
        }

        System.out.println("Multi-thread read/write demo finished.");
    }

    static class WriterTask implements Runnable {
        @Override
        public void run() {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (int i = 1; i <= 5; i++) {
                    String line = "Line " + i + " written by " + Thread.currentThread().getName();
                    bw.write(line);
                    bw.newLine();
                    System.out.println("Wrote: " + line);
                    Thread.sleep(100);
                }
            } catch (IOException | InterruptedException e) {
                System.err.println("Writer error: " + e.getMessage());
            }
        }
    }

    static class ReaderTask implements Runnable {
        @Override
        public void run() {
            for (int attempt = 0; attempt < 3; attempt++) {
                try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                    System.out.println("Reading attempt " + (attempt + 1));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println("Read: " + line);
                    }
                } catch (IOException e) {
                    System.err.println("Reader error (attempt " + (attempt + 1) + "): " + e.getMessage());
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.err.println("Reader interrupted: " + e.getMessage());
                }
            }
        }
    }
}
