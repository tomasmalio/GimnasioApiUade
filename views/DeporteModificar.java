package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controllers.ActividadController;
import models.Deporte;

public class DeporteModificar extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel jLabelSearch;
	private JLabel jLabelTitulo;
	private JLabel jLabelDescripcion;
	
	private JTextField fieldCodigoBuscar;
	private JTextField fieldTitulo;
	private JTextField fieldDescripcion;
	
	private JButton buttonBuscar;
	private JButton buttonModificar;
	
	private ActividadController sistema;
	
	public DeporteModificar (ActividadController s) {
		super();
		sistema = s;
		initGui();
	}
	
	private void initGui () {
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			{
				jLabelTitulo = new JLabel();
				getContentPane().add(jLabelTitulo);
				jLabelTitulo.setText("Código:");
				jLabelTitulo.setBounds(21, 40, 63, 28);
				jLabelTitulo.setVisible(false);
			}
			{
				fieldTitulo = new JTextField();
				getContentPane().add(fieldTitulo);
				fieldTitulo.setBounds(119, 40, 210, 28);
				fieldTitulo.setVisible(false);
			}
			{
				jLabelDescripcion = new JLabel();
				getContentPane().add(jLabelDescripcion);
				jLabelDescripcion.setText("Descripción:");
				jLabelDescripcion.setBounds(21, 80, 63, 28);
				jLabelDescripcion.setVisible(false);
			}
			{
				fieldDescripcion = new JTextField();
				getContentPane().add(fieldDescripcion);
				fieldDescripcion.setBounds(119, 80, 210, 28);
				fieldDescripcion.setVisible(false);
			}
			
			/**
			 * Acción para dar de baja a un deporte
			 */
			{
				buttonModificar = new JButton();
				getContentPane().add(buttonModificar);
				buttonModificar.setText("Modificar Deporte");
				buttonModificar.setBounds(150, 217, 200, 28);
				buttonModificar.setVisible(false);
				buttonModificar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						sistema.modificarDeporte(Integer.parseInt(fieldCodigoBuscar.getText()), fieldTitulo.getText(), fieldDescripcion.getText());
						setVisible(false);
					}
				});
			}
			
			/**
			 * Buscar un socio a través del documento único
			 */
			{
				jLabelSearch = new JLabel();
				getContentPane().add(jLabelSearch);
				jLabelSearch.setText("Ingrese el código:");
				jLabelSearch.setBounds(21, 7, 150, 28);
			}
			{
				fieldCodigoBuscar = new JTextField();
				getContentPane().add(fieldCodigoBuscar);
				fieldCodigoBuscar.setBounds(140, 7, 147, 28);
			}
			{
				buttonBuscar = new JButton();
				getContentPane().add(buttonBuscar);
				buttonBuscar.setText("Buscar");
				buttonBuscar.setBounds(301, 7, 77, 28);
				buttonBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						Deporte deporte = sistema.buscarDeporte(Integer.parseInt(fieldCodigoBuscar.getText()));
						
						if (deporte != null) {
							jLabelTitulo.setVisible(true);
							jLabelDescripcion.setVisible(true);
							
							fieldTitulo.setVisible(true);
							fieldTitulo.setEnabled(true);
							fieldTitulo.setText(deporte.getTitulo());
							fieldDescripcion.setVisible(true);
							fieldDescripcion.setEnabled(true);
							fieldDescripcion.setText(deporte.getDescripcion());
							
							buttonModificar.setVisible(true);
						} else {
							String mensajeError = "¡Atención! No se ha encontrado el deporte que usted esta buscando!";
						    JOptionPane.showMessageDialog(null, mensajeError);
						}
					}
				});
			}
			
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
