package fr.nullpointer.consulting;

//import java.io.IOException;

import java.io.IOException;

class Main {
    public static void main(String[] args) {
            RechercheData maRechercheData = new RechercheData();
        try {
            String donnees = maRechercheData.funcRecherche();

        SimpleProducer monProducer = new SimpleProducer();
            monProducer.createMessage(donnees);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

