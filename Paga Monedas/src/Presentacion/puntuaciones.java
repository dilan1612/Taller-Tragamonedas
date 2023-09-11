package Presentacion;

import javax.swing.*;
import java.awt.*;

public class puntuaciones extends JFrame {

    private JLabel FondoP;
    private Image imgF, newimgF;
    private JLabel gameOver;
    private Image imgG, newimgG;
    private JLabel points;

    private String pointsAll;


    public puntuaciones(String pointsAll){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setBackground(null);
        this.pointsAll=pointsAll;
        setLocationRelativeTo(null);
        setTitle("puntuaciones");
        setResizable(false);

        begin();
    }

    private void begin() {
        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        imgF = new ImageIcon(getClass().getResource("/Recursos/fondo.png")).getImage();
        newimgF = imgF.getScaledInstance(900, 500, Image.SCALE_SMOOTH);

        FondoP = new JLabel();

        FondoP.setIcon(new ImageIcon(newimgF));

        FondoP.setBounds(0, 0, 900, 500);

        FondoP.setLayout(null);

        imgG = new ImageIcon(getClass().getResource("/Recursos/gameover3.png")).getImage();
        newimgG = imgG.getScaledInstance(400, 400, Image.SCALE_SMOOTH);

        gameOver= new JLabel();
        gameOver.setLayout(null);
        gameOver.setIcon(new ImageIcon(newimgG));
        gameOver.setBounds(250, -25, 400, 400);
        gameOver.setLayout(null);

        points= new JLabel("SU PUNTAJE ES: "+pointsAll);
        points.setBounds(300,300,500,50);
        points.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 18));
        points.setForeground(Color.WHITE);
        points.setLayout(null);
    }

    private void addComponents() {

        add(gameOver);
        add(points);

        add(FondoP);
        setVisible(true);
    }
}
