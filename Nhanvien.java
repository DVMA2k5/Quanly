package main.java.quanly.GUI;

import javax.swing.*;
import java.awt.*;

public class Nhanvien extends JFrame {

    public Nhanvien() {
        setTitle("Nhân viên");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel chính
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // --- Panel Thông tin ---
        JPanel panelThongTin = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        panelThongTin.add(new JLabel("Mã nhân viên:"), getConstraints(gbc, 0, row));
        JTextField txtMaNV = createTextField("NV20230925001");
        panelThongTin.add(txtMaNV, getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Họ và tên:"), getConstraints(gbc, 0, row));
        JTextField txtTenNV = createTextField("Nguyễn Văn A");
        panelThongTin.add(txtTenNV, getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Chức vụ:"), getConstraints(gbc, 0, row));
        JTextField txtChucVu = createTextField("Nhân viên bán hàng");
        panelThongTin.add(txtChucVu, getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Phòng ban:"), getConstraints(gbc, 0, row));
        JTextField txtPhongBan = createTextField("Kinh doanh");
        panelThongTin.add(txtPhongBan, getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Số điện thoại:"), getConstraints(gbc, 0, row));
        JTextField txtSoDienThoai = createTextField("0987654321");
        panelThongTin.add(txtSoDienThoai, getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Lương:"), getConstraints(gbc, 0, row));
        JTextField txtLuong = createTextField("12.000.000");
        panelThongTin.add(txtLuong, getConstraints(gbc, 1, row++));

        panelThongTin.add(new JLabel("Trạng thái:"), getConstraints(gbc, 0, row));
        JTextField txtTrangThai = createTextField("Đang làm việc");
        panelThongTin.add(txtTrangThai, getConstraints(gbc, 1, row++));

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

        // Gắn panel vào mainPanel
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
        Nhanvien nv = new Nhanvien();
        nv.setVisible(true);
    }
}
