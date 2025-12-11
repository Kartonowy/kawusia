package zsk.egzamin02_2025_01.kolorki;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    SeekBar r;
    SeekBar g;
    SeekBar b;

    TextView rv;
    TextView gv;
    TextView bv;

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
        Color color = new Color();

        r = (SeekBar) findViewById(R.id.red);
        r.setMax(255);
        g = (SeekBar) findViewById(R.id.green);
        g.setMax(255);
        b = (SeekBar) findViewById(R.id.blue);
        b.setMax(255);

        rv = (TextView) findViewById(R.id.redv);
        gv = (TextView) findViewById(R.id.greenv);
        bv = (TextView) findViewById(R.id.bluev);

        r.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rv.setText(Integer.toString(progress));
                updateBlock();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                gv.setText(Integer.toString(progress));
                updateBlock();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                bv.setText(Integer.toString(progress));
                updateBlock();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button s = (Button) findViewById(R.id.save);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView colv = (TextView) findViewById(R.id.colv);

                colv.setText(String.format("%s, %s, %s", rv.getText().toString(), gv.getText().toString(), bv.getText().toString()));
                String l = String.format("#%02x%02x%02x", Integer.parseInt(rv.getText().toString()), Integer.parseInt(gv.getText().toString()), Integer.parseInt(bv.getText().toString()));
                int c = Color.parseColor(l);
                colv.setBackgroundColor(c);
            }
        });
    }

    void updateBlock() {
        View v = (View) findViewById(R.id.blok);
        String l = String.format("#%02x%02x%02x", Integer.parseInt(rv.getText().toString()), Integer.parseInt(gv.getText().toString()), Integer.parseInt(bv.getText().toString()));
        int c = Color.parseColor(l);
        v.setBackgroundColor(c);
    }
}