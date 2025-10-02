package zsk.egzamin02_2025_01.egzamin_02_2025_01_02;

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

public class MainActivity extends AppCompatActivity {

    boolean odkurzaczonoff = false;

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

        Button pralkabuton = (Button) findViewById(R.id.pralka);
        EditText program = (EditText) findViewById(R.id.program);
        TextView np = (TextView) findViewById(R.id.nrprania) ;
        Button odkurzacbuton = (Button) findViewById(R.id.odkurzacz);
        TextView wl = (TextView) findViewById(R.id.wlaczenie);


        pralkabuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int programn = Integer.parseInt(program.getText().toString());

                if (programn <= 12 && programn >= 1) {
                    np.setText("Numer prania: " + programn);
                }
            }
        });

        odkurzacbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odkurzacbuton.setText(odkurzaczonoff ? "Włącz" : "Wyłącz");
                wl.setText(odkurzaczonoff ? "Odkurzacz wyłączony" : "Odkurzacz włączony");
                odkurzaczonoff = !odkurzaczonoff;
            }
        });

    }
}