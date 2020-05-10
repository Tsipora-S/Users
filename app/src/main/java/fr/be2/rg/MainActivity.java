package fr.be2.rg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button ajoutUser,voirListe;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAjoutUser:
                Intent intent = new Intent(MainActivity.this, AjoutActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.btnVoirListe:
                Intent intent2 = new Intent(MainActivity.this, VueActivity.class);
                MainActivity.this.startActivity(intent2);
                break;

        }
    }
    private void init() {

        ajoutUser = findViewById(R.id.btnAjoutUser);
        voirListe = findViewById(R.id.btnVoirListe);
        ajoutUser.setOnClickListener(this);
        voirListe.setOnClickListener(this);
    }
}
