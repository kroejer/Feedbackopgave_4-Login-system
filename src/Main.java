import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

void main() {
    Scanner input = new Scanner(System.in);

    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    String[] usernames = {"Oliver", "Jonas", "Valdemar", "Kasper"};
    String[] passwords = {"pass1", "pass2", "pass3", "pass4"};
    String username = "";
    int usernameIndex;

    username = inputUsername(input);
    usernameIndex = validateUsername(usernames, username);

    loginAttempt(input, timeFormat, usernameIndex, username, passwords);

}

static String inputUsername(Scanner input) {
    System.out.print("Indtast brugernavn: ");
    String username = input.nextLine();
    return username;
}

static int validateUsername(String[] usernames, String username) {
    for (int i = 0; i < usernames.length; i++) {
        if (username.equalsIgnoreCase(usernames[i])) {
            return i;
        }
    }
    return -1;
}

static String inputPassword(Scanner input) {
    System.out.print("Indtast adgangskode: ");
    String password = input.nextLine();
    return password;
}

static boolean validatePassword(String[] passwords, String password, int usernameIndex) {
    if(usernameIndex == -1){
        return false;
    }else{
        for (int i = 0; i < passwords.length; i++) {
            if (passwords[usernameIndex].equals(password)) {
                return true;
            }
        }
    }
    return false;
}

static void loginAttempt(Scanner input, DateTimeFormatter timeFormat, int usernameIndex, String username, String[] passwords) {
    int loginAttempts = 3;
    String password = "";
    while (loginAttempts > 0) {

        password = inputPassword(input);
        if (validatePassword(passwords, password, usernameIndex)) {
            System.out.println("Velkommen " + username + "! Login kl. " + LocalTime.now().format(timeFormat));
            break;
        } else {
            System.out.println("Forkert brugernavn eller adgangskode!");
            loginAttempts--;
            if (loginAttempts != 0) {
                System.out.println("Du har " + loginAttempts + " forsøg tilbage");
            }
        }
    }
    if (loginAttempts == 0) {
        System.out.println("Du har brugt alle forsøg. Lukker ned");
    }

}