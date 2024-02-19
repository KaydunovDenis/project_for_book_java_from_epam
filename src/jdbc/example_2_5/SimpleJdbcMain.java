package jdbc.example_2_5;

import org.h2.tools.Csv;
import org.h2.tools.SimpleResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class SimpleJdbcMain
{
    private static final Logger logger = Logger.getLogger("LOG");
    private static final String SQL_SELECT_ALL = "SELECT * FROM phonebook";

    public static void main(String[] args)
    {
        try (Connection connection = ConnectorCreator.createConnection();
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            //2
            select(resultSet);
            //3
            //insertUsingPreparedStatement(connection);
            //3
            //insertUsingMoveToInsertRow(resultSet);
            //4
            //insertUsingResultSet(resultSet);
            //5
            //insertUsingBatch(connection);
            //5 
            //populateUsingBatch(connection);
            //From H2 documentation
            saveDataToCsvFile();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void saveDataToCsvFile() throws SQLException
    {
        SimpleResultSet rs = new SimpleResultSet();
        rs.addColumn("NAME", Types.VARCHAR, 255, 0);
        rs.addColumn("EMAIL", Types.VARCHAR, 255, 0);
        rs.addRow("Bob Meier", "bob.meier@abcde.abc");
        rs.addRow("John Jones", "john.jones@abcde.abc");
        new Csv().write("data/test.csv", rs, null);
    }

    private static void populateUsingBatch(Connection connection) throws SQLException
    {
        List<Abonent> abonents =
            List.of(new Abonent(101, "Golubev", 1233452),
                new Abonent(102, "Gobev", 1233352),
                new Abonent(103, "Robov", 9998123));
        // filling abonents
        PreparedStatement statement =
            connection.prepareStatement("INSERT INTO phonebook VALUES(?,?,?)");
        for (Abonent abonent : abonents) {
            statement.setInt(1, abonent.getId());
            statement.setString(2, abonent.getName());
            statement.setInt(3, abonent.getPhone());
            statement.addBatch();
        }
        int[] updateCounts = statement.executeBatch();
        logger.info("populateUsingBatch: Update count of row: " + Arrays.toString(updateCounts));
    }

    private static void insertUsingBatch(Connection connection) throws SQLException
    {
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("INSERT INTO phonebook VALUES (93, 'Sagant', 113211)");
        statement.addBatch("INSERT INTO location VALUES (201, 'Minsk')");
        statement.addBatch("INSERT INTO location VALUES (202, 'Lviv')");
        int[] updateCounts = statement.executeBatch();
        connection.commit();
        logger.info("insertUsingBatch: " + Arrays.toString(updateCounts));
    }

    private static void insertUsingPreparedStatement(Connection connection) throws SQLException
    {
        String sql = "INSERT INTO phonebook(idphonebook, lastname, phone) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 43);
        statement.setString(2, "Skaryna");
        statement.setInt(3, 990077);
        int rowsUpdate = statement.executeUpdate();
        logger.info("Rows was updated: " + rowsUpdate);
    }

    private static void insertUsingResultSet(ResultSet resultSet) throws SQLException
    {
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            if (id == 2) {
                resultSet.updateInt("phone", 1111111); // update row
                resultSet.updateRow();
            }
        }
        logger.info("insertUsingResultSet: ");
    }

    private static void insertUsingMoveToInsertRow(ResultSet resultSet) throws SQLException
    {
        resultSet.moveToInsertRow();
        resultSet.updateInt(1, 80);
        resultSet.updateString(2, "Bahdanovich");
        resultSet.updateInt(3, 222322);
        resultSet.insertRow();
        resultSet.moveToCurrentRow();
        logger.info("insertUsingMoveToInsertRow: ");
    }

    private static void select(ResultSet resultSet) throws SQLException
    {
        List<Abonent> abonents = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int number = resultSet.getInt("phone");
            abonents.add(new Abonent(id, name, number));
        }
        logger.info("SELECT: " + abonents.toString());
    }
}