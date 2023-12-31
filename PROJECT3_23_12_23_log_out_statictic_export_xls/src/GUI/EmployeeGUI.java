package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import BUS.EmployeeBUS;
import BUS.HistoryBUS;
import Controller.EmployeeController;
import DTO.Employee;
import DTO.Historye;

import java.awt.Toolkit;

public class EmployeeGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Name;
	private JTextField textField_NgaySinh;
	private JTable table;
	private JTextField textField_FindName;
	private ButtonGroup buttonGroup;
	private JComboBox comboBox_ChucVu;
	private JRadioButton rdbtn_Nam;
	private JRadioButton rdbtn_Nu;
	private JTable table_1;
	private JTextField textField_FindName_1;
	private JTextField textField_Date_1;
	private JTextField textField_Date_2;
	private JLabel label_DoanhThu;
	private JLabel label_DoanhThu_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EmployeeGUI frame = new EmployeeGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EmployeeGUI() {
		setForeground(new Color(255, 255, 255));
		setResizable(false);
		setTitle("ADMIN");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\eclipse-workspace\\PROJECT3_23_12_23_log_out\\icon\\icons8-admin-30.png"));
		setBackground(new Color(51, 51, 51));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 878, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(51, 51, 51));
		tabbedPane.setBounds(0, 0, 862, 457);
		contentPane.add(tabbedPane);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setForeground(SystemColor.desktop);
		tabbedPane.addTab("DANH SÁCH NHÂN VIÊN", null, panel, null);
		tabbedPane.setBackgroundAt(0, SystemColor.controlHighlight);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblNewLabel.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_22_12_23_LOGIN_Admin_Frame\\icon\\icons8-customer-50.png"));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(270, 11, 285, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và tên");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 63, 79, 28);
		panel.add(lblNewLabel_1);
		
		textField_Name = new JTextField();
		textField_Name.setForeground(SystemColor.desktop);
		textField_Name.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField_Name.setColumns(10);
		textField_Name.setBorder(new LineBorder(Color.BLACK,1));
		textField_Name.setBackground(Color.WHITE);
		textField_Name.setBounds(99, 63, 178, 28);
		panel.add(textField_Name);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 108, 79, 28);
		panel.add(lblNewLabel_1_1);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setForeground(SystemColor.desktop);
		textField_NgaySinh.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBorder(new LineBorder(Color.BLACK,1));
		textField_NgaySinh.setBackground(Color.WHITE);
		textField_NgaySinh.setBounds(99, 110, 178, 28);
		panel.add(textField_NgaySinh);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Chức vụ");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setForeground(SystemColor.text);
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(297, 108, 79, 28);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Giới tính");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_2.setForeground(SystemColor.text);
		lblNewLabel_1_2_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_2_2.setBounds(297, 63, 86, 28);
		panel.add(lblNewLabel_1_2_2);
		
		rdbtn_Nam = new JRadioButton("Nam");
		rdbtn_Nam.setForeground(new Color(255, 255, 255));
		rdbtn_Nam.setFont(new Font("Segoe UI", Font.BOLD, 16));
		rdbtn_Nam.setBackground(new Color(51, 51, 51));
		rdbtn_Nam.setBounds(382, 66, 79, 23);
		panel.add(rdbtn_Nam);
		
		rdbtn_Nu = new JRadioButton("Nữ");
		rdbtn_Nu.setForeground(Color.WHITE);
		rdbtn_Nu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		rdbtn_Nu.setBackground(new Color(51, 51, 51));
		rdbtn_Nu.setBounds(462, 66, 79, 23);
		panel.add(rdbtn_Nu);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtn_Nam);
		buttonGroup.add(rdbtn_Nu);
		
		comboBox_ChucVu = new JComboBox<>();
		comboBox_ChucVu.addItem("Phục vụ");
		comboBox_ChucVu.addItem("Tiếp tân");
		comboBox_ChucVu.setForeground(SystemColor.desktop);
		comboBox_ChucVu.setBackground(new Color(255, 255, 255));
		comboBox_ChucVu.setBorder(new LineBorder(Color.BLACK,1));
		comboBox_ChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBox_ChucVu.setBounds(386, 110, 144, 28);
		comboBox_ChucVu.setSelectedIndex(-1);
		panel.add(comboBox_ChucVu);
		
		ActionListener actionListener = new EmployeeController(this);
		
		JButton btn_Them = new JButton("THÊM");
		btn_Them.addActionListener(actionListener);
		btn_Them.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_22_12_23_LOGIN_Admin_Frame\\icon\\icons8-add-24.png"));
		btn_Them.setForeground(SystemColor.desktop);
		btn_Them.setBackground(new Color(46, 204, 113));
		btn_Them.setBorder(new LineBorder(Color.BLACK,1));
		btn_Them.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Them.setBounds(588, 65, 113, 30);
		panel.add(btn_Them);
		
		JButton btn_Sua = new JButton("SỬA");
		btn_Sua.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_22_12_23_LOGIN_Admin_Frame\\icon\\icons8-edit-30.png"));
		btn_Sua.setForeground(SystemColor.desktop);
		btn_Sua.setBackground(new Color(255, 165, 0));
		btn_Sua.setBorder(new LineBorder(Color.BLACK,1));
		btn_Sua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Sua.addActionListener(actionListener);;
		btn_Sua.setBounds(713, 65, 113, 30);
		panel.add(btn_Sua);
		
		JButton btn_Luu = new JButton("LƯU");
		btn_Luu.addActionListener(actionListener);
		btn_Luu.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_22_12_23_LOGIN_Admin_Frame\\icon\\icons8-save-25.png"));
		btn_Luu.setForeground(SystemColor.desktop);
		btn_Luu.setBackground(new Color(52, 152, 219));
		btn_Luu.setBorder(new LineBorder(Color.BLACK,1));
		btn_Luu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Luu.setBounds(588, 108, 113, 30);
		panel.add(btn_Luu);
		
		JButton btn_Xoa = new JButton("XÓA");
		btn_Xoa.addActionListener(actionListener);
		btn_Xoa.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_22_12_23_LOGIN_Admin_Frame\\icon\\icons8-delete-24.png"));
		btn_Xoa.setForeground(SystemColor.desktop);
		btn_Xoa.setBackground(new Color(231, 76, 60));
		btn_Xoa.setBorder(new LineBorder(Color.BLACK,1));
		btn_Xoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Xoa.setBounds(713, 106, 113, 30);
		panel.add(btn_Xoa);
		
		JButton btn_CapNhat = new JButton("CẬP NHẬT");
		btn_CapNhat.addActionListener(actionListener);
		btn_CapNhat.setForeground(SystemColor.desktop);
		btn_CapNhat.setBackground(new Color(255, 165, 0));
		btn_CapNhat.setBorder(new LineBorder(Color.BLACK,1));
		btn_CapNhat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_CapNhat.setBounds(713, 147, 113, 30);
		panel.add(btn_CapNhat);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.desktop);
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(10, 175, 691, 3);
		panel.add(separator);
		
		table = new JTable();
		table.setForeground(SystemColor.desktop);
		table.setBorder(new LineBorder(Color.BLACK,1));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		table.setBackground(SystemColor.controlLtHighlight);
		table.setAutoCreateRowSorter(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Họ và tên", "Ngày sinh", "Giới tính", "Chức vụ"
			}
		));
		Font font = new Font("Segoe UI", Font.BOLD, 16);
		JTableHeader header = table.getTableHeader();
		header.setFont(font);
		table.setBounds(10, 223, 837, 198);
		table.setRowHeight(25);
		updateTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 223, 837, 198);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ và tên");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(SystemColor.text);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 184, 79, 28);
		panel.add(lblNewLabel_1_2);
		
		textField_FindName = new JTextField();
		textField_FindName.setForeground(SystemColor.desktop);
		textField_Name.setBorder(new LineBorder(Color.BLACK,1));
		textField_FindName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField_FindName.setColumns(10);
		textField_FindName.setBorder(new LineBorder(Color.BLACK,1));
		textField_FindName.setBackground(Color.WHITE);
		textField_FindName.setBounds(99, 184, 178, 28);
		panel.add(textField_FindName);
		
		JButton btn_Tim = new JButton("TÌM");
		btn_Tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		        table.setRowSorter(sorter);

		        String searchText = textField_FindName.getText();
		        if (searchText.length() == 0) {
		            sorter.setRowFilter(null); // Nếu không có văn bản tìm kiếm, hiển thị toàn bộ dữ liệu.
		        } else {
		            // Áp dụng bộ lọc dựa trên cột "Họ và Tên" với biểu thức chính quy, không phân biệt chữ hoa và thường.
		            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 1));
		        }
			}
		});
		btn_Tim.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_22_12_23_LOGIN_Admin_Frame\\icon\\icons8-find-25.png"));
		btn_Tim.setBackground(new Color(52, 152, 219));
		btn_Tim.setForeground(SystemColor.desktop);
		btn_Tim.setBorder(new LineBorder(Color.BLACK,1));
		btn_Tim.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Tim.setBounds(287, 184, 113, 28);
		panel.add(btn_Tim);
		
		JButton btn_Reload = new JButton("TẢI LẠI");
		btn_Reload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                table.setRowSorter(sorter);

                sorter.setRowFilter(null); // Nếu không có văn bản tìm kiếm, hiển thị toàn bộ dữ liệu.
			}
		});
		btn_Reload.setBackground(new Color(255, 165, 0));
		btn_Reload.setForeground(SystemColor.desktop);
		btn_Reload.setBorder(new LineBorder(Color.BLACK,1));
		btn_Reload.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Reload.setBounds(410, 184, 113, 28);
		panel.add(btn_Reload);
		
		JButton btnNewButton = new JButton(".");
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginGUI();
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_22_12_23_LOGIN_Admin_Frame\\icon\\icons8-sign-out-30.png"));
		btnNewButton.setBounds(808, 0, 49, 34);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		tabbedPane.addTab("THỐNG KÊ & DOANH THU", null, panel_1, null);
		tabbedPane.setBackgroundAt(1, SystemColor.controlHighlight);
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setForeground(SystemColor.desktop);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Họ và tên", "Ngày đặt", "Ngày trả", "Phòng số", "Đơn giá"
			}
		));
		Font font_1 = new Font("Calibri", Font.BOLD, 18);
		table_1.setAutoCreateRowSorter(true);
		table_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		table_1.setBounds(10, 51, 837, 194);
		JTableHeader header1 = table_1.getTableHeader();
		header1.setFont(font_1);
		table_1.setBounds(10, 223, 837, 198);
		table_1.setRowHeight(25);
		updateTable_1();
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 128, 837, 194);
		panel_1.add(scrollPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("DANH SÁCH KHÁCH HÀNG ĐÃ SỬ DỤNG DỊCH VỤ");
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 11, 593, 29);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Họ và tên");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_3.setForeground(SystemColor.text);
		lblNewLabel_1_2_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_2_3.setBounds(10, 89, 79, 28);
		panel_1.add(lblNewLabel_1_2_3);
		
		textField_FindName_1 = new JTextField();
		textField_FindName_1.setForeground(SystemColor.desktop);
		textField_FindName_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField_FindName_1.setColumns(10);
		textField_FindName_1.setBorder(new LineBorder(Color.BLACK,1));
		textField_FindName_1.setBackground(Color.WHITE);
		textField_FindName_1.setBounds(99, 89, 178, 28);
		panel_1.add(textField_FindName_1);
		
		JButton btn_Tim_1 = new JButton("TÌM");
		btn_Tim_1.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_23_12_23_log_out\\icon\\icons8-find-25.png"));
		btn_Tim_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
				table_1.setRowSorter(sorter);
				
				String name = textField_FindName_1.getText();
				if (name.length() == 0) {
					sorter.setRowFilter(null);
				}else {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + name, 1));
				}
			}
		});
		btn_Tim_1.setForeground(SystemColor.desktop);
		btn_Tim_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Tim_1.setBorder(new LineBorder(Color.BLACK,1));
		btn_Tim_1.setBackground(new Color(52, 152, 219));
		btn_Tim_1.setBounds(287, 89, 113, 28);
		panel_1.add(btn_Tim_1);
		
		JButton btn_Reload_1 = new JButton("TẢI LẠI");
		btn_Reload_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
				table_1.setRowSorter(sorter);
				
				sorter.setRowFilter(null);
			}
		});
		btn_Reload_1.setForeground(SystemColor.desktop);
		btn_Reload_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Reload_1.setBorder(new LineBorder(Color.BLACK,1));
		btn_Reload_1.setBackground(new Color(255, 165, 0));
		btn_Reload_1.setBounds(410, 89, 113, 28);
		panel_1.add(btn_Reload_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.desktop);
		separator_1.setBackground(SystemColor.desktop);
		separator_1.setBounds(10, 68, 837, 3);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("TỔNG DOANH THU:");
		lblNewLabel_1_2_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_3_1.setForeground(SystemColor.text);
		lblNewLabel_1_2_3_1.setFont(new Font("Courier New", Font.BOLD, 16));
		lblNewLabel_1_2_3_1.setBounds(10, 325, 178, 28);
		panel_1.add(lblNewLabel_1_2_3_1);
		
		label_DoanhThu = new JLabel("");
		label_DoanhThu.setHorizontalAlignment(SwingConstants.LEFT);
		label_DoanhThu.setForeground(SystemColor.text);
		label_DoanhThu.setFont(new Font("Courier New", Font.BOLD, 16));
		label_DoanhThu.setBounds(162, 325, 160, 28);
		panel_1.add(label_DoanhThu);
		
		// Lấy tổng doanh thư gán cho label_DoanhThu
		long Price_1 = new HistoryBUS().totalPrice();
		label_DoanhThu.setText(String.valueOf(Price_1)+" VNĐ");
		
		JLabel lblNewLabel_1_2_3_1_1 = new JLabel("TỔNG DOANH THU TỪ");
		lblNewLabel_1_2_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_3_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_2_3_1_1.setFont(new Font("Courier New", Font.BOLD, 16));
		lblNewLabel_1_2_3_1_1.setBounds(10, 353, 193, 28);
		panel_1.add(lblNewLabel_1_2_3_1_1);
		
		textField_Date_1 = new JTextField();
		textField_Date_1.setForeground(SystemColor.desktop);
		textField_Date_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField_Date_1.setColumns(10);
		textField_Date_1.setBorder(new LineBorder(Color.BLACK,1));
		textField_Date_1.setBackground(Color.WHITE);
		textField_Date_1.setBounds(187, 353, 113, 26);
		panel_1.add(textField_Date_1);
		
		JLabel lblNewLabel_3 = new JLabel("-");
		lblNewLabel_3.setFont(new Font("Courier New", Font.BOLD, 20));
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setBounds(300, 360, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		textField_Date_2 = new JTextField();
		textField_Date_2.setForeground(SystemColor.desktop);
		textField_Date_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		textField_Date_2.setColumns(10);
		textField_Date_2.setBorder(new LineBorder(Color.BLACK,1));
		textField_Date_2.setBackground(Color.WHITE);
		textField_Date_2.setBounds(312, 353, 113, 26);
		panel_1.add(textField_Date_2);
		
		JLabel lblNewLabel_3_1 = new JLabel(":");
		lblNewLabel_3_1.setForeground(SystemColor.text);
		lblNewLabel_3_1.setFont(new Font("Courier New", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(423, 359, 46, 14);
		panel_1.add(lblNewLabel_3_1);
		
		label_DoanhThu_1 = new JLabel("");
		label_DoanhThu_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_DoanhThu_1.setForeground(SystemColor.text);
		label_DoanhThu_1.setFont(new Font("Courier New", Font.BOLD, 16));
		label_DoanhThu_1.setBounds(435, 353, 160, 28);
		panel_1.add(label_DoanhThu_1);
		
		JButton btn_Tinh = new JButton("TÍNH");
		btn_Tinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String regex = "^(?:(?:19|20)\\d\\d)-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]|(?:0[1-9]|1\\d|2[0-8]))|(?:19|20)\\d\\d-(0[1-9]|1[0-2])-(29|30)(?:-0[1-9]|-1[0-9]|-2[0-8])|(?:19|20)(?:0[48]|[2468][048]|[13579][26])-02-29$\r\n";
				if (textField_Date_1.getText().isBlank() || textField_Date_2.getText().isBlank()) {
					JOptionPane.showMessageDialog(btn_Tinh, "Vui lòng điền đầy đủ thông tin");
				}else {
					if (!textField_Date_1.getText().matches(regex) || !textField_Date_2.getText().matches(regex)) {
						JOptionPane.showMessageDialog(null, "Nhập ngày theo định dạng yyyy-mm-dd :V");
					}else {
						Date date_1 = Date.valueOf(textField_Date_1.getText());
						Date date_2 = Date.valueOf(textField_Date_2.getText());
						
						long price = new HistoryBUS().totalPrice(date_1, date_2);
						label_DoanhThu_1.setText(price+" VNĐ");
					}
				}
			}
		});
		btn_Tinh.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_23_12_23_log_out_statictic\\icon\\icons8-calculator-24.png"));
		btn_Tinh.setForeground(SystemColor.desktop);
		btn_Tinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Tinh.setBorder(new LineBorder(Color.BLACK,1));
		btn_Tinh.setBackground(new Color(52, 152, 219));
		btn_Tinh.setBounds(605, 353, 113, 28);
		panel_1.add(btn_Tinh);
		
		JButton btn_Reload_1_1 = new JButton("EXPORT");
		btn_Reload_1_1.setIcon(new ImageIcon("F:\\eclipse-workspace\\PROJECT3_23_12_23_log_out_statictic_export_xls\\icon\\icons8-report-21.png"));
		btn_Reload_1_1.addActionListener(actionListener);
		btn_Reload_1_1.setForeground(SystemColor.desktop);
		btn_Reload_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Reload_1_1.setBorder(new LineBorder(Color.BLACK,1));
		btn_Reload_1_1.setBackground(new Color(255, 165, 0));
		btn_Reload_1_1.setBounds(734, 89, 113, 28);
		panel_1.add(btn_Reload_1_1);
		setVisible(true);
	}
	private void updateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		// Lấy dữ liệu từng bảng employee và lưu vào ArrayList
		ArrayList<Employee> employees = new EmployeeBUS().listEmployees();
		clearTable();
		for (Employee employee : employees) {
			model.addRow(employee.toObject());
		}
	}
	private void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowCount = model.getRowCount();
		
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}
	private void updateTable_1() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		
		ArrayList<Historye> historyes = new HistoryBUS().listHistories();
		clearTable_1();
		for (Historye historye : historyes) {
			model.addRow(historye.toObject());
		}
	}
	private void clearTable_1() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		int rowCount = model.getRowCount();
		
		for (int i = rowCount -1 ; i >= 0; i--) {
			model.removeRow(i);
		}
	}
	public void setEmptyForm() {
		textField_Name.setText(null);
		textField_NgaySinh.setText(null);
		buttonGroup.clearSelection();
		comboBox_ChucVu.setSelectedIndex(-1);
	}
	public void save() {
		String regex = "^(?:(?:19|20)\\d\\d)-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]|(?:0[1-9]|1\\d|2[0-8]))|(?:19|20)\\d\\d-(0[1-9]|1[0-2])-(29|30)(?:-0[1-9]|-1[0-9]|-2[0-8])|(?:19|20)(?:0[48]|[2468][048]|[13579][26])-02-29$\r\n";
		if (textField_Name.getText().isBlank() || textField_NgaySinh.getText().isBlank() || (!rdbtn_Nam.isSelected() && !rdbtn_Nu.isSelected())||comboBox_ChucVu.getSelectedItem() == null ) {
			JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
		}else {
			if (!textField_NgaySinh.getText().matches(regex)) {
				JOptionPane.showMessageDialog(null, "Nhập ngày sinh theo định dạng yyyy-MM-dd");
			}else {
				String name = textField_Name.getText();
				Date dateOfBirth = null;
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					dateOfBirth = new Date(dateFormat.parse(textField_NgaySinh.getText()).getTime());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Nhập ngày theo định dạng yyyy-MM-dd");
					e.printStackTrace();
				}
				String gioiTinh = "";
				if (rdbtn_Nam.isSelected()) {
					gioiTinh = "Nam";
				}else if (rdbtn_Nu.isSelected()) {
					gioiTinh = "Nữ";
				}
				String position = String.valueOf(comboBox_ChucVu.getSelectedItem());
				new EmployeeBUS().addEmployee(new Employee(name, dateOfBirth, gioiTinh, position));
				updateTable();
			}
		}
	}
	public void edit() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowIndex = table.getSelectedRow();
		
		if (!(table.isRowSelected(rowIndex))) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 nhân viên trong bảng");
		}else {
			String name = (String) model.getValueAt(rowIndex, 1);
			Date dateOfBirth = (Date) model.getValueAt(rowIndex, 2);
			String gioiTinh = (String) model.getValueAt(rowIndex, 3);
			String position = (String) model.getValueAt(rowIndex, 4);
			
			textField_Name.setText(name);
			textField_NgaySinh.setText(dateOfBirth+"");
			if (gioiTinh.equals("Nam")) {
				rdbtn_Nam.setSelected(true);
			}else if (gioiTinh.equals("Nữ")) {
				rdbtn_Nu.setSelected(true);
			}
			comboBox_ChucVu.setSelectedItem(position);
		}
		
	}
	public void update() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowIndex = table.getSelectedRow();
		
		if (!(table.isRowSelected(rowIndex))) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 nhân viên trong bảng");
		}else {
			if (textField_Name.getText().isBlank() || textField_NgaySinh.getText().isBlank() || (!rdbtn_Nam.isSelected() && !rdbtn_Nu.isSelected())||comboBox_ChucVu.getSelectedItem() == null ) {
				JOptionPane.showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
			}else {
				int id = Integer.valueOf((String) model.getValueAt(rowIndex, 0));
				String name = textField_Name.getText();
				Date dateOfBirth = null;
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					dateOfBirth = new Date(dateFormat.parse(textField_NgaySinh.getText()).getTime());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Nhập ngày theo định dạng yyyy-MM-dd");
					e.printStackTrace();
				}
				String gioiTinh = "";
				if (rdbtn_Nam.isSelected()) {
					gioiTinh = "Nam";
				}else if (rdbtn_Nu.isSelected()) {
					gioiTinh = "Nữ";
				}
				String position = String.valueOf(comboBox_ChucVu.getSelectedItem());
				new EmployeeBUS().edit(new Employee(id, name, dateOfBirth, gioiTinh, position));
				updateTable();
			}
		}
	}
	public void delete() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowIndex = table.getSelectedRow();
		
		if (!table.isRowSelected(rowIndex)) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 nhân viên trong bảng");
		}else {
			int id = Integer.valueOf((String) model.getValueAt(rowIndex, 0));
			String name = String.valueOf(model.getValueAt(rowIndex, 1));
			Date dateOfBirth = (Date) model.getValueAt(rowIndex, 2);
			String gioiTinh = String.valueOf(model.getValueAt(rowIndex, 3));
			String position = String.valueOf(model.getValueAt(rowIndex, 4));
			
			new EmployeeBUS().delete(new Employee(id, name, dateOfBirth, gioiTinh, position));
			updateTable();
		}
	}
	public void toExcel() {
		JFileChooser fileChooser = new JFileChooser();
		int option = fileChooser.showSaveDialog(EmployeeGUI.this);
		if (option == JFileChooser.APPROVE_OPTION) {
			String name = fileChooser.getSelectedFile().getName();
			String path = fileChooser.getSelectedFile().getParentFile().getPath();
			String file = path + "\\"+name+".txt";
			export(table, new File(file));
		}
	}
	public void export(JTable table, File file) {
		try {
			TableModel model = table_1.getModel();
			FileWriter fileWriter = new FileWriter(file);
			
			String str = "			DANH SÁCH KHÁCH HÀNG ĐÃ SỬ DỤNG DỊCH VỤ";
			
			fileWriter.write(str);
			fileWriter.write("\n");
			fileWriter.write("\n");
			
			for (int i = 0; i < model.getColumnCount(); i++) {
				fileWriter.write(model.getColumnName(i)+"\t");
			}
			fileWriter.write("\n");
			
			for (int i = 0; i < model.getRowCount(); i++) {
				for (int j = 0; j < model.getColumnCount(); j++) {
					if (j == model.getColumnCount() - 2) {
						fileWriter.write(model.getValueAt(i, j).toString()+"\t\t");
					}else {
						fileWriter.write(model.getValueAt(i, j).toString()+"\t");
					}
				}
				fileWriter.write("\n");
			}
			fileWriter.write("\n");
			fileWriter.write("\t"+"TỔNG DOANH THU: "+label_DoanhThu.getText());
			fileWriter.write("\n");
			fileWriter.write("\t"+"TỔNG DOANH THU TỪ "+textField_Date_1.getText()+" ĐẾN "+textField_Date_2.getText()+": "+label_DoanhThu_1.getText());
			fileWriter.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
