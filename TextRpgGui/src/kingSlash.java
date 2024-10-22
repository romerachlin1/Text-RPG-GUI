import java.util.Random;

public class kingSlash {

    public static void left() {
        Random random = new Random();
        int npc = random.nextInt(2) + 1; // generates random number between 1-2 to signify npc's choice.
        //

        GUI.choice1.setText(">");
        GUI.choice2.setText("");
        GUI.choice3.setText("");

        GUI.nextPosition1 = "kingCharge";
        GUI.nextPosition2 = "";
        GUI.nextPosition3 = "";

        if (npc == 1) {
            GUI.mainTextArea.setText("""
                    You Slash left.
                                               
                    Blood is sprayed as your attack lands!
                    """);
            gameFunctions.takeDamage(GUI.king, GUI.user);

            GUI.mainTextArea.append("\n The King has " + GUI.king.getHp() + " HP left!");
        }
        if (npc == 2) {
            GUI.mainTextArea.setText("""
                    You Slash left.
                                               
                    Your attack misses at the last second..
                    """);
        }
    }

    public static void right() {
        Random random = new Random();
        int npc = random.nextInt(2) + 1; // generates random number between 1-2 to signify npc's choice.
        //

        GUI.choice1.setText(">");
        GUI.choice2.setText("");
        GUI.choice3.setText("");

        GUI.nextPosition1 = "kingCharge";
        GUI.nextPosition2 = "";
        GUI.nextPosition3 = "";

        if (npc == 2) {
            GUI.mainTextArea.setText("""
                    You Slash right.
                                               
                    Blood is sprayed as your attack lands!
                    """);
            gameFunctions.takeDamage(GUI.king, GUI.user);

            GUI.mainTextArea.append("\n The King has " + GUI.king.getHp() + " HP left!");
        }
        if (npc == 1) {
            GUI.mainTextArea.setText("""
                    You Slash right.
                                               
                    Your attack misses at the last second..
                    """);
        }
    }
}
