import java.util.Random;

public class kingFireBall {

    public static void left() {
        Random random = new Random();
        int npc = random.nextInt(2) + 1; // generates random number between 1-2 to signify npc's choice.
        //

        GUI.choice1.setText(">");
        GUI.choice2.setText("");
        GUI.choice3.setText("");

        GUI.nextPosition1 = "kingFightFire";
        GUI.nextPosition2 = "";
        GUI.nextPosition3 = "";

        if (npc == 1) {
            GUI.mainTextArea.setText("""
                    You dodge left.
                                               
                    The Kings shoots a fireball as you dodge
                    and lands a direct hit
                    
                    You take 2 damage!
                    """);
            gameFunctions.setHP(GUI.user, 2);
        }
        if (npc == 2) {
            GUI.mainTextArea.setText("""
                    You dodge left.
                                               
                    You feel the heat of the fireball as it
                    passes right by you
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

        GUI.nextPosition1 = "kingFightFire";
        GUI.nextPosition2 = "";
        GUI.nextPosition3 = "";

        if (npc == 2) {
            GUI.mainTextArea.setText("""
                    You dodge right.
                                               
                    The Kings shoots a fireball as you dodge
                    and lands a direct hit.
                    
                    You take 2 damage!
                    """);
            gameFunctions.setHP(GUI.user, 2);
        }
        if (npc == 1) {
            GUI.mainTextArea.setText("""
                    You dodge right.
                                               
                    You feel the heat of the fireball as it
                    passes right by you
                    """);
        }
    }
}
