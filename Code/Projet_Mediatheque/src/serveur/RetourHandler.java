package serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RetourHandler extends Thread {
    private Socket socket;

    public RetourHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Recevoir la demande de retour depuis le client
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            // Traitement de la demande de retour...

            // Envoyer la réponse au client
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject("Retour effectué.");

            // Fermer les flux et le socket
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
