/*
 * ДЗ по 3 уроку
 *
 * alexbox726@gmail.com
 */
package client;

import java.io.*;

public class History extends Controller {
    // String ячейка
    // Служит временным контейнером для сообщений
    String CatchMsg;

    // Общий метод
    public void StartHistory() throws IOException, FileNotFoundException {
        if (socket.isConnected()) {
            myHistory();
            TransformMsg();
        }
    }

    public void myHistory() {
        // Создаём файл переписки с помощью FileWriter
        // append - дописывает данные в существующий файл не создавая нового
        // Условие при котором запускается цикл работы FileWriter
        if (nickname != null) {
            try (FileWriter out = new FileWriter("client/ChatHistory/history_" + nickname +
                    ".txt", true)) {
                out.write("\n" + CatchMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Закрываем наш поток FileWriter после работы
        }
        if (socket.isClosed()) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Метод чтения текста из TextArea и переноса его в CatchMsg
    public void TransformMsg() {
        if (textArea != null) {
            try {
                BufferedReader input = new BufferedReader(new FileReader("client/ChatHistory/history_" +
                        nickname + ".txt"));
                textArea.getText();
                try {
                    CatchMsg.getBytes(String.valueOf(textArea));
    //                System.out.println(CatchMsg);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
