import java.util.Random;
import java.util.Scanner;

class MathQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0; // Scorul jucătorului
        int numberOfQuestions = 5; // Numărul total de întrebări
        System.out.println("Bine ai venit la Math Quiz!");
        System.out.println("Rezolvă cele " + numberOfQuestions + " probleme pentru a câștiga puncte.");
        System.out.println("Introduceți răspunsurile corecte. Succes!\n");

        for (int i = 0; i < numberOfQuestions; i++) {
            // Generează două numere și un operator aleatoriu
            int num1 = random.nextInt(20) + 1; // Număr între 1 și 20
            int num2 = random.nextInt(20) + 1; // Număr între 1 și 20
            char operator = generateRandomOperator();

            // Calculează răspunsul corect
            int correctAnswer = calculateAnswer(num1, num2, operator);
    
            // Pune întrebarea
            System.out.println("Întrebarea " + (i + 1) + ":");
            System.out.print(num1 + " " + operator + " " + num2 + " = ");
            int userAnswer = scanner.nextInt();

            // Verifică răspunsul
            if (userAnswer == correctAnswer) {
                System.out.println("Corect! +1 punct.\n");
                score++;
            } else {
                System.out.println("Greșit. Răspunsul corect era: " + correctAnswer + ".\n");
            }
        }

        // Finalul jocului
        System.out.println("Testul s-a terminat! Ai obținut un scor de " + score + "/" + numberOfQuestions + ".");
        if (score == numberOfQuestions) {
            System.out.println("Felicitări, ai răspuns corect la toate întrebările!");
        } else if (score > numberOfQuestions / 2) {
            System.out.println("Bine jucat! Ai făcut o treabă bună.");
        } else {
            System.out.println("Mai încearcă! Poți să faci mai bine data viitoare.");
        }
    }

    // Generează un operator aleatoriu
    private static char generateRandomOperator() {
        char[] operators = {'+', '-', '*', '/'};
        Random random = new Random();
        return operators[random.nextInt(4)];
    }

    // Calculează răspunsul corect pe baza operatorului
    private static int calculateAnswer(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' ->
                // Gestionare diviziune pentru a evita împărțirea la 0
                    num2 != 0 ? num1 / num2 : 0;
            default -> throw new IllegalArgumentException("Operator necunoscut: " + operator);
        };
    }
}
