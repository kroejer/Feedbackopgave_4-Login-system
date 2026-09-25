import java.util.Scanner;

void main() {
    Scanner input = new Scanner(System.in);

    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    String[] usernames = {"Oliver", "Jonas", "Valdemar", "Kasper"};
    String[] passwords = {"pass1", "pass2", "pass3", "pass4"};
    String username = "";
    String password = "";

    username = inputUsername(input);

    if (validateUsername(usernames, username)) {

        loginAttempt(input, timeFormat, usernames, username, passwords, password);

    } else {
        System.out.println("Ukendt brugernavn!");
    }

}

static String inputUsername(Scanner input) {
    System.out.print("Indtast brugernavn: ");
    String username = input.nextLine();
    return username;
}

static boolean validateUsername(String[] usernames, String username) {
    for (int i = 0; i < usernames.length; i++) {
        if (username.equalsIgnoreCase(usernames[i])) {
            return true;
        }
    }
    return false;
}

static String inputPassword(Scanner input) {
    System.out.print("Indtast adgangskode: ");
    String password = input.nextLine();
    return password;
}

static boolean validatePassword(String[] passwords, String password, String[] usernames, String username) {

    for (int i = 0; i < passwords.length; i++) {
        if (password.equals(passwords[i]) && username.equalsIgnoreCase(usernames[i])) {
            return true;
        }
    }
    return false;
}

static void loginAttempt(Scanner input, DateTimeFormatter timeFormat, String[] usernames, String username, String[] passwords, String password) {
    int loginAttempts = 3;
    while (loginAttempts > 0 && !validatePassword(passwords, password, usernames, username)) {

        password = inputPassword(input);
        if (validatePassword(passwords, password, usernames, username)) {
            System.out.println("Velkommen " + username + "! Login kl. " + LocalTime.now().format(timeFormat));
            break;
        } else {
            System.out.println("Forkert adgangskode!");
            loginAttempts--;
            if (loginAttempts != 0) {
                System.out.println("Du har " + loginAttempts + " forsøg tilbage");
            }
        }
    }
    if (loginAttempts == 0) {
        System.out.println("Du har brugt alle forsøg. Kontoen er nu låst!");
    }

}