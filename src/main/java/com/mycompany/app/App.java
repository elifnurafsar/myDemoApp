package com.mycompany.app;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int search(ArrayList<Integer> array, int e,String text,String[] sozluk) {
        //this method finds all possible words from sozluk with change the order of characters
        // from given string and turns the number of possible words
        //the array used for show possible word's place
        for (int i = 0; i < sozluk.length; i++) {
            boolean bul = true;
            if (sozluk[i].length() == text.length()) {
                for (int j = 0; j < sozluk[i].length(); j++) {
                    if (text.indexOf(sozluk[i].charAt(j)) == -1) {
                        bul = false;
                    }
                }
                if (bul) {
                    e++;
                    array.add(i);
                }
            }
        }
            return e;
        }

       /* public static void main (String[]args){
            String[] strings = {"elif", "nur", "afsar", "beyza", "ayse", "bulent", "minik<3", "busra", "selin", "sena", "yagmur", "ase", "sa"};
            String s = "sea";
            int integ = 0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            int i = search(list, integ, s, strings);
            System.out.println(i);
        }*/

    }
