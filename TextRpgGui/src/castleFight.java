import java.util.Random;

public class castleFight {

    GUI gui;
    gameFunctions gF;

    public static void High(){
        Random random = new Random();
        int npc = random.nextInt(3) + 1; // generates random number between 1-3 to signify npc's choice.
        //

        GUI.choice1.setText(">");
        GUI.choice2.setText("");
        GUI.choice3.setText("");

        GUI.nextPosition1 = "kingFight";
        GUI.nextPosition2 = "";
        GUI.nextPosition3 = "";

        if (npc == 1){
            GUI.mainTextArea.setText("""
                           You attack from above!
                           
                           You both clash and neither manage
                           to land a blow..
                           
                           """);

        }if (npc == 2){
            GUI.mainTextArea.setText("""
                           You attack from above!
                           
                           You get the wind knocked out of you as
                           you suffer a blow to your middle body..
                           
                           """);

            gameFunctions.setHP(GUI.user, GUI.king.getWeapon().getDamage());

        }if (npc == 3){
            GUI.mainTextArea.setText("""
                           You attack from above!
                           
                           You penetrate their defence and land the blow!
                           
                           """);
            gameFunctions.takeDamage(GUI.king, GUI.user);

            GUI.mainTextArea.append("\n The King has " + GUI.king.getHp() + " HP left!");

        }
    }

    public static void Middle(){
        Random random = new Random();
        int npc = random.nextInt(3) + 1; // generates random number between 1-3 to signify npc's choice.
        //
        GUI.choice1.setText(">");
        GUI.choice2.setText("");
        GUI.choice3.setText("");

        GUI.nextPosition1 = "kingFight";
        GUI.nextPosition2 = "";
        GUI.nextPosition3 = "";

        if (npc == 1){
            GUI.mainTextArea.setText("""
                           You attack their middle body!
                           
                           You penetrate their defence and land the blow!
                           """);
            gameFunctions.takeDamage(GUI.king, GUI.user);

            GUI.mainTextArea.append("\n The King has " + GUI.king.getHp() + " HP left!");


        }if (npc == 2){
            GUI.mainTextArea.setText("""
                           You attack their middle body!
                           
                           You both clash and neither manage
                           to land a blow..
                           """);


        }if (npc == 3){
            GUI.mainTextArea.setText("""
                           You attack their middle body!
                           
                           You feel a blow land near your legs
                           as you crash to the ground..
                           
                           """);

            gameFunctions.setHP(GUI.user, GUI.king.getWeapon().getDamage());
        }
    }

    public static void Low(){
        Random random = new Random();
        int npc = random.nextInt(3) + 1; // generates random number between 1-3 to signify npc's choice.
        //

        GUI.choice1.setText(">");
        GUI.choice2.setText("");
        GUI.choice3.setText("");

        GUI.nextPosition1 = "kingFight";
        GUI.nextPosition2 = "";
        GUI.nextPosition3 = "";

        if (npc == 1){
            GUI.mainTextArea.setText("""
                           You aim for the legs and attack!
                           
                           Before landing your attack you feel sharp pain
                           in your upper body as you suffer an attack.
                           """);

            gameFunctions.setHP(GUI.user, GUI.king.getWeapon().getDamage());

        }if (npc == 2){
            GUI.mainTextArea.setText("""
                           You aim for the legs and attack!
                           
                           You penetrate their defence and land the blow!
                           """);

            gameFunctions.takeDamage(GUI.king, GUI.user);

            GUI.mainTextArea.append("\n The King has " + GUI.king.getHp() + " HP left!");

        }if (npc == 3){
            GUI.mainTextArea.setText("""
                           You aim for the legs and attack!
                           
                           You both clash and neither manage
                           to land a blow..
                           """);


        }

    }
}
