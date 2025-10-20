package main.java.quanly.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Khachhang extends JFrame {

    public Khachhang() {
        setTitle("Quản lý cửa hàng giày");
        setSize(1500, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // -------- Panel Trái: Thông tin hóa đơn --------
        JPanel panelThongTin = new JPanel();
        panelThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
        panelThongTin.setLayout(new GridBagLayout());
        panelThongTin.setPreferredSize(new Dimension(280, 0)); // rộng hơn 1 chút
        panelThongTin.setBackground(Color.WHITE); // màu nền sáng

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6); // khoảng cách giữa các component
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; // textfield kéo dài theo width

        // ---- TopPanel chọn ngày ----
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        topPanel.setBackground(Color.WHITE); // đồng bộ màu nền
        String[] NgayBD = { "21 Tháng Mười Một 2025", "22 Tháng Mười Một 2025" };
        JComboBox<String> txtNgayBD = new JComboBox<>(NgayBD);
        topPanel.add(new JLabel("Ngày bắt đầu:"));
        topPanel.add(txtNgayBD);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelThongTin.add(topPanel, gbc);
        gbc.gridwidth = 1; // reset cho các dòng sau

        // ---- Các textfield ----
        JTextField txtMaHD = new JTextField("29", 12);
        JTextField txtKh = new JTextField("Nguyễn Văn A", 12);
        JTextField txtBan = new JTextField("Online", 12);
        JTextField txtTrangThai = new JTextField("Đang xử lý", 12);
        JTextField txtTong = new JTextField("0", 12);
        JTextField txtGiamGia = new JTextField("0", 12);
        JTextField txtPhaiTra = new JTextField("0", 12);

        // Add các dòng với label đều nhau
        addRow(panelThongTin, gbc, 1, "Mã Khách hàng:", txtMaHD);
        addRow(panelThongTin, gbc, 2, "Khách hàng:", txtKh);
        addRow(panelThongTin, gbc, 3, "Bàn:", txtBan);
        addRow(panelThongTin, gbc, 4, "Trạng thái:", txtTrangThai);
        addRow(panelThongTin, gbc, 5, "Tổng (VND):", txtTong);
        addRow(panelThongTin, gbc, 6, "Giảm giá (%):", txtGiamGia);
        addRow(panelThongTin, gbc, 7, "Phải trả (VND):", txtPhaiTra);

        // ---- Nút ----
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.WHITE);
        panelButton.setLayout(new BoxLayout(panelButton, BoxLayout.Y_AXIS)); // xếp dọc

        JButton btnThanhToan = new JButton("Thanh Toán");
        btnThanhToan.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnThanhToan.setMaximumSize(new Dimension(120, 35)); // rộng hơn, nhìn đẹp

        JButton btnDong = new JButton("Đóng");
        btnDong.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDong.setMaximumSize(new Dimension(120, 35));

        panelButton.add(btnThanhToan);
        panelButton.add(Box.createRigidArea(new Dimension(0, 10))); // khoảng cách giữa 2 nút
        panelButton.add(btnDong);

        panelThongTin.add(panelButton, gbc);
        // ---- Thêm panel trái vào frame ----
        add(panelThongTin, BorderLayout.WEST);

        // -------- Panel Giữa: Danh mục giày --------
        JPanel panelSanPham = new JPanel(new BorderLayout(10, 10));
        panelSanPham.setBorder(BorderFactory.createTitledBorder("Danh mục giày"));
        panelSanPham.setPreferredSize(new Dimension(400, 300));

        // menu loại giày
        String[] loaiGiay = { "Tất cả", "Nike", "Adidas", "Converse", "Vans" };
        JComboBox<String> comboLoaiGiay = new JComboBox<>(loaiGiay);
        panelSanPham.add(comboLoaiGiay, BorderLayout.NORTH);

        JPanel sanpham = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        sanpham.setBackground(Color.WHITE);

        String[] shoes = { "Adidas Forum", "Lacoste Baseshot", "Puma Softride" };
        double[] prices = { 1200000, 1500000, 960000, 45000 };
        ImageIcon[] hinhGiay = {
                new ImageIcon(new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\giay1.jpg")
                        .getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\giay2.jpg")
                        .getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\giay3.jpg")
                        .getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH)),
        };

        for (int i = 0; i < shoes.length; i++) {
            JPanel sp = new JPanel();
            sp.setLayout(new BoxLayout(sp, BoxLayout.Y_AXIS));
            sp.setPreferredSize(new Dimension(150, 200));
            sp.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            sp.setBackground(Color.white);

            JLabel hinh = new JLabel(hinhGiay[i]);
            hinh.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel ten = new JLabel(shoes[i]);
            ten.setFont(new Font("Arial", Font.BOLD, 14));
            ten.setAlignmentX(Component.CENTER_ALIGNMENT);
            ten.setBorder(BorderFactory.createEmptyBorder(5, 0, 2, 0));

            JLabel gia = new JLabel(String.format("%,.0f VND", prices[i]));
            gia.setFont(new Font("Arial", Font.PLAIN, 12));
            gia.setAlignmentX(Component.CENTER_ALIGNMENT);

            sp.add(hinh);
            sp.add(ten);
            sp.add(gia);

            sanpham.add(sp);
        }

        JScrollPane scrollSanPham = new JScrollPane(sanpham);
        scrollSanPham.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSanPham.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panelSanPham.add(scrollSanPham, BorderLayout.CENTER);

        add(panelSanPham, BorderLayout.CENTER);

        // -------- Panel Phải: Giỏ hàng --------
        JPanel panelHoaDon = new JPanel(new BorderLayout());
        panelHoaDon.setBorder(BorderFactory.createTitledBorder("Danh sách giày đã chọn"));

        String[] columnNames = { "Tên giày", "Số lượng", "Đơn giá", "Thành tiền" };
        DefaultTableModel modelHoaDon = new DefaultTableModel(columnNames, 0);
        JTable tableHoaDon = new JTable(modelHoaDon);

        JScrollPane scrollPane = new JScrollPane(tableHoaDon);
        panelHoaDon.add(scrollPane, BorderLayout.CENTER);

        panelHoaDon.setPreferredSize(new Dimension(300, getHeight()));
        add(panelHoaDon, BorderLayout.EAST);

        setVisible(true);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int y, String label, JTextField txt) {
        gbc.gridx = 0;
        gbc.gridy = y;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        panel.add(txt, gbc);
    }

    public static void main(String[] args) {
        Khachhang dh = new Khachhang();
        dh.setVisible(true);
    }
}
