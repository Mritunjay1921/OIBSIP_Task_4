package com.mritunjay.quiztime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        int score = getIntent().getIntExtra("SCORE", 0);

        TextView scoreTextView = findViewById(R.id.scoreTextView);
        TextView messageTextView = findViewById(R.id.messageTextView);
        Button restartbtn = findViewById(R.id.button);

        scoreTextView.setText("Your Score: " + score);

        restartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartbtn("Restart");
            }
        });



        // You can customize the congratulatory messages based on the score
        if (score == 0) {
            messageTextView.setText("Oops! Better luck next time.");
        } else if (score < 3) {
            messageTextView.setText("Not bad, keep practicing!");
        } else if (score < 5) {
            messageTextView.setText("Good job!");
        } else {
            messageTextView.setText("Congratulations! You did great!");
        }

    }

    public void onExitButtonClick(View view) {
        finish(); // Call the finish() method to exit the app
    }

    private void restartbtn(String topic) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("TOPIC", topic);
        startActivity(intent);
    }
}
