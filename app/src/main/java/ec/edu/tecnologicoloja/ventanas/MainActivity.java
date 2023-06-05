package ec.edu.tecnologicoloja.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_adivinar;
    EditText txt_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_adivinar=(Button) findViewById(R.id.button);
        txt_color=(EditText) findViewById(R.id.TextColor);
    }
    public void clickBtn(View v){
        //Toast.makeText(getApplicationContext(),"Esto es una prueba",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        //String colorValue=txt_color.getText().toString();

        //Enviamos el texto a la siente pantalla con el intent.putExtra
        intent.putExtra("color",txt_color.getText().toString());
        startActivity(intent);
    }
}