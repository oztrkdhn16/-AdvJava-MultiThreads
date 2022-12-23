package AdvJavaPractice.multithreads.threadpool;

/*
Thread yaratmak cidden maliyetli bir olaydır. Her Thread için sistemde belli bir kaynak ayrılır.
Bu kaynaklar CPU, Hafıza gibi önemli olanlardır. Uygulamamız çalışırken belli miktarda bir Thread
ile sınırlandırmak isteyebiliriz.

Bu nedenle Thread havuzu oluşturup bu havuzu önceden oluşturulmuş ve kullanıma hazır Thread nesneleri
ile doldururuz. Böylece, performans kazanımı ve sistem kaynaklarının verimli kullanımını sağlayabiliriz.

Task: Bir randevu oluşturma uygulaması tasarlayınız.(AppoinmentCenter)
      Uygulama herbir talep için bir gün sonrasına tarih
      vermelidir. 5 kişi için randevu alınmak isteniyor.
      Thread havuzu oluşturup işleri 3 threade yaptırınız.
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppointmentApp2 {


    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] users = {"Tolstoy","Balzac","ViktorHugo","C.Dickens","Dostoyevski"};

        AppointmentCenter2 appointmentCenter2 = new AppointmentCenter2();

        for(String user: users){
            MyThread thread = new MyThread(appointmentCenter2);
            service.execute(thread);
        }
        service.shutdown();
    }

}

class MyThread extends Thread{

    private AppointmentCenter2 appointmentCenter2;

    public MyThread(AppointmentCenter2 appointmentCenter2) {
        this.appointmentCenter2 = appointmentCenter2;
    }

    @Override
    public void run() {
        String tname = Thread.currentThread().getName();
        System.out.println("+++"+tname+" basladi.");
        System.out.println("Randevu Tarihiniz: " + appointmentCenter2.getAppointmentDate());
        System.out.println("..."+tname+" bitti...");
    }

}
