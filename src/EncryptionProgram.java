/**
 * Original code following the video
 * **/
import java.util.*;


public class EncryptionProgram {

    private Scanner scanner;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private char[] letters;


    EncryptionProgram() {
        scanner = new Scanner(System.in);
        list = new ArrayList();
        shuffledList = new ArrayList();
        character = ' ';

        newKey();   //Generating a new encryption key before asking anything to the user
        askQuestion();  //Initiating the user interaction or the "Menu"

    }

    private void askQuestion() { //Displays the menu
        while(true) {
            System.out.println("\n*************************************************");
            System.out.println("What do you want to do?");
            System.out.println("(N)ew Key, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
            //use of scanner to read input, with charAt(0) only scan the first letter ignoring the remaining letters
            //then convert the String scanned to Character and to Upper case
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (response) {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Not a valid answer :(");
            }

        }

    }

    //generate the new key, first cleaning or resetting all variables involved
    //then using a for starting in 32 to 127 (ASCII values we need) assign the character value to the list and add 1 to the character
    private void newKey() {

        character = ' ';
        shuffledList.clear();
        list.clear();

        for (int i = 32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }
        shuffledList = new ArrayList(list);
        Collections.shuffle(shuffledList);
        System.out.println("A new key has been created :)");
    }

    private void getKey() {
        System.out.println("Key: ");
        for(Character c : list) System.out.print(c);
        for(Character c : shuffledList) System.out.print(c);
        System.out.println();
    }
    private void encrypt() {
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();
        //scanner.nextLine();
        letters = message.toCharArray();


        for (int i = 0; i < letters.length; i++) {

            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == list.get(j)) {
                    letters[i]=shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted: ");
        for(char x : letters) System.out.print(x);

    }

    private void decrypt() {

        for (int i = 0; i < letters.length; i++) {

            for (int j = 0; j < shuffledList.size(); j++) {
                if (letters[i] == shuffledList.get(j)) {
                    letters[i]=list.get(j);
                    break;
                }
            }
        }
        System.out.println("Message decrypted: ");
        for(char x : letters) System.out.print(x);
        
    }

    private void quit() {
        System.out.println("Thanks for using this program, Bye!");
        System.exit(0);

    }


}//END
