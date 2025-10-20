package main.java.quanly.GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.*;
import java.util.*;

public class Doanhthu extends JFrame {
    private JTable table;
    private JLabel txtTongThu;
    private Object[][] fullData; // dữ liệu gốc
    private String[] columns = {"STT", "Sản phẩm", "DateCheckOut", "DateCheckIn", "Doanh thu"};
    
    public Doanhthu() {
        setTitle("Doanh Thu");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.white);

        // ====== Panel phía trên ======
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(Color.white);

        JLabel titlePanel = new JLabel("Doanh Thu");
        titlePanel.setFont(new Font("Arial", Font.BOLD, 25));
        titlePanel.setForeground(Color.red);
        titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        northPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        String[] NgayBD = {"21/11/2025", "22/11/2025", "23/11/2025"};
        JComboBox<String> txtNgayBD = new JComboBox<>(NgayBD);
        String[] NgayKT = {"21/11/2025", "22/11/2025", "23/11/2025"};
        JComboBox<String> txtNgayKT = new JComboBox<>(NgayKT);
        JButton btnThongKe = new JButton("Thống kê");

        topPanel.add(new JLabel("Từ ngày:"));
        topPanel.add(txtNgayBD);
        topPanel.add(new JLabel("Đến ngày:"));
        topPanel.add(txtNgayKT);
        topPanel.add(btnThongKe);
        northPanel.add(topPanel, BorderLayout.SOUTH);
        add(northPanel, BorderLayout.NORTH);

        // ====== Dữ liệu mẫu ======
        fullData = new Object[][]{
            {1, "Sản phẩm 01", "21/11/2025", "21/11/2025", 150000},
            {2, "Sản phẩm 02", "22/11/2025", "22/11/2025", 200000},
            {3, "Sản phẩm 03", "23/11/2025", "23/11/2025", 250000},
            {4, "Sản phẩm 04", "21/11/2025", "21/11/2025", 300000},
        };

        table = new JTable(fullData, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // ====== Panel dưới (Tổng doanh thu + nút) ======
        JPanel southPanel = new JPanel(new BorderLayout());

        JPanel tongThuPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        JLabel lblTongThu = new JLabel("Tổng doanh thu: ");
        txtTongThu = new JLabel("0 VND");
        lblTongThu.setFont(new Font("Arial", Font.BOLD, 16));
        txtTongThu.setFont(new Font("Arial", Font.BOLD, 16));
        txtTongThu.setForeground(Color.BLUE);
        tongThuPanel.add(lblTongThu);
        tongThuPanel.add(txtTongThu);
        southPanel.add(tongThuPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnSua = new JButton("Đóng");
        JButton btnLamMoi = new JButton("Làm mới");
        bottomPanel.add(btnSua);
        bottomPanel.add(btnLamMoi);
        southPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(southPanel, BorderLayout.SOUTH);

        // ====== Tính tổng khi load lần đầu ======
        updateTongDoanhThu(fullData);

        // ====== Chức năng Thống kê ======
        btnThongKe.addActionListener(e -> {
            String start = (String) txtNgayBD.getSelectedItem();
            String end = (String) txtNgayKT.getSelectedItem();
            Object[][] filteredData = filterDataByDate(start, end);
            table.setModel(new DefaultTableModel(filteredData, columns));
            updateTongDoanhThu(filteredData);
        });
    }

    // Lọc dữ liệu theo ngày
    private Object[][] filterDataByDate(String start, String end) {
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dStart = sdf.parse(start);
            Date dEnd = sdf.parse(end);
            for (Object[] row : fullData) {
                Date dRow = sdf.parse((String) row[2]);
                if (!dRow.before(dStart) && !dRow.after(dEnd)) {
                    list.add(row);
                }
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return list.toArray(new Object[0][]);
    }

    // Cập nhật tổng doanh thu
    private void updateTongDoanhThu(Object[][] data) {
        int tong = 0;
        for (Object[] row : data) {
            tong += (int) row[4];
        }
        txtTongThu.setText(String.format("%,d VND", tong));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Doanhthu dt = new Doanhthu();
            dt.setVisible(true);
        });
    }
}
