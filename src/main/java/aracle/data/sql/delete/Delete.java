package aracle.data.sql.delete;

import aracle.data.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.sql.SQLException;

public class Delete {
    public static String account(String uuid) {
        String feedback = null;
        String statement = "DELETE FROM data_accounts WHERE uuid = '%s'";
        try {
            Core.mySQL.update(String.format(statement, uuid));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + uuid +  "'s account was successfully deleted from accounts table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while deleting " + uuid +"'s account!");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String player(String uuid) {
        String feedback = null;
        String statement = "DELETE FROM data_players WHERE uuid = '%s'";
        try {
            Core.mySQL.update(String.format(statement, uuid));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + uuid +  "'s player was successfully deleted from players table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while deleting " + uuid +"'s player!");
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String weapon(String id) {
        String feedback = null;
        String statement = "DELETE FROM data_weapons WHERE id = '%s'";
        try {
            Core.mySQL.update(String.format(statement, id));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + id +  " was successfully deleted from weapons table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while deleting " + id);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String armor(String id) {
        String feedback = null;
        String statement = "DELETE FROM data_armor WHERE id = '%s'";
        try {
            Core.mySQL.update(String.format(statement, id));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + id +  " was successfully deleted from armor table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while deleting " + id);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String runes(String id) {
        String feedback = null;
        String statement = "DELETE FROM data_runes WHERE id = '%s'";
        try {
            Core.mySQL.update(String.format(statement, id));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + id +  " was successfully deleted from runes table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while deleting " + id);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }

    public static String inventory(String iid) {
        String feedback = null;
        String statement = "DELETE FROM data_inventories WHERE iid = '%s'";
        try {
            Core.mySQL.update(String.format(statement, iid));
        } catch (SQLException exception) {
            feedback = exception.getMessage();
        }
        if (feedback == null) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + iid +  " was successfully deleted from inventories table.");

        }
        else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + "error while deleting " + iid);
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "ERROR: " + ChatColor.WHITE + feedback);
        }
        return feedback;
    }
}
