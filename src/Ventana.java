import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JPanel Pinicio;
    private JButton Bfacil;
    private JButton Bmedio;
    private JButton Bdificil;
    private JButton Btutorial;
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
    private JPanel Pconfig;
    private JButton a8Button;
    private JButton a6Button;
    private JButton a5Button;
    private JPanel Pdificil;
    private JButton a1Button1;
    private JButton a2Button1;
    private JButton a4Button2;
    private JButton a3Button1;
    private JPanel Pfacil;
    private JButton a4Button1;
    private JButton a6Button1;
    private JButton a8Button1;
    private JButton a12Button;
    private JButton a13Button;
    private JButton a14Button;
    private JButton a15Button;
    private JButton a16Button;
    private JButton Breiniciar;
    private JButton Bempezar;
    private Timer Ctimer;
    private int horas = 0;
    private int minutos= 0;
    private int segundos;
    public void ActualizarLtimer() //Actualiza el label del cronometro
    {
        String ltimer = horas +"h:" + minutos + "m:" + segundos + "s";
        Ltimer.setText(ltimer);
    }
    public Ventana() {
        super("Memory Game");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Bfacil.setFocusPainted(false);
        Bmedio.setFocusPainted(false);
        Bdificil.setFocusPainted(false);
        Pmenus.setVisible(false);

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
        Bvolver.addActionListener(new ActionListener() //Devuelve a la pantalla inicial
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Pinicio.setVisible(true);
                Pmenus.setVisible(false);
                Pconfig.setVisible(false);
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
        Bfacil.addActionListener(new ActionListener() //Abre el nivel facil (4 imagenes)
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Pinicio.setVisible(false);
                Pmenus.setVisible(true);
                Pconfig.setVisible(false);
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
                Pconfig.setVisible(false);
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
                Pconfig.setVisible(false);
                Pfacil.setVisible(false);
                Pmedio.setVisible(false);
                Pdificil.setVisible(true);
            }
        });
    }

}