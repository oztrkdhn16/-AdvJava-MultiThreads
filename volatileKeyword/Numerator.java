package AdvJavaPractice.multithreads.volatileKeyword;

public class Numerator {

    private volatile static int counter = 0;
    //Volatile keyword'u degiskenin main memory'de saklanmasini garanti eder ancak tum thread'lerin
    //degiskene ayni anda ulasmasindan kaynakli cakismaya cozme garantisi yoktur.
    //Bunun için synchronized keywordü de kullanılmalı

    public void getOrder(){
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized(this) {
            counter++;
            System.out.println("Sayin " + name + " siraniz: " + counter);
        }
    }

}
