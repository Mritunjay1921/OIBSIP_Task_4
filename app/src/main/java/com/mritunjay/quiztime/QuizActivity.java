package com.mritunjay.quiztime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizActivity extends AppCompatActivity {

    private int currentQuestionIndex = 0;
    private int score = 0;
    private String topic;
    int totalQuestion = 10;

    private TextView questionTextView;
    TextView totalQuestionsTextView;
    private Button option1Button, option2Button, option3Button, option4Button;

    // Create ArrayLists for sports and technology questions
    private ArrayList<Question> sportsQuestions = new ArrayList<>();
    private ArrayList<Question> technologyQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        topic = getIntent().getStringExtra("TOPIC");

        // Initialize views
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.questionTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        option4Button = findViewById(R.id.option4Button);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        // Load questions for each topic (You should populate the questions from your data source)
        loadSportsQuestions();
        loadTechnologyQuestions();

        // Set up initial question
        displayQuestion(currentQuestionIndex);

        // Set click listeners for options buttons
        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(0);
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(2);
            }
        });

        option4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(3);
            }
        });
    }

    private void loadSportsQuestions() {
        sportsQuestions.add(new Question("Which sport is known as the 'king of sports'?",
                new ArrayList<>(Arrays.asList("Football", "Cricket", "Soccer", "Tennis")), 0)); // Correct Answer: Football

        sportsQuestions.add(new Question("In which sport is a 'shuttlecock' used?",
                new ArrayList<>(Arrays.asList("Badminton", "Tennis", "Table Tennis", "Squash")), 0)); // Correct Answer: Badminton

        sportsQuestions.add(new Question("Which country won the FIFA World Cup in 2018?",
                new ArrayList<>(Arrays.asList("Brazil", "France", "Germany", "Spain")), 1)); // Correct Answer: France

        sportsQuestions.add(new Question("How many players are there in a baseball team?",
                new ArrayList<>(Arrays.asList("9", "10", "11", "12")), 0)); // Correct Answer: 9

        sportsQuestions.add(new Question("In which sport can you score a 'birdie'?",
                new ArrayList<>(Arrays.asList("Golf", "Tennis", "Badminton", "Table Tennis")), 0)); // Correct Answer: Golf

        sportsQuestions.add(new Question("Which country is famous for producing the sportswear brand 'Nike'?",
                new ArrayList<>(Arrays.asList("USA", "Germany", "Italy", "Japan")), 0)); // Correct Answer: USA

        sportsQuestions.add(new Question("What is the diameter of a basketball hoop in inches?",
                new ArrayList<>(Arrays.asList("16 inches", "18 inches", "20 inches", "22 inches")), 1)); // Correct Answer: 18 inches

        sportsQuestions.add(new Question("Which athlete is known as the 'Fastest Man on Earth'?",
                new ArrayList<>(Arrays.asList("Usain Bolt", "Michael Phelps", "Roger Federer", "Serena Williams")), 0)); // Correct Answer: Usain Bolt

        sportsQuestions.add(new Question("Which city hosted the Summer Olympics in 2008?",
                new ArrayList<>(Arrays.asList("Beijing", "London", "Rio de Janeiro", "Sydney")), 0)); // Correct Answer: Beijing

        sportsQuestions.add(new Question("What is the highest possible break in snooker?",
                new ArrayList<>(Arrays.asList("147", "155", "163", "170")), 0)); // Correct Answer: 147
    }

    private void loadTechnologyQuestions() {
        technologyQuestions.add(new Question("Who founded Microsoft?",
                new ArrayList<>(Arrays.asList("Bill Gates", "Steve Jobs", "Mark Zuckerberg", "Jeff Bezos")), 0)); // Correct Answer: Bill Gates

        technologyQuestions.add(new Question("What does 'HTML' stand for?",
                new ArrayList<>(Arrays.asList("HyperText Markup Language", "Home Tool Markup Language", "HyperTool Marking Language", "HyperText Manipulation Language")), 0)); // Correct Answer: HyperText Markup Language

        technologyQuestions.add(new Question("What is the programming language used to build Android apps?",
                new ArrayList<>(Arrays.asList("Java", "Python", "C#", "Swift")), 0)); // Correct Answer: Java

        technologyQuestions.add(new Question("What company developed the 'iPhone'?",
                new ArrayList<>(Arrays.asList("Apple", "Samsung", "Google", "Sony")), 0)); // Correct Answer: Apple

        technologyQuestions.add(new Question("Which computer scientist is considered the 'father of modern computers'?",
                new ArrayList<>(Arrays.asList("Alan Turing", "Ada Lovelace", "Charles Babbage", "John von Neumann")), 2)); // Correct Answer: Charles Babbage

        technologyQuestions.add(new Question("What does 'CPU' stand for?",
                new ArrayList<>(Arrays.asList("Central Processing Unit", "Computer Processing Unit", "Control Processing Unit", "Core Processing Unit")), 0)); // Correct Answer: Central Processing Unit

        technologyQuestions.add(new Question("What is the largest social media platform in the world?",
                new ArrayList<>(Arrays.asList("Facebook", "Twitter", "Instagram", "LinkedIn")), 0)); // Correct Answer: Facebook

        technologyQuestions.add(new Question("Which company developed the 'Windows' operating system?",
                new ArrayList<>(Arrays.asList("Microsoft", "Apple", "Google", "IBM")), 0)); // Correct Answer: Microsoft

        technologyQuestions.add(new Question("What does 'URL' stand for?",
                new ArrayList<>(Arrays.asList("Uniform Resource Locator", "Universal Reference Link", "Universal Resource Link", "Unified Resource Locator")), 0)); // Correct Answer: Uniform Resource Locator

        technologyQuestions.add(new Question("What does 'RAM' stand for in computing?",
                new ArrayList<>(Arrays.asList("Random Access Memory", "Read-Only Memory", "Read Access Memory", "Real-time Access Memory")), 0)); // Correct Answer: Random Access Memory
    }

    private void displayQuestion(int questionIndex) {
        // Display the question and its options in the views based on the current question index
        // For example:
        Question question;
        if (topic.equals("Sports")) {
            question = sportsQuestions.get(questionIndex);
        } else {
            question = technologyQuestions.get(questionIndex);
        }

        questionTextView.setText(question.getQuestion());
        option1Button.setText(question.getOptions().get(0));
        option2Button.setText(question.getOptions().get(1));
        option3Button.setText(question.getOptions().get(2));
        option4Button.setText(question.getOptions().get(3));
    }

    private void checkAnswer(int selectedOptionIndex) {
        Question question;
        if (topic.equals("Sports")) {
            question = sportsQuestions.get(currentQuestionIndex);
        } else {
            question = technologyQuestions.get(currentQuestionIndex);
        }

        if (question.getCorrectAnswerIndex() == selectedOptionIndex) {
            score++;
        }

        currentQuestionIndex++;

        if (currentQuestionIndex < sportsQuestions.size() || currentQuestionIndex < technologyQuestions.size()) {
            displayQuestion(currentQuestionIndex);
        } else {
            // Quiz completed, show the score/result screen
            showResult();
        }
    }

    private void showResult() {
        // Display the final score and a message based on the user's performance
        // For example:
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
        finish();
    }
}
