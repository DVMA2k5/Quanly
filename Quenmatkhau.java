package main.java.quanly.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Quenmatkhau extends JFrame {

    public Quenmatkhau() {
        setTitle("QUÊN MẬT KHẨU");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Xử lý sự kiện đóng cửa sổ
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Exit(Quenmatkhau.this);
            }
        });

        // Panel bên trái (ảnh minh họa)
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setPreferredSize(new Dimension(300, 0));

        ImageIcon originalIcon = new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\pic0.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        JLabel lblImage = new JLabel(new ImageIcon(scaledImage));
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(lblImage, BorderLayout.CENTER);

        // Panel bên phải (form)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("Khôi phục mật khẩu");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(Color.BLACK);

        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 2;
        rightPanel.add(lblTitle, gbc);
        gbc.gridwidth = 1;

        // ID đăng nhập
        gbc.gridx = 0; gbc.gridy = 1;
        rightPanel.add(new JLabel("ID đăng nhập:"), gbc);

        gbc.gridx = 1;
        JTextField txtUser = new JTextField(20);
        rightPanel.add(txtUser, gbc);

        // Email khôi phục
        gbc.gridx = 0; gbc.gridy = 2;
        rightPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        JTextField txtEmail = new JTextField(20);
        rightPanel.add(txtEmail, gbc);

        // Panel nút
        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        panelBtn.setBackground(Color.WHITE);

        JButton btnSend = new JButton("Gửi yêu cầu");
        btnSend.setBackground(new Color(33, 150, 243));
        btnSend.setForeground(Color.WHITE);

        JButton btnBack = new JButton("Quay lại");
        btnBack.setBackground(new Color(255, 87, 34));
        btnBack.setForeground(Color.WHITE);

        panelBtn.add(btnSend);
        panelBtn.add(btnBack);

        gbc.gridx = 1; gbc.gridy = 3;
        rightPanel.add(panelBtn, gbc);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    // HÀM THOÁT
    public static void Exit(JFrame frame) {
        int option = JOptionPane.showConfirmDialog(
                frame,
                "Bạn có chắc chắn muốn thoát không?",
                "Xác nhận thoát",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Quenmatkhau qmk = new Quenmatkhau();
        qmk.setVisible(true);
    }
}
