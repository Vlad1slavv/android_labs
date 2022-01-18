package un.labs.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckedTextView perimeterCheckButton = findViewById(R.id.perimeterTextView);
        perimeterCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (perimeterCheckButton.isChecked()) {
                    perimeterCheckButton.setChecked(false);
                    perimeterCheckButton.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);
                } else {
                    perimeterCheckButton.setChecked(true);
                    perimeterCheckButton.setCheckMarkDrawable(android.R.drawable.checkbox_on_background);
                }
            }
        });

        CheckedTextView areaCheckButton = findViewById(R.id.areaTextView);
        areaCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (areaCheckButton.isChecked()) {
                    areaCheckButton.setChecked(false);
                    areaCheckButton.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);
                } else {
                    areaCheckButton.setChecked(true);
                    areaCheckButton.setCheckMarkDrawable(android.R.drawable.checkbox_on_background);
                }
            }
        });

        RadioGroup radioGroup = findViewById(R.id.figure_radio_group);

        Button button = findViewById(R.id.ok_button);
        button.setOnClickListener(v -> {
            String insertedText = "";
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.radio_square:
                    if (perimeterCheckButton.isChecked()) {
                        insertedText = insertedText + "Перимитер квадрата зі стороною 5 = 20";
                    }
                    if (areaCheckButton.isChecked()) {
                        insertedText = insertedText + "\nПлоща квадрата зі сотоною 5 = 25";
                    }
                    if (!perimeterCheckButton.isChecked() && !areaCheckButton.isChecked()) {
                        insertedText = "Ви не вибрали ні периметер, ні площу!";
                    }
                    break;
                case R.id.radio_triangle:
                    if (perimeterCheckButton.isChecked()) {
                        insertedText = insertedText + "Перимитер рівносторонього трикутника зі стороною 4 = 12";
                    }
                    if (areaCheckButton.isChecked()) {
                        insertedText = insertedText + "\nПлоща рівносторонього трикутника зі стороною 4 = 6,928";
                    }
                    if (!perimeterCheckButton.isChecked() && !areaCheckButton.isChecked()) {
                        insertedText = "Ви не вибрали ні периметер, ні площу!";
                    }
                    break;
                case R.id.radio_circle:
                    if (perimeterCheckButton.isChecked()) {
                        insertedText = insertedText + "Довжина круга з радіусом 3 = 18,84";
                    }
                    if (areaCheckButton.isChecked()) {
                        insertedText = insertedText + "\nПлоща круга з радіусом = 28,26";
                    }
                    if (!perimeterCheckButton.isChecked() && !areaCheckButton.isChecked()) {
                        insertedText = "Ви не вибрали ні периметер, ні площу!";
                    }
                    break;
            }

            //----------
            Bundle bundle = new Bundle();

            bundle.putString("text", insertedText);

            FragmentContent2 fragmentContent2 = new FragmentContent2();

            fragmentContent2.setArguments(bundle);

            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, fragmentContent2, null).addToBackStack(null)
                    .commit();
        });

    }
}