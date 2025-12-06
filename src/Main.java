import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter three first digits of bank account: ");
        int userInput = scan.nextInt();

        URI u = new URI("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
        URL url = u.toURL();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String str;
            boolean found = false;

            while ((str = rd.readLine()) != null) {
                int bankNum = Integer.parseInt(str.substring(0, 6).trim());
                if (bankNum == userInput) {
                    String bankName = str.substring(6, 144).trim();
                    System.out.println("Bank name: " + bankName);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Bank not found");
            }
        }
    }
}