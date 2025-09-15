package zsk.egzamin.a08092025;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int gamescore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Random rand = new Random();

        Button throwdice = findViewById(R.id.throwdice);
        Button reset = findViewById(R.id.reset);

        TextView game_result = (TextView) findViewById(R.id.gameresult);
        TextView roll_result = (TextView) findViewById(R.id.rollresult);

        int[] diceIds = new int[]{
                R.id.dice1, R.id.dice2, R.id.dice3, R.id.dice4, R.id.dice5
        };

        int[] diceRes = {
                R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4, R.drawable.k5, R.drawable.k6
        };

        ImageView[] images = new ImageView[diceIds.length];
        for (int i = 0; i < diceIds.length; ++i) {
            images[i] = findViewById(diceIds[i]);
        }

        throwdice.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             int[] rolls = {0, 0, 0, 0, 0, 0};

                                             for (ImageView dice : images) {
                                                 int random = rand.nextInt(6);
                                                 dice.setImageResource(diceRes[random]);

                                                 rolls[random] += 1;

                                             }

                                             int localscore = 0;

                                             for (int i = 0; i < rolls.length; ++i) {
                                                if (rolls[i] >= 2)  {
                                                    localscore = i * rolls[i];
                                                }
                                             }

                                             gamescore +=  localscore;

                                             roll_result.setText("Wynik tego losowania: " + localscore);
                                             game_result.setText("Wynik gry: " + gamescore);

                                         }
                                     }
        );
        reset.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         for (ImageView dice : images) {
                                             dice.setImageResource(R.drawable.question);
                                         }

                                         roll_result.setText("Wynik tego losowania: 0");
                                         game_result.setText("Wynik gry: 0");
                                         gamescore = 0;

                                     }
                                 }
        );
    }
}