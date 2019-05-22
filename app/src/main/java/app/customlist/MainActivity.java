package app.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView list_View;
    ArrayAdapter<String> arrayAdapter;
    int indice = 0;
    Toast t1;
    String countryList[]={
            "India",
            "Mexico",
            "Japon"

    };
    final ArrayList<String> lista = new ArrayList<String>(Arrays.asList(countryList));
    Button btn_Agregar;
    Button btn_Edit_Apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Agregar = findViewById(R.id.btn_Agregar);
        btn_Edit_Apply = findViewById(R.id.btn_Edit_Apply);
        list_View= findViewById(R.id.list_View);
        arrayAdapter= new ArrayAdapter<String>(MainActivity.this, R.layout.activity_listview, R.id.txt_Name, lista);
        list_View.setAdapter(arrayAdapter);
        btn_Edit_Apply.setVisibility(View.GONE);

    }

    public void agregar(View view) {
        final TextView txtagregar = findViewById(R.id.txt_Campo);
        String palabra = txtagregar.getText().toString();
        lista.add(palabra);
        t1 = Toast.makeText(getApplicationContext(), "Agregando..", Toast.LENGTH_SHORT);
        t1.setGravity(Gravity.TOP, 0, 50);
        t1.show();
        arrayAdapter.notifyDataSetChanged();
    }

    public void eliminar(View view) {
        View item = (View) view.getParent();
        int pos = list_View.getPositionForView(item);
        lista.remove(pos);
        t1 = Toast.makeText(getApplicationContext(), "Eliminando..", Toast.LENGTH_SHORT);
        t1.setGravity(Gravity.TOP, 0, 50);
        t1.show();
        arrayAdapter.notifyDataSetChanged();
    }


    public void editar(View view) {
        t1 = Toast.makeText(getApplicationContext(), "Editando..", Toast.LENGTH_SHORT);
        t1.setGravity(Gravity.TOP, 0, 50);
        t1.show();
        View item = (View) view.getParent();
        int pos = list_View.getPositionForView(item);
        btn_Agregar.setVisibility(View.GONE);
        btn_Edit_Apply.setVisibility(View.VISIBLE);
        indice = pos;
    }

    public void aplicar(View view) {
        final TextView txtagregar = findViewById(R.id.txt_Campo);
        String palabra = txtagregar.getText().toString();
        lista.set(indice, palabra);
        arrayAdapter.notifyDataSetChanged();
        btn_Edit_Apply.setVisibility(View.GONE);
        btn_Agregar.setVisibility(View.VISIBLE);
        t1 = Toast.makeText(getApplicationContext(), "Aplicando..", Toast.LENGTH_SHORT);
        t1.setGravity(Gravity.TOP, 0, 50);
        t1.show();

    }
}
