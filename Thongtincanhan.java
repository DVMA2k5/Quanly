package main.java.quanly.GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Thongtincanhan extends JFrame{
    public Thongtincanhan(){
        setTitle("Thông tin cá nhân");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

         // Panel chính
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Các label + textfield
        JLabel lblTenDN = new JLabel("Tên đăng nhập:");
        JTextField txtTenDN = new JTextField("Nguyễn Văn A",20);

        JLabel lblTenHT = new JLabel("Tên hiển thị:");
        JTextField txtTenHT = new JTextField("Admin A",20);

        JLabel lblMK = new JLabel("Mật khẩu:");
        JPasswordField txtMK = new JPasswordField("12345",20);

        JLabel lblMKMoi = new JLabel("Mật khẩu mới:");
        JPasswordField txtMKMoi = new JPasswordField(20);

        JLabel lblNhapLai = new JLabel("Nhập lại:");
        JPasswordField txtNhapLai = new JPasswordField(20);

        // Thêm vào panel
        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblTenDN, gbc);
        gbc.gridx = 1; panel.add(txtTenDN, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblTenHT, gbc);
        gbc.gridx = 1; panel.add(txtTenHT, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblMK, gbc);
        gbc.gridx = 1; panel.add(txtMK, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(lblMKMoi, gbc);
        gbc.gridx = 1; panel.add(txtMKMoi, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panel.add(lblNhapLai, gbc);
        gbc.gridx = 1; panel.add(txtNhapLai, gbc);

        // Panel cho button
        JPanel buttonPanel = new JPanel();
        JButton btnCapNhat = new JButton("Cập nhật");
        JButton btnThoat = new JButton("Thoát");
        buttonPanel.add(btnCapNhat);
        buttonPanel.add(btnThoat);

        // Thêm vào frame
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        Thongtincanhan tt = new Thongtincanhan();
        tt.setVisible(true);
    }
}
