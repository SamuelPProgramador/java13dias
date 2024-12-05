package bbsg.Tienda_libros.vista;

import bbsg.Tienda_libros.modelo.Libro;
import bbsg.Tienda_libros.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class LibroForm extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField autorTexto;
    private JTextField textoPrecio;
    private JTextField textoExistenacia;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTextField libroTexto;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarForma();

        agregarButton.addActionListener(e -> agregarLibro());
        tablaLibros.addComponentListener(new ComponentAdapter() {
        });
        tablaLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarLibroSelecionado();
            }
        });
    }

    private void cargarLibroSelecionado() {
        //los indice comienza en 0
        var renglon = tablaLibros.getSelectedRow();
        if (renglon != -1){
            String idLibro =  tablaLibros.getModel().getValueAt(renglon, 0).toString();
            //me quede aqui

        }
    }

    private void agregarLibro() {
        //leer los valores del formulario
        if(libroTexto.getText().equals("")){
            mostrarMensaje("Proporciona el nombre del libro");
            libroTexto.requestFocusInWindow();
            return;
        }
        var nombreLibro = libroTexto.getText();
        var autor = autorTexto.getText();
        var precio = Double.parseDouble(textoPrecio.getText());
        var existencia = Integer.parseInt(textoExistenacia.getText());
        //Creamos el objeto libro
        var libro = new Libro(null, nombreLibro, autor, precio, existencia);
//        libro.setNombreLibro(nombreLibro);
//        libro.setAutor(autor);
//        libro.setPrecio(precio);
//        libro.setExitencias(existencia);
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se has guardado libro con exitos....");
        limpiarFormulario();
        listarLibro();
    }

    private void limpiarFormulario() {
        libroTexto.setText("");
        autorTexto.setText("");
        textoPrecio.setText("");
        textoExistenacia.setText("");

    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void iniciarForma() {
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth()/ 2);
        int y = (tamanioPantalla.height - getHeight() / 2);
        setLocation(x, y);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.tablaModeloLibros = new DefaultTableModel(0, 5);
        String [] cabeceros = {"Id", "Libro", "Autor", "Precio", "Existencia"};
        this.tablaModeloLibros.setColumnIdentifiers(cabeceros);
        //Intanciar el objeto jtable
        this.tablaLibros = new JTable(tablaModeloLibros);

        listarLibro();
    }

    private void listarLibro() {
        //limpiamos la tabla
        tablaModeloLibros.setRowCount(0);
        //Obtenemos los libros
        var libros = libroServicio.listar_libros();
        libros.forEach((libro -> {
            Object[] renglonLibro ={
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExitencias()
            };
            this.tablaModeloLibros.addRow(renglonLibro);
        }));

    }
}
