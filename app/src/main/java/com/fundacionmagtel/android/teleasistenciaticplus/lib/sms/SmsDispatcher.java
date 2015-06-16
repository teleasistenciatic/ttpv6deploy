package com.fundacionmagtel.android.teleasistenciaticplus.lib.sms;

import android.telephony.SmsManager;
import android.widget.Toast;

import com.fundacionmagtel.android.teleasistenciaticplus.modelo.Constants;
import com.fundacionmagtel.android.teleasistenciaticplus.lib.helper.AppLog;


/**
 * Created by FESEJU on 19/03/2015.
 * La clase final que envía realmente el SMS
 * Depende de que la constante FAKE_SMS para enviarse (si esta a true, no se manda para no suponer
 * una tarificación adicional)
 * @author Juan José Ferres
 */

public class SmsDispatcher implements Constants {

    private String phoneNumber; //Destinatario
    private String message; //cuerpo del mensaje

    /**
     * Constructor
     * @param phone telefono
     * @param msgText mensaje
     */

    public SmsDispatcher(String phone, String msgText) {
        this.phoneNumber = phone;
        this.message = msgText;

        /////////////// LIMITE DE LOS 160 CARACTERES ////////////////////////////////
        // si tiene más de 160 caracteres no se manda el SMS sin mensaje de error  //
        /////////////////////////////////////////////////////////////////////////////

        // 1. Para recortar primero eliminamos los caractes de TeleAsistenciaTIC+
        if ( message.length() > Constants.LIMITE_CARACTERS_SMS ) {
            message = message.replace("TELEASISTENCI@TIC+:","");

            // 2. Si siguen siendo demasiados caracteres, nos quedamos con los 160 últimos
            if ( message.length() > Constants.LIMITE_CARACTERS_SMS ) {
                message = message.substring( message.length() - Constants.LIMITE_CARACTERS_SMS );
            }

        }
    }

    /**
     * Enviar SMS
     */
    public void send() {
        if (phoneNumber.length() == 0) {
            return;
        }

        // ¿Qué import es? import android.telephony.gsm.SmsManager;
        SmsManager sms = SmsManager.getDefault();
        try {
            if ( ! Constants.FAKE_SMS ) {


                sms.sendTextMessage(phoneNumber, null, message, null, null);

            }
        } catch (Exception e) {
            AppLog.e("SmsDispatcher", "SMS send error", e);
        }
        AppLog.i("SMSSend", phoneNumber + " " + message);
    }
}