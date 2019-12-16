package org.team68;

import org.team68.workflow.impl.GlobalWorkflow;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException, InterruptedException {
        GlobalWorkflow grabNewGame = new GlobalWorkflow();
        grabNewGame.execute();
    }
}


//        final String CURRENT_FREE_GAME = "//a[contains(@href, '/store/fr/product')]";
//
//        xpathExpression = "(//*[@id=\"dieselReactWrapper\"]/div/div[4]/div[1]/div[3]/div/section/div/a)";
//
//        String firstfreegame = xpathExpression + "[1]";
//        String secondfreegame = xpathExpression + "[2]";
//        String thirdfreegame = xpathExpression + "[3]";
//        String fourthfreegame = xpathExpression + "[4]";
//        String fifthfreegame = xpathExpression + "[5]";
//
////        boolean firstfreegamebool = ($x(secondfreegame).exists());
//
//        Configuration.headless = true;
//        Selenide.open(URL);
//
//        String ee = $x("(//a[contains(@href, '/store/fr/product')])[1]").getText();
//            System.out.println(ee);
//        System.out.println("Fin");
//        }
//    }

//        if firstfreegame < 2 {
//                System.out.println("Good day");
//            } else{
//                System.out.println("Good evening");
//            }
//        }
//    }


//            if ($x(secondfreegame).exists()) {
//                String secondfreegamehref = $x(secondfreegame).getAttribute("href");
//                System.out.println("Le jeux" + secondfreegamehref + "est gratuit en ce moment");
//            } else {
//                System.out.println("Il n'y a que 1 jeu gratuit cette semaine");
//            }

//            if ($x(thirdfreegame).exists()) {
//                String thirdfreegamehref = $x(thirdfreegame).getAttribute("href");
//                System.out.println("Le jeux" + thirdfreegamehref + "est gratuit en ce moment");
//            } else {
//                System.out.println("Pas plus de 2 jeu gratuit cette semaine c'est déja pas mal");
//            }
//
//            if ($x(fourthfreegame).exists()) {
//                String fourthfreegamehref = $x(fourthfreegame).getAttribute("href");
//                System.out.println("Le jeux" + fourthfreegamehref + "est gratuit en ce moment");
//            } else {
//                System.out.println("Wow tu a déja ù 3 jeu gratuit mais pas plus pour cette semaine");
//            }
//        }
//    }
//}

//        // 1. Open a KeePass database file through a plain text password
//
//        KeePassFile database = KeePassDatabase
//                .getInstance("C:\\Users\\Medaey\\Nextcloud\\KeePassXC\\databasse\\getmyfreeweeklygame.kdbx")
//                .openDatabase("1234", new File("C:\\Users\\Medaey\\Nextcloud\\KeePassXC\\databasse\\getmyfreeweeklygame.key"));
//
//        // 2. Retrieve all entries
//        List<Entry> keepasslist = database.getEntries();
//
//        // 3. Print every entry
//        for (Entry entry : keepasslist) {
//            System.out.println("           Title: " + entry.getTitle());
//            System.out.println("        Username: " + entry.getUsername());
//            System.out.println("        Password: " + entry.getPassword());
//        }