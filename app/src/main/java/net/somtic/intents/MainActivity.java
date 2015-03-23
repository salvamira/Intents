package net.somtic.intents;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void pgWeb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://campus.somtic.net/"));
        startActivity(intent);
    }

    public void llamadaTelefono(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:966870700"));
        startActivity(intent);
    }


    public void googleMaps(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:38.553468,-0.121579"));
        startActivity(intent);
    }

    public void hacerFoto(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void mandarCorreo(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "asunto");
        intent.putExtra(Intent.EXTRA_TEXT, "texto del correo");
        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[] {"smira@iesperemaria.com" });
        startActivity(intent);
    }

    // Realizar una búsqueda en google
    public void buscar(View view) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "IES Pere Maria Orts");
        startActivity(intent);
    }

    public void llamadaTelefono2(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:966870700"));
        startActivity(intent);
    }

    public void streetView(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("google.streetview:cbll=38.553468,-0.121579"));
        startActivity(intent);
    }

    // Compartir con ...
    public void compartir(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Compartido desde IES Pere Maria Orts");
        intent.setType("text/plain");
        String titulo = getResources().getString(R.string.btn_compartir);
        Intent chooser = Intent.createChooser(intent, titulo);
        if (chooser.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}
