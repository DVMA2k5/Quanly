package main.java.quanly.GUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Danhsachsanpham extends JFrame {

    private DefaultTableModel model;

    public Danhsachsanpham() {
        setTitle("Danh sách sản phẩm");
        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.white);

        // Tiêu đề
        JLabel tittPanel = new JLabel("Danh sách các sản phẩm");
        tittPanel.setFont(new Font("Arial", Font.BOLD, 25));
        tittPanel.setForeground(Color.red);
        tittPanel.setHorizontalAlignment(SwingConstants.CENTER);
        tittPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(tittPanel, BorderLayout.NORTH);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Top Panel: nút thêm và tìm kiếm
        JPanel topPanel = new JPanel(new FlowLayout());
        JButton them = new JButton("Thêm Sản Phẩm");
        them.setFont(new Font("Arial", Font.BOLD, 12));
        JTextField timkiem = new JTextField(25);
        JButton tk = new JButton("Tìm kiếm");
        tk.setFont(new Font("Arial", Font.BOLD, 12));

        topPanel.add(them);
        topPanel.add(new JLabel("Tìm sản phẩm:"));
        topPanel.add(timkiem);
        topPanel.add(tk);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        // Bottom Panel: bảng và các nút dưới bảng
        JPanel botPanel = new JPanel(new BorderLayout());
        botPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        String[] colum = {"STT", "Hình ảnh", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm","Số lượng"};
        Object[][] data = {
                {1,new ImageIcon(new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\giay1.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)), "SP20230608230022", "Sản phẩm 01", "Loại 03","0"},
                {2,new ImageIcon(new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\giay2.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)), "SP20230608230124", "Sản phẩm 02", "Loại 01","20"},
                {3,new ImageIcon(new ImageIcon("C:\\Quanly\\src\\main\\java\\quanly\\IMG\\giay3.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)), "SP20230608230125", "Sản phẩm 03", "Loại 02","0"},
        };

        model = new DefaultTableModel(data, colum) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 1) return Icon.class;
                return Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(60);

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

        // 🔔 Chỉ hiển thị thông báo khi cửa sổ vừa mở
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                kiemTraHetHang();
            }
        });
    }

    private void kiemTraHetHang() {
        StringBuilder hetHang = new StringBuilder();
        for (int i = 0; i < model.getRowCount(); i++) {
            String soLuong = model.getValueAt(i, 5).toString();
            if (soLuong.equals("0")) {
                hetHang.append(model.getValueAt(i, 3)).append(" (Mã: ")
                        .append(model.getValueAt(i, 2)).append(")\n");
            }
        }
        if (hetHang.length() > 0) {
            JOptionPane.showMessageDialog(this,
                    "Các sản phẩm sau đã hết hàng:\n" + hetHang,
                    "Thông báo hết hàng",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Danhsachsanpham sp = new Danhsachsanpham();
            sp.setVisible(true);
        });
    }
}
