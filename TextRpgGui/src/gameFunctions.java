import java.util.Scanner;
import java.util.Random;


public class gameFunctions {

    GUI gui;

    static String afterFight, fightContinue;
    static Player enemyContinue;

    public static void selectPosition (String nextPosition){
        switch (nextPosition){
//            case "test": GUI.endGame();break;
            case "cave": GUI.cave1(); break;
            case "forest2": GUI.forest2(); break;
            case "forestDead": GUI.forestDead(); break;
            case "forest3": GUI.forest3(); break;
            case "forestRiddle": GUI.forestRiddle(); break;
            case "caveDeeper": GUI.cave1Deeper();break;
            case "caveInvestigate": GUI.cave1Investigate();break;
            case "fork": GUI.fork();break;
            case "fightCave": fightStart(GUI.user, GUI.caveMan); break;
            case "fightContinue": fightContinue(GUI.user, enemyContinue); break;
            case "caveDeeperCall1": GUI.cave1DeeperCall();break;
            case "caveDeeperCall2": GUI.cave1DeeperCall2();break;
            case "forest": GUI.forest();break;
            case "rest": GUI.forkRest();break;
            case "castlePath": GUI.castlePath();break;
            case "castlePath2": GUI.castlePath2();break;
            case "caveDeeperRush": GUI.caveDeeperRush1();break;
            case "castleAttack": GUI.castleAttack();break;
            case "castleAttack2": GUI.castleAttack2();break;
            case "castleCall": GUI.castleCall();break;
            case "castleRPS": GUI.castleRPS();break;
            case "castleRPSLose": GUI.castleRPSLose();break;
            case "castleRPSWin": GUI.castleRPSWin();break;
            case "castle": GUI.castle();break;
            case "castle2": GUI.castle2();break;
            case "rock": RockPaperScissors.rpsRock();break;
            case "paper": RockPaperScissors.rpsPaper();break;
            case "scissors": RockPaperScissors.rpsScissors();break;
            case "kingFight": GUI.kingFight1();break;
            case "high": castleFight.High();break;
            case "middle": castleFight.Middle();break;
            case "low": castleFight.Low();break;
            case "kingFightFire": GUI.kingFightFireball();break;
            case "leftFire": kingFireBall.left();break;
            case "rightFire": kingFireBall.right();break;
            case "kingCharge": GUI.kingFightCharge();break;
            case "leftSlash": kingSlash.left();break;
            case "rightSlash": kingSlash.right();break;
            case "kingDead1": GUI.kingDead1();break;
            case "kingDead2": GUI.kingDead2();break;
            case "kingDead3": GUI.kingDead3();break;
            case "endGame": GUI.endGame();break;

        }
    }


    public static void checkDead(int damage){
        if (GUI.user.getHp() - damage <0){

            GUI.frame.getContentPane().removeAll();
            GUI.frame.getContentPane().revalidate();
            GUI.frame.getContentPane().repaint();


            MyPanel gameOverPanel = new MyPanel(200,150, 630, 250);
            MyTextArea gameOverText = new MyTextArea("""
                    'YOU HAVE FAILED ME'
                    
                             You have died..
                    
                              GAME OVER
                    """, 100,100,600,250);

            gameOverPanel.add(gameOverText);
            GUI.frame.getContentPane().add(gameOverPanel);
        }

    }




    public static void setHP(Player user, int hpDecrease){
        user.setHp(user.getHp() - hpDecrease);
        GUI.hpNumberLabel.setText("" + user.getHp());
    }

    //Player A takes Damage based off of Player B's weapon
    public static void takeDamage(Player A, Player B){
        A.setHp(A.getHp() - B.getWeapon().getDamage());
        return;

    }

    public static void fightStart(Player user, Player enemy){
        afterFight = GUI.afterFight;
        enemyContinue = enemy;

       GUI.mainTextArea.setText("You have encountered " + enemy.getName() + " who has " + enemy.getHp() + " HP!");

       GUI.choice1.setText("Attack");
       GUI.choice2.setText("");
       GUI.choice3.setText("");
       GUI.nextPosition1 = "fightContinue";
       GUI.nextPosition2 = "";
       GUI.nextPosition3 = "";

    }

    public static void fightContinue(Player user, Player enemy){
        if (user.getHp() - enemy.getWeapon().getDamage()<=0){
            GUI.mainTextArea.setText(enemy.getName()+ " has defeated " + user.getName()+ "!" + "/n");
            GUI.mainTextArea.append("""
                
                'YOU HAVE FAILED ME'
                You have died..
                GAME OVER"
                """);

            GUI.choice1.setText("");
            GUI.nextPosition1 = "";
            return;

        }if (enemy.getHp() - user.getWeapon().getDamage()<=0){
            GUI.mainTextArea.setText(user.getName() + " has defeated " + enemy.getName() + "!");

            GUI.choice1.setText("Continue");
            GUI.nextPosition1 = afterFight;
        }else {
            user.setHp(user.getHp() - enemy.getWeapon().getDamage());
            enemy.setHp(enemy.getHp() - user.getWeapon().getDamage());
            GUI.hpNumberLabel.setText(""+user.getHp());
            GUI.mainTextArea.setText(user.getName() + " has taken " + enemy.getWeapon().getDamage() + " damage!" +
                    "\n" + enemy.getName() + " has taken " + user.getWeapon().getDamage() + " damage!" +
                    "\n" + enemy.getName() + " has " + enemy.getHp() + " HP left.");
        }
    }

    // generates a game of rock paper scissors against an npc
    //return -1 if lost, 1 if won, restarts if tie.
    public static int rockPaperScissors(Player A) {
        System.out.println("Choose:");
        System.out.println("1: Rock");
        System.out.println("2: Paper");
        System.out.println("3: Scissors");
        Random random = new Random();
        int npc = random.nextInt(3) + 1; // generates random number between 1-3 to signify npc's choice.
        //
        Scanner input = new Scanner(System.in);
        String choice;
        do {
            choice = input.next();
            if (choice.equals("1")) {
                System.out.println("You have chosen Rock");
                if (npc == 2){
                    System.out.println("Your opponent has chosen Paper and you have lost..");
                    return -1;
                } if (npc == 3){
                    System.out.println("Your opponent has chosen Scissors and you have won!");
                    return 1;
                } if (npc == 1) {
                    System.out.println("Your opponent has chosen Rock and you have tied..");
                    System.out.println();
                   return rockPaperScissors(A);
                }
            }
            if (choice.equals("2")) {
                System.out.println("You have chosen Paper");
                if (npc == 2){
                    System.out.println("Your opponent has chosen Paper and you have tied..");
                    System.out.println();
                   return rockPaperScissors(A);
                } if (npc == 3){
                    System.out.println("Your opponent has chosen Scissors and you have lost..");
                    return -1;
                } if (npc == 1){
                    System.out.println("Your opponent has chosen Rock and you have Won!");
                    return 1;
                }
            }
            if (choice.equals("3")) {
                System.out.println("You have chosen Scissors");
                if (npc == 2){
                    System.out.println("Your opponent has chosen Paper and you have Won!");
                    return 1;
                } if (npc == 3 ){
                    System.out.println("Your opponent has chosen Scissors and you have tied..");
                    System.out.println();
                   return rockPaperScissors(A);
                } if (npc == 1) {
                    System.out.println("Your opponent has chosen Rock and you have lost..");
                    return -1;
                }
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
        return 0;
    }
    // generates a fight against an npc
    //return -1 if lost, 1 if won, restarts if tie.
    public static int grandFight(Player A){
        System.out.println("What would you like to do?");
        System.out.println("1: High Attack");
        System.out.println("2: Middle Attack");
        System.out.println("3: Low Attack");
        Random random = new Random();
        int npc = random.nextInt(3) + 1; // generates random number between 1-3 to signify npc's choice.
        //
        Scanner input = new Scanner(System.in);
        String choice;
        do {
            choice = input.next();
            if (choice.equals("1")) {
                System.out.println("You attack from above!");
                if (npc == 2){
                    System.out.println("You get the wind knocked out of you as you suffer a blow to your middle body..");
                    return -1;
                } if (npc == 3){
                    System.out.println("You penetrate their defence and land the blow!");
                    return 1;
                } if (npc == 1) {
                    System.out.println("You both clash and neither manage to land a blow..");
                    System.out.println();
                    return grandFight(A);
                }
            }
            if (choice.equals("2")) {
                System.out.println("You attack their middle body!");
                if (npc == 2){
                    System.out.println("You both clash and neither manage to land a blow..");
                    System.out.println();
                    return grandFight(A);
                } if (npc == 3){
                    System.out.println("You feel a blow land near your legs as you crash to the ground..");
                    return -1;
                } if (npc == 1){
                    System.out.println("You penetrate their defence and land the blow!");
                    return 1;
                }
            }
            if (choice.equals("3")) {
                System.out.println("You aim for the legs and attack!");
                if (npc == 2){
                    System.out.println("You penetrate their defence and land the blow!");
                    return 1;
                } if (npc == 3 ){
                    System.out.println("You both clash and neither manage to land a blow..");
                    System.out.println();
                    return grandFight(A);
                } if (npc == 1) {
                    System.out.println("Before landing your attack you feel sharp pain in your upper body as you suffer an attack");
                    return -1;
                }
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
        return 0;
    }

    //generates a fireball dodging sequence
    public static void fireBall (Player A){
        System.out.println("In what direction do you dodge?");
        System.out.println("1: Left");
        System.out.println("2: Right");
        Random random = new Random();
        int npc = random.nextInt(2) + 1; // generates random number between 1-2 to signify npc's choice.
        Scanner input = new Scanner(System.in);
        String choice;
        choice = input.next();
            if (choice.equals("1")) {
                System.out.println("You dodge left!");
                if (npc == 1) {
                    System.out.println("The Kings shoots a fireball as you dodge and lands a direct hit");
                    A.setHp(A.getHp() - 2);
                    System.out.println("You take 2 damage and have " + A.getHp() + " left.");
                }
                if (npc == 2) {
                    System.out.println("You feel the heat of the fireball as it passes right by you");
                }
            }
            if (choice.equals("2")) {
                System.out.println("You dodge right!");
                if (npc == 1) {
                    System.out.println("You feel the heat of the fireball as it passes right by you");
                }
                if (npc == 2) {
                    System.out.println("The Kings shoots a fireball as you dodge and lands a direct hit");
                    A.setHp(A.getHp() - 2);
                    System.out.println("You take 2 damage and have " + A.getHp() + " left.");
                }
            }
    }
    //A flurry attack is unleashed on player A by player B
    public static void flurryAttack (Player A, Player B){
        System.out.println("In what direction do you slash?");
        System.out.println("1: Left");
        System.out.println("2: Right");
        Random random = new Random();
        int npc = random.nextInt(2) + 1; // generates random number between 1-2 to signify npc's choice.
        Scanner input = new Scanner(System.in);
        String choice;
        choice = input.next();
        if (choice.equals("1")) {
            System.out.println("You Slash left!");
            if (npc == 1) {
                System.out.println("Blood is sprayed as your attack lands!");
                A.setHp(A.getHp() - B.getWeapon().getDamage());
            }
            if (npc == 2) {
                System.out.println("Your attack misses at the last second..");
            }
        }
        if (choice.equals("2")) {
            System.out.println("You Slash right!");
            if (npc == 1) {
                System.out.println("Your attack misses at the last second..");            }
            if (npc == 2) {
                System.out.println("Blood is sprayed as your attack lands!");
                A.setHp(A.getHp() - B.getWeapon().getDamage());
            }
        }
    }
}
