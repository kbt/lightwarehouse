/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lwh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import kbt.Config;

/**
 *
 * @author http://www.zentus.com/sqlitejdbc/
 */
public class Db
{
  private static Connection db;

  public static Connection getDb()
  {
    if (db == null) {
      try {
        Class.forName("org.sqlite.JDBC");
      }
      catch (ClassNotFoundException ex) {
        System.out.println(ex);
      }

      try {
        db = DriverManager.getConnection("jdbc:sqlite:" + Config.get("dbfile"));
      }
      catch (SQLException ex) {
        System.out.println(ex);
      }
    }

    return db;
  }

  public static void close()
  {
    if (db != null) {
      try {
        db.close();
      }
      catch (SQLException e) {
        System.err.println("db close: " + e);
      }
      db = null;
    }
  }
}
