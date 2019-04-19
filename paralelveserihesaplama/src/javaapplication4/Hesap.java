/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.util.concurrent.locks.*;
import java.math.BigInteger;


/**
*
* <p>
* Paralel ve seri hesaplamaların süre hesabı
* </p>
*/
public class Hesap {
 //private int toplamPara = 1;
   private BigInteger toplam=new BigInteger("1");
   private BigInteger sonuc;
 private final Lock bolge = new ReentrantLock();
 public BigInteger sonuc(){
 return toplam;
 }
 public void carp(int basla,int bit){
 bolge.lock(); //Kritik bölge başlangıç
 for(int i=basla;i<=bit;i++)
 {
            BigInteger bi = BigInteger.valueOf(i);
            toplam=toplam.multiply(bi);
 sonuc=toplam;
 }
 try{
 // Veri çöküşünü daha iyi görebilmek için bekleme verildi.
 Thread.sleep(1);
 }
 catch(InterruptedException ex){
 }
 //toplam = this.sonuc().multiply(sonuc);
 bolge.unlock(); //Kritik bölgeyi kapat.
 }
}
