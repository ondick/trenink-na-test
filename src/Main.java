import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Piloti> platniPiloti = new ArrayList<>();
        Validator validator = new Validator();

        try {
            File soubor = new File("trenink_piloti_testovaci_data.txt");
            Scanner scanner = new Scanner(soubor);

            int cisloRadku = 1;
            while (scanner.hasNextLine()) {
                String radek = scanner.nextLine();
                if (radek.trim().isEmpty()) {
                    cisloRadku++;
                    continue;
                }

                List<String> chyby = new ArrayList<>();
                boolean jePlatny = validator.validujRadek(radek, chyby, platniPiloti);

                if (jePlatny) {
                    System.out.println("Řádek " + cisloRadku + ": validní");

                } else {
                    System.out.println("Řádek " + cisloRadku + ": nevalidní (" + String.join(", ", chyby) + ")");
                }

                cisloRadku++;
            }
            scanner.close();
            System.out.println("");
            System.out.println("Starsi 50 let");
            for (Piloti pilot : platniPiloti) {
                if (pilot.getRokNarozeni() <= 1976) {
                    System.out.println(pilot.getKodPilota() + " " + pilot.getPlaneta() + " " + pilot.getRokNarozeni() + " " + pilot.getTypLodi() + " " + pilot.getPocetVitezstvi());
                }
            }

            if (platniPiloti.isEmpty()) {
                System.out.println("Seznam prazdnej");
            } else {
                int maxVitezstvi = -1;
                for (Piloti pilot : platniPiloti) {
                    if (pilot.getPocetVitezstvi() > maxVitezstvi) {
                        maxVitezstvi = pilot.getPocetVitezstvi();
                    }
                }
                System.out.println("");
                System.out.println("Piloti s nejvic wins:");
                for (Piloti pilot : platniPiloti) {
                    if (pilot.getPocetVitezstvi() == maxVitezstvi) {
                        System.out.println(pilot.getKodPilota() + " " + pilot.getPlaneta() + " " + pilot.getRokNarozeni() + " " + pilot.getTypLodi() + ",  vyhry: " + pilot.getPocetVitezstvi());
                    }
                }
            }
            System.out.println("");
            if (platniPiloti.isEmpty()) {
                System.out.println("Seznam prazdnej");
            } else {
                int nejmladsi = 1;
                for (Piloti pilot : platniPiloti) {
                    if (pilot.getRokNarozeni() >= nejmladsi) {
                        nejmladsi = pilot.getRokNarozeni();
                    }
                }
                System.out.println("Nejmladsi pilto:");
                for (Piloti pilot : platniPiloti) {
                    if (pilot.getRokNarozeni() == nejmladsi) {
                        System.out.println(pilot.getKodPilota() + " " + pilot.getPlaneta() + " " + pilot.getRokNarozeni() + " " + pilot.getTypLodi() + " " + pilot.getPocetVitezstvi());
                    }
                }
            }
            int pocetStihacek = 0;
            int pocetTransporter = 0;
            int pocetExplorer = 0;
            int pocetBitevnik = 0;
            if (platniPiloti.isEmpty()) {
                System.out.println("Seznam prazdnej");
            }
            else {

                for (Piloti pilot : platniPiloti) {
                    if (pilot.getTypLodi().equals("Stíhač")){
                        pocetStihacek++;
                    }else if (pilot.getTypLodi().equals("Transportér")){
                        pocetTransporter++;
                    }else if (pilot.getTypLodi().equals("Explorer")){
                        pocetExplorer++;
                    }else if (pilot.getTypLodi().equals("Bitevník")){
                        pocetBitevnik++;
                    }
                }
                int p1 = pocetStihacek;    String n1 = "stihacu";
                int p2 = pocetTransporter; String n2 = "transporter";
                int p3 = pocetExplorer;    String n3 = "explorer";
                int p4 = pocetBitevnik;    String n4 = "bitevnik";

                if (p1 < p2) {
                    int tp = p1; p1 = p2; p2 = tp;
                    String tn = n1; n1 = n2; n2 = tn;
                }
                if (p3 < p4) {
                    int tp = p3; p3 = p4; p4 = tp;
                    String tn = n3; n3 = n4; n4 = tn;
                }
                if (p1 < p3) {
                    int tp = p1; p1 = p3; p3 = tp;
                    String tn = n1; n1 = n3; n3 = tn;
                }
                if (p2 < p4) {
                    int tp = p2; p2 = p4; p4 = tp;
                    String tn = n2; n2 = n4; n4 = tn;
                }
                if (p2 < p3) {
                    int tp = p2; p2 = p3; p3 = tp;
                    String tn = n2; n2 = n3; n3 = tn;
                }

                System.out.println("");
                System.out.println("pocet " + n1 + ":" + p1);
                System.out.println("pocet " + n2 + ":" + p2);
                System.out.println("pocet " + n3 + ":" + p3);
                System.out.println("pocet " + n4 + ":" + p4);
            }


            /*double celkovaCenaVsech = 0.0;
            Map<String, Integer> ksPodleProduktu = new HashMap<>();

            for (Zakaznik z : platniObjednavky) {
                celkovaCenaVsech += z.getCelkovaCena();

                ksPodleProduktu.put(
                        z.getProdukt(),
                        ksPodleProduktu.getOrDefault(z.getProdukt(), 0) + z.getPocetKusu()
                );
            }

            System.out.println("\n===========================================");
            System.out.println("Celková cena všech platných objednávek: "
                    + String.format("%.2f Kč", celkovaCenaVsech));
            System.out.println("-------------------------------------------");
            System.out.println("Počet objednaných kusů podle produktů:");
            for (Map.Entry<String, Integer> entry : ksPodleProduktu.entrySet()) {
                System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + " ks");
            }
            System.out.println("===========================================");*/

        } catch (Exception e) {
            System.out.println("Soubor se nepodařilo načíst.");
        }
    }
}