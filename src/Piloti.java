public class Piloti {

    private String kodPilota;
    private String planeta;
    private int rokNarozeni;
    private String typLodi;
    private int pocetVitezstvi;

    public Piloti(String kodPilota, String planeta, int rokNarozeni, String typLodi, int pocetVitezstvi) {
        this.kodPilota = kodPilota;
        this.planeta = planeta;
        this.rokNarozeni = rokNarozeni;
        this.typLodi = typLodi;
        this.pocetVitezstvi = pocetVitezstvi;
    }

    public String getKodPilota() {
        return kodPilota;
    }

    public void setKodPilota(String kodPilota) {
        this.kodPilota = kodPilota;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public int getRokNarozeni() {
        return rokNarozeni;
    }

    public void setRokNarozeni(int rokNarozeni) {
        this.rokNarozeni = rokNarozeni;
    }

    public String getTypLodi() {
        return typLodi;
    }

    public void setTypLodi(String typLodi) {
        this.typLodi = typLodi;
    }

    public int getPocetVitezstvi() {
        return pocetVitezstvi;
    }

    public void setPocetVitezstvi(int pocetVitezstvi) {
        this.pocetVitezstvi = pocetVitezstvi;
    }

    @Override
    public String toString() {
        return "Pilot: "+kodPilota+" "+planeta+" "+rokNarozeni+" "+pocetVitezstvi;
    }
}