package view;

import controller.TermekController;
import model.Termek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class TermekGUI extends JFrame {

    private JButton btnLegdragabb, btnLegolcsobb, btnTermekKodok, btnNoveltArak, btnAtlagArak;
    private DefaultListModel<String> dlm;
    private JList<String> lstElemek;
    private TermekController tk;
    private Termek termek;


    public TermekGUI() {
        formBeallitasok();
        init();

        JPanel pnlFent = new JPanel(new FlowLayout());
        pnlFent.add(btnLegdragabb);
        pnlFent.add(btnLegolcsobb);
        pnlFent.add(btnTermekKodok);
        pnlFent.add(btnNoveltArak);
        pnlFent.add(btnAtlagArak);
        add(pnlFent,BorderLayout.NORTH);
        add(lstElemek, BorderLayout.CENTER);

        btnLegdragabb.addActionListener(e -> onLegdragabb());
        btnLegolcsobb.addActionListener(e -> onLegolcsobb());
        btnTermekKodok.addActionListener(e -> onKulonbozoTermekkodok());
        btnNoveltArak.addActionListener(e -> onNoveltArak());
        btnAtlagArak.addActionListener(e -> onAtlagArak());

    }

    private void formBeallitasok() {
        setTitle("Raktáron");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //kilépés exit-re
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int valasz = JOptionPane.showConfirmDialog(TermekGUI.this, "Biztosan ki akarsz lépni?");
                if (valasz == 0) {
                    System.exit(0);
                } else {

                }

            }
        });
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

    }

    private void init() {

        tk = new TermekController();
        termek = new Termek();
        btnLegdragabb = new JButton("Legdragabb termek");
        btnLegolcsobb = new JButton("Legolcsobb termek");
        btnTermekKodok = new JButton("Kulonbozo termekkodok");
        btnNoveltArak = new JButton("Növelt árak");
        btnAtlagArak = new JButton("Átlag árak");


        dlm = new DefaultListModel<>();
        lstElemek = new JList<>(dlm);

    }

    private void onLegdragabb() {
        dlm.removeAllElements();
        List<Termek> lista = tk.peldanyosit("termekek.txt");
        String s = String.valueOf(termek.legdragabbTermek(lista));
        dlm.addElement(s);
    }

    private void onLegolcsobb() {
        dlm.removeAllElements();
        List<Termek> lista = tk.peldanyosit("termekek.txt");
        String s = String.valueOf(termek.legolcsobbTermek(lista));
        dlm.addElement(s);
    }

    private void onKulonbozoTermekkodok() {
        dlm.removeAllElements();
        List<Termek> lista = tk.peldanyosit("termekek.txt");
        TreeSet<String> s = termek.hanyKulonbozoTermekkodVan(lista);

        for (String string : s) {
            dlm.addElement(string);
        }
    }

    private void onNoveltArak() {
        dlm.removeAllElements();
        List<Termek> lista = tk.peldanyosit("termekek.txt");
        Map<String, Double> s = termek.noveltArak(lista);

        for (Double value : s.values()) {
            dlm.addElement(String.valueOf(value));
        }
    }

    private void onAtlagArak() {
        dlm.removeAllElements();
        List<Termek> lista = tk.peldanyosit("termekek.txt");
        Map<String, Double> s = termek.termekenkentAtlagar(lista);

        for (Double value : s.values()) {
            dlm.addElement(String.valueOf(value));
        }
    }
}
