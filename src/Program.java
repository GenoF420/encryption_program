/*
We need to use the ASCII table for the values, from the character 32 to 126
We need to generate the keys (two lists) to encrypt the message:
    -Generate a List with the ASCII values
    -Generate another list (shuffled) with the ASCII values
The menu will have:
    -Generate new key
    -Show key
    -Encrypt message
    -Decrypt message
    -Quit

 */
//import required classes
import java.util.*;

//Define the program class
public class Program {
    //Declare instance variables
    private char character;
    private final ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char[] charMessage;
    private final Scanner scanner;

    //Constructor
    public Program() {
        //Initialize instance variables
        this.list = new ArrayList<>();
        this.shuffledList = new ArrayList<>();
        this.character = ' ';
        scanner = new Scanner(System.in);

        //Generate the key and display the menu options
        generateKey();
        menu();
    }

    //Method to display the menu options
    private void menu() {
        char answer;
        //Display the menu;
        System.out.println();
        System.out.println("********************************************");
        System.out.println("Welcome, What do you want to do? :) ");
        System.out.println("(G)enerate new Key, (S)how key, (E)ncrypt message, (D)ecrypt message, (Q)uit");
        answer = Character.toUpperCase(scanner.nextLine().charAt(0));

        //Handle menu options
        switch(answer) {
            case 'G':
                generateKey();
                break;
            case 'S':
                showKey();
                break;
            case 'E':
                encryptMessage();
                break;
            case 'D':
                decryptMessage();
                break;
            case 'Q':
                quit();
            default:
                System.out.println("Please enter a valid option :(");
                menu();
        }
    }

    //Method to generate a new encryption key
    private void generateKey() {

        //Clear existing lists and reset the character to space
        character = ' ';
        list.clear();
        shuffledList.clear();

        generateList();

        //Copy the list and shuffled it to create the key
        shuffledList = new ArrayList(list);
        Collections.shuffle(shuffledList);
        System.out.println("Key Correctly Generated :p");
        menu();

    }

    //Method to display the generated key
    private void showKey() {
        System.out.println();
        for (Character c : list) System.out.print(c);
        System.out.println();
        for (Character c : shuffledList) System.out.print(c);
        System.out.println();
        menu();
    }

    //Method to encrypt a message
    private void encryptMessage() {
        //Get the message from the user
        System.out.println("Enter a message to encrypt :o");
        String message = scanner.nextLine();
        charMessage = message.toCharArray();

        //Encrypt the message
        //Loop through each character in the message
       for (int i = 0; i < charMessage.length; i++) {
           //Loop through each character in the original ASCII list
           for (int j = 0; j < list.size(); j++) {
               //Check if the current character in the message matches the character in the original list
               if (charMessage[i] == list.get(j)) {
                   //If it matches, replace it with the corresponding character in the shuffled list
                   charMessage[i] = shuffledList.get(j);
                   //Exit the inner loop as the character has been successfully encrypted
                   break;
               }
           }
       }
       //Display the encrypted message
        System.out.println("Message encrypted!! :D");
        System.out.println(charMessage);
        menu();

    }

    //Method to decrypt the message
    private void decryptMessage() {
        //Decrypt the message similar to encrypt the message
        for (int i = 0; i < charMessage.length; i++) {
            for (int j = 0; j < shuffledList.size(); j++) {
                if (charMessage[i] == shuffledList.get(j)) {
                    charMessage[i] = list.get(j);
                    break; //si el brake no se pone, el valor de charMessage podría volver a cambiar dentro de un mismo ciclo
                }
            }

        }
        System.out.println("Message decrypted!");
        System.out.println(charMessage);
        menu();
    }

    //Method to quit the program
    private void quit() {
        System.out.println("Thanks for using this program, bye!!");
        System.exit(0);
    }

    //Method to generate the list of ASCII characters for the key
    private void generateList() {
        for (int i = 32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }
    }

}
