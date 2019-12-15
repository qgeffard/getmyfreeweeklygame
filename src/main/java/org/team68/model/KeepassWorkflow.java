package org.team68.model;

import de.slackspace.openkeepass.KeePassDatabase;
import de.slackspace.openkeepass.domain.Entry;
import de.slackspace.openkeepass.domain.Group;
import de.slackspace.openkeepass.domain.KeePassFile;

import java.io.IOException;
import java.util.List;

    class Launcher {

        public static void main(String[] args) {

            String databasekey = "1234";
            String databaseLocation = "C:\\Users\\Medaey\\Nextcloud\\KeePassXC\\databasse\\getmyfreeweeklygame-nokey.kdbx";

            // Open Database
            KeePassFile database = KeePassDatabase.getInstance(databaseLocation).openDatabase(databasekey);

            // Retrieve all entries
            List<Entry> entries = database.getEntries();
            for (Entry entry : entries) {
                System.out.println("Title: " + entry.getTitle() + " Password: " + entry.getPassword());
            }

            // Retrieve all top groups
            List<Group> groups = database.getTopGroups();
            for (Group group : groups) {
                System.out.println(group.getName());
            }
        }
    }