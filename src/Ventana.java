import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JPanel Pinicio;
    private JButton Bfacil;
    private JButton Bmedio;
    private JButton Bdificil;
    private JButton Baspecto;
    private JPanel Pmenus;
    private JPanel Popciones;
    private JButton Bvolver;
    private JPanel Pmedio;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a7Button;
    private JLabel Ltimer;
    private JPanel Paspectos;
    private JButton a8Button;
    private JButton a6Button;
    private JButton a5Button;
    private JPanel Pdificil;
    private JPanel Pfacil;
    private JButton a12Button;
    private JButton Breiniciar;
    private JButton Bempezar;
    private JPanel PopcionesJuego;
    private JButton BequiposDeFutbol;
    private JButton Bmemes;
    private JButton Balbumes;
    private JPanel Pjuego;
    private JLabel L1;
    private JLabel L2;
    private JLabel L3;
    private JLabel L4;
    private JLabel L5;
    private JLabel L6;
    private JLabel L7;
    private JLabel L8;
    private JLabel L9;
    private JLabel L10;
    private JLabel L11;
    private JLabel L12;
    private JLabel L13;
    private JLabel L14;
    private JLabel L15;
    private JLabel L16;
    private JButton a9Button;
    private JButton a10Button;
    private JButton a11Button;
    private Timer Ctimer;
    private int horas = 0;
    private int minutos= 0;
    private int segundos;
    private Color colorAzul = new Color(67,80,163);
    //////////////////////////////////////////////////////////////////////// Imagenes de memes
    private ImageIcon M1 = new ImageIcon("\\Imagenes\\Memes\\1.jpg");
    private ImageIcon M2 = new ImageIcon("\\Imagenes\\Memes\\2.jpg");
    private ImageIcon M3 = new ImageIcon("\\Imagenes\\Memes\\3.jpg");
    private ImageIcon M4 = new ImageIcon("\\Imagenes\\Memes\\4.jpg");
    private ImageIcon M5 = new ImageIcon("\\Imagenes\\Memes\\5.jpg");
    private ImageIcon M6 = new ImageIcon("\\Imagenes\\Memes\\6.jpg");
    private ImageIcon M7 = new ImageIcon("\\Imagenes\\Memes\\7.jpg");
    private ImageIcon M8 = new ImageIcon("\\Imagenes\\Memes\\8.jpg");
////////////////////////////////////////////////////////////////////////////////////////////// Imagenes de equipos de futbol
    private ImageIcon E1 = new ImageIcon("\\src\\Imagenes\\Equipos de futbol\\1.jpg");
    private ImageIcon E2 = new ImageIcon("\\src\\Imagenes\\Equipos de futbol\\2.jpg");
    private ImageIcon E3 = new ImageIcon("\\src\\Imagenes\\Equipos de futbol\\3.jpg");
    private ImageIcon E4 = new ImageIcon("\\src\\Imagenes\\Equipos de futbol\\4.jpg");
    private ImageIcon E5 = new ImageIcon("\\src\\Imagenes\\Equipos de futbol\\5.jpg");
    private ImageIcon E6 = new ImageIcon("\\src\\Imagenes\\Equipos de futbol\\6.jpg");
    private ImageIcon E7 = new ImageIcon("\\src\\Imagenes\\Equipos de futbol\\7.jpg");
    private ImageIcon E8 = new ImageIcon("\\src\\Imagenes\\Equipos de futbol\\8.jpg");
    ////////////////////////////////////////////////////////////////////////////////////////////// Imagenes de albumes
    private ImageIcon A1 = new ImageIcon("\\src\\Imagenes\\Albumes\\1.jpg");
    private ImageIcon A2 = new ImageIcon("\\src\\Imagenes\\Albumes\\2.jpg");
    private ImageIcon A3 = new ImageIcon("\\src\\Imagenes\\Albumes\\3.jpg");
    private ImageIcon A4 = new ImageIcon("\\src\\Imagenes\\Albumes\\4.jpg");
    private ImageIcon A5 = new ImageIcon("\\src\\Imagenes\\Albumes\\5.jpg");
    private ImageIcon A6 = new ImageIcon("\\src\\Imagenes\\Albumes\\6.jpg");
    private ImageIcon A7 = new ImageIcon("\\src\\Imagenes\\Albumes\\7.jpg");
    private ImageIcon A8 = new ImageIcon("\\src\\Imagenes\\Albumes\\8.jpg");

    private JButton[] botones = {a1Button,a2Button,a3Button,a4Button,a5Button,a6Button,a7Button,a8Button,a9Button,a10Button,a11Button,a12Button}; //Adentro van las imagenes
    int[] vector = new int[16];

    public void ActualizarLtimer() //Actualiza el label del cronometro
    {
        String ltimer = horas +"h:" + minutos + "m:" + segundos + "s";
        Ltimer.setText(ltimer);
    }
        public Ventana()
        {
        super("Memory Game");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Bfacil.setFocusPainted(false);
        Bmedio.setFocusPainted(false);
        Bdificil.setFocusPainted(false);
        Pmenus.setVisible(false);
        Pmenus.setBackground(colorAzul);
        Pfacil.setBackground(colorAzul);
        Pmedio.setBackground(colorAzul);
        Pdificil.setBackground(colorAzul);
        Pinicio.setBackground(colorAzul);
        Popciones.setBackground(colorAzul);
        PopcionesJuego.setBackground(colorAzul);
        Paspectos.setBackground(colorAzul);

        Ctimer=new Timer(1000, e -> { //Uso de Timer para el funcionamiento del cronometro
            segundos++;
            if (segundos==60)
            {
                segundos=0;
                minutos++;
            }

            if (minutos==60)
            {
                minutos=0;
                horas++;
            }
            if (horas==24)
            {
                horas=0;
                minutos=0;
                segundos=0;
            }
            ActualizarLtimer();
        });
        Bvolver.addActionListener(new ActionListener() //Devuelve a la pantalla inicial
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Pinicio.setVisible(true);
                Pmenus.setVisible(false);
                Paspectos.setVisible(false);
                Popciones.setVisible(false);
                PopcionesJuego.setVisible(false);
                Pfacil.setVisible(false);
                Pmedio.setVisible(false);
                Pdificil.setVisible(false);

                if(Ctimer.isRunning())
                {
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
            public void actionPerformed(ActionEvent e)
            {
                Ctimer.start();
                Bempezar.setEnabled(false);
                Breiniciar.setEnabled(true);
            }
        });
        Breiniciar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(Ctimer.isRunning()) //Condicion para que el cronometro se detenga
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
            public void actionPerformed(ActionEvent e)
            {
                Pinicio.setVisible(false);
                Pmenus.setVisible(true);
                Paspectos.setVisible(false);
                Popciones.setVisible(true);
                PopcionesJuego.setVisible(true);
                Pfacil.setVisible(true);
                Pmedio.setVisible(false);
                Pdificil.setVisible(false);
            }
        });
        Bmedio.addActionListener(new ActionListener() //Abre el nivel medio (8 imagenes)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Pinicio.setVisible(false);
                Pmenus.setVisible(true);
                Paspectos.setVisible(false);
                Popciones.setVisible(true);
                PopcionesJuego.setVisible(true);
                Pfacil.setVisible(false);
                Pmedio.setVisible(true);
                Pdificil.setVisible(false);
            }
        });

        Bdificil.addActionListener(new ActionListener() //Abre el nivel dificil (16 imagenes)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Pinicio.setVisible(false);
                Pmenus.setVisible(true);
                Paspectos.setVisible(false);
                Popciones.setVisible(true);
                PopcionesJuego.setVisible(true);
                Pfacil.setVisible(false);
                Pmedio.setVisible(false);
                Pdificil.setVisible(true);
            }
        });

        Baspecto.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Pinicio.setVisible(false);
                Pmenus.setVisible(true);
                Paspectos.setVisible(true);
                Popciones.setVisible(true);
                PopcionesJuego.setVisible(false);
                Pfacil.setVisible(false);
                Pmedio.setVisible(false);
                Pdificil.setVisible(false);
            }
        });

//////////////////////////////////////////////// PRUEBA DE VECTORES
        BequiposDeFutbol.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Aqui iria: public void displayImages() {
                //        for(int i=0; i < vector.length; i++) {
                //            try {
                //                ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/Equipos de futbol" + vector[i] + ".jpg"));
                //                botones[i].setIcon(icon);
                //            } catch (Exception e) {
                //                e.printStackTrace();
                //            }
                //        }
                //    }
            }
        });

        Bmemes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Aqui iria: public void displayImages() {
                //        for(int i=0; i < vector.length; i++) {
                //            try {
                //                ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/Memes" + vector[i] + ".jpg"));
                //                botones[i].setIcon(icon);
                //            } catch (Exception e) {
                //                e.printStackTrace();
                //            }
                //        }
                //    }
            }
        });
    }

    public void generarVectorFacil() {
        // Inicializa el vector con valor 0
        Arrays.fill(vector, 0);
        Random random = new Random();

        // Agrega los numeros entre 1 y 8 en dos posiciones diferentes de las 16 disponibles en el arreglo
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < 2; j++) {
                int posicion;
                // El ciclo se ejecuta mientras haya un valor distinto de cero en la posición del arreglo
                // Esto indica que debe encontrar una posición en cero para asignar el valor de i
                do {
                    posicion = random.nextInt(4);
                } while (vector[posicion] != 0);
                vector[posicion] = i;
            }
        }

        System.out.println("El vector resultante es: " + Arrays.toString(vector));
    }

    public void displayImages() {
        for(int i=0; i < vector.length; i++) {
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/imgs/landscape" + vector[i] + ".jpg"));
                botones[i].setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}