package com.etisalat.sampletask.models;

import com.etisalat.sampletask.bases.ApplicationContextProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Ahmed Etman on 4/26/2018.
 */

public class CachingDataHandler {

   public static Menu loadObject(){
       Menu menu = null;
       try {
           String filePath = ApplicationContextProvider.getContext()
                   .getFilesDir().getPath() + "/foodMenu.txt";

           FileInputStream fi = new FileInputStream(new File(filePath));
           ObjectInputStream oi = new ObjectInputStream(fi);

           // Read objects
           menu = (Menu) oi.readObject();

           oi.close();
           fi.close();

       } catch (FileNotFoundException e) {
           System.out.println("File not found");
       } catch (IOException e) {
           System.out.println("Error initializing stream");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       return menu;
   }

    public static void saveObject(Menu menu){
        try {
            String filePath = ApplicationContextProvider.getContext()
                    .getFilesDir().getPath() + "/foodMenu.txt";

            FileOutputStream f = new FileOutputStream(new File(filePath));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(menu);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
