/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.isi.junittestecase.service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fallou
 */
public class Methodes {

 
    /**
     * methode qui verifie si le mail est valide sur le plan syntaxique
     *
     * @param texte
     * @return
     */
    public  boolean validerEmail(String texte) {
        boolean ok = true;
        if (!texte.contains("@")) {
            ok = false;
        } else {
            int x = texte.indexOf('@');

            if (x > 3 && texte.contains("@") == true) {
                String sousText = texte.substring(x);
                ok = "@yahoo.com".equals(sousText) || "@yahoo.fr".equals(sousText) || "@gmail.fr".equals(sousText) || "@gmail.com".equals(sousText) || "@hotmail.fr".equals(sousText) || "@hotmail.com".equals(sousText);
            }
        }
        return ok;
    }

    /**
     * methode qui verifie si le numero du telephone est valide au niveau
     * national(SENEGAL)
     *
     * @param texte
     * @return
     */
    public  boolean validerNumeroTelephone(String texte) {
        boolean ok = true;
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(texte);
        char premierCaractere = texte.charAt(0);
        char deuxiemCaractere = texte.charAt(1);

        if (matcher.find() && matcher.group().equals(texte) && texte.length() == 9 && premierCaractere == '7' || premierCaractere == '3') {
            ok = deuxiemCaractere == '7' || deuxiemCaractere == '8' || deuxiemCaractere == '6' || deuxiemCaractere == '0' || deuxiemCaractere == '3';

        } else {

            ok = false;
        }
        return ok;
    }

    /**
     * methode qui verifie que le texte est uniquement alphabetique
     *
     * @param texte
     * @return
     */
    public  boolean validerName(String texte) {
        boolean trouve = true;
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(texte);
        trouve = matcher.find() && matcher.group().equals(texte) && texte.trim().length() >= 2;
        return trouve;
    }
}
