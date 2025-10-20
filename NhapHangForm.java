package main.java.quanly.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class NhapHangForm extends JFrame {
    private JTextField txtMaSP, txtTenSP, txtSoLuong, txtDonGia;
    private JButton btnThem, btnXoa, btnThoat;
    private JTable table;
    private DefaultTableModel model;
    private JLabel lblTongTien;

    public NhapHangForm() {
        setTitle("Quản lý nhập hàng");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Font chung
        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        // Panel nhập dữ liệu
        JPanel pnlInput = new JPanel(new GridBagLayout());
        pnlInput.setBorder(BorderFactory.createTitledBorder("Thông tin sản phẩm"));
        pnlInput.setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Mã sản phẩm
        gbc.gridx = 0; gbc.gridy = 0;
        pnlInput.add(new JLabel("Mã sản phẩm:"), gbc);
        gbc.gridx = 1;
        txtMaSP = new JTextField(15);
        pnlInput.add(txtMaSP, gbc);

        // Tên sản phẩm
        gbc.gridx = 0; gbc.gridy = 1;
        pnlInput.add(new JLabel("Tên sản phẩm:"), gbc);
        gbc.gridx = 1;
        txtTenSP = new JTextField(15);
        pnlInput.add(txtTenSP, gbc);

        // Số lượng
        gbc.gridx = 0; gbc.gridy = 2;
        pnlInput.add(new JLabel("Số lượng:"), gbc);
        gbc.gridx = 1;
        txtSoLuong = new JTextField(15);
        pnlInput.add(txtSoLuong, gbc);

        // Đơn giá
        gbc.gridx = 0; gbc.gridy = 3;
        pnlInput.add(new JLabel("Đơn giá:"), gbc);
        gbc.gridx = 1;
        txtDonGia = new JTextField(15);
        pnlInput.add(txtDonGia, gbc);

        // Nút bấm
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        pnlButtons.setBackground(Color.white);
        btnThem = new JButton("Thêm");
        btnXoa = new JButton("Xóa dòng");
        btnThoat = new JButton("Thoát");

        pnlButtons.add(btnThem);
        pnlButtons.add(btnXoa);
        pnlButtons.add(btnThoat);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        pnlInput.add(pnlButtons, gbc);

        // Bảng danh sách sản phẩm
        String[] columns = {"Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.setRowHeight(25);
        table.setFont(font);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);

        // Panel tổng tiền
        JPanel pnlTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTongTien = new JLabel("Tổng tiền: 0 VNĐ");
        lblTongTien.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTongTien.setForeground(Color.RED);
        pnlTotal.add(lblTongTien);

        // Layout chính
        setLayout(new BorderLayout(10, 10));
        add(pnlInput, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
        add(pnlTotal, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NhapHangForm().setVisible(true);
        });
    }
}
