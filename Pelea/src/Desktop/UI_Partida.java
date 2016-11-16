package Desktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.*;
import logic.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI_Partida extends JFrame {

	private JPanel contentPane;
	private JTextField txtVida1;
	private JTextField txtEnergia1;
	private JTextField txtEvasion1;
	private JTextField txtDefensa1;
	private JTextField txtVida2;
	private JTextField txtEnergia2;
	private JTextField txtEvasion2;
	private JTextField txtDefensa2;
	private JTextField txtEnergiaAtaque;
	private JTextField txtId1;
	private JTextField txtPersonaje1;
	private JTextField txtId2;
	private JTextField txtPersonaje2;
	
	private Personaje perActual1;
	private Personaje perActual2;
	
	private PersonajeLogic ctrl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Partida frame = new UI_Partida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_Partida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVida1 = new JLabel("Vida:");
		lblVida1.setBounds(22, 94, 46, 14);
		contentPane.add(lblVida1);
		
		JLabel lblEnergia1 = new JLabel("Energ\u00EDa:");
		lblEnergia1.setBounds(22, 119, 59, 14);
		contentPane.add(lblEnergia1);
		
		JLabel lblEvasion1 = new JLabel("Evasi\u00F3n:");
		lblEvasion1.setBounds(22, 144, 59, 14);
		contentPane.add(lblEvasion1);
		
		JLabel lblDefensa1 = new JLabel("Defensa:");
		lblDefensa1.setBounds(22, 168, 66, 14);
		contentPane.add(lblDefensa1);
		
		JLabel lblVida2 = new JLabel("Vida:");
		lblVida2.setBounds(282, 92, 46, 14);
		contentPane.add(lblVida2);
		
		JLabel lblEnergia2 = new JLabel("Energ\u00EDa:");
		lblEnergia2.setBounds(282, 115, 66, 14);
		contentPane.add(lblEnergia2);
		
		JLabel lblEvasion2 = new JLabel("Evasi\u00F3n:");
		lblEvasion2.setBounds(282, 140, 66, 14);
		contentPane.add(lblEvasion2);
		
		JLabel lblDefensa2 = new JLabel("Defensa:");
		lblDefensa2.setBounds(282, 164, 66, 14);
		contentPane.add(lblDefensa2);
		
		txtVida1 = new JTextField();
		txtVida1.setEditable(false);
		txtVida1.setBounds(99, 92, 59, 20);
		contentPane.add(txtVida1);
		txtVida1.setColumns(10);
		
		txtEnergia1 = new JTextField();
		txtEnergia1.setEditable(false);
		txtEnergia1.setColumns(10);
		txtEnergia1.setBounds(99, 117, 59, 20);
		contentPane.add(txtEnergia1);
		
		txtEvasion1 = new JTextField();
		txtEvasion1.setEditable(false);
		txtEvasion1.setColumns(10);
		txtEvasion1.setBounds(99, 142, 59, 20);
		contentPane.add(txtEvasion1);
		
		txtDefensa1 = new JTextField();
		txtDefensa1.setEditable(false);
		txtDefensa1.setColumns(10);
		txtDefensa1.setBounds(99, 166, 59, 20);
		contentPane.add(txtDefensa1);
		
		txtVida2 = new JTextField();
		txtVida2.setEditable(false);
		txtVida2.setColumns(10);
		txtVida2.setBounds(355, 88, 59, 20);
		contentPane.add(txtVida2);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setEditable(false);
		txtEnergia2.setColumns(10);
		txtEnergia2.setBounds(355, 113, 59, 20);
		contentPane.add(txtEnergia2);
		
		txtEvasion2 = new JTextField();
		txtEvasion2.setEditable(false);
		txtEvasion2.setColumns(10);
		txtEvasion2.setBounds(355, 138, 59, 20);
		contentPane.add(txtEvasion2);
		
		txtDefensa2 = new JTextField();
		txtDefensa2.setEditable(false);
		txtDefensa2.setColumns(10);
		txtDefensa2.setBounds(355, 166, 59, 20);
		contentPane.add(txtDefensa2);
		
		JRadioButton rdbtnAtacar = new JRadioButton("Atacar");
		rdbtnAtacar.setBounds(240, 215, 95, 23);
		contentPane.add(rdbtnAtacar);
		
		JRadioButton rdbtnDefender = new JRadioButton("Defender");
		rdbtnDefender.setBounds(240, 242, 109, 23);
		contentPane.add(rdbtnDefender);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(22, 299, 101, 23);
		contentPane.add(btnCancelar);
		
		JButton btnComenzarPartida = new JButton("Comenzar Partida");
		btnComenzarPartida.setBounds(254, 299, 172, 23);
		contentPane.add(btnComenzarPartida);
		
		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTurno.setBounds(22, 221, 46, 14);
		contentPane.add(lblTurno);
		
		JLabel lblEnergaAtaque = new JLabel("Energ\u00EDa Ataque:");
		lblEnergaAtaque.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnergaAtaque.setBounds(22, 246, 120, 14);
		contentPane.add(lblEnergaAtaque);
		
		txtEnergiaAtaque = new JTextField();
		txtEnergiaAtaque.setBounds(154, 244, 66, 20);
		contentPane.add(txtEnergiaAtaque);
		txtEnergiaAtaque.setColumns(10);
		
		JLabel lblPersonaje = new JLabel("Personaje 1 o 2");
		lblPersonaje.setBounds(71, 222, 172, 16);
		contentPane.add(lblPersonaje);
		
		JButton btnPersonaje1 = new JButton("Buscar Pj 1");
		btnPersonaje1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar(txtPersonaje1);
			}
		});
		btnPersonaje1.setBounds(32, 12, 126, 25);
		contentPane.add(btnPersonaje1);
		
		JButton btnPersonaje2 = new JButton("Buscar Pj 2");
		btnPersonaje2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscar(txtPersonaje2);
			}
		});
		btnPersonaje2.setBounds(288, 12, 126, 25);
		contentPane.add(btnPersonaje2);
		
		txtId1 = new JTextField();
		txtId1.setForeground(Color.WHITE);
		txtId1.setEnabled(false);
		txtId1.setBounds(22, 49, 36, 20);
		contentPane.add(txtId1);
		txtId1.setColumns(10);
		
		txtPersonaje1 = new JTextField();
		txtPersonaje1.setBounds(68, 49, 114, 31);
		contentPane.add(txtPersonaje1);
		txtPersonaje1.setColumns(10);
		
		txtId2 = new JTextField();
		txtId2.setForeground(Color.WHITE);
		txtId2.setEnabled(false);
		txtId2.setColumns(10);
		txtId2.setBounds(252, 49, 36, 20);
		contentPane.add(txtId2);
		
		txtPersonaje2 = new JTextField();
		txtPersonaje2.setColumns(10);
		txtPersonaje2.setBounds(300, 49, 114, 31);
		contentPane.add(txtPersonaje2);
	}

	public void MapearAFormulario(Personaje p, JTextField txtPersonaje){
		if(txtPersonaje == txtPersonaje1){
			if(p.getId()>0) txtId1.setText(String.valueOf(p.getId()));
			txtPersonaje1.setText(p.getNombre());
			txtVida1.setText(String.valueOf(p.getVida()));
			txtEnergia1.setText(String.valueOf(p.getEnergia()));
			txtDefensa1.setText(String.valueOf(p.getDefensa()));
			txtEvasion1.setText(String.valueOf(p.getEvasion()));
			

		} else {
			
			if(p.getId()>0) txtId2.setText(String.valueOf(p.getId()));
			txtPersonaje2.setText(p.getNombre());
			txtVida2.setText(String.valueOf(p.getVida()));
			txtEnergia2.setText(String.valueOf(p.getEnergia()));
			txtDefensa2.setText(String.valueOf(p.getDefensa()));
			txtEvasion2.setText(String.valueOf(p.getEvasion()));
			
		
		}
		
	}
	
	public void buscar(JTextField txtPersonaje ){
		
		if(txtPersonaje.getText().isEmpty()){
			notifyUser("Debe ingresar un nombre por el cual buscar!");
		} else{
			try{
				if(txtPersonaje == txtPersonaje1){
					perActual1 = ctrl.getByNombre(txtPersonaje.getText());
					if (perActual1.getNombre() == null){
						notifyUser("Personaje inexistente !");
					} else{
						this.MapearAFormulario(perActual1, txtPersonaje);
						notifyUser("Hola " + perActual1.getNombre() + " !");
					}
				} else{
					perActual2 = ctrl.getByNombre(txtPersonaje.getText());
					if (perActual2.getNombre() == null){
						notifyUser("Personaje inexistente !");
					} else{
						this.MapearAFormulario(perActual2, txtPersonaje);
						notifyUser("Hola " + perActual2.getNombre() + " !");
					}
				}
				
				
			} catch (Exception ex) {
				notifyUser(ex.getMessage());
			}
		}
	}
	
	
	
	public void notifyUser(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
}
