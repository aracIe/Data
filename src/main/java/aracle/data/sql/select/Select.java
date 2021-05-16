package aracle.data.sql.select;

import aracle.data.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    public static String[] account(String uuid) {
        String feedback = null;
        String[] accountData = null;
        String statement;
        String name = null;
        String ip = null;
        String account = null;
        statement = "SELECT name,ip,account FROM data_accounts WHERE uuid = '%s'";
        try (ResultSet resultSet = Core.mySQL.query(String.format(statement, uuid))) {
            resultSet.next();
            name = resultSet.getString("name");
            ip = resultSet.getString("ip");
            account = resultSet.getString("account");
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY +  "account information output:" + uuid);
            accountData = new String[3];
            accountData[0] = name;
            accountData[1] = ip;
            accountData[2] = account;
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while getting account information of " + uuid);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return accountData;
    }
    public static String[] player(String uuid) {
        String feedback = null;
        String[] playerData = null;
        String statement;
        int level = 0;
        int coins = 0;
        String fraction = null;
        int health = 0;
        int arcana = 0;
        int endurance = 0;
        int shards = 0;
        statement = "SELECT level,coins,fraction,health,arcana,endurance,shards FROM data_players WHERE uuid = '%s'";
        try (ResultSet resultSet = Core.mySQL.query(String.format(statement, uuid))) {
            resultSet.next();
            level = resultSet.getInt("level");
            coins = resultSet.getInt("coins");
            fraction = resultSet.getString("fraction");
            health = resultSet.getInt("health");
            arcana = resultSet.getInt("arcana");
            endurance = resultSet.getInt("endurance");
            shards = resultSet.getInt("shards");
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY +  "player information output:" + uuid);
            playerData = new String[7];
            playerData[0] = String.valueOf(level);
            playerData[1] = String.valueOf(coins);
            playerData[2] = fraction;
            playerData[3] = String.valueOf(health);
            playerData[4] = String.valueOf(arcana);
            playerData[5] = String.valueOf(endurance);
            playerData[6] = String.valueOf(shards);
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while getting player information of " + uuid);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return playerData;
    }
    public static String[] weapon(String id) {
        String feedback = null;
        String[] weaponData = null;
        String statement;
        String name = null;
        String description = null;
        String fraction = null;
        int rarity = 0;
        String type = null;
        String subtype = null;
        String essence = null;
        int damage = 0;
        int speed = 0;
        int minPower = 0;
        int maxPower = 0;
        int minLevel = 0;
        int maxLevel = 0;
        statement = "SELECT name,description,fraction,rarity,type,subtype,essence,damage,speed,minPower,maxPower,minLevel,maxLevel FROM data_weapons WHERE uuid = '%s'";
        try (ResultSet resultSet = Core.mySQL.query(String.format(statement, id))) {
            resultSet.next();
            name = resultSet.getString("name");
            description = resultSet.getString("description");
            fraction = resultSet.getString("fraction");
            rarity = resultSet.getInt("rarity");
            type = resultSet.getString("type");
            subtype = resultSet.getString("subtype");
            essence = resultSet.getString("essence");
            damage = resultSet.getInt("damage");
            speed = resultSet.getInt("speed");
            minPower = resultSet.getInt("minPower");
            maxPower = resultSet.getInt("maxPower");
            minLevel = resultSet.getInt("minLevel");
            maxLevel = resultSet.getInt("maxLevel");
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY +  "weapon information output:" + id);
            weaponData = new String[13];
            weaponData[0] = name;
            weaponData[1] = description;
            weaponData[2] = fraction;
            weaponData[3] = String.valueOf(rarity);
            weaponData[4] = type;
            weaponData[5] = subtype;
            weaponData[6] = essence;
            weaponData[7] = String.valueOf(damage);
            weaponData[8] = String.valueOf(speed);
            weaponData[9] = String.valueOf(minPower);
            weaponData[10] = String.valueOf(maxPower);
            weaponData[11] = String.valueOf(minLevel);
            weaponData[12] = String.valueOf(maxLevel);
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while getting weapon information of " + id);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return weaponData;
    }
    public static String[] armor(String id) {
        String feedback = null;
        String[] weaponData = null;
        String statement;
        String name = null;
        String description = null;
        String fraction = null;
        int rarity = 0;
        String type = null;
        String subtype = null;
        String essence = null;
        int defence = 0;
        int minPower = 0;
        int maxPower = 0;
        int minLevel = 0;
        int maxLevel = 0;
        statement = "SELECT name,description,fraction,rarity,type,subtype,essence,defence,minPower,maxPower,minLevel,maxLevel FROM data_armor WHERE id = '%s'";
        try (ResultSet resultSet = Core.mySQL.query(String.format(statement, id))) {
            resultSet.next();
            name = resultSet.getString("name");
            description = resultSet.getString("description");
            fraction = resultSet.getString("fraction");
            rarity = resultSet.getInt("rarity");
            type = resultSet.getString("type");
            subtype = resultSet.getString("subtype");
            essence = resultSet.getString("essence");
            defence = resultSet.getInt("defence");
            minPower = resultSet.getInt("minPower");
            maxPower = resultSet.getInt("maxPower");
            minLevel = resultSet.getInt("minLevel");
            maxLevel = resultSet.getInt("maxLevel");
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY +  "armor information output:" + id);
            weaponData = new String[12];
            weaponData[0] = name;
            weaponData[1] = description;
            weaponData[2] = fraction;
            weaponData[3] = String.valueOf(rarity);
            weaponData[4] = type;
            weaponData[5] = subtype;
            weaponData[6] = essence;
            weaponData[7] = String.valueOf(defence);
            weaponData[8] = String.valueOf(minPower);
            weaponData[9] = String.valueOf(maxPower);
            weaponData[10] = String.valueOf(minLevel);
            weaponData[11] = String.valueOf(maxLevel);
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while getting armor information of " + id);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return weaponData;
    }
    public static String[] runes(String id) {
        String feedback = null;
        String[] weaponData = null;
        String statement;
        String name = null;
        String description = null;
        String fraction = null;
        int rarity = 0;
        String type = null;
        String subtype = null;
        String essence = null;
        int damage = 0;
        int speed = 0;
        int defence = 0;
        int health = 0;
        int arcana = 0;
        int endurance = 0;
        statement = "SELECT name,description,fraction,rarity,type,subtype,essence,damage,speed,defence,health,arcana,endurance FROM data_runes WHERE id = '%s'";
        try (ResultSet resultSet = Core.mySQL.query(String.format(statement, id))) {
            resultSet.next();
            name = resultSet.getString("name");
            description = resultSet.getString("description");
            fraction = resultSet.getString("fraction");
            rarity = resultSet.getInt("rarity");
            type = resultSet.getString("type");
            subtype = resultSet.getString("subtype");
            essence = resultSet.getString("essence");
            damage = resultSet.getInt("damage");
            speed = resultSet.getInt("speed");
            defence = resultSet.getInt("defence");
            health = resultSet.getInt("health");
            arcana = resultSet.getInt("arcana");
            endurance = resultSet.getInt("endurance");
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY +  "rune information output:" + id);
            weaponData = new String[12];
            weaponData[0] = name;
            weaponData[1] = description;
            weaponData[2] = fraction;
            weaponData[3] = String.valueOf(rarity);
            weaponData[4] = type;
            weaponData[5] = subtype;
            weaponData[6] = essence;
            weaponData[7] = String.valueOf(damage);
            weaponData[8] = String.valueOf(speed);
            weaponData[9] = String.valueOf(defence);
            weaponData[10] = String.valueOf(health);
            weaponData[11] = String.valueOf(arcana);
            weaponData[11] = String.valueOf(endurance);
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while getting rune information of " + id);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return weaponData;
    }
    public static String[] inventories(String iid) {
        String feedback = null;
        String[] inventoryData = null;
        String statement;
        String id = null;
        int power = 0;
        int level = 0;
        statement = "SELECT id,power,level FROM data_inventories WHERE iid = '%s'";
        try (ResultSet resultSet = Core.mySQL.query(String.format(statement, iid))) {
            resultSet.next();
            id = resultSet.getString("id");
            power = resultSet.getInt("power");
            level = resultSet.getInt("level");
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY +  "inventory information output:" + iid);
            inventoryData = new String[3];
            inventoryData[0] = id;
            inventoryData[1] = String.valueOf(power);
            inventoryData[2] = String.valueOf(level);
        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while getting inventory information of " + iid);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return inventoryData;
    }
}
