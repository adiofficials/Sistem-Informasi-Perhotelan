package GUI;

import Model.NPM07028_Modelinsertkamar;
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

public class NPM07028_Insert extends JFrame {

    NPM07028_Modelinsertkamar modelinsert;

    public NPM07028_Insert() throws SQLException {
        setSize(700, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JFrame frame_menu2 = new JFrame();
        getContentPane().setBackground(Color.PINK);
        JButton button_insert = new JButton("Insert");
        JButton button_update = new JButton("Update");
        JButton button_delete = new JButton("Delete");
        JButton button_back = new JButton("Back");
        JLabel label_kuota = new JLabel("Nama kamar");
        JLabel labelNoKamar = new JLabel("No Kamar");
        JLabel labelJenisKamar = new JLabel("Jenis Kamar");
        JLabel labelStatusKamar = new JLabel("Status Kamar");
        JTextField tfNamaKamar = new JTextField();
        JTextField tfNoKamar = new JTextField();
        JTextField tfJenisKamar = new JTextField();
        JTextField tfStatusKamar = new JTextField();

        JTable tabel_datakamar = new JTable();
        JScrollPane scroll_pane = new JScrollPane(tabel_datakamar);
        scroll_pane.setBounds(150, 100, 480, 180);

        button_insert.setBounds(25, 100, 100, 30);
        button_insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namaKamar = tfNamaKamar.getText();
                int noKamar = Integer.parseInt(tfNoKamar.getText());
                String jenisKamar = tfJenisKamar.getText();
                String status = tfStatusKamar.getText();

                try {
                    NPM07028_AllObject.datakamar.insert(namaKamar, noKamar, jenisKamar, status);
                    tabel_datakamar.setModel(NPM07028_AllObject.datakamar.viewTabel());
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        tabel_datakamar.setModel(NPM07028_AllObject.datakamar.viewTabel());

        button_update.setBounds(25, 150, 100, 30);
        button_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int noKamar = Integer.parseInt(tfNoKamar.getText());
                    boolean ketemu = NPM07028_AllObject.datakamar.cariDataKamar(noKamar);
                    if (ketemu) {
                        String namaKamar = tfNamaKamar.getText();
                        String jenisKamar = tfJenisKamar.getText();
                        String statusKamar = tfStatusKamar.getText();
                        NPM07028_AllObject.datakamar.update(namaKamar, noKamar, jenisKamar, statusKamar);
                        tabel_datakamar.setModel(NPM07028_AllObject.datakamar.viewTabel());
                    }
                    if (!ketemu) {
                        JOptionPane.showMessageDialog(null, "Kamar yang ingin diupdate tidak ditemukan");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        button_delete.setBounds(25, 200, 100, 30);
        button_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int noKamar = Integer.parseInt(tfNoKamar.getText());
                    boolean ketemu = NPM07028_AllObject.datakamar.cariDataKamar(noKamar);
                    if (ketemu) {
                        NPM07028_AllObject.datakamar.delete(noKamar);
                        tabel_datakamar.setModel(NPM07028_AllObject.datakamar.viewTabel());
                    }
                    if (!ketemu) {
                        JOptionPane.showMessageDialog(null, "Kamar yang ingin dihapus tidak ditemukan");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NPM07028_Insert.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        button_back.setBounds(25, 250, 100, 30);
        button_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NPM07028_Admin frame_admin = new NPM07028_Admin();
                dispose();
            }
        });

        tfNamaKamar.setBounds(150, 50, 100, 30);
        tfNoKamar.setBounds(275, 50, 100, 30);
        tfJenisKamar.setBounds(400, 50, 100, 30);
        tfStatusKamar.setBounds(525, 50, 100, 30);

        label_kuota.setFont(new Font("Consolas", Font.BOLD, 12));
        label_kuota.setBounds(150, 15, 100, 30);
        labelNoKamar.setFont(new Font("Consolas", Font.BOLD, 12));
        labelNoKamar.setBounds(275, 15, 100, 30);
        labelJenisKamar.setFont(new Font("Consolas", Font.BOLD, 12));
        labelJenisKamar.setBounds(400, 15, 100, 30);
        labelStatusKamar.setFont(new Font("Consolas", Font.BOLD, 12));
        labelStatusKamar.setBounds(525, 15, 100, 30);

        add(label_kuota);
        add(labelNoKamar);
        add(labelJenisKamar);
        add(labelStatusKamar);
        add(button_insert);
        add(button_update);
        add(button_delete);
        add(button_back);
        add(tfNamaKamar);
        add(tfJenisKamar);
        add(tfNoKamar);
        add(tfStatusKamar);
        add(scroll_pane);
        setVisible(true);
    }
}
