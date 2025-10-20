package main.java.quanly.GUI;

import javax.swing.*;
import java.awt.*;

public class SanPham extends JFrame {

    public SanPham() {
        setTitle("Sản Phẩm");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chính
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // --- Panel Hình ảnh ---
        JPanel panelHinhAnh = new JPanel(new BorderLayout(10, 10));

        JLabel lblHinhAnh = new JLabel(
                new ImageIcon(
                        new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\giay1.jpg")
                                .getImage()
                                .getScaledInstance(300, 90, Image.SCALE_SMOOTH)
                )
        );
        lblHinhAnh.setHorizontalAlignment(JLabel.CENTER);
        lblHinhAnh.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        panelHinhAnh.add(lblHinhAnh, BorderLayout.CENTER);

        JButton btnChonAnh = new JButton("Chọn ảnh");
        btnChonAnh.setPreferredSize(new Dimension(100, 30));
        JPanel panelBtnAnh = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelBtnAnh.add(btnChonAnh);
        panelHinhAnh.add(panelBtnAnh, BorderLayout.SOUTH);

        // --- Panel Thông tin ---
        JPanel panelThongTin = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;
        panelThongTin.add(new JLabel("Mã sản phẩm:"), getConstraints(gbc, 0, row));
        panelThongTin.add(createTextField("SP20230608230124"), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Tên sản phẩm:"), getConstraints(gbc, 0, row));
        panelThongTin.add(createTextField("Sản phẩm 02"), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Loại sản phẩm:"), getConstraints(gbc, 0, row));
        panelThongTin.add(createTextField("Loại 01"), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Nhà cung cấp:"), getConstraints(gbc, 0, row));
        panelThongTin.add(createTextField("Nhà cung cấp 02"), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Số lượng:"), getConstraints(gbc, 0, row));
        panelThongTin.add(createTextField("30"), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Đơn giá:"), getConstraints(gbc, 0, row));
        panelThongTin.add(createTextField("450.000"), getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Trạng thái:"), getConstraints(gbc, 0, row));
        panelThongTin.add(createTextField("Còn hàng"), getConstraints(gbc, 1, row++));

        // --- Panel nút chức năng ---
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnSua = new JButton("Sửa");
        JButton btnXoa = new JButton("Xóa");
        JButton btnLamMoi = new JButton("Làm mới");

        Dimension btnSize = new Dimension(100, 30);
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
    }

    // Hàm tạo textfield gọn đẹp
    private JTextField createTextField(String text) {
        JTextField tf = new JTextField(text);
        tf.setPreferredSize(new Dimension(200, 28));
        return tf;
    }

    // Hàm set vị trí trong GridBagLayout
    private GridBagConstraints getConstraints(GridBagConstraints gbc, int x, int y) {
        GridBagConstraints c = (GridBagConstraints) gbc.clone();
        c.gridx = x;
        c.gridy = y;
        if (x == 1) c.fill = GridBagConstraints.HORIZONTAL;
        return c;
    }

    public static void main(String[] args) {
        SanPham sp = new SanPham();
        sp.setVisible(true);
    }
}
