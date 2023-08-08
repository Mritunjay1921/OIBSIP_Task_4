package com.mritunjay.quiztime;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sportsButton = findViewById(R.id.sportsButton);
        Button technologyButton = findViewById(R.id.technologyButton);

        sportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz("Sports");
            }
        });

        technologyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz("Technology");
            }
        });
    }

    private void startQuiz(String topic) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("TOPIC", topic);
        startActivity(intent);
    }
}
