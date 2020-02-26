package com.company;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download implements Runnable {
    String link;
    File out;

    public Download(String link,File out){
        this.link=link;
        this.out=out;
    }

    @Override
    public void run() {
        try{
            URL url=new URL(link);
            HttpURLConnection http=(HttpURLConnection)url.openConnection();
            double filesize=(double)http.getContentLengthLong();
            BufferedInputStream in=new BufferedInputStream(http.getInputStream());
            FileOutputStream fos=new FileOutputStream(this.out);
            BufferedOutputStream bout=new BufferedOutputStream(fos, 1024);
            byte[] buffer = new byte[1024];
            double downloaded=0.00;
            int read=0;
            double parcentDownloaded =0.00;
            while((read=in.read(buffer,0,1024))>=0){
                bout.write(buffer,0, read);
                downloaded+=read;
                parcentDownloaded=downloaded*100/filesize;
                String parcent=String.format("%.4f",parcentDownloaded);
                System.out.println("Downloaded "+parcent);
            }
            bout.close();
            in.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
