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
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

/**
*
* <p>
* Paralel ve seri hesaplamaların süre hesabı
* </p>
*/

public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static double gecensure0;
 public static void main(String[] args) {
 
 //int faktoriyel=100;
 
/*Veriyi dışarıdan Alınca paralel hesaplama süresine verinin girilene kadar olan zamanı alıyor.Fakat yukarıdaki gibi değişkeni
 elle verdiğimizde hesaplama sürelerini normali gösteriyor.
 
 Not: Sadece küçük sayılarda yapıyor büyük değerler girildiğinde işlemler süre hesaplamaları gayet normal
 
 */
 
 System.out.print("Sayı: ");
 Scanner verial=new Scanner(System.in); 
 int faktoriyel= verial.nextInt();
 Sayi say=new Sayi(faktoriyel);
 }
    
}
