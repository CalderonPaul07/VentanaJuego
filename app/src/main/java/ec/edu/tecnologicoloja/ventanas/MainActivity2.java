package ec.edu.tecnologicoloja.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private String randomColor,colorR;
    TextView texto;
    LinearLayout fondoColor,colorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle datos = this.getIntent().getExtras();
        colorR = datos.getString("color");
        texto=(TextView) findViewById(R.id.textView);
        fondoColor = findViewById(R.id.background);
        colorLayout = findViewById(R.id.colorelegido);

        colorLayout.setBackgroundColor(android.graphics.Color.parseColor(colorExadecimal(colorR)));

        //String colorR=getIntent().getStringExtra("color");

        Toast.makeText(getApplicationContext(), "Color recibido: " + colorR, Toast.LENGTH_LONG).show();
        colorAleatorio();
        compararRespuesta();

    }


    public void colorAleatorio() {
        //Llamamos al metodo random
        Random random = new Random();

        // Creamos un array con los colores disponibles
        String[] colores = {"rojo", "amarillo", "azul"};

        // Generamos un índice aleatorio para seleccionar un color del array
        int randomIndex = random.nextInt(colores.length);

        // Obtener el color aleatorio
        randomColor = colores[randomIndex];
        fondoColor.setBackgroundColor(android.graphics.Color.parseColor(colorExadecimal(randomColor)));

    }

    public void compararRespuesta(){
        //fondoColor.setBackgroundColor(colorExadecimal(randomColor));
        if (colorR.toLowerCase().equals(randomColor)){
            //Toast.makeText(getApplicationContext(), "Color recibido: ganastes " + colorR, Toast.LENGTH_LONG).show();
            //Mostramos el resutado en el TextView
            texto.setText("Ganastes \n El color es: "+randomColor);
        }else{
            //Toast.makeText(getApplicationContext(), "Color recibido: perdistes " + colorR, Toast.LENGTH_LONG).show();
            //Mostramos el resutado en el TextView
            texto.setText("Perdiste \n El color es: "+randomColor);
        }
    }
    public static String colorExadecimal(String color){
        String colorHexa;

        switch (color) {
            case "azul":
                colorHexa = "#0000FF";
                break;
            case "rojo":
                colorHexa = "#FF0000" ;
                break;
            case "amarillo":
                colorHexa = "#FFFF00";
                break;
            default:
                colorHexa = "#000000";
        }

        return colorHexa;
    }
}