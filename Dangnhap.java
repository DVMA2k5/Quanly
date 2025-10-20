package main.java.quanly.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Dangnhap extends JFrame {

    private JTextField txtUser;
    private JPasswordField txtPass;
    private static HashMap<String, String> accounts = new HashMap<>(); // lưu tạm tk

    public Dangnhap() {
        setTitle("ĐĂNG NHẬP");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // tạo tk mặc định
        accounts.put("admin", "123");
        accounts.put("user", "111");

        // Xử lý sự kiện đóng cửa sổ
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Exit(Dangnhap.this);
            }
        });

        // Panel trái (ảnh)
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);

        ImageIcon originalIcon = new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\pic0.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        JLabel lblImage = new JLabel(new ImageIcon(scaledImage));
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(lblImage, BorderLayout.CENTER);

        // Panel phải (form đăng nhập)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("Đăng nhập");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitle.setForeground(Color.BLACK);

        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 3;
        rightPanel.add(lblTitle, gbc);
        gbc.gridwidth = 1;

        // ID đăng nhập
        gbc.gridx = 0; gbc.gridy = 1;
        rightPanel.add(new JLabel("ID đăng nhập:"), gbc);

        gbc.gridx = 1;
        txtUser = new JTextField(20);
        rightPanel.add(txtUser, gbc);

        // Mật khẩu
        gbc.gridx = 0; gbc.gridy = 2;
        rightPanel.add(new JLabel("Mật khẩu:"), gbc);

        gbc.gridx = 1;
        txtPass = new JPasswordField(20);
        rightPanel.add(txtPass, gbc);

        // Nút "Quên mật khẩu"
        gbc.gridx = 1; gbc.gridy = 3;
        JButton btnForgot = new JButton("Quên mật khẩu?");
        btnForgot.setForeground(Color.RED);
        btnForgot.setBorderPainted(false);
        btnForgot.setContentAreaFilled(false);
        btnForgot.addActionListener(e -> forgotPassword());
        rightPanel.add(btnForgot, gbc);

        // Panel chứa nút
        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        panelBtn.setBackground(Color.WHITE);

        JButton btnLogin = new JButton("Đăng nhập");
        btnLogin.setBackground(new Color(255, 87, 34));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(e -> login());

        JButton btnRegister = new JButton("Đăng ký");
        btnRegister.setBackground(new Color(0, 150, 136));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFocusPainted(false);
        btnRegister.addActionListener(e -> register());

        panelBtn.add(btnLogin);
        panelBtn.add(btnRegister);

        gbc.gridx = 1; gbc.gridy = 4;
        rightPanel.add(panelBtn, gbc);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    // Hàm login
    private void login() {
        String user = txtUser.getText().trim();
        String pass = new String(txtPass.getPassword()).trim();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (accounts.containsKey(user) && accounts.get(user).equals(pass)) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");

            if (user.equals("admin")) {
                Admin ad = new Admin();
                ad.setVisible(true);
            } 
            // nếu bạn có User form riêng thì mở ra ở đây

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Đăng ký (mở form Dangki)
    private void register() {
        Dangki dk = new Dangki();
        dk.setVisible(true);
        this.dispose();
    }

    // Quên mật khẩu
    private void forgotPassword() {
        JOptionPane.showMessageDialog(this, "Vui lòng liên hệ admin để lấy lại mật khẩu!");
    }

    // HÀM THOÁT
    public static void Exit(JFrame frame) {
        int option = JOptionPane.showConfirmDialog(
                frame,
                "Bạn có chắc chắn muốn thoát không?",
                "Xác nhận thoát",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dangnhap().setVisible(true));
    }
}
