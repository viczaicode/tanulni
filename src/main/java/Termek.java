import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Termek {

    private String kod;
    private int ar;
    private String leiras;
    private int afa;


    public Termek(String kod, int ar) {
        this.kod = kod;
        this.ar = ar;
    }

    public Termek() {
    }

    public Termek(String kod, int ar, String leiras, int afa) {
        this.kod = kod;
        this.ar = ar;
        this.leiras = leiras;
        this.afa = afa;
    }

    public String getLeiras() {
        return leiras;
    }

    public int getAfa() {
        return afa;
    }



    public String getKod() {
        return kod;
    }

    public int getAr() {
        return ar;
    }

    // ----------------------------------//
    //            FELADATOK!!!           //
    // ----------------------------------//

    public int legdragabbTermek(List<Termek> lista) {
        int legdragabbTermek = 0;

        for (Termek termek : lista) {
            if (termek.getAr() > legdragabbTermek) {
                legdragabbTermek = termek.getAr();
            }
        }

        return  legdragabbTermek;
    }

    public int legolcsobbTermek(List<Termek> lista) {

        int legolcsobbTermek = Integer.MAX_VALUE;
        for (Termek termek : lista) {
            if (termek.getAr() < legolcsobbTermek) {
                legolcsobbTermek = termek.getAr();
            }
        }

        return  legolcsobbTermek;
    }

    public TreeSet<String> hanyKulonbozoTermekkodVan(List<Termek> lista) {
        TreeSet<String> termekKodok = new TreeSet<>();

        for (Termek termek : lista) {
            termekKodok.add(termek.getKod());
        }

        //Stream<String> sorted = termekKodok.stream().sorted();sorted.


        return  termekKodok;
    }

    public Map<String, Double> termekenkentAtlagar(List<Termek> lista) {

        Map<String, Double> osszegMap = new HashMap<>();
        Map<String, Integer> dbMap = new HashMap<>();

        for (Termek termek : lista) {
            String kod = termek.getKod();
            double ar = termek.getAr();

            if (osszegMap.containsKey(kod)) {
                osszegMap.put(kod, Double.valueOf(osszegMap.get(kod) + ar));
                dbMap.put(kod, Integer.valueOf(dbMap.get(kod) + 1));
            } else {
                osszegMap.put(kod, Double.valueOf(ar));
                dbMap.put(kod, Integer.valueOf(1));
            }
        }

        // ABC sorrend
        Map<String, Double> eredmeny = new TreeMap<>();

        for (String kod : osszegMap.keySet()) {
            double atlag = osszegMap.get(kod) / dbMap.get(kod);
            eredmeny.put(kod, Double.valueOf(atlag));
        }

        return eredmeny;
    }

    public double szorzottAr(double ar) {
        return  ar * 1.1;
    }


    public Map<String, Double> noveltArak(List<Termek> lista) {

        HashMap<String, Double> noveltArak = new HashMap<>();

        for (Termek termek : lista) {
            noveltArak.put(termek.getKod(), Double.valueOf(termek.getAr() * 1.1));
        }
        return noveltArak;
    }





    @Override
    public String toString() {
        return "Termek{" +
                "kod='" + kod + '\'' +
                ", ar=" + ar +
                ", leiras='" + leiras + '\'' +
                ", afa=" + afa +
                '}';
    }
}
