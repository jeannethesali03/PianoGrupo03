package sv.edu.catolica.pianogrupo03;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PianoInfantil extends PianoTradicional {

    private Toast ultimoToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piano_infantil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void sonarSonido(String tecla) {
        MediaPlayer sonido;

        switch (tecla) {
            case "PERIQUITO":
                sonido = MediaPlayer.create(this, R.raw.sonido_periquito);
                break;
            case "PERRITO":
                sonido = MediaPlayer.create(this, R.raw.sonido_perrito);
                break;
            case "ELEFANTITO":
                sonido = MediaPlayer.create(this, R.raw.sonido_elefante);
                break;
            case "GATITO":
                sonido = MediaPlayer.create(this, R.raw.sonido_gatitio);
                break;
            case "CUYO":
                sonido = MediaPlayer.create(this, R.raw.sonido_cuyo);
                break;
            case "CULEBRA":
                sonido = MediaPlayer.create(this, R.raw.sonido_culebra);
                break;
            case "POLLITO":
                sonido = MediaPlayer.create(this, R.raw.sonido_pollito);
                break;
            case "TIGRITO":
                sonido = MediaPlayer.create(this, R.raw.sonido_tigrito);
                break;
            default:
                return;
        }

        if (sonido != null) {
            sonido.setOnCompletionListener(mp -> {
                mp.release();
            });
            sonido.start();
        }
    }

    //Metodo para evitar que queden notificaciones de Toast en cola,
    //especialmente al salir.
    private void mostrarToast(String mensaje) {
        if (ultimoToast != null) {
            ultimoToast.cancel(); // Cancela el Toast anterior
        }
        ultimoToast = Toast.makeText(this, mensaje, Toast.LENGTH_SHORT);
        ultimoToast.show();
    }
    public void SonarPeriquito(View view) {
        sonarSonido("PERIQUITO");
        mostrarToast("Periquito");
    }

    public void SonarPerrito(View view) {
        sonarSonido("PERRITO");
        mostrarToast("Perrito");
    }

    public void SonarElefantito(View view) {
        sonarSonido("ELEFANTITO");
        mostrarToast("Elefantito");
    }

    public void SonarGatito(View view) {
        sonarSonido("GATITO");
        mostrarToast("Gatito");
    }

    public void SonarCuyo(View view) {
        sonarSonido("CUYO");
        mostrarToast("Cuyo");
    }

    public void SonarCulebra(View view) {
        sonarSonido("CULEBRA");
        mostrarToast("Serpiente");
    }

    public void SonarPollito(View view) {
        sonarSonido("POLLITO");
        mostrarToast("Pollito");
    }

    public void SonarTigrito(View view) {
        sonarSonido("TIGRITO");
        mostrarToast("Tigrito");
    }
}