package un.labs.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentContent1 extends Fragment {

    public FragmentContent1(){
        super(R.layout.fragment_layout);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckedTextView perimeterCheckButton = getActivity().findViewById(R.id.perimeterTextView);
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

        CheckedTextView areaCheckButton = getActivity().findViewById(R.id.areaTextView);
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

        RadioGroup radioGroup = getActivity().findViewById(R.id.figure_radio_group);

        Button button = getActivity().findViewById(R.id.ok_button);
        button.setOnClickListener(v -> {
            String insertedText = "";
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.radio_square:
                    if (perimeterCheckButton.isChecked()) {
                        insertedText = insertedText + "\nПеримитер квадрата зі стороною 5 = 20";
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
                        insertedText = insertedText + "\nПеримитер рівносторонього трикутника зі стороною 4 = 12";
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
                        insertedText = insertedText + "\nДовжина круга з радіусом 3 = 18,84";
                    }
                    if (areaCheckButton.isChecked()) {
                        insertedText = insertedText + "\nПлоща круга з радіусом = 28,26";
                    }
                    if (!perimeterCheckButton.isChecked() && !areaCheckButton.isChecked()) {
                        insertedText = "Ви не вибрали ні периметер, ні площу!";
                    }
                    break;
            }
            Bundle bundle = new Bundle();
            bundle.putString("text", insertedText);
            FragmentContent2 fragmentContent2 = new FragmentContent2();
            fragmentContent2.setArguments(bundle);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, fragmentContent2, null).addToBackStack(null)
                    .commit();
        });
    }


}
