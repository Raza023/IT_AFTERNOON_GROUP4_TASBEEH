package com.example.tasbeehpro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    EditText name, recited, count;

    HelperDB db;
    ArrayList<Tasbeeh> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        name = findViewById(R.id.name);
        recited = findViewById(R.id.recited);
        count = findViewById(R.id.count);

        list = new ArrayList<Tasbeeh>();

        db = new HelperDB(this);
        RefreshGrid();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tName = name.getText().toString();
                String tRecited = recited.getText().toString();
                int tCount = Integer.parseInt(count.getText().toString());
                String tCountstr = Integer.toString(tCount);

                list.add(new Tasbeeh(tName,tRecited,tCount));
                RefreshGrid();

                if(name.equals("") && recited.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter valid data of tasbeeh",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.insert(new Tasbeeh(tName,tRecited,tCount));
                    RefreshGrid();
                    Toast.makeText(MainActivity.this,"Tasbeeh Record has been added",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void RefreshGrid()
    {
        ArrayList<Tasbeeh> list = db.getTasbeeh();
        ArrayAdapter<Tasbeeh> adpt = new ArrayAdapter<Tasbeeh>(MainActivity.this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adpt);
    }
}