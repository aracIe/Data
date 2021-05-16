package aracle.data.sql.update;

import aracle.data.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.SQLException;

public class Update {
    public static String accounts(String uuid, String name, String ip, String account) {
        String feedback = null;
        String statement;
        try {
            statement = "UPDATE data_accounts SET uuid = '%s', name = '%s', ip = '%s', account = '%s'";
            Core.mySQL.update(String.format(statement, uuid, name, ip, account));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + name +  "'s account was successfully loaded to accounts table. Uuid: " + ChatColor.GRAY + uuid);

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while loading " + name +"'s account! Uuid: " + ChatColor.GRAY + uuid);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String players(String uuid, int level, int coins, String fraction, int health, int arcana, int endurance, int shards) {
        String feedback = null;
        String statement;
        try {
            statement = "UPDATE players SET uuid = '%s', level = %d, coins = %d, fraction = '%s', health = %d, arcana = %d, endurance = %d, shards = %d";
            Core.mySQL.update(String.format(statement, uuid, level, coins, fraction, health, arcana, endurance, shards));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY + uuid +  " was successfully loaded to players table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while loading " + uuid + "!");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String weapons(String id, String name, String description, String fraction, int rarity, String type, String subtype, String essences, int damage, int speed, int minPower, int maxPower, int minLevel, int maxLevel) {
        String feedback = null;
        String statement;
        try {
            statement = "UPDATE data_weapons SET id = '%s', name = '%s', description = '%s', fraction = '%s', rarity= %d, type = '%s', subtype = '%s', essences = '%s', damage = %d, speed = %d, minPower = %d, maxPower = %d, minLevel = %d, mexLevel = %d";
            Core.mySQL.update(String.format(statement, id, name, description, fraction, rarity, type, subtype, essences, damage, speed, minPower, maxPower, minLevel, maxLevel));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY + id +  " was successfully loaded to weapons table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while loading " + id + "!");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String armor(String id, String name, String description, String fraction, int rarity, String type, String subtype, String essences, int defence, int minPower, int maxPower, int minLevel, int maxLevel) {
        String feedback = null;
        String statement;
        try {
            statement = "UPDATE data_armor SET id = '%s', name = '%s', description = '%s', fraction = '%s', rarity= %d, type = '%s', subtype = '%s', essences = '%s', defence = %d, minPower = %d, maxPower = %d, minLevel = %d, mexLevel = %d";
            Core.mySQL.update(String.format(statement, id, name, description, fraction, rarity, type, subtype, essences, defence, minPower, maxPower, minLevel, maxLevel));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY + id +  " was successfully loaded to armor table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while loading " + id + "!");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String runes(String id, String name, String description, String fraction, int rarity, String type, String subtype, String essences, int damage, int speed, int defence, int health, int arcana, int endurance) {
        String feedback = null;
        String statement;
        try {
            statement = "UPDATE data_runes SET id = '%s', name = '%s', description = '%s', fraction = '%s', rarity= %d, type = '%s', subtype = '%s', essences = '%s', defence = %d, minPower = %d, maxPower = %d, minLevel = %d, mexLevel = %d";
            Core.mySQL.update(String.format(statement, id, name, description, fraction, rarity, type, subtype, essences, damage, speed, defence, health, arcana, endurance));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY + id +  " was successfully loaded to runes table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while loading " + id + "!");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String inventories(int iid, String uuid, String id, int power, int level) {
        String feedback = null;
        String statement;
        try {
            statement = "UPDATE data_inventories SET iid = %d, uuid = '%s', id = '%s', power = %d, level = %d ";
            Core.mySQL.update(String.format(statement, iid, uuid, id, power, level));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.GRAY + id +  " was successfully loaded to inventories table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while loading " + id + "!");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }
}
