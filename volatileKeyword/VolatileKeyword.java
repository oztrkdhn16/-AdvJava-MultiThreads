package AdvJavaPractice.multithreads.volatileKeyword;

public class VolatileKeyword {

    /*

Birden fazla thread kullanılan bir uygulamada ,değişkenler performans nedeniyle CPU cache'inde tutulabilir.
Bilgisayarın birden fazla CPU'su(çekirdek) olduğunu düşünürsek her thread farklı CPU üzerinde çalısabilir
bu nedenle her thread değişkenlerin değerini CPU cache'ine farklı değerde yazabilir.

"volatile" keywordü değişken üzerinde bir değişiklik olduğunda diğer threadler tarafından görünmesini garanti eder.
"volatile" bir değişken CPU cache yerine bilgisayarın main memory'sinden okunur ve CPU cache yerine main memory'sine yazılır.
non-volatile değişkenler için böyle bir garanti yoktur.

TASK: Banka/Hastahane işlemleri için sıra numarası veren bir uygulama(Numerator) tasarlayınız.
      Uygulama her talep için bir sonraki sırayı vermeli.

     */

    public static void main(String[] args) {

        Numerator numerator = new Numerator();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                numerator.getOrder();
            }
        });
        thread1.setName("Ridvan");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                numerator.getOrder();
            }
        });
        thread2.setName("Betul");
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                numerator.getOrder();
            }
        });
        thread3.setName("Yunus");
        thread3.start();




    }

}
