package un.labs.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        EditText editText = findViewById(R.id.infoTextMultiLine);

        String fileName = "Info file";

        int data;
        StringBuffer information = new StringBuffer("");
        byte[] buffer = new byte[1024];

        FileInputStream fileInputStream;


        try {
            fileInputStream = InfoActivity.this.openFileInput(fileName);
            while ((data = fileInputStream.read(buffer)) != -1)
            {
                information.append(new String(buffer, 0, data));
            }

            fileInputStream.close();


            editText.setText(information);
        }
        catch (FileNotFoundException e) {
            Toast.makeText(InfoActivity.this, "Файл пустий!", Toast.LENGTH_SHORT).show();
        }

        catch (IOException e) {
            e.printStackTrace();
        }


        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoActivity.this.deleteFile(fileName);
                editText.setText("");
            }
        });
    }
}