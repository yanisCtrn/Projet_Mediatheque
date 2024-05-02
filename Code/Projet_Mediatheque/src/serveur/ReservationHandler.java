package serveur;

import modele.DemandeReservation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ReservationHandler extends Thread {
    private Socket socket;

    public ReservationHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Recevoir la demande de réservation depuis le client
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            DemandeReservation demande = (DemandeReservation) inputStream.readObject();

            // Traitement de la demande de réservation...

            // Envoyer la réponse au client
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject("Réservation confirmée.");

            // Fermer les flux et le socket
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
