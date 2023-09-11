package Presentacion;

import Logic.Gambler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame implements ActionListener {

    private JLabel FondoP;
    private Image imgF, newimgF;
    private JLabel ingreseName;
    private JTextField jugador;
    private JLabel ingreseDinero;
    private JTextField money;
    private JButton iniciar;
    private Image img, newimg;
    private JLabel imboton, imboton2;
    private Gambler player;
    private JButton instrucc;

    public Registro(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        player= new Gambler();
        setBackground(null);

        setLocationRelativeTo(null);
        setTitle("Registro");
        setResizable(false);

        begin();
    }

    private void begin() {
        beginComponents();
        addComponents();
    }

    private void beginComponents() {
        imgF = new ImageIcon(getClass().getResource("/Recursos/Recurso 11.png")).getImage();
        newimgF = imgF.getScaledInstance(900, 500, Image.SCALE_SMOOTH);

        FondoP = new JLabel();

        FondoP.setIcon(new ImageIcon(newimgF));

        FondoP.setBounds(0, 0, 900, 500);

        FondoP.setLayout(null);

        ingreseName= new JLabel("INGRESE EL NOMBRE DEL JUGADOR");
        ingreseName.setBounds(525,100,500,50);
        ingreseName.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 18));
        ingreseName.setForeground(Color.WHITE);
        ingreseName.setLayout(null);

        jugador= new JTextField();
        jugador.setBounds(525,150,300,50);
        jugador.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 22));
        jugador.setForeground(Color.white);
        jugador.setOpaque(false);

        ingreseDinero= new JLabel("INGRESE EL VALOR DE LA APUESTA");
        ingreseDinero.setBounds(500,200,500,50);
        ingreseDinero.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 18));
        ingreseDinero.setForeground(Color.WHITE);
        ingreseDinero.setLayout(null);

        money= new JTextField();
        money.setBounds(570,250,200,50);
        money.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 22));
        money.setForeground(Color.white);
        money.setOpaque(false);

        iniciar= new JButton("JUGAR");
        iniciar.setForeground(Color.white);
        iniciar.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 25));
        iniciar.setBounds(500,325,300,50);
        iniciar.setBorder(BorderFactory.createEmptyBorder());
        iniciar.setBackground(Color.RED);
        iniciar.setOpaque(false);
        iniciar.addActionListener(this);

        img = new ImageIcon(getClass().getResource("/Recursos/botonCasino.png")).getImage();
        newimg = img.getScaledInstance(300, 200, Image.SCALE_SMOOTH);


        imboton= new JLabel();
        imboton.setIcon(new ImageIcon(newimg));
        imboton.setBounds(500,250,300,200);
        imboton.setLayout(null);

        instrucc= new JButton("INSTRUCCIONES");
        instrucc.setForeground(Color.white);
        instrucc.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 25));
        instrucc.setBounds(500,375,300,50);
        instrucc.setBorder(BorderFactory.createEmptyBorder());
        instrucc.setBackground(Color.RED);
        instrucc.setOpaque(false);
        instrucc.addActionListener(this);

        imboton2= new JLabel();
        imboton2.setIcon(new ImageIcon(newimg));
        imboton2.setBounds(500,300,300,200);
        imboton2.setLayout(null);

    }

    private void addComponents() {
        add(ingreseName);
        add(jugador);
        add(ingreseDinero);
        add(money);
        add(iniciar);
        add(instrucc);
        add(imboton);
        add(imboton2);

        add(FondoP);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();

        if (componente.equals(iniciar)){
            this.setVisible(false);
            new MainWindow3().begin();
        }

        if (componente.equals(instrucc)){
            this.setVisible(false);
            new instrucciones();
        }

    }
}
