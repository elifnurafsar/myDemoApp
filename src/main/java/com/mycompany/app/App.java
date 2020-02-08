package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

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
       public static void main(String[] args) {
           port(getHerokuAssignedPort());

           get("/", (req, res) -> "Hello, World");

           post("/compute", (req, res) -> {
               //System.out.println(req.queryParams("input1"));
               //System.out.println(req.queryParams("input2"));

               String input1 = req.queryParams("input1");
               java.util.Scanner sc1 = new java.util.Scanner(input1);
               sc1.useDelimiter("[;\r\n]+");
               java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
               while (sc1.hasNext())
               {
                   int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                   inputList.add(value);
               }
               System.out.println(inputList);


               String[] strings = {"elif", "nur", "afsar", "beyza", "ayse", "bulent", "minik<3", "busra","yaprak", "selin", "sena", "yagmur", "ase", "sa"};

               String input2 = req.queryParams("input2").replaceAll("\\s","");
               int input2AsInt = Integer.parseInt(input2);

               int result = App.search(inputList, input2AsInt,"beyaz",strings);

               Map map = new HashMap();
               map.put("result", result);
               return new ModelAndView(map, "compute.mustache");
           }, new MustacheTemplateEngine());


           get("/compute",
                   (rq, rs) -> {
                       Map map = new HashMap();
                       map.put("result", "not computed yet!");
                       return new ModelAndView(map, "compute.mustache");
                   },
                   new MustacheTemplateEngine());
       }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}


