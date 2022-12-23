package AdvJavaPractice.multithreads.waitNotify;

import com.sun.source.tree.NewArrayTree;

public class ShopWaitNotify {

    /*
    TASK: Bir marketteki stok miktarını takip eden bir uygulama tasarlayınız.
          Markette yeterli ürün yoksa yeni ürün gelmesi beklensin.
          Yeni ürün eklenince ürün satışı gerçekleşsin.
    */

    public static volatile int stok = 0;

    public static void main(String[] args) {

        ShopWaitNotify shop = new ShopWaitNotify();

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                shop.consumeProduct(3);
            }
        });
        consumerThread.setName("Tuketici");
        consumerThread.start();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                shop.produceProduct(2);
            }
        });
        producerThread.setName("Uretici");
        producerThread.start();

    }
    public synchronized void consumeProduct(int amount){

        if(amount>stok){
            System.out.println(Thread.currentThread().getName()+" urun satin almak istiyor.");
            System.out.println("Yeterli urun yok, Guncel Urun Stogu: "+ stok);
            System.out.println("Tuketici urun girisi yapilmasini bekliyor...");
            System.out.println();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        if(amount<=stok){
            System.out.println(Thread.currentThread().getName()+" urun satin almak istiyor.");
            System.out.println("Urun satis alindi, stoktan dusuluyor.");
            stok -= amount;
            System.out.println("Guncel Stok: "+stok);
            System.out.println();
        }else {
            System.out.println(Thread.currentThread().getName()+" urun satin almak istiyor.");
            System.out.println("Yeterli urun yok, Guncel Stok: "+stok);
            System.out.println("Bugun git yarin gel...");
            System.out.println();
        }
    }

    public synchronized void produceProduct(int amount){
        System.out.println(Thread.currentThread().getName()+" urun eklemek istiyor.");
        System.out.println("Yeni urunler eklendi, stok guncelleniyor.");
        stok += amount;
        System.out.println("Guncel Stok: "+stok);
        notify();
        System.out.println();

    }


}
