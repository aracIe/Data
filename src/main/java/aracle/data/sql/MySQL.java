package aracle.data.sql;

import aracle.data.Core;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQL extends Database {

    private final HikariDataSource dataSource;

    private String host;
    private String port;
    private String database;
    private String user;
    private String password;
    private Boolean SSL;

    private Integer minimumIdle;
    private Integer maximumPoolSize;
    private Integer connectionTimeout;
    public MySQL() {
        FileConfiguration configuration = Core.instance().configuration;
        setHost(configuration.getString("MySQL.address"));
        setPort(configuration.getString("MySQL.port"));
        setDatabase(configuration.getString("MySQL.database"));
        setUser(configuration.getString("MySQL.username"));
        setPassword(configuration.getString("MySQL.password"));
        setSSL(true);
        setMinimumIdle(2);
        setMaximumPoolSize(10);
        setConnectionTimeout(1500);

        HikariConfig config = new HikariConfig();

        final String URL = "jdbc:mysql://%s:%s/%s?useSSL=%s";
        config.setJdbcUrl(String.format(URL, getHost(), getPort(), getDatabase(), getSSL()));

        config.setUsername(getUser());
        config.setPassword(getPassword());

        config.setMinimumIdle(getMinimumIdle());
        config.setMaximumPoolSize(getMaximumPoolSize());
        config.setConnectionTimeout(getConnectionTimeout());

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        config.addDataSourceProperty("useLocalSessionState", "true");
        config.addDataSourceProperty("rewriteBatchedStatements", "true");
        config.addDataSourceProperty("cacheResultSetMetadata", "true");
        config.addDataSourceProperty("cacheServerConfiguration", "true");
        config.addDataSourceProperty("elideSetAutoCommits", "true");
        config.addDataSourceProperty("maintainTimeStats", "false");

        config.setPoolName("DataAPI-Pool");

        config.setConnectionTestQuery("SELECT 1");

        dataSource = new HikariDataSource(config);
    }
    /**
     * Getter for the Hikari DataSource object
     *
     * @return Hikari DataSource object
     */
    public HikariDataSource getDataSource() {
        return dataSource;
    }

    /**
     * Gets connection from Hikari DataSource
     *
     * @return connection
     * @throws SQLException if cannot get a connection
     */
    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = dataSource.getConnection();
        }
        return connection;
    }
    private String getHost() {
        return host;
    }

    private void setHost(String host) {
        this.host = host;
    }

    private String getPort() {
        return port;
    }

    private void setPort(String port) {
        this.port = port;
    }

    private String getDatabase() {
        return database;
    }

    private void setDatabase(String database) {
        this.database = database;
    }

    private String getUser() {
        return user;
    }

    private void setUser(String user) {
        this.user = user;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private Boolean getSSL() {
        return SSL;
    }

    private void setSSL(Boolean SSL) {
        this.SSL = SSL;
    }

    private Integer getMinimumIdle() {
        return minimumIdle;
    }

    private void setMinimumIdle(Integer minimumIdle) {
        this.minimumIdle = minimumIdle;
    }

    private Integer getMaximumPoolSize() {
        return maximumPoolSize;
    }

    private void setMaximumPoolSize(Integer maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    private Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    private void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
}
