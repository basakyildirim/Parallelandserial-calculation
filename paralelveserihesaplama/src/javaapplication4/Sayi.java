/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Timer;
import java.io.*;
import java.util.Scanner;

/**
*
* <p>
* Paralel ve seri hesaplamaların süre hesabı
* </p>
*/
public class Sayi {
    public Sayi(int faktoriyel)
    {   
 int mod,fark,havuzsayisi;
 Hesap hesap = new Hesap();
 
 long baslangic1=System.currentTimeMillis();    
 mod=faktoriyel%4;
 fark=faktoriyel/4;
 if(mod==0)
     havuzsayisi=fark;
 else
     havuzsayisi=fark+1;
 ExecutorService havuz = Executors.newFixedThreadPool(havuzsayisi);
 // İşlemleri oluştur
 for(int i=1;i<=faktoriyel-mod;i=i+4)
 {
    havuz.execute(new faktor(hesap,i,i+3));
 }
 if(mod!=0)
 {
    havuz.execute(new faktor(hesap,faktoriyel-mod+1,faktoriyel));
 }
     
 havuz.shutdown();
 // Bütün işlemler bitene kadar bekle
 while(!havuz.isTerminated()){ }
 long bitis1=System.currentTimeMillis();
 double gecensure1=(bitis1-baslangic1);
 System.out.println("Paralel Hesaplama Süresi :" + gecensure1 +" Milisaniyedir.");
 
 double baslangic2=System.currentTimeMillis(); 
 
 Hesap hesap2 = new Hesap();
 ExecutorService havuz1 = Executors.newFixedThreadPool(1);
 // İşlemleri oluştur
 for(int i=1;i<=faktoriyel-mod;i=i+4)
 {
    havuz1.execute(new faktor(hesap2,i,i+3));
 }
 if(mod!=0)
 {
    havuz1.execute(new faktor(hesap2,faktoriyel-mod+1,faktoriyel));
 }
     
 havuz1.shutdown();
 // Bütün işlemler bitene kadar bekle
 while(!havuz1.isTerminated()){ }
 long bitis2=System.currentTimeMillis();
 double gecensure2=(bitis2-baslangic2);
 
 System.out.println("Seri Hesaplama Süresi :" + gecensure2 +" Milisaniyedir.");
 
           try{
                  File dosya = new File("sonuc.txt");
                  if(!dosya.exists()){ // eğer dosya yoksa
                  }
                  else
                  {
                        dosya.delete(); // eğer dosyamız varsa.. // silme işlemi gerçekleştirir.
                  }
                  FileWriter yazici = new FileWriter(dosya,true);
                  BufferedWriter yaz = new BufferedWriter(yazici);
                  yaz.write(hesap.sonuc().toString());
                  yaz.close();
                  System.out.println("Sonuç Dosyaya Yazıldı.");
            }
            catch (Exception hata){
                  hata.printStackTrace();
            }
 
    }

    
}