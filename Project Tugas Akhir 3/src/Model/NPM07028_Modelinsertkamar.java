package Model;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class NPM07028_Modelinsertkamar {

    private Koneksi koneksi;

    public NPM07028_Modelinsertkamar() {
        koneksi = new Koneksi();
    }

    public void insert(String namaKamar, int noKamar, String jenisKamar, String status) {
        String sql = "INSERT INTO kamar_07028 (id_kamar, nama_kamar, no_kamar, jenis_kamar, status) "
                + "VALUES (id_kamar.NEXTVAL, '" + namaKamar + "', '" + noKamar + "', '"
                + jenisKamar + "', '" + status + "')";
        this.koneksi.ManipulasiData(sql);
    }

    public void update(String namaKamar, int noKamar, String jenisKamar, String status) {
        String sql = "UPDATE kamar_07028 SET nama_kamar = '" + namaKamar + "', jenis_kamar = '" + jenisKamar
                + "', status = '" + status + "' WHERE no_kamar = '" + noKamar + "'";
        this.koneksi.ManipulasiData(sql);
    }

    public void delete(int noKamar) {
        String sql = "DELETE FROM kamar_07028 WHERE no_kamar = " + noKamar;
        this.koneksi.ManipulasiData(sql);
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel modelDataKamar = new DefaultTableModel();
        modelDataKamar.addColumn("Nama Kamar");
        modelDataKamar.addColumn("No Kamar");
        modelDataKamar.addColumn("Jenis Kamar");
        modelDataKamar.addColumn("Status");
        ResultSet rs = this.koneksi.GetData("SELECT id_kamar, nama_kamar, no_kamar, jenis_kamar, status "
                + "FROM kamar_07028");
        while (rs.next()) {
            NPM07028_Kamar kamar = new NPM07028_Kamar();
            kamar.setIdKamar(rs.getInt("id_kamar"));
            kamar.setNamaKamar(rs.getString("nama_kamar"));
            kamar.setNoKamar(rs.getInt("no_kamar"));
            kamar.setJenisKamar(rs.getString("jenis_kamar"));
            kamar.setStatus(rs.getString("status"));

            Object[] temp = new Object[4];
            temp[0] = kamar.getNamaKamar();
            temp[1] = kamar.getNoKamar();
            temp[2] = kamar.getJenisKamar();
            temp[3] = kamar.getStatus();
            modelDataKamar.addRow(temp);
        }
        return modelDataKamar;
    }

    public boolean cariDataKamar(int noKamar) throws SQLException {
        String sql = "SELECT * FROM kamar_07028 WHERE no_kamar = " + noKamar;
        ResultSet rs = this.koneksi.GetData(sql);
        return rs.next();
    }

}
