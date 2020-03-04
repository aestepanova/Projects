package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {




    public static void main(String[] args) {

        for(int i=12916;i<=13082;i++) {
            getSumOs(i, 5);
            System.out.println("");
        }
    }



    public static void getTemprature(String urls){
        try {
            ArrayList<Integer> A=new ArrayList<>();
            Document doc = Jsoup.connect(urls).get();
            Elements tr = doc.getElementsByAttributeValue("class", "first");
            tr.forEach(tro -> {
                Element td = tro.parent().child(1);
                String temprature = td.text();
                A.add(Integer.parseInt(temprature));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void getSredTemprature(Integer terr,Integer N) {
        try {
            String urlspp = "https://www.gismeteo.ru/diary/"+terr.toString()+"/2019/1/";
            Document docu = Jsoup.connect(urlspp).get();
            Elements traa = docu.getElementsByAttributeValue("id", "page_title");
            String a=traa.first().text();
            String b=a.substring(15,a.indexOf(" ",15));
            System.out.printf("%-24s",b);
        } catch (IOException e ) {

        }
        catch (NullPointerException d) {

        }
        for (Integer r = 1; r <= 12; r++) {
        ArrayList<Double> A = new ArrayList<>();
        for (int j = 0; j <= 31; j++) {
            A.add(0.);
        }
            for (int k = 0; k < N; k++) {
                Integer age = 2019 - k;
                String urls = "https://www.gismeteo.ru/diary/"+terr.toString()+"/" + age.toString() + "/" + r.toString() + "/";
                AtomicInteger i = new AtomicInteger();
                try {
                    Document doc = Jsoup.connect(urls).get();
                    Elements tr = doc.getElementsByAttributeValue("class", "first");
                    tr.forEach(tro -> {
                        Element td = tro.parent().child(1);
                        String temprature = td.text();
                        Element tdv = tro.parent().child(6);
                        String tempratureV = tdv.text();
                        if (temprature.equals("")) temprature="3";
                        if (tempratureV.equals("")) tempratureV="3";
                        A.set(i.get(), A.get(i.get()) + (Integer.parseInt(temprature)) + (Integer.parseInt(tempratureV)));
                        i.getAndIncrement();
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            double sum1 = 0;
            for (int j = 0; j < A.size() / 2; j++) {
                A.set(j, A.get(j) / ((double) N*2.0));
                sum1 += A.get(j);
            }
            System.out.print(String.format("%-8.2f", sum1 / (A.size() / 2))+"       ");//РЕЗУЛЬТАТ
            double sum2 = 0;
            for (int j = A.size() / 2; j < A.size(); j++) {
                A.set(j, A.get(j) /((double) N*2.0));
                sum2 += A.get(j);
            }
            System.out.print(String.format("%-8.2f", sum2 / (A.size() - A.size() / 2))+"       ");//РЕЗУЛЬТАТ
        }
    }


    public static void getSumSun(Integer terr,Integer N) {
        try {
            String urlspp = "https://www.gismeteo.ru/diary/"+terr.toString()+"/2019/1/";
            Document docu = Jsoup.connect(urlspp).get();
            Elements traa = docu.getElementsByAttributeValue("id", "page_title");
            String a=traa.first().text();
            String b=a.substring(15,a.indexOf(" ",15));
            System.out.printf("%-24s",b);
        } catch (IOException e ) {

        }
        catch (NullPointerException d) {

        }
        for (Integer r = 1; r <= 12; r++) {
            ArrayList<Double> A = new ArrayList<>();
            for (int j = 0; j <= 31; j++) {
                A.add(0.);
            }
            for (int k = 0; k < N; k++) {
                Integer age = 2019 - k;
                String urls = "https://www.gismeteo.ru/diary/"+terr.toString()+"/" + age.toString() + "/" + r.toString() + "/";
                AtomicInteger i = new AtomicInteger();
                try {
                    Document doc = Jsoup.connect(urls).get();
                    Elements tr = doc.getElementsByAttributeValue("class", "first");
                    tr.forEach(tro -> {
                        Integer sum=0;
                        Element td = tro.parent().child(3).child(0);
                        String obl = td.attr("src");
                        if (obl.substring(35,38).equals("sun")) sum=1;
                        A.set(i.get(), A.get(i.get()) + sum);
                        i.getAndIncrement();
                    });
                } catch (IOException e) {

                }
                catch (IndexOutOfBoundsException e) {

                }

            }
            double sum1 = 0;
            for (int j = 0; j < A.size() / 2; j++) {
                A.set(j, A.get(j) / ((double) N));
                sum1 += A.get(j);
            }
            System.out.print(String.format("%-8.0f", sum1)+"       ");//РЕЗУЛЬТАТ
            double sum2 = 0;
            for (int j = A.size() / 2; j < A.size(); j++) {
                A.set(j, A.get(j) /((double) N));
                sum2 += A.get(j);
            }
            System.out.print(String.format("%-8.0f", sum2)+"       ");//РЕЗУЛЬТАТ
        }
    }
    public static void getSumOs(Integer terr,Integer N) {
        try {
            String urlspp = "https://www.gismeteo.ru/diary/"+terr.toString()+"/2019/1/";
            Document docu = Jsoup.connect(urlspp).get();
            Elements traa = docu.getElementsByAttributeValue("id", "page_title");
            String a=traa.first().text();
            String b=a.substring(15,a.indexOf(" ",15));
            System.out.printf("%-24s",b);
        } catch (IOException e ) {

        }
        catch (NullPointerException d) {

        }
        for (Integer r = 1; r <= 12; r++) {
            ArrayList<Double> A = new ArrayList<>();
            for (int j = 0; j <= 31; j++) {
                A.add(0.);
            }
            for (int k = 0; k < N; k++) {
                Integer age = 2019 - k;
                String urls = "https://www.gismeteo.ru/diary/"+terr.toString()+"/" + age.toString() + "/" + r.toString() + "/";
                AtomicInteger i = new AtomicInteger();
                try {
                    Document doc = Jsoup.connect(urls).get();
                    Elements tr = doc.getElementsByAttributeValue("class", "first");
                    tr.forEach(tro -> {
                        Element td = tro.parent().child(4).select("img").first();
                        if(td!=null)
                        A.set(i.get(), A.get(i.get()) + 1);
                        i.getAndIncrement();
                    });
                } catch (IOException e) {

                }
                catch (IndexOutOfBoundsException e) {

                }

            }
            double sum1 = 0;
            for (int j = 0; j < A.size() / 2; j++) {
                A.set(j, A.get(j) / ((double) N));
                sum1 += A.get(j);
            }
            System.out.print(String.format("%-8.0f", sum1)+"       ");//РЕЗУЛЬТАТ
            double sum2 = 0;
            for (int j = A.size() / 2; j < A.size(); j++) {
                A.set(j, A.get(j) /((double) N));
                sum2 += A.get(j);
            }
            System.out.print(String.format("%-8.0f", sum2)+"       ");//РЕЗУЛЬТАТ
        }
    }
}
