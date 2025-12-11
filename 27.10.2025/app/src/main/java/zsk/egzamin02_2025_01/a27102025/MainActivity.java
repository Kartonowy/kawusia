package zsk.egzamin02_2025_01.a27102025;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

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
        Button be = (Button) findViewById(R.id.cipher);

        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int key = Integer.parseInt(((EditText)findViewById(R.id.key)).getText().toString());
                String code = ((EditText)findViewById(R.id.code)).getText().toString();

                char[] news = new char[code.length()];
                for (int i = 0; i < code.length(); ++i) {
                    news[i] = (char)((((code.charAt(i) - 'a') + key) % 26) + 'a');
                }

                ((TextView)findViewById(R.id.output)).setText(Arrays.toString(news));

            }
        });
    }

}