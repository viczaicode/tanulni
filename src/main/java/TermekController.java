import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TermekController {

    Termek termek = new Termek();

    public TermekController() {
        feladatok();
    }

    public List<Termek> peldanyosit(String fajlnev) {
        List<Termek> termekek = new ArrayList<>();

        try {
            List<String> sorok = Files.readAllLines(Path.of(fajlnev));
            for (String sor : sorok) {
                String[] adatok = sor.split(" ");
                termekek.add(new Termek(adatok[0], Integer.parseInt(adatok[1])));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  termekek;
    }

    public void feladatok() {
        List<Termek> lista = peldanyosit("termekek.txt");


        //1. FELADAT
        System.out.println("a legmagasabb ár: " + termek.legdragabbTermek(lista));
        //System.out.println("a legolcsóbb ár: " + termek.legolcsobbTermek(lista));

        //2. FELADAT
        System.out.print("a különböző termékkódok ABC szerint:");
        List<String> termekKodok = new ArrayList<>();
        for (String s : termek.hanyKulonbozoTermekkodVan(lista)) {
            termekKodok.add(s);
        }
        for (String s : termekKodok) {
            System.out.print(s + ",");
        }


        System.out.println(" ");
        //3. FELADAT
        System.out.println("az átlagárak ABC szerint:" + termek.termekenkentAtlagar(lista));







        System.out.println("a 10%-kal növelt árak:");
        System.out.println(termek.noveltArak(lista));
    }



}
