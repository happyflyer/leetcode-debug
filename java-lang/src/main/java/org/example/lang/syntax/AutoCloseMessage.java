package org.example.lang.syntax;

/**
 * @author lifei
 */
public class AutoCloseMessage {
    public interface IMessage extends AutoCloseable {
        void send(String msg);
    }

    public static class NetMessage implements IMessage {
        private boolean open() {
            System.out.println("开启资源");
            return true;
        }

        @Override
        public void send(String msg) {
            if (open()) {
                System.out.println("发送数据");
            }
        }

        @Override
        public void close() throws Exception {
            System.out.println("自动关闭");
        }
    }

    public static void main(String[] args) throws Exception {
        try (IMessage message = new NetMessage()) {
            message.send("Hello");
        }
    }
}
