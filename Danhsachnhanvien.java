package main.java.quanly.GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Danhsachnhanvien extends JFrame {

    public Danhsachnhanvien() {
        setTitle("Danh sách nhân viên");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.white);

        // Tiêu đề
        JLabel titlePanel = new JLabel("Danh sách các Nhân viên");
        titlePanel.setFont(new Font("Arial", Font.BOLD, 25));
        titlePanel.setForeground(Color.red);
        titlePanel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(titlePanel, BorderLayout.NORTH);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Top Panel: nút thêm và tìm kiếm
        JPanel topPanel = new JPanel(new FlowLayout());
        JButton themButton = new JButton("Thêm Nhân viên");
        themButton.setFont(new Font("Arial", Font.BOLD, 12));
        JTextField timKiemField = new JTextField(25);
        JButton timKiemButton = new JButton("Tìm kiếm");
        timKiemButton.setFont(new Font("Arial", Font.BOLD, 12));

        topPanel.add(themButton);
        topPanel.add(new JLabel("Tìm Nhân viên:"));
        topPanel.add(timKiemField);
        topPanel.add(timKiemButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // Bottom Panel: bảng và các nút dưới bảng
        JPanel botPanel = new JPanel(new BorderLayout());
        botPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        String[] columns = {"STT", "Họ và tên", "Mã nhân viên", "Số điện thoại"};
        Object[][] data = {
            {1,"Nguyễn Văn A", "NV20230608230022", "0325647248"},
            {2,"Lê Văn B", "NV20230608230124", "01247530"},
            {3,"Nguyễn Văn C", "NV20230608230125", "057832486"},
        };

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(40);

        // Canh giữa header
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(SwingConstants.CENTER);

        JScrollPane scrollPane = new JScrollPane(table);
        botPanel.add(scrollPane, BorderLayout.CENTER);

        // Nút dưới bảng
        JPanel bottomButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton suaButton = new JButton("Sửa");
        JButton lamMoiButton = new JButton("Làm mới");
        JButton xemButton = new JButton("Đóng");

        bottomButtonPanel.add(suaButton);
        bottomButtonPanel.add(xemButton);
        bottomButtonPanel.add(lamMoiButton);

        botPanel.add(bottomButtonPanel, BorderLayout.SOUTH);

        mainPanel.add(botPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Danhsachnhanvien frame = new Danhsachnhanvien();
        frame.setVisible(true);
    }
}
