package main.java.quanly.GUI;

import javax.swing.*;
import java.awt.*;

public class ThemSanPham extends JFrame {
    public ThemSanPham() {
        setTitle("Sản Phẩm");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel chính
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        // ===== Panel Hình ảnh =====
        JPanel panelHinhAnh = new JPanel(new BorderLayout(10, 10));
        panelHinhAnh.setBackground(Color.WHITE);
        panelHinhAnh.setPreferredSize(new Dimension(260, 0));

        JLabel lblHinhAnh = new JLabel("No Image", SwingConstants.CENTER);
        lblHinhAnh.setPreferredSize(new Dimension(220, 220));
        lblHinhAnh.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        panelHinhAnh.add(lblHinhAnh, BorderLayout.CENTER);

        JButton btnChonAnh = new JButton("Chọn ảnh");
        btnChonAnh.setPreferredSize(new Dimension(120, 34));
        JPanel pBtnAnh = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pBtnAnh.setBackground(Color.WHITE);
        pBtnAnh.add(btnChonAnh);
        panelHinhAnh.add(pBtnAnh, BorderLayout.SOUTH);

        // ===== Panel Thông tin =====
        JPanel panelThongTin = new JPanel(new GridBagLayout());
        panelThongTin.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        int row = 0;
        panelThongTin.add(new JLabel("Mã sản phẩm:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Tên sản phẩm:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Loại sản phẩm:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Nhà cung cấp:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Số lượng:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Đơn giá:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Trạng thái:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        // ===== Panel Nút =====
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelButton.setBackground(Color.WHITE);

        JButton btnSua = new JButton("Sửa");
        JButton btnXoa = new JButton("Xóa");
        JButton btnLamMoi = new JButton("Làm mới");

        Dimension btnSize = new Dimension(100, 36);
        btnSua.setPreferredSize(btnSize);
        btnXoa.setPreferredSize(btnSize);
        btnLamMoi.setPreferredSize(btnSize);

        panelButton.add(btnSua);
        panelButton.add(btnXoa);
        panelButton.add(btnLamMoi);

        // Gắn vào mainPanel
        mainPanel.add(panelHinhAnh, BorderLayout.WEST);
        mainPanel.add(panelThongTin, BorderLayout.CENTER);
        mainPanel.add(panelButton, BorderLayout.SOUTH);

        add(mainPanel);
        setPreferredSize(new Dimension(820, 520));
        pack();
        setLocationRelativeTo(null);
    }

    // Hàm tiện ích set vị trí GridBag
    private GridBagConstraints getConstraints(GridBagConstraints gbc, int x, int y) {
        GridBagConstraints c = (GridBagConstraints) gbc.clone();
        c.gridx = x;
        c.gridy = y;
        if (x == 0) {
            c.anchor = GridBagConstraints.EAST;
            c.fill = GridBagConstraints.NONE;
        } else {
            c.weightx = 1.0;
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        return c;
    }

    public static void main(String[] args) {
        ThemSanPham sp= new ThemSanPham();
        sp.setVisible(true);
    }
}
