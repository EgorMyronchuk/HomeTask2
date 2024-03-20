import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] aim =
        {
                        { '0'  ,'1'  ,'2'  ,'3'  ,'4'  ,'5' },
                        { '1'  ,'-'  ,'-'  ,'-'  ,'-'  ,'-' },
                        { '2'  ,'-'  ,'-'  ,'-'  ,'-'  ,'-' },
                        { '3'  ,'-'  ,'-'  ,'-'  ,'-'  ,'-' },
                        { '4'  ,'-'  ,'-'  ,'-'  ,'-'  ,'-' },
                        { '5'  ,'-'  ,'-'  ,'-'  ,'-'  ,'-' }
        };
        Scanner scan = new Scanner(System.in);
        System.out.println("All Set. Get ready to rumble!");
        int trigerX = Random ();
        int trigerY = Random ();
        while (true){
            System.out.println("Please enter a row ");
            int x = Check(scan);
            System.out.println("Please enter a column ");
            int y = Check(scan);

            if (aim [x][y] == '*')  System.out.println("You shoted at this place");
            else aim [x][y] = '*';

            if (x == trigerX && y == trigerY){
                aim [x][y] = 'x';
                System.out.println("\n You have won! \n");
                OutputConsole(aim);
                break;
            }
            OutputConsole(aim);


        }
    }
    public static int Check (Scanner scan ) {
        String temp = scan.nextLine();
        if (isParsable(temp)) {
            if (Integer.parseInt(temp) > 0 && Integer.parseInt(temp) < 6){
                return Integer.parseInt(temp);
            }
            else {
                System.out.println("Your number under 1 or over 5");
                return Check(scan);
            }
        }
        else {
            System.out.println("Please enter number!");
            return Check(scan);
        }
    }

    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
    public static int Random (){
        Random rnd = new Random();
        return rnd.nextInt(5) + 1;
    }
    public static void OutputConsole (char[][] chr){
        for (int i = 0; i < chr.length; i++) {
            for (int j = 0; j < chr[i].length; j++) {
                System.out.print(chr[i][j] + "|");
            }
            System.out.println();
        }
    }
}