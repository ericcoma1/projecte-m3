package finestra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;

public class Finestra2 extends JFrame implements ActionListener{
    ArrayList<Rutina> alp = new ArrayList<>();
    /**
     *
     */
    JButton boto1;
    JTextField textBox1,textBox2,textBox3,textBox4;
    DefaultTableModel model;
    JTable taula;



    private static final long serialVersionUID = 1L;
    public JPanel panell;
    private JLabel jlDemanaDataNaixament, jlResultat;
    private JTextField jtfDataNaixament;
    private JButton jbBotoCalcula;
    private JTextArea jtArea;

    JTextField jtfEntrada;
    JButton jbMostra;
    JLabel jlEtiqueta;

    public Finestra2() {
        setVisible(true);
        setSize(420, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Rutina");

        setLocationRelativeTo(null); //null -> centre
        setMinimumSize(new Dimension(200,200));

        this.getContentPane().setBackground(Color.CYAN);
        iniciarComponents();

    }

    private void iniciarComponents(){
        posarPanells();
        posarLabels();
        posarBotons();
        posaTextBox();
        posarTaula();
    }


    public void posarPanells() {
        panell = new JPanel(); //creo el panell però encara no el tinc a la finestra
        this.getContentPane().add(panell);
        panell.setLayout(null);

    }


    private void posarLabels(){
        JLabel etiqueta = new JLabel("Rutina",SwingConstants.CENTER);

        etiqueta.setBounds(0,0,380, 70);
        etiqueta.setForeground(Color.black);
        etiqueta.setFont(new Font("cooper black",Font.PLAIN,24));

        JLabel etiqueta2 = new JLabel("Nom:",SwingConstants.CENTER);
        etiqueta2.setBounds(10,65,100, 40);

        JLabel etiqueta7 = new JLabel("Ex 3:",SwingConstants.CENTER);
        etiqueta7.setBounds(200,65,100, 40);

        JLabel etiqueta3 = new JLabel("Ex 1:",SwingConstants.CENTER);
        etiqueta3.setBounds(10,110,100, 40);

        JLabel etiqueta4 = new JLabel("Ex 2:",SwingConstants.CENTER);
        etiqueta4.setBounds(10,155,100, 40);

        JLabel etiqueta5 = new JLabel("Exercicis:",SwingConstants.CENTER);
        etiqueta5.setBounds(10,40,70, 30);
        etiqueta5.setForeground(Color.black);

        JLabel etiqueta6 = new JLabel("LLista:",SwingConstants.CENTER);
        etiqueta6.setBounds(10,250,50, 30);
        etiqueta6.setForeground(Color.black);

        panell.add(etiqueta);
        panell.add(etiqueta2);
        panell.add(etiqueta3);
        panell.add(etiqueta4);
        panell.add(etiqueta5);
        panell.add(etiqueta6);
        panell.add(etiqueta7);
    }

    private void posarBotons() {
        boto1 = new JButton("Descarregar Rutina");
        boto1.setBounds(10,210,150,30);
        panell.add(boto1);
        boto1.addActionListener(this);

    }



    private void posaTextBox() {
        textBox1 = new JTextField("Nom");
        textBox1.setBounds(100,70,100,30);
        panell.add(textBox1);
        textBox2 = new JTextField("Ex1");
        textBox2.setBounds(100,115,100,30);
        panell.add(textBox2);
        textBox3 = new JTextField("Ex2");
        textBox3.setBounds(100,160,100,30);
        panell.add(textBox3);
        textBox4 = new JTextField("Ex3");
        textBox4.setBounds(300,70,100,30);
        panell.add(textBox4);


    }

    private void posarTaula() {

        model = new DefaultTableModel();
        model.addColumn("Nom");
        model.addColumn("Ex1");
        model.addColumn("Ex2");
        model.addColumn("Ex3");
        taula = new JTable(model);
        taula.setBounds(20,280,300,200);
        panell.add(taula);
        //Es necessari crear el scroll pq es vegin les columnes
        JScrollPane scroll = new JScrollPane(taula,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20,280,360,200);
        panell.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boto1) {
            Rutina p = new Rutina(textBox1.getText(),textBox2.getText(),textBox3.getText(),textBox4.getText());
            alp.add(p);

            for (Rutina r : alp) {
                model.addRow(new String[]{r.getNom(),r.getEx1(),r.getEx2(),r.getEx3()});

                try {
                    FileWriter myWriter = new FileWriter(r.getNom()+".txt");
                    myWriter.write("Nom: "+r.getNom()+"\nExercici 1: "+r.getEx1()+"\nExercici 2: "+r.getEx2()+"\nExercici 3: "+r.getEx3());
                    myWriter.close();
                    System.out.println("fet.");
                } catch (IOException er) {
                    System.out.println("error.");
                    er.printStackTrace();
                }
            }


        }
    }
}