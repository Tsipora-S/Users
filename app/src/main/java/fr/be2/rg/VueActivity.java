package fr.be2.rg;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class VueActivity extends MainActivity {
    DatabaseHelper db;
    ListView userlist;
    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_main);

        db= new DatabaseHelper(this);
        listItem = new ArrayList<>();
        userlist = findViewById(R.id.users_list);

        viewData();
      userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              int id=getId(i);
              db.deleteData(id);
              String text = userlist.getItemAtPosition(i).toString();
              if (db.deleteData(id)) {
                  Toast.makeText(VueActivity.this, "" + text + " supprimé", Toast.LENGTH_SHORT).show();
                  viewData();
              }
          }
      });
      }
        protected void viewData(){
            Cursor cursor = db.viewData();
            listItem.clear();
            if (cursor.getCount() == 0){
                Toast.makeText(VueActivity.this, "no data To Show", Toast.LENGTH_SHORT).show();
            }
            else {
                while (cursor.moveToNext())
                {
                    listItem.add(cursor.getString(1)+"["+cursor.getString(2)+" ans]");

                }
                adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
                userlist.setAdapter(adapter);

        }
    }

    private int getId(int pos){
        Cursor cursor=db.viewData();
        cursor.moveToPosition(pos);
        int myId=cursor.getInt(0);
        return myId;
    }
}
