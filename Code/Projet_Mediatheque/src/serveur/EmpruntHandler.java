package serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class EmpruntHandler extends Thread {
    private Socket socket;

    public EmpruntHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Recevoir la demande d'emprunt depuis le client
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Traitement de la demande d'emprunt...

            // Envoyer la réponse au client
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject("Emprunt confirmé.");

            // Fermer les flux et le socket
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
