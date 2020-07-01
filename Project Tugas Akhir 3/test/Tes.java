/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adira
 */
public class Tes {

    public static void main(String[] args) {
        String tanggal = "11/11/2011";
        String namaPengunjung = "aris";
        int noKamar = 111;
        String jenisKamar = "VIP";
        
        String sql = "INSERT INTO kamar_07028 (id_kamar, no_kamar, jenis_kamar) VALUES "
                + "(id_kamar.NEXTVAL, '" + noKamar + "', '" + jenisKamar + "')";
        System.out.println(sql);
        
        String sql2 = "UPDATE booking_07028 SET tanggal_masuk = TO_DATE('" + tanggal + "', 'dd/mm/yyyy') "
                + "WHERE nama_pengunjung LIKE '" + namaPengunjung + "'";
        System.out.println(sql2);
        
    }
}
