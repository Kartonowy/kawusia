package zsk.egzamin02_2023_01.cz2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;

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

        simpleList = (ListView) findViewById(R.id.lv);

        String[] initial = {
                "Zakupy: chleb, masło, ser",
                "Do zrobienia: obiad, umyć podłogi",
                "weekend: kino, spacer z psem"
        };

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.list_element, R.id.itemTextView, initial);
        simpleList.setAdapter(aa);

        EditText ex = (EditText) findViewById(R.id.news);
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aa.add(ex.getText().toString());
            }
        });
    }


}