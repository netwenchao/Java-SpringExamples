package cn.dragon2.IOInDeep;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
  public static void main(String[] args) throws IOException {
    SenderThread sender = new SenderThread();
    ReceiverThread receiver = new ReceiverThread();
    sender.getOutputStream().connect(receiver.getInput());

    new Thread(sender, "Sender").start();
    new Thread(receiver).start();
  }
}

class SenderThread implements Runnable, AutoCloseable {
  private PipedOutputStream outputStream;
  long times = 1000;

  public SenderThread() {
    outputStream = new PipedOutputStream();
  }

  @Override
  public void run() {

    try {
      outputStream.write((Thread.currentThread().getName() + Long.toString(System.currentTimeMillis())).getBytes());
      outputStream.flush();
      Thread.sleep(1000);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

    try {
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public PipedOutputStream getOutputStream() {
    return outputStream;
  }

  @Override
  public void close() throws Exception {
    outputStream.close();
  }

}

class ReceiverThread implements Runnable, AutoCloseable {
  PipedInputStream input = null;

  public ReceiverThread() {
    input = new PipedInputStream();
  }

  @Override
  public void run() {
    try {
      byte[] data = input.readAllBytes();
      if (data.length > 0)
        System.out.println(new String(data));
      Thread.sleep(1000);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public PipedInputStream getInput() {
    return input;
  }

  @Override
  public void close() throws Exception {
    input.close();
  }
}