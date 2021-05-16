package aracle.data.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

public abstract class Database {

    // Connection to the database
    protected Connection connection;

    /**
     * Creates a new Database
     */
    protected Database() {
        this.connection = null;
    }

    /**
     * Checks if a connection is open with the database
     *
     * @return true if the connection is open
     * @throws SQLException if the connection cannot be checked
     */
    private boolean checkConnection() throws SQLException {
        return connection != null && !connection.isClosed();
    }

    /**
     * Gets the connection with the database
     *
     * @return Connection with the database, null if none
     * @throws SQLException if cannot get a connection
     */
    public Connection getConnection() throws SQLException {
        return connection;
    }

    /**
     * Closes the connection with the database
     *
     * @throws SQLException if the connection cannot be closed
     */
    public void closeConnection() throws SQLException {
        connection.close();
    }

    /**
     * Executes a SQL Query and returns a ResultSet
     * If the connection is closed, it will be opened
     *
     * @param query Query to be run
     * @return ResultSet object
     * @throws SQLException If the query cannot be executed
     */
    public ResultSet query(String query) throws SQLException {
        if (!checkConnection()) connection = getConnection();

        PreparedStatement statement = connection.prepareStatement(query);

        return statement.executeQuery();
    }
    /**
     * Executes a SQL Query
     * If the connection is closed, it will be opened
     *
     * @param query    Query to be run
     * @param consumer to pass ResultSet to
     * @throws SQLException If the query cannot be executed
     */
    public void query(String query, SQLConsumer<ResultSet> consumer) throws SQLException {
        ResultSet resultSet = query(query);

        consumer.accept(resultSet);

        resultSet.close();
        resultSet.getStatement().close();
    }

    /**
     * Executes an Update SQL Update
     * See {@link java.sql.PreparedStatement#executeUpdate()}
     * If the connection is closed, it will be opened
     *
     * @param update Update to be run
     * @return result code, see {@link java.sql.PreparedStatement#executeUpdate()}
     * @throws SQLException If the query cannot be executed
     */
    public int update(String update) throws SQLException {
        if (!checkConnection()) connection = getConnection();

        PreparedStatement statement = connection.prepareStatement(update);
        int resultCode = statement.executeUpdate();

        statement.close();

        return resultCode;
    }

    /**
     * Executes an SQL update asynchronously
     *
     * @param update Update to be run
     * @return result code, see {@link java.sql.PreparedStatement#executeUpdate()}
     * internally throws SQLException           If the query cannot be executed
     * internally throws ClassNotFoundException If the driver cannot be found; see {@link #getConnection()}
     */
    public CompletableFuture<Integer> updateAsync(String update) {
        return CompletableFuture.supplyAsync(() -> {
            int resultCode = 0;
            try {
                resultCode = update(update);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return resultCode;
        });
    }
}
