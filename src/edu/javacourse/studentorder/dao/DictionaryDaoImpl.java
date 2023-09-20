package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao{
    private static final String GET_STREET = "SELECT street_code, street_name " +
            "FROM jc_street " + "WHERE UPPER(street_name) LIKE UPPER (?)";


    private Connection getConnection() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/jc_student";
        String user = "postgres";
        String password = "postgres";
        Connection con = DriverManager.getConnection(url, user, password);
        return con;

    }

    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> result = new LinkedList<>();



        try(Connection con = getConnection()) {
            PreparedStatement stmt = con.prepareStatement(GET_STREET);

            stmt.setString(1,"%" + pattern + "%");

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                    result.add(str);
                }
        }
        catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }
}
