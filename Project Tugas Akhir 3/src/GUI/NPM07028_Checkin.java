package GUI;

import Model.NPM07028_ModelCheckin;
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

public class NPM07028_Checkin extends JFrame {

    NPM07028_ModelCheckin modelcheckin = new NPM07028_ModelCheckin();

    public NPM07028_Checkin() throws SQLException {
        setSize(850, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JFrame frame_checkin = new JFrame();
        getContentPane().setBackground(Color.PINK);
        JButton button_insert = new JButton("Check in");
        JButton button_back = new JButton("Back");
        JLabel label_nocekin = new JLabel("Nama Pengunjung");
        JLabel label_id = new JLabel("No Kamar");
        JLabel label_tipe = new JLabel("Jenis Kamar");
        JLabel label_tanggal_cek_in = new JLabel("Tanggal Check In");
        JLabel label_tanggal_cek_out = new JLabel("Tanggal Check Out");
        JTextField tfNamaPengunjung = new JTextField();
        JTextField tfNoKamar = new JTextField();
        JTextField tfJenisKamar = new JTextField();
        JTextField tfTanggalCekIn = new JTextField();
        JTextField tfTanggalCekOut = new JTextField();

        JTable tabel_checkin = new JTable();
        JScrollPane scroll_pane = new JScrollPane(tabel_checkin);
        scroll_pane.setBounds(150, 100, 600, 180);

        button_insert.setBounds(25, 100, 100, 30);
        button_insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ketemu = false;
                String namaPengunjung = tfNamaPengunjung.getText();
                int noKamar = Integer.parseInt(tfNoKamar.getText());
                String jenisKamar = tfJenisKamar.getText();
                String tanggalCekIn = tfTanggalCekIn.getText();
                String tanggalCekOut = tfTanggalCekOut.getText();
                try {
                    NPM07028_AllObject.datacheckin.insert(noKamar, jenisKamar);
                    NPM07028_AllObject.datacheckin.insert2(namaPengunjung, tanggalCekIn, tanggalCekOut, noKamar);
                    tabel_checkin.setModel(NPM07028_AllObject.datacheckin.viewTabel());
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Checkin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        tabel_checkin.setModel(NPM07028_AllObject.datacheckin.viewTabel());

        button_back.setBounds(25, 150, 100, 30);
        button_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NPM07028_Admin frame_admin = new NPM07028_Admin();
                dispose();
            }
        });

        tfNamaPengunjung.setBounds(150, 50, 100, 30);
        tfNoKamar.setBounds(275, 50, 100, 30);
        tfJenisKamar.setBounds(400, 50, 100, 30);
        tfTanggalCekIn.setBounds(525, 50, 100, 30);
        tfTanggalCekOut.setBounds(650, 50, 100, 30);
        
        
        label_nocekin.setFont(new Font("Consolas", Font.BOLD, 12));
        label_nocekin.setBounds(150, 15, 150, 30);
        label_id.setFont(new Font("Consolas", Font.BOLD, 12));
        label_id.setBounds(275, 15, 100, 30);
        label_tipe.setFont(new Font("Consolas", Font.BOLD, 12));
        label_tipe.setBounds(400, 15, 100, 30);
        label_tanggal_cek_in.setFont(new Font("Consolas", Font.BOLD, 12));
        label_tanggal_cek_in.setBounds(525, 15, 150, 30);
        label_tanggal_cek_out.setFont(new Font("Consolas", Font.BOLD, 12));
        label_tanggal_cek_out.setBounds(650, 15, 150, 30);

        add(label_nocekin);
        add(label_id);
        add(label_tipe);
        add(label_tanggal_cek_in);
        add(label_tanggal_cek_out);
        add(button_insert);
        add(button_back);
        add(tfNamaPengunjung);
        add(tfNoKamar);
        add(tfJenisKamar);
        add(tfTanggalCekIn);
        add(tfTanggalCekOut);
        add(scroll_pane);
        setVisible(true);
    }
}
