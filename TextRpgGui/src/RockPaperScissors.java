import java.util.Random;

public class RockPaperScissors {
    GUI gui;
    gameFunctions gF;

    public static void rpsRock(){
        Random random = new Random();
        int npc = random.nextInt(3) + 1; // generates random number between 1-3 to signify npc's choice.
        //
        if (npc == 1){
            GUI.mainTextArea.setText("""
                           You have chosen Rock.
                           
                           Your opponent has chosen Rock.
                           
                           It is a draw..
                           """);

            GUI.choice1.setText(">");
            GUI.choice2.setText("");
            GUI.choice3.setText("");

            GUI.nextPosition1 = "castleRPS";
            GUI.nextPosition2 = "";
            GUI.nextPosition3 = "";

        }if (npc == 2){
            GUI.mainTextArea.setText("""
                           You have chosen Rock.
                           
                           Your opponent has chosen Paper.
                           
                           You have lost..
                           """);

            GUI.choice1.setText(">");
            GUI.choice2.setText("");
            GUI.choice3.setText("");

            GUI.nextPosition1 = "castleRPSLose";
            GUI.nextPosition2 = "";
            GUI.nextPosition3 = "";
        }if (npc == 3){
            GUI.mainTextArea.setText("""
                           You have chosen Rock.
                           
                           Your opponent has chosen Scissors.
                           
                           You have Won!
                           """);

            GUI.choice1.setText(">");
            GUI.choice2.setText("");
            GUI.choice3.setText("");

            GUI.nextPosition1 = "castleRPSWin";
            GUI.nextPosition2 = "";
            GUI.nextPosition3 = "";
        }
    }

    public static void rpsPaper(){
        Random random = new Random();
        int npc = random.nextInt(3) + 1; // generates random number between 1-3 to signify npc's choice.
        //

        if (npc == 1){
            GUI.mainTextArea.setText("""
                           You have chosen Paper.
                           
                           Your opponent has chosen Rock.
                           
                           You have Won!
                           """);

            GUI.choice1.setText(">");
            GUI.choice2.setText("");
            GUI.choice3.setText("");

            GUI.nextPosition1 = "castleRPSWin";
            GUI.nextPosition2 = "";
            GUI.nextPosition3 = "";
        }if (npc == 2){
            GUI.mainTextArea.setText("""
                           You have chosen Paper.
                           
                           Your opponent has chosen Paper.
                           
                           It is a draw.
                           """);

            GUI.choice1.setText(">");
            GUI.choice2.setText("");
            GUI.choice3.setText("");

            GUI.nextPosition1 = "castleRPS";
            GUI.nextPosition2 = "";
            GUI.nextPosition3 = "";
        }if (npc == 3){
            GUI.mainTextArea.setText("""
                           You have chosen Paper.
                           
                           Your opponent has chosen Scissors.
                           
                           You have lost..
                           """);

            GUI.choice1.setText(">");
            GUI.choice2.setText("");
            GUI.choice3.setText("");

            GUI.nextPosition1 = "castleRPSLose";
            GUI.nextPosition2 = "";
            GUI.nextPosition3 = "";
        }
    }

    public static void rpsScissors(){
        Random random = new Random();
        int npc = random.nextInt(3) + 1; // generates random number between 1-3 to signify npc's choice.
        //

        if (npc == 1){
            GUI.mainTextArea.setText("""
                           You have chosen Scissors.
                           
                           Your opponent has chosen Rock.
                           
                           You have lost..
                           """);

            GUI.choice1.setText(">");
            GUI.choice2.setText("");
            GUI.choice3.setText("");

            GUI.nextPosition1 = "castleRPSLose";
            GUI.nextPosition2 = "";
            GUI.nextPosition3 = "";
        }if (npc == 2){
            GUI.mainTextArea.setText("""
                           You have chosen Scissors.
                           
                           Your opponent has chosen Paper.
                           
                           You have Won!
                           """);

            GUI.choice1.setText(">");
            GUI.choice2.setText("");
            GUI.choice3.setText("");

            GUI.nextPosition1 = "castleRPSWin";
            GUI.nextPosition2 = "";
            GUI.nextPosition3 = "";
        }if (npc == 3){
            GUI.mainTextArea.setText("""
                           You have chosen Scissors.
                           
                           Your opponent has chosen Scissors.
                           
                           It is a draw..
                           """);

            GUI.choice1.setText(">");
            GUI.choice2.setText("");
            GUI.choice3.setText("");

            GUI.nextPosition1 = "castleRPS";
            GUI.nextPosition2 = "";
            GUI.nextPosition3 = "";
        }

    }
}
