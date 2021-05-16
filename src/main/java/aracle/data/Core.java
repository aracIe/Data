package aracle.data;

import aracle.data.settings.Settings;
import aracle.data.sql.Database;
import aracle.data.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.SQLException;

public final class Core extends JavaPlugin {

    private static Core instance;
    public static Database mySQL;
    public static Core instance() { return instance; }
    public File settings = new File(getDataFolder()+File.separator+"settings.yml");
    public FileConfiguration configuration = YamlConfiguration.loadConfiguration(settings);

    @Override
    public void onEnable() {
        instance = this;
        Settings.load();
        initialize();
    }

    public void initialize() {
        String feedback = null;
        try {
            mySQL = new MySQL();
        } catch (Exception exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + "connected to Database.");
            tables();
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while connecting to mySQL!");
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    public void tables() {
        String feedback = null;
        String statement;
        try {
            statement = "CREATE TABLE IF NOT EXISTS data_accounts (uuid VARCHAR(36), name VARCHAR(20), ip VARCHAR(20), account VARCHAR(15))";
            mySQL.update(statement);
            statement = "CREATE TABLE IF NOT EXISTS data_players (uuid VARCHAR(36), level INT(5), coins INT(6), fraction VARCHAR(25), health INT(5), arcana INT(5), endurance INT(5), shards INT(5))";
            mySQL.update(statement);
            statement = "CREATE TABLE IF NOT EXISTS data_weapons (id VARCHAR(50), name VARCHAR(75), description TEXT(500), fraction VARCHAR(25), rarity INT(1), type VARCHAR(20), subtype VARCHAR(50), essences VARCHAR(300), damage INT(2), speed INT(1), minPower INT(2), maxPower INT(2), minLevel INT(2), maxLevel INT(2))";
            mySQL.update(statement);
            statement = "CREATE TABLE IF NOT EXISTS data_armor (id VARCHAR(50), name VARCHAR(75), description TEXT(500), fraction VARCHAR(25), rarity INT(1), type VARCHAR(20), subtype VARCHAR(50), essences VARCHAR(300), defence INT(2), minPower INT(2), maxPower INT(2), minLevel INT(2), maxLevel INT(2))";
            mySQL.update(statement);
            statement = "CREATE TABLE IF NOT EXISTS data_runes (id VARCHAR(50), name VARCHAR(75), description TEXT(500), fraction VARCHAR(25), rarity INT(1), type VARCHAR(20), subtype VARCHAR(50), essences VARCHAR(300), damage INT(2), speed INT(1), defence INT(2), health INT(5), arcana INT(5), endurance INT(5))";
            mySQL.update(statement);
            statement = "CREATE TABLE IF NOT EXISTS data_inventories (iid INT(9) AUTO_INCREMENT, uuid VARCHAR(36), id VARCHAR(50), power INT(2), level INT(2))";
            mySQL.update(statement);
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + "tables was successfully loaded.");
            tables();
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while loading tables!");
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        try {
            mySQL.closeConnection();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
