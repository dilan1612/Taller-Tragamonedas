package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class instrucciones extends JFrame implements ActionListener {

    private JLabel FondoP;
    private Image imgF, newimgF;
    private JTextArea texto;
    private Image img, newimg;
    private JLabel imboton1;
    private JButton iniciar;

    public instrucciones(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
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
        imgF = new ImageIcon(getClass().getResource("/Recursos/fondo.png")).getImage();
        newimgF = imgF.getScaledInstance(900, 500, Image.SCALE_SMOOTH);

        FondoP = new JLabel();

        FondoP.setIcon(new ImageIcon(newimgF));

        FondoP.setBounds(0, 0, 900, 500);

        FondoP.setLayout(null);



        texto= new JTextArea("INSTRUCCIONES"+"\nPARA JUGAR EN NUESTRA MAQUINA DEBES COLOCAR EL VALOR DE LA\n APUESTA"
                + " ,DEBES DARLE AL BOTON INICIAR Y LAS FIGURAS VAN EMPEZAR A\n ROTAR, VAN A VER 3 BOTONES PARA QUE PUEDAS DETENER LAS" +
                " FIGURAS.\n SI DOS FIGURAS SON IGUALES EL VALOR DE LA APUESTA SE VA MULTIPLICAR\n POR 2, Y SI TRES FIGURAS SON" +
                " IGUALES EL VALOR SE VA A MULTIPLICAR\n POR 3.");
        texto.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 20));
        texto.setOpaque(false);
        texto.setForeground(Color.white);
        texto.setBounds(50,100,800,200);


        img = new ImageIcon(getClass().getResource("/Recursos/botonCasino.png")).getImage();
        newimg = img.getScaledInstance(320,300, Image.SCALE_SMOOTH);


        imboton1= new JLabel();
        imboton1.setIcon(new ImageIcon(newimg));
        imboton1.setBounds(490,325,320,50);
        imboton1.setLayout(null);

        iniciar= new JButton("PRINCIPAL");
        iniciar.setForeground(Color.white);
        iniciar.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 25));
        iniciar.setBounds(500,325,300,50);
        iniciar.addActionListener(this);

        iniciar.setBackground(Color.RED);
        iniciar.setOpaque(false);
    }

    private void addComponents() {

        add(texto);

        add(iniciar);
        add(imboton1);
        add(FondoP);

        setVisible(true);
    }

    public static void main(String[] args) {
        new instrucciones();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object componente = e.getSource();
        if (componente.equals(iniciar)){


            // player.setName(jugador.getText());
            // System.out.println(player.getName());
            //player.setBet(Double.parseDouble(money.getText()));
            //System.out.println(money.getText());
            this.setVisible(false);
            new Registro();
        }
    }
}
