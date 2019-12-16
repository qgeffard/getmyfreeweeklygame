package org.team68.workflow.impl;

import de.slackspace.openkeepass.KeePassDatabase;
import de.slackspace.openkeepass.domain.Entry;
import de.slackspace.openkeepass.domain.KeePassFile;

import java.io.File;
import java.util.List;

public class KeepassWorkflow {

    public void e() {
        // 1. Open a KeePass database file through a plain text password

        KeePassFile database = KeePassDatabase
                .getInstance("C:\\Users\\Medaey\\Nextcloud\\KeePassXC\\databasse\\getmyfreeweeklygame.kdbx")
                .openDatabase("1234", new File("C:\\Users\\Medaey\\Nextcloud\\KeePassXC\\databasse\\getmyfreeweeklygame.key"));

        // 2. Retrieve all entries
        List<Entry> keepasslist = database.getEntries();

        // 3. Print every entry
        for (Entry entry : keepasslist) {
            System.out.println("    * Credential: " + entry.getTitle());
            System.out.println("        Username: " + entry.getUsername());
            System.out.println("        Password: " + entry.getPassword());
        }
    }
}