import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NivelMedio extends Ventana
{

    private JPanel panel3;
    private JButton Bvolver;

    public NivelMedio()
    {
        setContentPane(panel3);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Bvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new Ventana();
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
    }
}
