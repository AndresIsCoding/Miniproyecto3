import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Ventana extends JFrame
{
    private JPanel panel1;
    private JButton Bfacil;
    private JButton Bmedio;
    private JButton Bdificil;
    private JLabel Llogo;
    private JLabel Ltutorial;
    private Color color1;
    private Color color2;

    public Ventana()
    {

        super("Memory Game");
        setContentPane(panel1); //PANTALLA INICIAL (MENU)
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //CONFIGURACIONES DEL PANEL
        color1= new Color(173,22,41);
        color2=new Color(114,64,139);
        Bfacil.addActionListener(new ActionListener() //ABRE EL NIVEL FACIL
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new NivelFacil();
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();


                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        int opc = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Mensaje de confirmación", JOptionPane.OK_CANCEL_OPTION);
                        if (opc == 0) {
                            System.exit(0);
                        }
                    }
                });
            }
        });
        Bmedio.addActionListener(new ActionListener() //ABRE EL NIVEL MEDIO
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new NivelMedio();
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();

                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        int opc = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Mensaje de confirmación", JOptionPane.OK_CANCEL_OPTION);
                        if (opc == 0) {
                            System.exit(0);
                        }
                    }
                });

            }
        });

        Bdificil.addActionListener(new ActionListener() //ABRE EL  NIVEL DIFICIL
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new NivelDificil();
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();

                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        int opc = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Mensaje de confirmación", JOptionPane.OK_CANCEL_OPTION);
                        if (opc == 0) {
                            System.exit(0);
                        }
                    }
                });

            }
        });
        Ltutorial.addMouseListener(new MouseAdapter() //ABRE LA PESTAÑA DEL TUTORIAL
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                JFrame frame = new Tutorial();
                frame.setSize(800,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                dispose();
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        int opc = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Mensaje de confirmación", JOptionPane.OK_CANCEL_OPTION);
                        if (opc == 0) {
                            System.exit(0);
                        }
                    }
                });

            }
        });

    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        int w=getWidth();
        int h=getHeight();

        GradientPaint gradientPaint=new GradientPaint(0,0,color1,0,h,color2);
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0,0,w,h);

    }

}
