import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtDatoEntero;
    private JButton btnInsertar;
    private JLabel lblValorTope;
    private JButton btnValorTope;
    private JButton btnExtraer;
    private JButton btnListar;
    private JTextArea txtListadoElementos;
    private Pila Coleccion=new Pila();

    public Ventana(){
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Coleccion.ingresarElemento(Integer.parseInt(txtDatoEntero.getText()));
                JOptionPane.showMessageDialog(null,"Dato Ingresado a la Pila");

            }
        });
        btnValorTope.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lblValorTope.setText("El valor del tope es: "+Coleccion.elementoTop());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnExtraer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null,"Se elimino el elemento"+Coleccion.extraerElemento());
                    btnListar.addActionListener(this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListadoElementos.setText(Coleccion.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
