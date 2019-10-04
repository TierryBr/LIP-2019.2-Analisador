package br.quixada.ufc.si.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.quixada.ufc.si.analex.AnalexSimples;
import br.quixada.ufc.si.anasin.AnasinSimples;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class telaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private String print;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaPrincipal frame = new telaPrincipal();
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
	public telaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(telaPrincipal.class.getResource("/br/quixada/ufc/si/view/brasil.jpg")));
		setTitle("LIP 2019.2");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 472);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblAnaliseLxica = new JLabel("Analisador de express\u00F5es");
		lblAnaliseLxica.setBackground(new Color(0, 0, 128));
		lblAnaliseLxica.setForeground(new Color(0, 0, 0));
		lblAnaliseLxica.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblAnaliseLxica.setBounds(245, 22, 290, 58);
		contentPane.add(lblAnaliseLxica);
		
		text1 = new JTextField();
		text1.setToolTipText("");
		text1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		text1.setBackground(Color.LIGHT_GRAY);
		text1.setBounds(127, 133, 524, 43);
		contentPane.add(text1);
		text1.setColumns(10);
		
		JLabel lblExpresso = new JLabel("Express\u00E3o:");
		lblExpresso.setForeground(new Color(0, 0, 0));
		lblExpresso.setFont(new Font("Arial", Font.PLAIN, 16));
		lblExpresso.setBounds(37, 143, 116, 25);
		contentPane.add(lblExpresso);
		
		JButton btnAnalisar = new JButton("L\u00E9xico");
		btnAnalisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if ((text1.getText().isEmpty())) { 
					JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
				}
				
				else {
					AnalexSimples ana = new AnalexSimples(text1.getText());
					
					if (ana.analex() != null) {
						print = ana.toString();
						
						JTextArea frameInterno = new JTextArea (20, 35);
						frameInterno.setFont(new Font("Arial Black", Font.PLAIN, 12));
						frameInterno.setText (text1.getText());
						frameInterno.setEditable(false);
					    frameInterno.setText(print);
					      
					    // enrola uma barra de rolagem em volta dele
					    JScrollPane scrollPane = new JScrollPane (frameInterno);
					      
					    // exibi-los em uma caixa de diálogo de mensagem
					    JOptionPane.showMessageDialog (contentPane, scrollPane);
						
					} else {
						JOptionPane.showMessageDialog(null, "ERRO! expressão invalida\n");
					}
				}
				
				// apaga os dados dos campos depois de analisar
				//text1.setText("");
			}
		});
		btnAnalisar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAnalisar.setBounds(172, 232, 104, 31);
		contentPane.add(btnAnalisar);
		
		JButton btnSinttico = new JButton("Sint\u00E1tico");
		btnSinttico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if ((text1.getText().isEmpty())) { 
					JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
				}
				
				else {
					AnasinSimples ana = new AnasinSimples(text1.getText());
					
					ana.anasint();
					print = ana.toString();
					 
					
					JTextArea frameInterno = new JTextArea (28, 43);
					frameInterno.setFont(new Font("Arial Black", Font.PLAIN, 12));
					frameInterno.setText (text1.getText());
					frameInterno.setEditable(false);
				    frameInterno.setText(print);
				      
				    // enrola uma barra de rolagem em volta dele
				    JScrollPane scrollPane = new JScrollPane (frameInterno);
				      
				    // exibi-los em uma caixa de diálogo de mensagem
				    JOptionPane.showMessageDialog (contentPane, scrollPane);
				      
					
				}
				
				// apaga os dados dos campos depois de analisar
				//text2.setText("");
				
				
			}
		});
		btnSinttico.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSinttico.setBounds(335, 232, 104, 31);
		contentPane.add(btnSinttico);
		
		JButton btnEncerrar = new JButton("Encerrar");
		btnEncerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEncerrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEncerrar.setBounds(335, 344, 104, 25);
		contentPane.add(btnEncerrar);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// apaga os dados dos campos depois de analisar
				text1.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBounds(503, 232, 104, 31);
		contentPane.add(btnNewButton);
	}
}
