package main.java.quanly.GUI;

import javax.swing.*;
import java.awt.*;

public class ThemNhanvien extends JFrame {
    public ThemNhanvien() {
        setTitle("Nhân viên");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel chính
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        // ===== Panel Thông tin =====
        JPanel panelThongTin = new JPanel(new GridBagLayout());
        panelThongTin.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        int row = 0;
        panelThongTin.add(new JLabel("Mã nhân viên:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Họ và tên:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Chức vụ:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Phòng ban:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Số điện thoại:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Lương:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Trạng thái:"), getConstraints(gbc, 0, row));
        panelThongTin.add(new JTextField(20), getConstraints(gbc, 1, row++));

        // ===== Panel nút chức năng =====
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

        // ===== Gắn panel vào mainPanel =====
        mainPanel.add(panelThongTin, BorderLayout.CENTER);
        mainPanel.add(panelButton, BorderLayout.SOUTH);

        add(mainPanel);
        setPreferredSize(new Dimension(650, 500));
        pack();
        setLocationRelativeTo(null);
    }

    // Hàm set vị trí trong GridBagLayout
    private GridBagConstraints getConstraints(GridBagConstraints gbc, int x, int y) {
        GridBagConstraints c = (GridBagConstraints) gbc.clone();
        c.gridx = x;
        c.gridy = y;
        if (x == 0) {
            c.anchor = GridBagConstraints.EAST;
        } else {
            c.weightx = 1.0;
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        return c;
    }

    public static void main(String[] args) {
        ThemNhanvien nv= new ThemNhanvien();
        nv.setVisible(true);
    }
}
