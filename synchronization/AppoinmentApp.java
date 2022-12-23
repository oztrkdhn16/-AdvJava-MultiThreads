package AdvJavaPractice.multithreads.synchronization;

public class AppoinmentApp {

    /*

    Multithreading programlamada birden fazla Thread aynı anda ortak bir kaynağa erişmeye çalışırsa
    istenmeyen sonuçlar oluşacaktır. Bu durumda threadlere sırayla erişim vermek gerekecektir.
    Bir thread kaynağı kullanıyorken diğerleri onu beklemelidirler. Bu "synchronized" keyword'ü ile sağlanır.
    synchronized keywordü metot ve bloklarda kullanılır.

    Task: Bir randevu oluşturma uygulaması tasarlayınız.(AppoinmentCenter)
          Uygulama her bir talep için bir gün sonrasına tarih
          vermelidir.
    */

    public static void main(String[] args) {

        String[] users = {"Tolstoy","ViktorHugo","Balzac","Dostoyevski","JohnSteinbeck"};
        AppoinmentCenter appoinmentCenter = new AppoinmentCenter();

        for(String user: users) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName(user);
                    String name = Thread.currentThread().getName();
                    System.out.format("Sayin %-13s, Randevu Tarihiniz: %10s %n", name, appoinmentCenter.getAppoinmentDate());
                }
            });
            thread.start();
        }
    }



}
