import java.util.*;

public class VotingService {
    private Question question;
    private Map<String, Student> userSubmission;

    /**
     * Constructor to initialize the VotingService.
     * Initializes the userSubmission map to store student submissions.
     */
    public VotingService() {
        userSubmission = new HashMap<>();
    }

    /**
     * Get the current question being voted on.
     *
     * @return The current question.
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Configure the question for the voting service.
     *
     * @param question The question to be configured.
     */
    public void configureQuestion(Question question) {
        this.question = question;
    }

    /**
     * Accept a submission from a student and store it in the userSubmission map.
     *
     * @param student The student object representing the submission.
     */
    public void acceptSubmission(Student student) {
        userSubmission.put(student.getId(), student);
    }

    /**
     * Display the result of the voting process.
     * Counts the number of times each choice was selected by students
     * and prints the results.
     */
    public void displayResult() {
        Map<String, Integer> counts = new HashMap<>();

        // Iterate through student submissions and count choices
        for (Student student : userSubmission.values()) {
            List<String> userChoice = student.getUserInput();
            for (String choice : userChoice) {
                counts.put(choice, counts.getOrDefault(choice, 0) + 1); // if there are unseen choices in the hashsmap, then add 0 else add 1
            }
        }

        // Print the counts for each choice in the question
        for (String choice : question.getUserAnswer()) {
            int count = counts.getOrDefault(choice, 0);
            System.out.println(choice + " : " + count);
        }
        System.out.println("");
    }
}
