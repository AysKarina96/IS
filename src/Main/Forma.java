package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JDialog;


public class Forma {

	 public int itog(int a,int b,int c) {
		 return a*b*c;
	 };
	 
	private JFrame frame;
	private JTextField Gid;
	
private JTextField VisaCost;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forma window = new Forma();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Forma() {
		initialize();
	}
	
int zx;
private JTextField Proj;
private JTextField StTransfer;
private JTextField Driver;
private JTextField Bilet;

	/**
	 * Initialize the contents of the frame.
	 */


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\planet-earth-1457453_960_720.png"));
		frame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame.setAlwaysOnTop(true);
		frame.setTitle("Рассчет стоимости тура");
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSpinner KolPerson = new JSpinner();
		KolPerson.setBounds(273, 125, 100, 20);
		KolPerson.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		frame.getContentPane().add(KolPerson);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(52, 250, 321, 134);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		JSpinner KolDay = new JSpinner();
		KolDay.setBounds(273, 150, 100, 20);
		KolDay.setModel(new SpinnerNumberModel(3, 3, 20, 1));
		frame.getContentPane().add(KolDay);
		
		VisaCost = new JTextField();
		VisaCost.setBounds(273, 50, 100, 20);
		frame.getContentPane().add(VisaCost);
		VisaCost.setColumns(10);
		
		Proj = new JTextField();
		Proj.setBounds(273, 175, 100, 20);
		Proj.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
					{
					if (Proj.getText().length()>9) e.consume(); //Не более 10 символов
					char c = e.getKeyChar ();
					if(!(Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE))){
						e.consume();
					}
			}
		});
		frame.getContentPane().add(Proj);
		Proj.setColumns(10);
		
	/*	public static int zx(int i,int b,int d) {
			// TODO Auto-generated method stub
			int sxx=i+b+d;
			return 0;
		}*/
		
		JButton btnNewButton = new JButton("Рассчитать стоимость");
		btnNewButton.setBounds(52, 401, 174, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ((Proj.getText().length() == 0) || (Gid.getText().length() == 0)) //Если не заполнены поля
				{
					JOptionPane optionPane = new JOptionPane("Не заполнены все поля!", JOptionPane.ERROR_MESSAGE);  //То выдает ошибку
					JDialog dialog = optionPane.createDialog("Ошибка"); //Заголовок окна
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true); return;
				}
				textArea.setText(""); //Очистка текствого поля
				int stVis = Integer.parseInt(VisaCost.getText()); 
				int Transfer = Integer.parseInt(StTransfer.getText()); 
				int stProj = Integer.parseInt(Proj.getText()); 
				int StBiletow = Integer.parseInt(Bilet.getText()); 
				int stGid = Integer.parseInt(Gid.getText()); 
				int stVod = Integer.parseInt(Driver.getText());
				int i = KolPerson.getValue().hashCode(); //Получаем значение кол-ва человек
				int n = KolDay.getValue().hashCode();
				int st1 = stVis*i;
				int st2 = (StBiletow+Transfer)*i*2;
				int st3 = (stProj)*2*i*n;
				int st4 = (stGid*i+stVod*i)*n;
				int itogo = st1+st2+st3+st4;
				zx(st1,st2,st3);
				textArea.append("Общая стоимость виз: "+Integer.toString(st1)+" Рублей\n");
				textArea.append("Общая стоимость билетов и трансфера: "+Integer.toString(st2)+" Рублей \n");
				textArea.append("Стоимость проживания и питания за "+Integer.toString(n)+" дней: "+Integer.toString(st2)+" Рублей \n");
				textArea.append("Итого: "+Integer.toString(itogo)+" Рублей \n");
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Выход");
		button.setBounds(235, 401, 138, 23);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0447\u0435\u043B\u043E\u0432\u0435\u043A:");
		label.setBounds(52, 128, 195, 14);
		frame.getContentPane().add(label);

		JLabel lblNewLabel_2 = new JLabel("\u0421\u0442\u043E\u0438\u043C\u043E\u0441\u0442\u044C \u043F\u0440\u043E\u0436\u0438\u0432\u0430\u043D\u0438\u044F \u0432 \u0441\u0443\u0442\u043A\u0438");
		lblNewLabel_2.setBounds(52, 178, 211, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u0434\u043D\u0435\u0439:");
		lblNewLabel_3.setBounds(52, 153, 195, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		Gid = new JTextField();
		Gid.setBounds(273, 200, 100, 20);
		Gid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { 
				if (Gid.getText().length()>9) e.consume(); //Не более 10 символов
				char c = e.getKeyChar ();
				if(!(Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE)) ){ //Контроль ввода данных
					e.consume();
				}
			}
		});
		frame.getContentPane().add(Gid);
		Gid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Стоимость услуг гида:");
		lblNewLabel_1.setBounds(52, 202, 211, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("\u0421\u0442\u043E\u0438\u043C\u043E\u0441\u0442\u044C \u0432\u0438\u0437\u044B \u043D\u0430 1 \u0447\u0435\u043B\u043E\u0432\u0435\u043A\u0430:");
		lblNewLabel_4.setBounds(52, 53, 216, 20);
		frame.getContentPane().add(lblNewLabel_4);
			
		JLabel label_1 = new JLabel("Стоимость услуг водителя:");
		label_1.setBounds(52, 226, 195, 14);
		frame.getContentPane().add(label_1);
		
		StTransfer = new JTextField();
		StTransfer.setBounds(273, 100, 100, 20);
		frame.getContentPane().add(StTransfer);
		StTransfer.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u0421\u0442\u0440\u043E\u0438\u043C\u043E\u0441\u0442\u044C \u0442\u0440\u0430\u043D\u0441\u0444\u0435\u0440\u0430:");
		lblNewLabel_5.setBounds(52, 100, 211, 20);
		frame.getContentPane().add(lblNewLabel_5);
		
		Driver = new JTextField();
		Driver.setColumns(10);
		Driver.setBounds(273, 224, 100, 20);
		frame.getContentPane().add(Driver);
		
		JLabel lblNewLabel_7 = new JLabel("\u0421\u0442\u043E\u0438\u043C\u043E\u0441\u0442\u044C \u0431\u0438\u043B\u0435\u0442\u0430:");
		lblNewLabel_7.setBounds(52, 75, 211, 20);
		frame.getContentPane().add(lblNewLabel_7);
		
		Bilet = new JTextField();
		Bilet.setBounds(273, 75, 100, 20);
		frame.getContentPane().add(Bilet);
		Bilet.setColumns(10);
	}

	protected void zx(int st1, int st2, int st3) {
		// TODO Auto-generated method stub
		
	}


	}
