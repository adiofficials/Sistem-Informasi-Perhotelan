package GUI;

import Model.NPM07028_Modelregis;
import Model.NPM07028_AllObject;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class NPM07028_Registrasi extends JFrame {

    NPM07028_Modelregis modelinsert = new NPM07028_Modelregis();

    public NPM07028_Registrasi() throws SQLException {
        setSize(700, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JFrame frame_regis = new JFrame();
        getContentPane().setBackground(Color.PINK);
        JButton button_regis = new JButton("Register");
        JButton button_back = new JButton("Back");
        JLabel label_nama = new JLabel("Nama Pengunjung");
        JLabel label_noktp = new JLabel("Telp Pengunjung");
        JLabel label_nohp = new JLabel("Alamat Pengunjung");
        JTextField tfNama = new JTextField();
        JTextField tfTelp = new JTextField();
        JTextField tfAlamat = new JTextField();

        JTable tabel_regis = new JTable();
        JScrollPane scroll_pane = new JScrollPane(tabel_regis);
        scroll_pane.setBounds(150, 100, 480, 180);

        button_regis.setBounds(25, 100, 100, 30);
        button_regis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = tfNama.getText();
                String noTelp = tfTelp.getText();
                String alamat = tfAlamat.getText();
                try {
                    NPM07028_AllObject.dataregis.insert(nama, alamat, noTelp);
                    tabel_regis.setModel(NPM07028_AllObject.dataregis.viewTabel());
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Registrasi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        tabel_regis.setModel(NPM07028_AllObject.dataregis.viewTabel());

        button_back.setBounds(25, 150, 100, 30);
        button_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NPM07028_Admin frame_Admin = new NPM07028_Admin();
                dispose();
            }
        });

        tfNama.setBounds(150, 50, 150, 30);
        tfTelp.setBounds(315, 50, 150, 30);
        tfAlamat.setBounds(475, 50, 150, 30);

        label_nama.setFont(new Font("Consolas", Font.BOLD, 12));
        label_nama.setBounds(150, 15, 150, 30);
        label_noktp.setFont(new Font("Consolas", Font.BOLD, 12));
        label_noktp.setBounds(315, 15, 150, 30);
        label_nohp.setFont(new Font("Consolas", Font.BOLD, 12));
        label_nohp.setBounds(475, 15, 150, 30);

        add(label_nama);
        add(label_noktp);
        add(label_nohp);
        add(button_regis);
        add(button_back);
        add(tfNama);
        add(tfTelp);
        add(tfAlamat);
        add(scroll_pane);
        setVisible(true);
    }
}
