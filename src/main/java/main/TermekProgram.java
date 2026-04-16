package main;

import controller.TermekController;
import view.TermekGUI;

import javax.swing.*;

public class TermekProgram {


    public static void main(String[] args) {

        new TermekController();

        SwingUtilities.invokeLater(() -> {

            //new Esemenyek().setVisible(true);
            new TermekGUI().setVisible(true);

        });
    }

}
