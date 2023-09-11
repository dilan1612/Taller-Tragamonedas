package Logic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RandomFigures implements Runnable {
    private JPanel panel;
    private ArrayList<ImageIcon> images;
    private JLabel label;
    private static final int LAPSO = 300;

    private int imageSize = 100;
    private String indexTx;
    private General gn;

    private String number;

    private volatile boolean state = true;
    public RandomFigures(JLabel label, General gn) {
        this.gn = gn;
        this.label = label;
        images=addImg();
    }
    @Override
    public synchronized  void run() {
        int cont =0;
        int value=0;
        while (cont<= LAPSO && state){
            int rnd = (int) (Math.random() * images.size());
            Image scaledImage = images.get(rnd).getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            label.setIcon(scaledIcon);
            this.number=String.valueOf(rnd);
            try {
                Thread.sleep(cont);
            } catch (InterruptedException e) {
                break;
            }
            cont+=5;
        }

        gn.setProfit(selectedFruit(Integer.parseInt(this.number)),Thread.currentThread());
    }
    private ArrayList<ImageIcon> addImg (){
        images = new ArrayList<>();

        images.add(new ImageIcon("Images/img/bar.png"));
        images.add(new ImageIcon("Images/img/trebol.png"));
        images.add(new ImageIcon("Images/img/corona.png"));
        images.add(new ImageIcon("Images/img/diamante.png"));
        images.add(new ImageIcon("Images/img/siete.png"));
        images.add(new ImageIcon("Images/img/fresa.png"));
        images.add(new ImageIcon("Images/img/uva.png"));

        return images;
    }
    public String selectedFruit(int value) {

        String nameFruit = "";

        switch (value) {
            case 0:
                nameFruit = "BAR";
                break;
            case 1:
                nameFruit = "TREBOL";
                break;
            case 2:
                nameFruit = "CORONA";
                break;
            case 3:
                nameFruit = "DIAMANTE";
                break;
            case 4:
                nameFruit = "SIETE";
                break;
            case 5:
                nameFruit = "FRESA";
                break;
            case 6:
                nameFruit = "UVA";
                break;
        }
        return nameFruit;
    }
    public void stopThread(){
        this.state=false;
    }
    public String getIndexTx() {
        return indexTx;
    }
}