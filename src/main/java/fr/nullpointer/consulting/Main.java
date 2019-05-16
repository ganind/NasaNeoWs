package fr.nullpointer.consulting;

import java.io.IOException;

class Main{
    public static void main(String[]args){
        RechercheData maRechercheData = new RechercheData();
        try {
            maRechercheData.funcRecherche();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

