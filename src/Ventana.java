import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ventana extends JFrame {
    private JPanel panel1, Pinicio, Pmenus, Popciones, Pjuego, Pfacil, Pmedio, Pdificil, Paspectos, PopcionesJuego;
    private JButton Bfacil, Bmedio, Bdificil, Baspecto, Bvolver, Bequipos, Bmemes, Balbumes, Breiniciar, Bempezar;
    private JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16, Ltimer;
    private Timer Ctimer;
    private int horas = 0, minutos = 0, segundos = 0;
    private ArrayList<Integer> images = new ArrayList<>();
    private String cartas = "Memes";
    private String incognita = "incognita";
    private JLabel[] labels = {L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15, L16}; //Adentro van los labels
    int[] vector = new int[16];

    public void ActualizarLtimer() //Actualiza el label del cronometro
    {
        String ltimer = horas + "h:" + minutos + "m:" + segundos + "s";
        Ltimer.setText(ltimer);
    }

    public Ventana() {
        super("Memory Game");
        for (int i = 0; i < 2; i++) {
            images.add(1);
            images.add(2);
            images.add(3);
            images.add(4);
            images.add(5);
            images.add(6);
            images.add(7);
            images.add(8);
        }
        System.out.println(String.valueOf(images));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Bfacil.setFocusPainted(false);
        Bmedio.setFocusPainted(false);
        Bdificil.setFocusPainted(false);
        Pmenus.setVisible(false);
        Color colorAzul = new Color(67, 80, 163);
        Pmenus.setBackground(colorAzul);
        Pfacil.setBackground(colorAzul);
        Pmedio.setBackground(colorAzul);
        Pdificil.setBackground(colorAzul);
        Pinicio.setBackground(colorAzul);
        Popciones.setBackground(colorAzul);
        PopcionesJuego.setBackground(colorAzul);
        Paspectos.setBackground(colorAzul);
        Pjuego.setBackground(colorAzul);

        Ctimer = new Timer(1000, e -> { //Uso de Timer para el funcionamiento del cronometro
            segundos++;
            if (segundos == 60) {
                segundos = 0;
                minutos++;
            }

            if (minutos == 60) {
                minutos = 0;
                horas++;
            }
            if (horas == 24) {
                horas = 0;
                minutos = 0;
                segundos = 0;
            }
            ActualizarLtimer();
        });
        Bvolver.addActionListener(new ActionListener() //Devuelve a la pantalla inicial
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pinicio.setVisible(true);
                Pmenus.setVisible(false);

                if (Ctimer.isRunning()) {
                    Ctimer.stop();
                    Bempezar.setEnabled(true);
                }
                horas = 0;
                minutos = 0;
                segundos = 0;
                ActualizarLtimer();
            }
        });
        Bempezar.addActionListener(new ActionListener() //Comienza el nivel
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ctimer.start();
                Bempezar.setEnabled(false);
                Breiniciar.setEnabled(true);
            }
        });
        Breiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Ctimer.isRunning()) //Condicion para que el cronometro se detenga
                {
                    Ctimer.stop();
                    Bempezar.setEnabled(true);
                }
                horas = 0;
                minutos = 0;
                segundos = 0;
                ActualizarLtimer(); //Reinicia el cronometro
                Bempezar.setEnabled(true);
                Breiniciar.setEnabled(false);
            }
        });

        Bfacil.addActionListener(new ActionListener() //Abre el nivel facil (4 imagenes)
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego();
                Pfacil.setVisible(true);
                Pmedio.setVisible(false);
                Pdificil.setVisible(false);
            }
        });
        Bmedio.addActionListener(new ActionListener() //Abre el nivel medio (8 imagenes)
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego();
                Pfacil.setVisible(true);
                Pmedio.setVisible(true);
                Pdificil.setVisible(false);

            }
        });

        Bdificil.addActionListener(new ActionListener() //Abre el nivel dificil (16 imagenes)
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego();
                Pfacil.setVisible(true);
                Pmedio.setVisible(true);
                Pdificil.setVisible(true);
            }
        });

        Baspecto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pinicio.setVisible(false);
                PopcionesJuego.setVisible(false);
                Pfacil.setVisible(false);
                Pmedio.setVisible(false);
                Pdificil.setVisible(false);
                Pmenus.setVisible(true);
                Paspectos.setVisible(true);

            }
        });

//////////////////////////////////////////////// Definen el set de cartas
        Bequipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartas = "Equipos";
            }
        });

        Bmemes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartas = "Memes";
            }
        });
        Balbumes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartas = "Albumes";
            }
        });

        for (int i = 1; i == 16 ; i++)
        {
            JLabel label = labels[i];
            int a = i;
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    super.mouseClicked(e);
                    ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/" + cartas + "/" + String.valueOf(images.get(a)) + ".jpg"));
                    labels[a].setIcon(icon);
                }
            });
        }

    }

    public void juego() {
        Paspectos.setVisible(false);
        Pinicio.setVisible(false);
        Pmenus.setVisible(true);
        PopcionesJuego.setVisible(true);
    }

    public void displayImages() {
        for (int i = 0; i < vector.length; i++) {
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/" +
                        cartas + "/" + String.valueOf(images.get(i)) + ".jpg"));
                labels[i].setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}