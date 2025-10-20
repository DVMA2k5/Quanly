package main.java.quanly.GUI;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;

public class Admin extends JFrame {
    public Admin(){
        setTitle("Admin");
        setSize(650, 410);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // ====== Menu ======
        JMenuBar menubar = new JMenuBar();

        JMenu doanhthu =  new JMenu("Doanh thu");
        JMenu ql = new JMenu("Quản lí");
        JMenuItem kh = new JMenuItem("Quản lí khách hàng");
        JMenuItem sp = new JMenuItem("Quản lí sản phẩm");
        JMenuItem nv = new JMenuItem("Quản lí nhân viên");

        ql.add(kh);
        ql.add(sp);
        ql.add(nv);

        JMenu infor = new JMenu("Thông tin tài khoản");
        JMenuItem ttcn = new JMenuItem("Thông tin cá nhân");
        JMenuItem dx = new JMenuItem("Đăng xuất");
        infor.add(ttcn);
        infor.add(dx);

        menubar.add(doanhthu);
        menubar.add(ql);
        menubar.add(infor);
        setJMenuBar(menubar);

        // ====== Ảnh động nền ======
        JPanel gifPanel = new JPanel(new BorderLayout());
        ImageIcon giftt = new ImageIcon("src/main/java/quanly/IMG/bg.gif");
        JLabel imggif = new JLabel(giftt); 
        gifPanel.add(imggif, BorderLayout.CENTER);
        add(gifPanel, BorderLayout.CENTER);

        // ====== Sự kiện ======

        // Doanh thu
        doanhthu.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                dispose();
                new Doanhthu().setVisible(true);
            }
            @Override public void menuDeselected(javax.swing.event.MenuEvent e) {}
            @Override public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        // Quản lí khách hàng
        kh.addActionListener(e -> {
            dispose();
            new Danhsachkhachhang().setVisible(true);
        });

        // Quản lí sản phẩm
        sp.addActionListener(e -> {
            dispose();
            new Danhsachsanpham().setVisible(true); // nếu bạn đã có class Sanpham
        });

        // Quản lí nhân viên
        nv.addActionListener(e -> {
            dispose();
            new Danhsachnhanvien().setVisible(true);
        });

        // Thông tin cá nhân
        ttcn.addActionListener(e -> {
            dispose();
            new Thongtincanhan().setVisible(true);
        });

        // Đăng xuất
        dx.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn đăng xuất?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if(option == JOptionPane.YES_OPTION) {
                dispose();
                new Dangnhap().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new Admin().setVisible(true);
    }
}
