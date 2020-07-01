package Model;

import Model.NPM07028_Checkin;
import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NPM07028_ModelCheckin {

    private Koneksi koneksi;

    public NPM07028_ModelCheckin() {
        this.koneksi = new Koneksi();
    }

    public void insert(int noKamar, String jenisKamar) {
        String sql = "INSERT INTO kamar_07028 (id_kamar, no_kamar, jenis_kamar) VALUES "
                + "(id_kamar.NEXTVAL, '" + noKamar + "', '" + jenisKamar + "')";
        this.koneksi.ManipulasiData(sql);
    }

    public void insert2(String namaPengunjung, String tanggalCekIn, String tanggalCekOut, int noKamar) 
                throws SQLException {
        String sql = "SELECT id_kamar FROM kamar_07028 WHERE no_kamar = " + noKamar;
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        int idKamar = rs.getInt("id_kamar");
        
        String sql2 = "UPDATE booking_07028 SET tanggal_masuk = TO_DATE('" + tanggalCekIn + "', 'dd/mm/yyyy'), "
                + "tanggal_keluar = TO_DATE('" + tanggalCekOut + "', 'dd/mm/yyyy'), id_kamar = " + idKamar 
                + " WHERE nama_pengunjung LIKE '" + namaPengunjung + "'";
        this.koneksi.ManipulasiData(sql2);
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel modelCheckin = new DefaultTableModel();
        modelCheckin.addColumn("No Kamar");
        modelCheckin.addColumn("Jenis Kamar");
        modelCheckin.addColumn("Nama Pengunjung");
        modelCheckin.addColumn("Tanggal Masuk");

        ResultSet rs = this.koneksi.GetData("SELECT a.no_kamar, a.jenis_kamar, "
                + "b.nama_pengunjung, b.tanggal_masuk FROM kamar_07028 a JOIN booking_07028 b ON "
                + "a.id_kamar = b.id_kamar");
        while (rs.next()) {
            Object[] temp = new Object[4];
            temp[0] = rs.getString("no_kamar");
            temp[1] = rs.getString("jenis_kamar");
            temp[2] = rs.getString("nama_pengunjung");
            String tanggalTerformat = new SimpleDateFormat().format(rs.getDate("tanggal_masuk"));
            temp[3] =  tanggalTerformat;
            modelCheckin.addRow(temp);
        }

        return modelCheckin;
    }
}
