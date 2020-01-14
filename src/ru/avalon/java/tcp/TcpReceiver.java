package ru.avalon.java.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Упражнение на выаботку умений связанных с получением сообщений, отправленных
 * с использованием протокола TCP.
 *
 * @author Daniel Alpatov
 */
public final class TcpReceiver {

    public static void main(String[] args) throws IOException {
        // 1. Определяем порт, на котором ожидается соединение.
        final int port = 10001;
        // 2. Подготавливаем серверный сокет.
        final ServerSocket listener = prepareServerSocket(port);
        // 3. Принимаем соединение.
        Socket socket = listener.accept();
        // 4. Полоучаем сообщение.
        final String message = receive(socket);
        // 5. Закрываем соединение.
        socket.close();
        // 6. Закрываем серверный сокет.
        listener.close();
    }

    /**
     * Возвращает серверный сокет, связанный с портом, описанным параметром
     * {@code port}.
     *
     * @param port порт, на котором предполагается получать входящие соединения.
     *
     * @return серверный сокет, связанный с портом {@code port}.
     */
    private static ServerSocket prepareServerSocket(int port) {

        /*
            * TODO Реализовать метод prepareServerSocket класса TcpReceiver
         */
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Ошибка создания Сервер Сокета " + ex.getMessage());
        }
        return serverSocket;
    }

    /**
     * Возвращает сообщение, прочитанное из входящего потока, указанного сокета.
     *
     * @param socket сокет, описывающий сетевое соединение.
     *
     * @return строковое сообщение.
     */
    private static String receive(Socket socket) {
        /*
         * TODO Реализовать метод receive класса TcpReceiver
         */
        String massage = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            StringBuilder buidMassage = new StringBuilder();
            while (br.ready()) {
                buidMassage.append(br.readLine());
            }
            massage = buidMassage.toString();
        } catch (IOException ex) {
            System.out.println("Ошибка чтения из потока " + ex.getMessage());
        }
        return massage;
    }

}
