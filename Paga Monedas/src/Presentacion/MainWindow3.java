package Presentacion;

import Logic.General;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow3 extends JFrame implements ActionListener {

    private JPanel aleatorios;
    private General general;

    private JLabel profit;
    private JTextField bet;

    private JLabel machine;
    private Image imgF, newimgF;
    private JLabel FondoP;
    private Image img, newimg;

    private Thread threadFigures;

    private String pointsAll;
    private JButton profitBtn;

    public MainWindow3() {

        setSize(900, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Registro");
        setLayout(null);
    }
    public void begin() {
        beginComponent();
        addComponente();
        setVisible(true);
    }
    private void beginComponent() {

        imgF = new ImageIcon(getClass().getResource("/Recursos/maquinaTraga.png")).getImage();
        newimgF = imgF.getScaledInstance(700, 400, Image.SCALE_SMOOTH);


        profitBtn = new JButton("Cobrar");
        profitBtn.setBounds(485, 365, 115, 20);
        profitBtn.addActionListener(e->{
            this.setVisible(false);
            new puntuaciones(pointsAll);

        });

        machine = new JLabel();

        machine.setLayout(null);
        machine.setIcon(new ImageIcon(newimgF));

        machine.setBounds(25, 15, 700, 400);

        machine.setLayout(null);

        aleatorios= new JPanel();
        aleatorios.setBackground(Color.CYAN);
        aleatorios.setOpaque(false);
        aleatorios.setBounds(63,0,900,500);
        aleatorios.setLayout(null);

        int val = 0;

        profit= new JLabel(String.valueOf(val));
        profit.setForeground(Color.white);
        profit.setBounds(540,232,100,20);
        profit.setFont(new Font("lasVegasFont", Font.BOLD , 20));

        bet= new JTextField("1000");
        bet.setEnabled(false);
        bet.setBounds(525,150,70,20);

        general= new General(profit);
        general.begin();

        threadFigures= new Thread(general);


        img = new ImageIcon(getClass().getResource("/Recursos/Recurso 11.png")).getImage();
        newimg = img.getScaledInstance(900, 500, Image.SCALE_SMOOTH);

        FondoP = new JLabel();

        FondoP.setIcon(new ImageIcon(newimg));

        FondoP.setBounds(0, 0, 900, 500);

        FondoP.setLayout(null);

    }

    private void addComponente() {

        aleatorios.add(general);
        threadFigures.start();


        profitBtn.addActionListener(this);

        this.add(aleatorios);
        this.add(profitBtn);
        this.add(profit);
        this.add(bet);
        this.add(machine);
        this.add(FondoP);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente.equals(profitBtn)){
            pointsAll=profit.getText();
            this.setVisible(false);
            new puntuaciones(pointsAll);
        }
    }
}
