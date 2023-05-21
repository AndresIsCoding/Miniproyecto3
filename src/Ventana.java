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
    private JPanel Pjuego;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JLabel Ltimer;
    private JPanel Pconfig;


    public Ventana() {
        super("Memory Game");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Bfacil.setFocusPainted(false);
        Bmedio.setFocusPainted(false);
        Bdificil.setFocusPainted(false);
        Pmenus.setVisible(false);

        Bfacil.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Pmenus.setVisible(true);
                Pjuego.setVisible(true);
                Pinicio.setVisible(false);
                Pconfig.setVisible(false);
            }
        });
    }
}