import java.util.Scanner;

public class SehirlerArasiUcus {

        static Scanner scan;
        static double varisUcreti = 0;
        static double brmFiyat = 0.1;
        static double bSehriUzaklik = 500;
        static double cSehriUzaklik = 700;
        static double dSehriUzaklik = 900;

        static String adSoyad;
        static int yas = 0;
        static String varisSehri;


        public static void main(String[] args) {
            sehirSecimi();
            ucusSekli();
            yasKontrol();
            adSoyadBilgisi();
            sonucuGoster();
            cikisIslemi();
        }
        public static void cikisIslemi(){

            scan = new Scanner(System.in);

            System.out.print("Islemi sonlandirmak icin (Exit - E) girin :");
            String exit = scan.next().toUpperCase();

            if (exit.equals("E")){
                sonucuGoster();
            }else {
                System.out.println("Gecersiz bilgi girdiniz ! ");
                cikisIslemi();
            }
        }

        public static void sonucuGoster(){
            scan = new Scanner(System.in);

            System.out.println("\nUcus Bilgileri : " + adSoyad + "\nYas : " + yas + "\nA sehrinden " + varisSehri +
                    " sehrine " + "\nToplam ödenecek tutar : " + varisUcreti + "$");
        }

        public static void ucusSekli() {
            scan = new Scanner(System.in);

            System.out.print("Ucusunuz tek yonse T , cift yonse C giriniz:");
            String seferSekli = scan.next().toUpperCase();


            if (seferSekli.equals("C")) {
                varisUcreti = (varisUcreti - (varisUcreti * 0.2)) * 2;
            } else if (seferSekli.equals("T")) {
                varisUcreti = varisUcreti;
            } else {
                System.out.println("Gecerli bir giris yapiniz !");
                ucusSekli();
            }
        }

        public static void yasKontrol() {
            scan = new Scanner(System.in);
            try {
                System.out.print("Yasinizi giriniz:");
                yas = scan.nextInt();

                if (yas < 0) {
                    System.out.println("Gecerli bir yas giriniz !");
                } else if (yas < 12) {
                    varisUcreti = varisUcreti / 2;
                } else if (yas < 24) {
                    varisUcreti = varisUcreti - (varisUcreti * 0.1);
                } else if (yas > 24 && yas < 65) {
                    varisUcreti = varisUcreti;
                } else if (yas >= 65) {
                    varisUcreti = varisUcreti - (varisUcreti * 0.3);
                }

            } catch (Exception e) {
                System.out.println("Lütfen sayi giriniz !");
                yasKontrol();
            }
        }

        public static void adSoyadBilgisi() {

            scan = new Scanner(System.in);

            System.out.print("Adinizi ve Soyadinizi giriniz:");
            adSoyad = scan.nextLine();

            if (adSoyad.length() == 0) {
                System.out.println("Gecerli bir isim giriniz !");
                adSoyadBilgisi();
            }
        }


        public static void sehirSecimi() {

            scan = new Scanner(System.in);

            System.out.print("Varis sehrinizi seciniz ( B - C - D ): ");
            varisSehri = scan.next().toUpperCase();

            if (varisSehri.equals("B") || varisSehri.equals("C") || varisSehri.equals("D")) {

                switch (varisSehri) {
                    case "B":
                        varisUcreti = bSehriUzaklik * brmFiyat;
                        break;
                    case "C":
                        varisUcreti = cSehriUzaklik * brmFiyat;
                        break;
                    case "D":
                        varisUcreti = dSehriUzaklik * brmFiyat;
                        break;
                }
            } else {
                System.out.println("Gecerli bir sehir giriniz !");
                sehirSecimi();
            }
        }

    }
