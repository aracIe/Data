package aracle.data.settings;

import aracle.data.Core;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class Settings {
    public static void load() {
        File settings = Core.instance().settings;
        FileConfiguration configuration = Core.instance().configuration;
        if (!settings.exists()) {
            configuration.set("MySQL.address","localhost");
            configuration.set("MySQL.database","database");
            configuration.set("MySQL.username","user");
            configuration.set("MySQL.password","password");
            configuration.set("MySQL.port", 3306);
            try { configuration.save(settings); }
            catch (IOException e) { e.printStackTrace(); }
        }
    }
}
