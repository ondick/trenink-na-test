import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private Pattern pKodPilota = Pattern.compile("^[A-Z]{3}\\d{3}$");
    private Pattern pRokNarozeni = Pattern.compile("^\\d{4}$");
    private Pattern pVitezstvi = Pattern.compile("^\\d+$");

    public boolean validujRadek(String radek, List<String> chyby, List<Piloti> platniPiloti) {
        // limit -1 zajistí, že nepřehlédne prázdné hodnoty na konci řádku
        String[] casti = radek.split(";");

        if (casti.length != 5) {
            chyby.add("neplatný počet údajů na řádku");
            return false;
        }

        String kodPilota = casti[0].trim();
        String planeta = casti[1].trim();
        String rokNarozeni = casti[2].trim();
        String typLodi = casti[3].trim();
        String pocetVitezstvi = casti[4].trim();

        boolean ok = true;

        Matcher mKodPilota = pKodPilota.matcher(kodPilota);
        if (!mKodPilota.matches()) {
            chyby.add("neplatný kod");
            ok = false;
        }

        if (!planeta.equals("Země") &&
                !planeta.equals("Mars") &&
                !planeta.equals("Venuše") &&
                !planeta.equals("Titan") &&
                !planeta.equals("Krypton")) {
            chyby.add("neplatna planeta");
            ok = false;
        }

        Matcher mRokNarozeni = pRokNarozeni.matcher(rokNarozeni);
        if (!mRokNarozeni.matches()) {
            chyby.add("neplatny rok narozeni");
            ok = false;
        } else if (Integer.parseInt(rokNarozeni) < 1900 || Integer.parseInt(rokNarozeni) > 2026) {
            chyby.add("neplatny rok narozeni");
            ok = false;
        }

        if (!typLodi.equals("Stíhač") &&
                !typLodi.equals("Transportér") &&
                !typLodi.equals("Explorer") &&
                !typLodi.equals("Bitevník")) {
            chyby.add("neplatna lod");
            ok = false;
        }



        Matcher mVitezstvi = pVitezstvi.matcher(pocetVitezstvi);
        if (!mVitezstvi.matches()) {
            chyby.add("neplatny pocet vitezstvi");
            ok = false;
        }else if(Integer.parseInt(pocetVitezstvi) < 0 || Integer.parseInt(pocetVitezstvi) > 1000){
            chyby.add("neplatny pocet vitezstvi");
            ok = false;
        }


        return ok;
    }
}