package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TopTen {

    public ArrayList<Vorname> topten = new ArrayList();
    private Connection conn;

    public ArrayList<Vorname> getTopTenList() {
        ResultSet rs;

        try {

            conn = play.db.DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT firstname_id, firstnameString, COUNT(id) as anzahl FROM vornamencheck.entryview GROUP BY firstname_id, firstnameString ORDER BY anzahl DESC, firstnameString ASC LIMIT 0, 10");
            rs = stmt.executeQuery();

            while ( rs.next() ){
                Vorname vn = Vorname.findById(rs.getLong(1));
                topten.add(vn);
            }

            rs.close();
            conn.close();
        }

        catch ( SQLException e ) {
            e.printStackTrace();
            System.exit(1);
        }

        return topten;

    }

}
