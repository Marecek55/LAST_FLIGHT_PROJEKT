package miniHra;

import Zaklad.Hra;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Tato trida spousti miniHru Skorabky
 */
public class MiniHra extends JPanel {
   boolean dohrano = false;
   boolean dohranoPomocne = false;
   int micekPozice = 0;
   boolean zadalspravne = false;
    int odpoved = 0;

    public boolean isDohrano() {
        return dohrano;
    }



    /**
     * Tato metoda se stara o to aby se prebravilo a predelali skorapky po skonceni
     * @param g the <code>Graphics</code> object to protect
     */
   @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       g.setColor(Color.BLUE);
       if (!dohrano) {

           g.fillRect(50 ,170 , 100, 250);
           g.fillRect(200 ,  170, 100, 250);
           g.fillRect(350 , 170, 100, 250);


       }else {
           switch (micekPozice) {
               case 1:
                   g.fillRect(50, 50, 100, 250);
                   g.fillRect(200, 170, 100, 250);
                   g.fillRect(350, 170, 100, 250);
                   g.setColor(Color.RED);
                   g.fillOval(75, 350, 50, 50);
                   break;
               case 2:
                   g.fillRect(50, 170, 100, 250);
                   g.fillRect(200, 50, 100, 250);
                   g.fillRect(350, 170, 100, 250);
                   g.setColor(Color.RED);
                   g.fillOval(225, 350, 50, 50);
                   break;
               case 3:
                   g.fillRect(50, 170, 100, 250);
                   g.fillRect(200, 170, 100, 250);
                   g.fillRect(350, 50, 100, 250);
                   g.setColor(Color.RED);
                   g.fillOval(375, 350, 50, 50);
                   break;
           }


       }

    }

    /**
     * Tato metoda spousti hru skorapky
     * @param hra
     */
    public void skorapky(Hra hra){
        System.out.print(hra.getData().nacteniRadkuSouboru("skorapky", "START", null));
        Scanner sc = new Scanner(System.in);

        do {
            try {
                 odpoved = sc.nextInt();
                 if (hra.getCas().getZbyvajiciCas()>=odpoved && odpoved >= 0) {
                     zadalspravne = true;
                 }else {
                     System.out.println("Nemas tolik casu");
                 }
            }catch (InputMismatchException e){
                System.out.println("Spatne zadane musis zadat cislo");
                sc.next();

            }
        }while (!zadalspravne);
       JFrame okno = new JFrame();
       okno.setSize(500 ,500);
       okno.setBackground(Color.black);
       okno.setLayout(new BorderLayout());
       okno.add(this, BorderLayout.CENTER);
        Random rd = new Random();
        micekPozice = rd.nextInt(1,4);
       okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel panelNaTlacitka = new JPanel();
       JButton tlacitko1 = new JButton("1");
       tlacitko1.setSize(30, 20);
       JButton tlacitko2 = new JButton("2");
       tlacitko2.setSize(30, 20);
       JButton tlacitko3 = new JButton("3");
       tlacitko3.setSize(30, 20);
       panelNaTlacitka.add(tlacitko1);
       panelNaTlacitka.add(tlacitko2);
       panelNaTlacitka.add(tlacitko3);
       okno.add(panelNaTlacitka, BorderLayout.SOUTH);
       tlacitko1.addActionListener(e -> {
           pomocnaMetoda(hra, okno, 1);
       });
        tlacitko2.addActionListener(e -> {
            pomocnaMetoda(hra, okno, 2);
        });
        tlacitko3.addActionListener(e -> {
            pomocnaMetoda(hra, okno, 3);
        });
       okno.setVisible(true);


    }

    /**
     * Tato metoda pomaha a zkracuje metodu pro vsechny tri tlacitka
     * @param hra
     * @param okno
     * @param cislo
     */
    public void pomocnaMetoda(Hra hra, JFrame okno, int cislo){
       dohrano = true;

        this.paintImmediately(0, 0, getWidth(), getHeight());
            if (micekPozice == cislo) {
                JOptionPane.showMessageDialog(this, "SUPEEER VYHRAVAS " + odpoved*2 +" Casu ");
                hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas()+ odpoved*2);

            }else{
                JOptionPane.showMessageDialog(this, "ALE NEE ZTRACIS " + odpoved +" Casu ");
                hra.getCas().setZbyvajiciCas(hra.getCas().getZbyvajiciCas() - odpoved);


            }
        System.out.println(hra.getCas().odecteniCasu(hra));
            okno.dispose();
    }

    public boolean isDohranoPomocne() {
        return dohranoPomocne;
    }

    public void setDohranoPomocne(boolean dohranoPomocne) {
        this.dohranoPomocne = dohranoPomocne;
    }
}
