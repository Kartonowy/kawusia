package zsk.egzamin01_2022_6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public int likes = 0;

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

        Button like = (Button) findViewById(R.id.like);

        TextView smth = (TextView)findViewById(R.id.likes);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likes += 1;

                smth.setText(String.format("%d polubień", likes));
            }
        });

        Button hate = (Button) findViewById(R.id.delete);
        hate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (likes > 0) {
                    likes -= 1;
                    smth.setText(String.format("%d polubień", likes));
                }
            }
        });
    }
}