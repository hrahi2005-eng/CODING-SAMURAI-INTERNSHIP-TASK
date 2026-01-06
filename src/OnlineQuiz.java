import java.util.Scanner;

public class OnlineQuiz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
                "1. Which language is used for Android development?",
                "2. Who is known as the father of Java?",
                "3. Which keyword is used to inherit a class in Java?"
        };

        String[][] options = {
                {"A. Python", "B. Java", "C. C++", "D. PHP"},
                {"A. Dennis Ritchie", "B. James Gosling", "C. Bjarne Stroustrup", "D. Guido van Rossum"},
                {"A. this", "B. super", "C. extends", "D. implements"}
        };

        char[] answers = {'B', 'B', 'C'};
        char[] userAnswers = new char[questions.length];

        int score = 0;

        System.out.println("===== Online Quiz Application =====\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            userAnswers[i] = sc.next().toUpperCase().charAt(0);

            if (userAnswers[i] == answers[i]) {
                score++;
            }
            System.out.println();
        }

        System.out.println("===== Quiz Result =====");
        System.out.println("Your Score: " + score + " / " + questions.length);

        System.out.println("\nCorrect Answers:");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Q" + (i + 1) + ": " + answers[i]);
        }

        sc.close();
    }
}