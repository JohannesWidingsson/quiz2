package quiz;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends Person implements Serializable {


    int score = 0;
    int playedGames = 0;

    Scanner scanPlayer = new Scanner(System.in);

    Quiz quiz = new Quiz();

    LinkedList<Player> playerList = new LinkedList<Player>();

    public Player(String name, int age, String eMail, int score, int playedGames) {
        super(name, age, eMail);
        this.score = score;
        this.playedGames = playedGames;

    }

    public Player() {
    }

    public Player(String name, int age, String eMail) {
        super(name, age, eMail);
    }




    public void player1() {


        System.out.println("* * * * * * * * * *");
        System.out.println("* Skapa spelare 1 *");
        System.out.println("* * * * * * * * * *");

        System.out.println("Namn: ");
        String name = scanPlayer.nextLine(); // lagras namnet
       // playerList.addFirst(name); //Trong hamnar på element 0
        System.out.println("Ålder: ");
        int age = scanPlayer.nextInt(); // lagras åldern
        //playerList.add(age);
        scanPlayer.nextLine();

        while (true) {
            System.out.println("E-mejl: ");
            String eMail = scanPlayer.nextLine(); //lagras email

            if (eMail.contains("@")) {
                playerList.add(new Player(name,age,eMail, score, playedGames));
                break;
            }
            System.out.println("Försök igen!");
        }

    }


    public void player2() {

        System.out.println("* * * * * * * * * *");
        System.out.println("* Skapa spelare 2 *");
        System.out.println("* * * * * * * * * *");

        System.out.println("Namn: ");
        String name2 = scanPlayer.nextLine();
        //playerList.addFirst(name2); // Johan, hamna på element 0 och Trong element 3

        System.out.println("Ålder: ");
        int age2 = scanPlayer.nextInt();
        //playerList.add(age2);
        scanPlayer.nextLine();

        while (true) {

            System.out.println("E-mejl: ");
            String eMail2 = scanPlayer.nextLine();

            if (eMail2.contains("@")) {
                playerList.add(new Player(name2, age2, eMail2, score, playedGames));
                break;
            }
            System.out.println("Försök igen!");

        }

    }

    public void switchPlayer() throws Exception{

        // Spelare 1 = element 0 i playerList

        quiz.readQuestion();
        int idCounter = 0;
        for (int i = 0; i < quiz.questionList.size(); i += 2) {

            
            idCounter++;
            System.out.println("Gör dig redo " + playerList.get(3));
            System.out.println(idCounter + ". " + quiz.questionList.get(i));
            String userInput = scanPlayer.nextLine();

            if (userInput.equalsIgnoreCase(quiz.questionList.get(i + 1))) {
                System.out.println("Du svarade rätt! :) \n");
            } else {
                System.out.println("Du svarade fel :( \n");
            }
        }

        quiz.readQuestion();
        System.out.println(quiz.questionList.get(0));
        String switchP = scanPlayer.nextLine();

        System.out.println("Gör dig redo " + playerList.get(3));
        quiz.questionList.get(1);
        // Spelare 1: Johannes
        // Fråga
        // Spelare 2: Astrid
        // Fråga
    }


    void writePlayer() throws Exception {
        System.out.println(playerList);

        FileOutputStream fos = new FileOutputStream("C:\\Users\\johannes\\Desktop\\Array\\array\\src\\quiz\\players.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(playerList);
        oos.flush();
        oos.close();

    }

    void readPlayer() throws Exception { // if (questList.length() <= )

        FileInputStream fis = new FileInputStream("C:\\Users\\johannes\\Desktop\\Array\\array\\src\\quiz\\players.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        playerList = (LinkedList<Player>) ois.readObject();
        ois.close();


    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                ", score=" + score +
                ", playedGames=" + playedGames ;
    }
}
