package com.company;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
String link="https://www1.ncdc.noaa.gov/pub/data/noaa/isd-lite/2020/010010-99999-2020.gz";
File out=new File("C:\\Users\\dimaT\\Desktop\\abc.gz");
while(true) {
    new Thread(new Download(link, out)).start();
    try{
    TimeUnit.HOURS.sleep(10);}
    catch(InterruptedException e){
        e.printStackTrace();
    }
}
    }
}
