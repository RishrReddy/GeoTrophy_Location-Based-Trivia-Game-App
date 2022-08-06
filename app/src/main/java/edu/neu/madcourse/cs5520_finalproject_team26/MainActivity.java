package edu.neu.madcourse.cs5520_finalproject_team26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import edu.neu.madcourse.cs5520_finalproject_team26.models.QuestionUser;
import edu.neu.madcourse.cs5520_finalproject_team26.models.User;

public class  MainActivity extends AppCompatActivity {

    Button triviaGamePage;
    Button playerSummaryPage;
    Button leaderboard;
    Button addQuestion;
    Button addDummyData;

    private DatabaseReference reference;
    private Button viewMessages;
    private Button leaveNote;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        triviaGamePage = findViewById(R.id.trivia_game_page_button);
        playerSummaryPage = findViewById(R.id.player_summary_button);
        leaderboard = findViewById(R.id.leaderboard_label);
        addQuestion = findViewById(R.id.add_question_label);

        triviaGamePage.setOnClickListener(v -> {
            Intent intent = new Intent(this, TriviaPageActivity.class);
            startActivity(intent);
        });

        playerSummaryPage.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlayerSummaryActivity.class);
            startActivity(intent);
        });

        leaderboard.setOnClickListener(v -> {
            Intent intent = new Intent(this, Leaderboard.class);
            startActivity(intent);
        });

        addQuestion.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddQuestion.class);
            startActivity(intent);
        });




        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        if(user == null) {

            startActivity(new Intent(this, LoginActivity.class));
        }

    }

    public void logOutClick(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void openLeaveNoteActivity() {
        Intent intent = new Intent(this, LeaveNoteActivity.class);
        startActivity(intent);
    }

    private void openViewMessagesActivity() {
        Intent intent = new Intent(this, ViewMessagesActivity.class);
        startActivity(intent);
    }
}