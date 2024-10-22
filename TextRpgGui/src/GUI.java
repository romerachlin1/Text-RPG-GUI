import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    static screenHandler actionHandler;
    static choiceHandler riddleHandler;
    static MyFrame frame;
    static MyPanel upPanel, downPanel, playerPanel, riddlePanel;
    static MyButton startButton, choice1, choice2, choice3, submit, riddleButton;
    static MyTextField name, riddleText;
    static Player user;
    static JLabel nameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponDamageLabel, riddleExample;
    static MyTextArea mainTextArea;
    static String location;
    static efficientHandler eHandler;
    static String nextPosition1, nextPosition2, nextPosition3, afterFight;
    static Font smallFont = new Font("Times New Roman", Font.PLAIN,23);
    static Font normalFont = new Font("Times New Roman", Font.PLAIN,30);
    static Player caveMan = new Player("Cave Man");
    static Player king = new Player("The King");
    static int count = 0;
    static Font titleFont = new Font("Times New Roman", Font.BOLD, 90);



    public static void titleFrame(){


        frame = new MyFrame("Chosen");
        upPanel = new MyPanel(70,100, 630, 250);
        MyLabel titleLabel = new MyLabel("Chosen");
        titleLabel.setFont(titleFont);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        upPanel.add(titleLabel);
        downPanel = new MyPanel(260,400, 250,100);
        startButton = new MyButton("START");
        actionHandler = new screenHandler();
        startButton.addActionListener(actionHandler);
        downPanel.add(startButton);

        frame.getContentPane().add(upPanel);
        frame.getContentPane().add(downPanel);
    }

    public static void NameScreen(){

        downPanel.removeAll();
        downPanel.updateUI();
        upPanel.removeAll();
        upPanel.updateUI();

        MyTextArea mainTextArea = new MyTextArea("""
                'CHOSEN ONE! IT IS TIME!'\
                \s
                
                You awaken with a start to see you are alone in a
                forest you do not recognise. \


                'YOU SHALL START ANEW, CHOOSE YOUR NAME.'""", 100,100,630,250);
        upPanel.add(mainTextArea);

        downPanel.setLayout(new GridLayout(2,1));
        submit = new MyButton("Submit");
        submit.addActionListener(actionHandler);

        name = new MyTextField();
        downPanel.add(name);
        downPanel.add(submit);
    }

    public static void GameScreen(){
        location = "gameScreen";
//reset panels
    downPanel.removeAll();
    downPanel.updateUI();
    upPanel.removeAll();
    upPanel.updateUI();

//create a top player panel
    playerPanel = new MyPanel(70,15,600,50);
    playerPanel.setLayout(new GridLayout(1,5));
    nameLabel = new MyLabel(user.getName());
    hpLabel = new MyLabel("HP: ");
    hpNumberLabel = new MyLabel("" + user.getHp());
    weaponLabel = new MyLabel(user.getWeapon().getType());
    weaponDamageLabel = new MyLabel("Damage: " + user.getWeapon().getDamage());
    playerPanel.add(nameLabel);
    playerPanel.add(hpLabel);
    playerPanel.add(hpNumberLabel);
    playerPanel.add(weaponLabel);
    playerPanel.add(weaponDamageLabel);
    frame.getContentPane().add(playerPanel);

//text area
    mainTextArea = new MyTextArea(
            "'" + user.getName() + ". YES.. A FINE NAME.. STRONG..'\n" +
            "\nARISE AND BEGIN YOUR ADVENTURE!"
            , 100,100,600,250);
    upPanel.add(mainTextArea);

//choice options area
    downPanel.setLayout(new GridLayout(3,1));
    choice1 = new MyButton("Begin");
    choice1.addActionListener(actionHandler);

    downPanel.add(choice1);
    choice2 = new MyButton("");
    choice2.addActionListener(actionHandler);
    downPanel.add(choice2);
    choice3 = new MyButton("");
    choice3.addActionListener(actionHandler);
    downPanel.add(choice3);

    }

    public static void Beginning(){
        eHandler = new efficientHandler();

        location = "beginning";

        mainTextArea.setText("""
                You look around and notice you have slept near a fork in a road.\
                           \s
                To your right you notice the forest thickens and
                becomes jagged.
                To your left the path leads to a dark cave.
                 
                Where does your destiny lead you?
                """);

        choice1.setText("Forest");
        choice1.addActionListener(eHandler);
        choice1.setActionCommand("c1");
        choice2.setText("Cave");
        choice2.addActionListener(eHandler);
        choice2.setActionCommand("c2");
        choice3.addActionListener(eHandler);
        choice3.setActionCommand("c3");

        nextPosition1 = "forest";
        nextPosition2 = "cave";
        nextPosition3 = "test";

    }

    public static void cave1(){
        location = "cave1";
        mainTextArea.setText("""
                You enter the cave and can only slightly see the
                inside due to the light entering from the entrance.
                
                You notice a recently put out fire with a pot near.
                
                What would you like to do?
                """);
        choice1.setText("Continue Deeper");
        choice2.setText("Investigate");
        choice3.setText("Leave");

        nextPosition1 = "caveDeeper";
        nextPosition2 = "caveInvestigate";
        nextPosition3 = "fork";
    }

    public static void cave1Investigate(){
        location = "cave1Investigate";

        mainTextArea.setText("""
                You look near the pot and while looking find a
                knife.
                
                What would you like to do?
                """);
        user.setWeapon(Weapon.knife);
        weaponLabel.setText(user.getWeapon().getType());
        weaponDamageLabel.setText("Damage: " + user.getWeapon().getDamage());
        choice1.setText("Continue Deeper");
        choice2.setText("Leave");
        choice3.setText("");

        nextPosition1 = "caveDeeper";
        nextPosition2 = "fork";
        nextPosition3 = "";
    }

    public static void cave1Deeper(){
        afterFight = "caveDeeperRush";
        caveMan.setHp(10);
        mainTextArea.setText("""
                As you delve deeper into the cave it becomes pitch
                black. You stop suddenly due to a rustling you
                hear a few feet ahead.
                
                What would you like to do?
                """);

        choice1.setText("Attack!");
        choice2.setText("Call out");
        choice3.setText("");

        nextPosition1 = "fightCave";
        nextPosition2 = "caveDeeperCall1";
        nextPosition3 = "";
    }



    public static void caveDeeperRush1(){
        mainTextArea.setText("""
                You land a fatal blow..
                You stand over the bloodied corpse of
                the man and from the corner of your eye
                spot something shining.
                You come closer and notice a sword.
                You put the sword away and leave the cave.
                """);

        user.setWeapon(Weapon.sword);
        weaponLabel.setText(user.getWeapon().getType());
        weaponDamageLabel.setText("Damage: " + user.getWeapon().getDamage());
        choice1.setText("Leave");
        choice2.setText("");
        nextPosition1 = "fork";
    }

    public static void cave1DeeperCall(){
        location = "cave1DeeperCall";
        mainTextArea.setText("""
                You call out into the darkness: 'Who's there?'
                A raspy voice answers back: 'Tiss I the Cave
                Dweller.. Who goes there?'
                You answer back: 'I am the Chosen One.'
                He answers back: 'Finally the day has come..
                Please accept this gift..'
                """);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");

        nextPosition1 = "caveDeeperCall2";
        nextPosition2 = "";
        nextPosition3 = "";

    }

    public static void cave1DeeperCall2(){
        location = "cave1DeeperCall2";
        mainTextArea.setText("""
                He hands you a sword you can see shine even in
                this dark cave.
                
                You put the sword away, thank the man and
                leave the cave.
                """);
        user.setWeapon(Weapon.sword);
        weaponLabel.setText(user.getWeapon().getType());
        weaponDamageLabel.setText("Damage: " + user.getWeapon().getDamage());

        nextPosition1 = "fork";

    }
    public static void fork(){
        location = "fork";
        mainTextArea.setText("""
                You have returned to the fork you started at.
                
                What would you like to do?
                """);

        choice1.setText("Head to Forest");
        choice2.setText("Rest");
        choice3.setText("");

        nextPosition1 = "forest";
        nextPosition2 = "rest";
    }

    public static void forkRest(){
        location = "forkRest";
        mainTextArea.setText("""
                You decide to rest for the night..
                
                After sleeping the night you awaken rested.
                
                Deeper into the forest you head..
                """);
        user.setHp(35);
        hpNumberLabel.setText(""+user.getHp());
        choice1.setText(">");
        choice2.setText("");

        nextPosition1 = "forest";
        nextPosition2 = "";
    }


    public static void forest(){
        location = "forest";
        mainTextArea.setText("""
        As you delve deeper into the forest the trees grow larger,
        sunlight becomes scarce and the plants thornier..
        You hesitate on your way and look back,
        but it is too late..
        The trees themselves closed the path back!"
        The only way to go is further in..
        """);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");

        nextPosition1 = "forest2";
        nextPosition2 = "";
    }

    public static void forest2(){
        mainTextArea.setText("""
                You continue walking through the forest until
                you come upon a spot with a stone slab and a
                sword shaped hole in the middle.
                
                As you see it the trees begin
                closing in around you!
                
                You realise if you don't act quick you'll be crushed.
                What do you do?
                """);

        mainTextArea.setFont(smallFont);
        if (user.getWeapon() != Weapon.sword){
            choice1.setText("Slash at trees");
            nextPosition1 = "forestDead";
        }else {
            choice1.setText("Slash at trees");
            choice2.setText("Insert Sword");
            nextPosition1 = "forestDead";
            nextPosition2 = "forest3";
        }
    }

    public static void forestDead(){
        mainTextArea.setFont(normalFont);
        mainTextArea.setText("""
                Nothing seems to stop the trees..
                If only you had inserted the sword..
                The trees close in and you are slowly
                crushed as you struggle to survive..
                
                GAME OVER
                """);

        choice1.setText("");
        choice2.setText("");
        nextPosition1 = "";
        nextPosition2 = "";
    }

    public static void forest3(){
        mainTextArea.setFont(normalFont);
        mainTextArea.setText("""
                As you insert the sword the trees suddenly stop.
                The trees to the North clear away
                leaving 5 trees standing.
                You approach the trees and notice each tree has
                some writing on it.
                
                You touch one and it begins to glow..
                """);

        choice1.setText(">");
        choice2.setText("");
        nextPosition1 = "forestRiddle";
        nextPosition2 = "";
    }

    public static void forestRiddle(){
        riddleHandler = new choiceHandler();
        mainTextArea.setFont(smallFont);
        mainTextArea.setText("""
                The writing on the trees is:
                Sun: With me the day starts and all shall come after.
                Moon: I am the end of day and after me night follows.
                Star: The Moon is my king and i shall follow till
                the end of time.
                Flame: I blaze after the Sun, for he is my king.
                Flower: I thrive off the sun and yield before the flame.
                As night comes i rest.
                In what order do you touch the trees?
                """);

        downPanel.setVisible(false);
        riddlePanel = new MyPanel(160,400, 450,70);
        riddlePanel.setLayout(new GridLayout(3,1));
        riddleButton = new MyButton("Submit");
        riddleButton.addActionListener(riddleHandler);

        riddleText = new MyTextField();
        riddleText.setFont(smallFont);
        riddleExample = new JLabel();
        riddleExample.setText("For Example: Flower Moon Sun Flame Star");
        riddleExample.setFont(smallFont);
        riddlePanel.add(riddleExample);
        riddlePanel.add(riddleText);
        riddlePanel.add(riddleButton);
        frame.getContentPane().add(riddlePanel);
    }

    public static void forestRiddleFail(){
        mainTextArea.setFont(normalFont);
        mainTextArea.setText("""
                The trees light up but quickly the light vanishes..
                """);
        riddlePanel.setVisible(false);
        downPanel.setVisible(true);

        choice1.setText(">");
        nextPosition1 = "forestRiddle";
    }

    public static void forestRiddlePass(){
        mainTextArea.setFont(normalFont);
        mainTextArea.setText("""
                            The trees light up and slowly all the trees to the
                            North part for you revealing a path..
                            
                            You head out of the forest and continue your
                            journey..
                            """);

        riddlePanel.setVisible(false);
        downPanel.setVisible(true);

        choice1.setText(">");
        choice2.setText("");
        nextPosition1 = "castlePath";
        nextPosition2 = "";
    }

    public static void castlePath(){
        mainTextArea.setText("""
                As you continue walking down the path you see a
                castle in the distance.
                You suddenly hear:
                'THAT IS YOUR DESTINATION AND FINAL TRIAL'
                
                You are drawn to the castle as if by a thread..
                """);
        nextPosition1 = "castlePath2";
    }

    public static void castlePath2() {

        mainTextArea.setText("""
                As you approach the castle gate you see
                a single guard.
                
                The guard notices and calls out: Who goes there?
                """);

        choice1.setText("Ignore and Attack");
        choice2.setText("Call Out");

        nextPosition1 = "castleAttack";
        nextPosition2 = "castleCall";
    }

    public static void castleAttack(){
        mainTextArea.setText("""
                You rush forward slashing at the guard!
                The guard moves at incredible speed stopping
                your slash and throwing you to the ground.
                
                You lose 3 HP!
                """);

        gameFunctions.setHP(user,3);

        choice1.setText(">");
        choice2.setText("");

        nextPosition1 = "castleAttack2";
        nextPosition2 = "";
    }

    public static void castleAttack2() {
        mainTextArea.setText("""
                While on the ground you hear the guard say:
                'I wouldn't try that again boy!'
                
                Ill let you in if you can defeat me in the ancient
                game of Rock, Paper, Scissors..
                """);
        choice1.setText("Battle");
        nextPosition1 = "castleRPS";
    }

        public static void castleCall(){
        mainTextArea.setText("""
                You call out: 'Tiss I, the Chosen One!'
                The guard replies: 'Chosen one Shmosen one..'
                
                You're not going anywhere before you defeat me
                in the ancient game of Rock Paper Scissors!
                """);

        choice1.setText("Battle");
        choice2.setText("");
        nextPosition1 = "castleRPS";
        nextPosition2 = "";

        }

    public static void castleRPS(){
        mainTextArea.setText("""
            You prepare for the legendary showdown.
            
            What do you choose?
            """);

        choice1.setText("Rock");
        choice2.setText("Paper");
        choice3.setText("Scissors");

        nextPosition1 = "rock";
        nextPosition2 = "paper";
        nextPosition3 = "scissors";
    }

    public static void castleRPSLose(){
        mainTextArea.setText("""
                The guard says:
                'Ha! I knew you couldn't defeat me!'
                He swipes his sword at you.
                You take 1 damage.
                
                'But i'm bored so i'll let you try again.'
                """);
        gameFunctions.setHP(user,1);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");

        nextPosition1 = "castleRPS";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public static void castleRPSWin(){
        mainTextArea.setText("""
                The guard says: 'You have defeated me
                fair and square.'
                'I acknowledge you as the chosen one.'
                'Good luck on your journey..'
                He moves aside and you enter the castle..
                """);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");

        nextPosition1 = "castle";
        nextPosition2 = "";
        nextPosition3 = "";

    }

    public static void castle(){
    mainTextArea.setText("""
            The door of the castle creaks open as you enter.
            You enter a large room with a long rug and
            stone pillars on the sides.
            At the edge of the rug you see a
            grand throne and a man sitting on it.
            """);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");

        nextPosition1 = "castle2";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public static void castle2(){
        king.setWeapon(Weapon.sword);


        mainTextArea.setText("""
                The man says:
                'I always knew this day would come..'
                In your head you hear:
                'THAT MAN IS YOUR DESTINY!'
                'DEFEAT HIM AND SAVE THIS WORLD!'
                The man unsheathes a sword as black as night and charges forward.
                """);
        choice1.setText("Charge");
        choice2.setText("");
        choice3.setText("");

        nextPosition1 = "kingFight";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public static void kingFight1(){
        gameFunctions.checkDead(king.getWeapon().getDamage());
        if (king.getHp() - user.getWeapon().getDamage()>=15) {
            mainTextArea.setText("""
                                    
                    How do you attack?
                    """);

            choice1.setText("High Attack");
            choice2.setText("Middle Attack");
            choice3.setText("Low Attack");

            nextPosition1 = "high";
            nextPosition2 = "middle";
            nextPosition3 = "low";
        }else {
            mainTextArea.setText("""
                    The king looks at you with rage in his eyes and
                    yells: 'I will not be defeated by you!'
                    
                    He raises his hand and you notice a flaming
                    orb emerge from his hands."
                    """);

            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");

            nextPosition1 = "kingFightFire";
            nextPosition2 = "";
            nextPosition3 = "";

        }
    }

    public static void kingFightFireball(){
        gameFunctions.checkDead(2);
        if (count <= 4) {
            mainTextArea.setText("""
                    In what direction do you dodge?
                                
                    """);

            choice1.setText("Left");
            choice2.setText("Right");
            choice3.setText("");

            nextPosition1 = "leftFire";
            nextPosition2 = "rightFire";
            nextPosition3 = "";

            count++;

        } else {
            count = 0;
            mainTextArea.setText("""
                    After surviving the kings attacks you
                    notice fear in the kings eyes..
                    You feel a strength in you pushing you forward
                     and you rush towards the king
                     for your counter attack!
                    """);

            choice1.setText("Charge!");
            choice2.setText("");
            choice3.setText("");

            nextPosition1 = "kingCharge";
            nextPosition2 = "";
            nextPosition3 = "";

        }

    }

    public static void kingFightCharge(){
        gameFunctions.checkDead(2);
        if (king.getHp() - user.getWeapon().getDamage()>=0){
            mainTextArea.setText("""
                    In what direction do you slash?
                                
                    """);

            choice1.setText("Left");
            choice2.setText("Right");
            choice3.setText("");

            nextPosition1 = "leftSlash";
            nextPosition2 = "rightSlash";
            nextPosition3 = "";

        } else {
            mainTextArea.setText("""
                    You deliver a final blow to the king and
                    he crashes to the ground..
                    His crown clanks next to his bloodied corpse
                    and you hear:
                    'TAKE IT!'
                    'IT IS YOURS NOW!'
                    """);

            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");

            nextPosition1 = "kingDead1";
            nextPosition2 = "";
            nextPosition3 = "";
        }
    }

    public static void kingDead1(){
        mainTextArea.setText("""
                You slowly lift the crown and place
                it on your head.
                
                You step over the Kings warm corpse
                and sit down on the throne.
                
                """);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");

        nextPosition1 = "kingDead2";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public static void kingDead2(){
        mainTextArea.setText("""
                As you sit the doors creak open..
                A man walks in and yells:
                
                'I am the chosen one and I am here to defeat you!'
                """);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");

        nextPosition1 = "kingDead3";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public static void kingDead3(){
        mainTextArea.setText("""
                In your head you hear:
                
                'AND SO THE CYCLE CONTINUES'
                
                So you stand and raise your sword
                to your new enemy..
                """);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");

        nextPosition1 = "endGame";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public static void endGame(){
        mainTextArea.setFont(titleFont);
        mainTextArea.setText(" GAME OVER");

        playerPanel.setVisible(false);
        downPanel.setVisible(false);
    }








//handlers
    public static class efficientHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();

            switch (yourChoice) {
                case "c1":
                    gameFunctions.selectPosition(nextPosition1);
                    break;
                case "c2":
                    gameFunctions.selectPosition(nextPosition2);
                    break;
                case "c3":
                    gameFunctions.selectPosition(nextPosition3);
                    break;
            }
        }


    }

 public static class screenHandler implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent event) {

         if (event.getSource() == startButton) {
             NameScreen();
         }
         if (event.getSource() == submit) {
             user = new Player(name.getText());
             GameScreen();
         }
         if (event.getSource() == choice1 && location.equals("gameScreen")) {
             Beginning();
         }

     }
 }
    public static class choiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == riddleButton){
                if (riddleText.getText().equals("Sun Flame Flower Moon Star")){
                    forestRiddlePass();
                } else {
                    forestRiddleFail();
                }
            }
        }
    }


    }
