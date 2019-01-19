package com.ensim.a24h;

public class MqttServices {
    void set_pixel(int numLed, int r, int v, int b) {

    }

    /*Change la couleur d’un anneau.
    Les 4 octets du message sont le numéro de l’anneau
    suivi des composantes rouge, vert, bleu de la couleur (0 à 255)*/
    void set_ring(int numAnneau, int r, int v, int b) {

    }

    /*Change la couleur d’une colonne.
    Les 4 octets du message sont le numéro de la colonne
    suivi des composantes rouge, vert, bleu de la couleur (0 à 255)*/
    void set_column(int numCol, int r, int v, int b) {

    }

    /*Démarre l’animation de remplissage progressif avec une couleur et une durée.
    Les 4 octets du message sont les composantes rouge, vert, bleu de la couleur (0 à 255)
    suivies de la durée.*/
    void color_wipe(int r, int v, int b, int duree) {

    }

    // Démarre l’animation arc-en - ciel.
    // Le contenu du message est ignoré.
    void animate_rainbow() {

    }

    // Change la couleur de toutes les leds.
    // Les 3 octets du message sont les composantes rouge, vert, bleu de la couleur (0 à 255)
    void fill(int r, int v, int b) {

    }

    // Renvoie un message sur le topic laumio/status/advertise contenant son nom.
    void discover() {

    }



    // !!!!!!!!!!!Fonctions pour les capteurs!!!!!!!!!!!!!!!!!!

    //Fonction pour la telecommande
    void subscribe_telecommande(/*nom de la touche*/) {

    }

    //Fonction pour le capteur de presence state
    void subscribe_presence_state() {

    }

    // Fonction pour le capteur de presence status
    void subscribe_presence_status() {

    }

    //Fonction pour le capteur de distance value
    void subscribe_distance_value() {

    }

    //Fonction pour le capteur de distance status
    void subscribe_distance_status() {

    }

    //Fonction pour le capteur atmosphérique

    void subscribe_atmosphere_temperature() {

    }


    void subscribe_atmosphere_pression() {

    }

    void subscribe_atmosphere_humidite() {

    }

    void subscribe_atmosphere_humidite_absolue() {

    }
}
