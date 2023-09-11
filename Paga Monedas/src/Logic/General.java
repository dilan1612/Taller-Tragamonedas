package Logic;

import Logic.RandomFigures;
import Persistence.CSVReader;
import Presentacion.puntuaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class General extends JPanel implements Runnable{

    private JPanel panelIcons;
    private JLabel IconOne;
    private JLabel IconTwo;
    private JLabel IconThree;

    private JButton startBtn;
    private JButton stopBtnOne;
    private JButton stopBtnTwo;
    private JButton stopBtnThree;

    private Thread threadOne;
    private Thread threadTwo;
    private Thread threadThree;

    private Image scaledImage;
    private ImageIcon scaledIcon;

    private RandomFigures figuresOne;
    private RandomFigures figuresTwo;
    private RandomFigures figuresThree;

    private boolean threadsRunning;
    private String profitOne,profitTwo,profitThree;
    private JLabel profitView;

    private JLabel imboton1, imboton2, imboton3, imboton4;

    private Image img, newimg;


    public General(JLabel profitLb) {

        setSize(900, 500);
        setLayout(null);
        setBackground(null);
        setOpaque(false);
        this.profitView =profitLb;
        this.threadsRunning=false;
    }

    public void begin(){
        begincomponent();
        initComponent();
    }

    private void begincomponent() {
        IconOne = new JLabel();
        IconOne.setBounds(0, 0, 100, 100);

        IconTwo = new JLabel();
        IconTwo.setBounds(115, 0, 100, 100);

        IconThree = new JLabel();
        IconThree.setBounds(230, 0, 100, 100);

        panelIcons = new JPanel();
        panelIcons.setBounds(50, 200, 400, 105);
        panelIcons.setOpaque(false);
        panelIcons.setBackground(Color.white);
        panelIcons.setLayout(null);

        stopBtnOne = new JButton("STOP 1");
        stopBtnOne.setBounds(5,410,120,50);
        stopBtnOne.setForeground(Color.white);
        stopBtnOne.setBackground(null);
        stopBtnOne.setFont(new Font("lasVegasFont", Font.BOLD , 15));
        stopBtnOne.setOpaque(false);

        stopBtnTwo = new JButton("STOP 2");
        stopBtnTwo.setBounds(130,410,120,50);
        stopBtnTwo.setForeground(Color.white);
        stopBtnTwo.setBackground(null);
        stopBtnTwo.setFont(new Font("lasVegasFont", Font.BOLD , 15));
        stopBtnTwo.setOpaque(false);

        stopBtnThree = new JButton("STOP 3");
        stopBtnThree.setBounds(255,410,120,50);
        stopBtnThree.setForeground(Color.white);
        stopBtnThree.setBackground(null);
        stopBtnThree.setFont(new Font("lasVegasFont", Font.BOLD , 15));
        stopBtnThree.setOpaque(false);

        startBtn = new JButton("INICIAR");
        startBtn.setBounds(375,410,120,50);
        startBtn.setForeground(Color.white);
        startBtn.setBackground(null);
        startBtn.setFont(new Font("lasVegasFont", Font.BOLD , 15));
        startBtn.setOpaque(false);



        ImageIcon icon = new ImageIcon("Images/img/bar.png");
        scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(scaledImage);

        IconOne.setIcon(scaledIcon);
        IconTwo.setIcon(scaledIcon);
        IconThree.setIcon(scaledIcon);

        img = new ImageIcon(getClass().getResource("/Recursos/botonCasino.png")).getImage();
        newimg = img.getScaledInstance(128,300, Image.SCALE_SMOOTH);

        imboton1= new JLabel();
        imboton1.setIcon(new ImageIcon(newimg));
        imboton1.setBounds(0,410,125,50);
        imboton1.setLayout(null);

        imboton2= new JLabel();
        imboton2.setIcon(new ImageIcon(newimg));
        imboton2.setBounds(127,410,125,50);
        imboton2.setLayout(null);

        imboton3= new JLabel();
        imboton3.setIcon(new ImageIcon(newimg));
        imboton3.setBounds(250,410,125,50);
        imboton3.setLayout(null);

        imboton4= new JLabel();
        imboton4.setIcon(new ImageIcon(newimg));
        imboton4.setBounds(375,410,125,50);
        imboton4.setLayout(null);
    }

    public void initComponent(){

        initThread();

        startBtn.addActionListener(e -> {
                initThread();
                startThread();
        });



        stopBtnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (figuresOne != null){
                    figuresOne.stopThread();
                }
            }
        });
        stopBtnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (figuresTwo!=null ){
                    figuresTwo.stopThread();
                }
            }
        });
        stopBtnThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (figuresThree !=null){
                    figuresThree.stopThread();
                }
            }
        });

        panelIcons.add(IconOne);
        panelIcons.add(IconTwo);
        panelIcons.add(IconThree);


        this.add(panelIcons);

        this.add(startBtn);
        this.add(stopBtnOne);
        this.add(stopBtnTwo);
        this.add(stopBtnThree);

        this.add(imboton1);
        this.add(imboton2);
        this.add(imboton3);
        this.add(imboton4);

    }
    private void initThread() {

        figuresOne = new RandomFigures(IconOne,this);
        figuresTwo = new RandomFigures(IconTwo,this);
        figuresThree = new RandomFigures(IconThree,this);

        threadOne = new Thread(figuresOne);
        threadTwo = new Thread(figuresTwo);
        threadThree = new Thread(figuresThree);
    }

    private void startThread(){

        threadsRunning=true;

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        new Thread(()->{

            while (threadOne.isAlive() || threadTwo.isAlive() || threadThree.isAlive()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            profitView.setText(profit(getProfitOne(),getProfitTwo(),getProfitThree()));

        }).start();
    }

    @Override
    public void run() {

        while (threadsRunning){
            if ((threadOne == null || !threadOne.isAlive()) && (threadTwo == null || !threadTwo.isAlive()) && (threadThree == null || !threadThree.isAlive())) {
                startThread();
            }
        }

        threadsRunning=false;
    }
    public void setProfit(String number,Thread thread) {
        if (thread==threadOne){
           // this.profitOne =number;
            setProfitOne(number);

        }else if (thread==threadTwo){
         //   this.profitTwo=number;
            setProfitTwo(number);

        } else if (thread==threadThree) {
            //this.profitThree=number;
            setProfitThree(number);
        }
    }

    public String getProfitOne() {
        return profitOne;
    }

    public void setProfitOne(String profitOne) {
        this.profitOne = profitOne;
    }

    public String getProfitTwo() {
        return profitTwo;
    }

    public void setProfitTwo(String profitTwo) {
        this.profitTwo = profitTwo;
    }

    public String getProfitThree() {
        return profitThree;
    }

    public void setProfitThree(String profitThree) {
        this.profitThree = profitThree;
    }

    private String profit(String profitOne,String profitTwo, String profitThree){

        String result="";
        int val=0;

        CSVReader read = new CSVReader();
        read.readData();

        List<String[]> data = read.readData();
        for (String[] row : data) {
            if (profitOne.equals(row[0]) && profitTwo.equals(row[1]) && profitThree.equals(row[2])) {
                val = Integer.parseInt(row[3])*1000;
                return String.valueOf(val);
            }
        }
            if ((profitOne.equals(profitTwo)) || (profitTwo.equals(profitThree) || (profitOne.equals(profitThree)))){
                val=1000*2;
                result=val+"";
            }
            else{
                result = "0";
            }
        return result;
    }
}
