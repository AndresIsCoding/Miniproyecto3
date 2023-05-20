import javax.swing.*;

public class Ventana extends JFrame
{
    private JPanel panel1;
    private JButton Bfacil;
    private JButton Bmedio;
    private JButton Bdificil;
    private JLabel Llogo;

    public Ventana()
    {
        super("Memory Game");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
