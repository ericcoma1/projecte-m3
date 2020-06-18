package finestra;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;

public class Finestra extends JFrame implements ActionListener {
    JButton boto1;
    JTextField textBox1,textBox2,textBox3;
    /**
     *
     */
    ArrayList<Client> alp = new ArrayList<>();

    private static final long serialVersionUID = 1L;
    public JPanel panell;

    private JLabel jlDemanaDataNaixament, jlResultat;
    private JTextField jtfDataNaixament;
    private JButton jbBotoCalcula;
    private JTextArea jtArea;

    JTextField jtfEntrada;
    JButton jbMostra;
    JLabel jlEtiqueta;



    public Finestra() {
        setVisible(true);
        setSize(1500, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Projecte Rutines");

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
        posarLlistesDesplegables();
        posarData();
    }


    public void posarPanells() {
        panell = new JPanel(); //creo el panell però encara no el tinc a la finestra
        this.getContentPane().add(panell);
        panell.setLayout(null);
    }


    private void posarLabels(){
        JLabel etiqueta = new JLabel("Clients",SwingConstants.CENTER);

        etiqueta.setBounds(0,0,380, 70);
        etiqueta.setForeground(Color.black);
        etiqueta.setFont(new Font("cooper black",Font.PLAIN,24));

        JLabel etiqueta2 = new JLabel("Nom:",SwingConstants.CENTER);
        etiqueta2.setBounds(10,65,100, 40);

        JLabel etiqueta3 = new JLabel("Cognoms:",SwingConstants.CENTER);
        etiqueta3.setBounds(10,110,100, 40);

        JLabel etiqueta4 = new JLabel("DNI:",SwingConstants.CENTER);
        etiqueta4.setBounds(10,155,100, 40);

        JLabel etiqueta5 = new JLabel("Dades:",SwingConstants.CENTER);
        etiqueta5.setBounds(10,40,50, 30);
        etiqueta5.setForeground(Color.black);

        JLabel etiqueta6 = new JLabel("LLista:",SwingConstants.CENTER);
        etiqueta6.setBounds(10,250,50, 30);
        etiqueta6.setForeground(Color.black);


        JLabel etiqueta7 = new JLabel("Rutina",SwingConstants.CENTER);

        etiqueta7.setBounds(500,0,380, 70);
        etiqueta7.setForeground(Color.black);
        etiqueta7.setFont(new Font("cooper black",Font.PLAIN,24));

        JLabel etiqueta8 = new JLabel("Nom:",SwingConstants.CENTER);
        etiqueta8.setBounds(500,65,100, 40);

        JLabel etiqueta9 = new JLabel("Ex 1:",SwingConstants.CENTER);
        etiqueta9.setBounds(500,110,100, 40);

        JLabel etiqueta10 = new JLabel("Ex 2:",SwingConstants.CENTER);
        etiqueta10.setBounds(500,155,100, 40);

        JLabel etiqueta11 = new JLabel("Ex 3:",SwingConstants.CENTER);
        etiqueta11.setBounds(500,195,100, 40);

        JLabel etiqueta12 = new JLabel("Exercicis:",SwingConstants.CENTER);
        etiqueta12.setBounds(500,40,70, 30);
        etiqueta12.setForeground(Color.black);




        JLabel etiqueta16 = new JLabel("Cercar Rutines",SwingConstants.CENTER);
        etiqueta16.setBounds(1000,0,380, 70);
        etiqueta16.setForeground(Color.black);
        etiqueta16.setFont(new Font("cooper black",Font.PLAIN,24));

        JLabel etiqueta17 = new JLabel("Cercar Client:",SwingConstants.CENTER);
        etiqueta17.setBounds(1000,50,100, 70);





        JLabel etiqueta13 = new JLabel("Asociar rutina amb client",SwingConstants.CENTER);
        etiqueta13.setBounds(500,270,380, 70);
        etiqueta13.setForeground(Color.black);
        etiqueta13.setFont(new Font("cooper black",Font.PLAIN,24));


        JLabel etiqueta14 = new JLabel("Rutina:",SwingConstants.CENTER);
        etiqueta14.setBounds(500,310,100, 70);

        JLabel etiqueta15 = new JLabel("Client:",SwingConstants.CENTER);
        etiqueta15.setBounds(500,370,100, 70);

        JLabel etiqueta18 = new JLabel("Dia:",SwingConstants.CENTER);
        etiqueta18.setBounds(500,430,100, 70);

        JLabel etiqueta19 = new JLabel("Veure Rutina",SwingConstants.CENTER);
        etiqueta19.setBounds(1000,370,380, 70);
        etiqueta19.setForeground(Color.black);
        etiqueta19.setFont(new Font("cooper black",Font.PLAIN,24));

        JLabel etiqueta20 = new JLabel("Client:",SwingConstants.CENTER);
        etiqueta20.setBounds(1000,410,100, 70);

        JLabel etiqueta21 = new JLabel("Dia:",SwingConstants.CENTER);
        etiqueta21.setBounds(1000,450,100, 70);

        panell.add(etiqueta);
        panell.add(etiqueta2);
        panell.add(etiqueta3);
        panell.add(etiqueta4);
        panell.add(etiqueta5);
        panell.add(etiqueta6);
        panell.add(etiqueta7);
        panell.add(etiqueta8);
        panell.add(etiqueta9);
        panell.add(etiqueta10);
        panell.add(etiqueta11);
        panell.add(etiqueta12);
        panell.add(etiqueta13);
        panell.add(etiqueta14);
        panell.add(etiqueta15);
        panell.add(etiqueta16);
        panell.add(etiqueta17);
        panell.add(etiqueta18);
        panell.add(etiqueta19);
        panell.add(etiqueta20);
        panell.add(etiqueta21);

    }

    private void posarBotons() {
        boto1 = new JButton("Afegir");
        boto1.setBounds(10,210,90,30);
        panell.add(boto1);
        boto1.addActionListener(this);
        JButton boto2 = new JButton("Modificar");
        boto2.setBounds(105,210,90,30);
        panell.add(boto2);

        JButton boto3 = new JButton("Eliminar");
        boto3.setBounds(200,210,90,30);
        panell.add(boto3);

        JButton boto4 = new JButton("Buscar");
        boto4.setBounds(295,210,90,30);
        panell.add(boto4);


        JButton boto5 = new JButton("relacionar");
        boto5.setBounds(500,520,100,30);
        panell.add(boto5);

        JButton boto6 = new JButton("Afegir");
        boto6.setBounds(500,250,90,30);
        panell.add(boto6);

        JButton boto7 = new JButton("Modificar");
        boto7.setBounds(600,250,90,30);
        panell.add(boto7);

        JButton boto8 = new JButton("Eliminar");
        boto8.setBounds(700,250,90,30);
        panell.add(boto8);

        JButton boto9 = new JButton("Buscar");
        boto9.setBounds(800,250,90,30);
        panell.add(boto9);

        JButton boto10 = new JButton("Buscar");
        boto10.setBounds(1210,70,100,30);
        panell.add(boto10);

        JButton boto11 = new JButton("Buscar");
        boto11.setBounds(1000,520,100,30);
        panell.add(boto11);
    }

    private void posarLlistesDesplegables() {

        Client u1 = new Client("eric","coma","44");
        Client u2 = new Client("sergi","sabata","24");
        DefaultComboBoxModel<Client> model = new DefaultComboBoxModel<Client>();
        JComboBox<Client> llista2 = new JComboBox<Client>(model);
        model.addElement(u1);
        model.addElement(u2);
        llista2.setBounds(600,330,200,30);
        panell.add(llista2);

        Client u3 = new Client("joel","a","45");
        Client u4 = new Client("oriol","s","25");
        DefaultComboBoxModel<Client> model2 = new DefaultComboBoxModel<Client>();
        JComboBox<Client> llista = new JComboBox<Client>(model2);
        model.addElement(u3);
        model.addElement(u4);
        llista.setBounds(600,330,200,30);
        panell.add(llista);

    }

    private void posaTextBox() {
         textBox1 = new JTextField("Nom");
        textBox1.setBounds(100,70,100,30);
        panell.add(textBox1);
        JTextField textBox2 = new JTextField("Cognoms");
        textBox2.setBounds(100,115,100,30);
        panell.add(textBox2);
        JTextField textBox3 = new JTextField("DNI");
        textBox3.setBounds(100,160,100,30);
        panell.add(textBox3);



        JTextField textBox4 = new JTextField("Ex1");
        textBox4.setBounds(600,115,100,30);
        panell.add(textBox4);
        JTextField textBox5 = new JTextField("Ex2");
        textBox5.setBounds(600,158,100,30);
        panell.add(textBox5);
        JTextField textBox6 = new JTextField("Ex3");
        textBox6.setBounds(600,200,100,30);
        panell.add(textBox6);
        JTextField textBox7 = new JTextField("Nom");
        textBox7.setBounds(600,70,100,30);
        panell.add(textBox7);



        JTextField textBox8 = new JTextField("Nom");
        textBox8.setBounds(1100,70,100,30);
        panell.add(textBox8);

        JTextField textBox9 = new JTextField("Nom");
        textBox9.setBounds(1100,430,100,30);
        panell.add(textBox9);
    }

    private void posarTaula() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nom");
        model.addColumn("DNI");
        for (int i=0;i<alp.size();i++) {

            model.addRow(new Client[]{alp.get(i)});

        }
        JTable taula = new JTable(model);
        taula.setBounds(20,280,300,200);
        panell.add(taula);
        //Es necessari crear el scroll pq es vegin les columnes
        JScrollPane scroll = new JScrollPane(taula,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20,280,360,200);
        panell.add(scroll);



        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("NOM RUTINA");
        model2.addColumn("Ex 1");
        model2.addColumn("Ex 2");
        model2.addColumn("Ex 3");
        JTable taula2 = new JTable(model2);
        taula2.setBounds(1000,150,300,200);
        panell.add(taula2);
        //Es necessari crear el scroll pq es vegin les columnes
        JScrollPane scroll2 = new JScrollPane(taula2,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll2.setBounds(1000,150,360,200);
        panell.add(scroll2);




        DefaultTableModel model3 = new DefaultTableModel();
        model3.addColumn("NOM RUTINA");
        model3.addColumn("Ex 1");
        model3.addColumn("Ex 2");
        model3.addColumn("Ex 3");
        JTable taula3 = new JTable(model3);
        taula3.setBounds(1000,600,300,200);
        panell.add(taula3);
        //Es necessari crear el scroll pq es vegin les columnes
        JScrollPane scroll3 = new JScrollPane(taula3,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll3.setBounds(1000,600,360,200);
        panell.add(scroll3);
    }
    private void posarData(){
        JDateChooser fecha_prest = new JDateChooser();
        fecha_prest.setBounds(600, 450, 126, 23);
        panell.add(fecha_prest);

        JDateChooser fecha_prest2 = new JDateChooser();
        fecha_prest2.setBounds(1100, 475, 126, 23);
        panell.add(fecha_prest2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==boto1) {
            Client p = new Client(textBox1.getText(),textBox2.getText(),textBox3.getText());
            alp.add(p);

        }
    }
}