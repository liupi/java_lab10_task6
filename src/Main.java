import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{
       Scanner scan =  new Scanner(System.in);
       System.out.println("Please enter three first digits of bank account: ");
       int userInput  = scan.nextInt();

       URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
       BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));

        String str;
        while ((str = rd.readLine()) != null) {
            int bankNum = Integer.parseInt(str.substring(0, 6).trim());
            if (bankNum == userInput){
                String bankName = str.substring(6, 144).trim();
                System.out.println("Bank name: " + bankName);
                break;
            }
        }
        rd.close();
    }
}