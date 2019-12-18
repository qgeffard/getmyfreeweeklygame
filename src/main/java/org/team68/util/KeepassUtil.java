package org.team68.util;

import de.slackspace.openkeepass.KeePassDatabase;
import de.slackspace.openkeepass.domain.KeePassFile;
import org.team68.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class KeepassUtil {

    public static final String KEEPASS_PATH = "KEEPASS_PATH";
    public static final String KEEPASS_ENCRYPT_PASSWORD = "KEEPASS_PASSWORD";
    public static final String KEEPASS_PASSWORD_KEY = "KEEPASS_PASSWORD_KEY";
    private KeePassFile database;

    public void readKeepassDatabase() {
        String keepass = System.getenv(KEEPASS_PATH);
        String password = System.getenv(KEEPASS_ENCRYPT_PASSWORD);
        String key = System.getenv(KEEPASS_PASSWORD_KEY);

        this.database = KeePassDatabase
                .getInstance(keepass)
                .openDatabase(password, new File("C:\\Users\\Medaey\\Nextcloud\\KeePassXC\\databasse\\getmyfreeweeklygame.key"));
    }

    public List<User> getDatabaseAsUser(){
        if(database == null){
            readKeepassDatabase();
        }

        List<User> result = new ArrayList<>(3);
        database.getEntries().forEach(entry -> {
            User user = new User();
            user.setDiscordId(entry.getTitle());
            user.setLogin(entry.getUsername());
            user.setPassword(entry.getPassword());
            result.add(user);
        });

        return result;
    }

}
