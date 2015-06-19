package com.fundacionmagtel.android.teleasistenciaticplus.act.user;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.fundacionmagtel.android.teleasistenciaticplus.R;

public class actUserOptionsAbout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_act_user_options_about);

        TextView listaEntidades = (TextView) findViewById(R.id.acerca_de_entidades);

        String listaColaboradoresHtml =
                "   <p>" +
                        " <br>C.M. Osario Romano (D. Sur) " +
                        " <br>C.M. Antonio Pareja (D. Norte Sierra) " +
                        " <br>C.M. Levante (D. Levante) " +
                        " <br>C.M. Huerta de la Reina - Tablero (D. Noroeste)" +
                        " <br>C.M. La Foggarilla (D. Poniente Norte)" +
                        " <br>C.M. El Higuerón (D. Periurbano Oeste) " +
                        " <br>C.M. Villarrubia (D. Periurbano Oeste)" +
                        " <br>C.M. Alcolea (D. Periurbano Este)</p>" +

                        " <p>Centro de Día de Personas Mayores Córdoba I" +
                        " <br>Centro de Día de Personas Mayores Córdoba II" +
                        " <br>Centro de Día de Personas Mayores Córdoba III" +
                        " <br>Centro de Día de Personas Mayores de Poniente \"Zoco\"" +
                        "<br>Centro de Día de Personas Mayores de Los Naranjos" +
                        "<br>Centro de Día de Personas Mayores Fuensanta-Cañero";

        listaEntidades.setText(Html.fromHtml(listaColaboradoresHtml));

        TextView listaDesarrollo = (TextView) findViewById(R.id.acerca_de_desarrollo);

        String listaDesarrolloHtml =
                "<p> <b>FUNDACIÓN MAGTEL</b> <br> Parque Empresarial Las Quemadas " +
        "<br>C/ Gabriel Ramos Bejarano, 114" +
        "<br> CP. 14014 - CÓRDOBA, ESPAÑA " +
        "<br><br> tlf.: (+34) 957 429 060 (extensión 283)	<br>- Horario: 8:00 a 14:00 de lunes a viernes " +
        "<br><br> teleasistenciatic@magtel.es " +
        "<br><br> <b>©2015 - Todos los derechos reservados</b></p>";

        listaDesarrollo.setText(Html.fromHtml(listaDesarrolloHtml));
    }
}
