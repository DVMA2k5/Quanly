package main.java.quanly.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Dangki extends JFrame {

    // Giả lập "database" bằng HashMap (id -> mật khẩu)
    private static HashMap<String, String> fakeDB = new HashMap<>();

    public Dangki() {
        setTitle("ĐĂNG KÝ TÀI KHOẢN");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Xử lý sự kiện đóng cửa sổ
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Exit(Dangki.this);
            }
        });

        // Panel trái (ảnh minh họa)
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setPreferredSize(new Dimension(300, 0));

        ImageIcon originalIcon = new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\pic0.jpg");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        JLabel lblImage = new JLabel(new ImageIcon(scaledImage));
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(lblImage, BorderLayout.CENTER);

        // Panel phải (form đăng ký)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("Đăng ký tài khoản");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
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

        // Mật khẩu
        gbc.gridx = 0; gbc.gridy = 2;
        rightPanel.add(new JLabel("Mật khẩu:"), gbc);
        gbc.gridx = 1;
        JPasswordField txtPass = new JPasswordField(20);
        rightPanel.add(txtPass, gbc);

        // Xác nhận mật khẩu
        gbc.gridx = 0; gbc.gridy = 3;
        rightPanel.add(new JLabel("Xác nhận mật khẩu:"), gbc);
        gbc.gridx = 1;
        JPasswordField txtConfirm = new JPasswordField(20);
        rightPanel.add(txtConfirm, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 4;
        rightPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        JTextField txtEmail = new JTextField(20);
        rightPanel.add(txtEmail, gbc);

        // Số điện thoại
        gbc.gridx = 0; gbc.gridy = 5;
        rightPanel.add(new JLabel("Số điện thoại:"), gbc);
        gbc.gridx = 1;
        JTextField txtPhone = new JTextField(20);
        rightPanel.add(txtPhone, gbc);

        // Panel chứa nút
        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        panelBtn.setBackground(Color.WHITE);

        JButton btnRegister = new JButton("Đăng ký");
        btnRegister.setBackground(new Color(0, 200, 83));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFocusPainted(false);

        JButton btnBack = new JButton("Quay lại");
        btnBack.setBackground(new Color(255, 87, 34));
        btnBack.setForeground(Color.WHITE);
        btnBack.setFocusPainted(false);

        panelBtn.add(btnRegister);
        panelBtn.add(btnBack);

        gbc.gridx = 1; gbc.gridy = 6;
        rightPanel.add(panelBtn, gbc);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        // ============= XỬ LÝ NÚT =============
        btnRegister.addActionListener(e -> {
            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword());
            String confirm = new String(txtConfirm.getPassword());
            String email = txtEmail.getText().trim();
            String phone = txtPhone.getText().trim();

            // Kiểm tra dữ liệu
            if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!pass.equals(confirm)) {
                JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không khớp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (fakeDB.containsKey(user)) {
                JOptionPane.showMessageDialog(this, "ID đã tồn tại, vui lòng chọn tên khác!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Lưu "tài khoản" vào fake DB
            fakeDB.put(user, pass);
            JOptionPane.showMessageDialog(this, "Đăng ký thành công!\nBạn có thể đăng nhập ngay.", "Thành công", JOptionPane.INFORMATION_MESSAGE);

            // Chuyển về trang đăng nhập
            this.dispose();
            new Dangnhap().setVisible(true);
        });

        btnBack.addActionListener(e -> {
            this.dispose();
            new Dangnhap().setVisible(true);
        });
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

    
}
