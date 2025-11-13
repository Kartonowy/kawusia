package zsk.egzamin02_2025_01.egzamin02_2024_01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String Sspecies = "Kot";
    int age = 0;

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

        String[] species = {"Pies", "Kot", "Świnka morska"};

        ListView list = (ListView) findViewById(R.id.gatunek);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.row, R.id.row,  species);

        list.setAdapter(adapter);

        SeekBar bar = findViewById(R.id.sb);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String species = parent.getItemAtPosition(position).toString().trim();
                switch (species) {
                    case "Pies":
                        bar.setMax(18);
                        Sspecies = "Pies";
                        break;
                    case "Kota":
                        bar.setMax(20);
                        Sspecies = "Kot";
                        break;
                    case "Świnka morska":
                        bar.setMax(9);
                        Sspecies = "Świnka morska";
                        break;
                    default:
                        break;
                }
            }
        });

        var prog = (TextView) findViewById(R.id.lat);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prog.setText("Ile ma lat? "+ Integer.toString(progress));
                age = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String hour = ((EditText) findViewById(R.id.hour)).getText().toString();
                String cel = ((EditText) findViewById(R.id.cel)).getText().toString();
                TextView out = (TextView) findViewById(R.id.out);

                out.setText(name + ", " + Sspecies + ", " + age + ", " + cel + ", " + hour);

            }
        });
    }

}