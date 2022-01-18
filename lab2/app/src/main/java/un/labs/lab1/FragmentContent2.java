package un.labs.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentContent2 extends Fragment {

    public FragmentContent2(){
        super(R.layout.text_fragment_layout);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = view.findViewById(R.id.editTextTextMultiLine);

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            String insertedText = bundle.getString("text", "Нічого не прийшло");
            editText.setText("");
            editText.setText(insertedText);
        }
    }


}
