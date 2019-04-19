/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
*
* <p>
* Paralel ve seri hesaplamaların süre hesabı
* </p>
*/
public class faktor implements Runnable{
 private Hesap hesap;
 private int bas,bit;
 public faktor(Hesap hesap,int basla,int bit){
 this.hesap = hesap;
 this.bas=basla;
 this.bit=bit;
 }
 @Override
 public void run() {
 hesap.carp(bas,bit);
 }
}
