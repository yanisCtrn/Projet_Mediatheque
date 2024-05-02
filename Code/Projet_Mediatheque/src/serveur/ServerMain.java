package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {
        try {
            // Serveur de réservation sur le port 3000
            ServerSocket reservationServer = new ServerSocket(3000);
            System.out.println("Serveur de réservation démarré.");

            // Serveur d'emprunt sur le port 4000
            ServerSocket empruntServer = new ServerSocket(4000);
            System.out.println("Serveur d'emprunt démarré.");

            // Serveur de retour sur le port 5000
            ServerSocket retourServer = new ServerSocket(5000);
            System.out.println("Serveur de retour démarré.");

            while (true) {
                // Accepte les connexions entrantes pour la réservation
                Socket reservationSocket = reservationServer.accept();
                // Gère la réservation dans un thread séparé
                new ReservationHandler(reservationSocket).start();

                // Accepte les connexions entrantes pour l'emprunt
                Socket empruntSocket = empruntServer.accept();
                // Gère l'emprunt dans un thread séparé
                new EmpruntHandler(empruntSocket).start();

                // Accepte les connexions entrantes pour le retour
                Socket retourSocket = retourServer.accept();
                // Gère le retour dans un thread séparé
                new RetourHandler(retourSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
