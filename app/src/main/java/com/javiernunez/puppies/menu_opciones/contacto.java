package com.javiernunez.puppies.menu_opciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import javax.mail.*;
import javax.mail.internet.*;

import com.javiernunez.puppies.R;
import com.javiernunez.puppies.mail.SendMail;

import java.util.Date;
import java.util.Properties;

public class contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //quito imagen 5 estrellas
        ImageView img5Stars = (ImageView) findViewById(R.id.imgFiveStarts);
        img5Stars.setVisibility(View.INVISIBLE);


    }

    public void enviaEmail(View v){
        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etMensaje = (EditText) findViewById(R.id.etMensaje);

        Toast.makeText(getBaseContext(), " Tu : " + etNombre.getText()  + " con mail : " + etEmail.getText()
                        + " Enviaste el mensaje: " + etMensaje.getText()
                , Toast.LENGTH_LONG).show();
        //Creating SendMail object
        SendMail sm = new SendMail(this, etEmail.getText().toString().trim(),
                etNombre.getText().toString().trim(), etMensaje.getText().toString().trim());
        //Executing sendmail to send email
        sm.execute();
    }

    public void enviarComentarios(View v) throws AddressException {

        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etMensaje = (EditText) findViewById(R.id.etMensaje);
        String email;
        String nombre;
        String mensaje;
        email = etEmail.getText().toString();
        nombre = etNombre.getText().toString();
        mensaje = etMensaje.getText().toString();



        //envío email con JavaMail, pero hay que cambiar configuración de envío (host, usuario, contraseña, etc)
        //envío con Gmail
        String host="smtp.gmail.com";
        String to= "januan@gmail.com"; //destinatario de los emails
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.stmp.user", to); //usuario email
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        String username = "user";
                        String password = "password"; //cambiar contraseña para que funcione
                        return new PasswordAuthentication(username, password);
                    }
                });
        // create a message
        try {
            MimeMessage msg = new MimeMessage(session);
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Mensaje de " + nombre);
            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress(email));
            msg.setText(mensaje);
            Transport transport = session.getTransport("smtp");
            transport.send(msg);
        }catch (MessagingException mex) {
            /*System.out.println("\n--Error enviando email");
            mex.printStackTrace();
            System.out.println();
            Exception ex = mex;
            do {
                if (ex instanceof SendFailedException) {
                    SendFailedException sfex = (SendFailedException)ex;
                    Address[] invalid = sfex.getInvalidAddresses();
                    if (invalid != null) {
                        System.out.println("    ** Invalid Addresses");
                        for (int i = 0; i < invalid.length; i++)
                            System.out.println("         " + invalid[i]);
                    }
                    Address[] validUnsent = sfex.getValidUnsentAddresses();
                    if (validUnsent != null) {
                        System.out.println("    ** ValidUnsent Addresses");
                        for (int i = 0; i < validUnsent.length; i++)
                            System.out.println("         "+validUnsent[i]);
                    }
                    Address[] validSent = sfex.getValidSentAddresses();
                    if (validSent != null) {
                        System.out.println("    ** ValidSent Addresses");
                        for (int i = 0; i < validSent.length; i++)
                            System.out.println("         "+validSent[i]);
                    }
                }
                System.out.println();
                if (ex instanceof MessagingException)
                    ex = ((MessagingException)ex).getNextException();
                else
                    ex = null;
            } while (ex != null);
            */
            Toast.makeText(getBaseContext(),  "Error enviando email de "+nombre + " con mensaje " + mensaje + " a " + to, Toast.LENGTH_LONG).show();
        }

        //Toast.makeText(getBaseContext(),  nombre + "con email "+email+" envía " + mensaje + " a " + to, Toast.LENGTH_LONG).show();
        /*
        Intent sendIntent = new Intent((Intent.ACTION_SEND));
        sendIntent.setData(Uri.parse("mailto:"));
        sendIntent.putExtra(Intent.EXTRA_EMAIL, to);
        sendIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Comentario de  " + nombre);
        sendIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(sendIntent, "Enviar email a través de:"));
        */
    }



}