package un.labs.lab1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

            String fileName = "Info file";

            FileOutputStream fileOutputStream;

            try {
                fileOutputStream = getContext().openFileOutput(fileName,Context.MODE_APPEND);
                fileOutputStream.write(insertedText.getBytes());
                fileOutputStream.close();
                Toast.makeText(getContext(), "Інформація збережена до файлу!", Toast.LENGTH_SHORT).show();
            }

            catch (FileNotFoundException e) {
                try {
                    File file = new File(getContext().getFilesDir(), fileName);
                    fileOutputStream = getContext().openFileOutput(fileName,Context.MODE_APPEND);
                    fileOutputStream.write("\n".getBytes());
                    fileOutputStream.write(insertedText.getBytes());

                    fileOutputStream.close();
                    Toast.makeText(getContext(), "Інформація збережена до нового файлу!", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
