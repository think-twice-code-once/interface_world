package com.thinktwicecodeonce.interfacelife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSelect = (Button) findViewById(R.id.activity_btn_select);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show 3 options
                OptionsDialog optionsDialog = new OptionsDialog();
                optionsDialog.show(getSupportFragmentManager(),
                        OptionsDialog.class.getSimpleName());
                optionsDialog.setOnSelectListener(new OnSelectListener() {
                    //handle results here:
                    @Override
                    public void onEdit() {
                        Toast.makeText(MainActivity.this, "Selected edit", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDelete() {
                        Toast.makeText(MainActivity.this, "Selected delete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(MainActivity.this, "Selected cancel", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
