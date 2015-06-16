package com.fundacionmagtel.android.teleasistenciaticplus.act.debug;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fundacionmagtel.android.teleasistenciaticplus.R;
import com.fundacionmagtel.android.teleasistenciaticplus.lib.helper.AppInfo;

/**
 * Actividad que muestra la memoria disponible y usada en el terminal
 * @author Juan Jose Ferres
 */
public class actDebugMemory extends Activity {

    /**
     * Método de framework onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_debug_memory);

        // Memoria usada (Solo API > 16 )

        TextView usedMemoryText = (TextView) findViewById(R.id.debug_used_memory_text);

        Long memoriaUsada = AppInfo.getUsedMemory();
        Long memoriaTotal = AppInfo.getTotalMemory();

        usedMemoryText.setText("Usada: " + String.valueOf(memoriaUsada) + " mb/ " + "Total: "
                                         + String.valueOf(memoriaTotal) + "mb");

        ProgressBar usedMemoryBar = (ProgressBar) findViewById(R.id.debug_progress_bar_used_memory);

        // Escalamos a 100 como referencia para la barra de progreso
        usedMemoryBar.setMax(100);
        usedMemoryBar.setProgress((int) ((memoriaUsada * 100.0f) / memoriaTotal));
    }

    /**
     * Salida de la aplicación al pulsar el botón de salida del layout
     * @param view vista
     */
    public void exit_button(View view) {
        finish();
    }
}
