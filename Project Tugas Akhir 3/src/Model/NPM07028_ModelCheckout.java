package Model;

import database.Koneksi;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class NPM07028_ModelCheckout {

    private Koneksi koneksi;

    public NPM07028_ModelCheckout() {
        this.koneksi = new Koneksi();
    }

    public void delete(int noKamar) throws SQLException{
        String sql = "SELECT id_kamar FROM kamar_07028 WHERE no_kamar = " + noKamar;
        ResultSet rs = this.koneksi.GetData(sql);
        rs.next();
        int idKamar = rs.getInt("id_kamar");
        
        String sql2 = "DELETE FROM booking_07028 WHERE id_kamar = " + idKamar;
        this.koneksi.ManipulasiData(sql2);

        String sql3 = "DELETE FROM kamar_07028 WHERE id_kamar = " + idKamar;
        this.koneksi.ManipulasiData(sql3);
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel modelCheckout = new DefaultTableModel();
        modelCheckout.addColumn("Nama Pengunjung");
        modelCheckout.addColumn("No Kamar");
        modelCheckout.addColumn("Jenis Kamar");
        modelCheckout.addColumn("Tanggal Masuk");
        modelCheckout.addColumn("Tanggal Keluar");

        ResultSet rs = this.koneksi.GetData("SELECT b.nama_pengunjung, a.no_kamar, a.jenis_kamar, "
                + "b.tanggal_masuk, b.tanggal_keluar FROM kamar_07028 a JOIN booking_07028 b ON "
                + "a.id_kamar = b.id_kamar");
        while (rs.next()) {
            Object[] temp = new Object[5];
            temp[0] = rs.getString("nama_pengunjung");
            temp[1] = rs.getString("no_kamar");
            temp[2] = rs.getString("jenis_kamar");
            String tanggalCekIn = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("tanggal_masuk"));
            temp[3] = tanggalCekIn;
            String tanggalCekOut = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("tanggal_keluar"));
            temp[4] = tanggalCekOut;
            modelCheckout.addRow(temp);
        }
        return modelCheckout;
    }

}
