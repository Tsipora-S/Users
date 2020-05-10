package fr.be2.rg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutActivity extends MainActivity implements View.OnClickListener{
    DatabaseHelper db;
    Button add_data;
    EditText add_name,add_age;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_main);
        db= new DatabaseHelper(this);
        add_data= findViewById(R.id.add_data);
        add_name= findViewById(R.id.add_name);
        add_age=findViewById(R.id.add_age);
        final VueActivity menu=new VueActivity();
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = add_name.getText().toString();
                int age = Integer.parseInt("0" + add_age.getText().toString());
                if (!name.equals("") && db.insertData(name, age)) {
                    Toast.makeText(AjoutActivity.this, "Utilisateur ajouté", Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    add_age.setText("0");
                    //menu.viewData();
                } else {
                    Toast.makeText(AjoutActivity.this, "Utilisateur non ajouté", Toast.LENGTH_SHORT).show();
                }
            }
        }
        );}

}
