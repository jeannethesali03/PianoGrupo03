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

public class PianoInstrumentos extends PianoTradicional {

    private Toast ultimoToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piano_instrumentos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void sonarSonido(String tecla) {
        MediaPlayer sonido;

        switch (tecla) {
            case "ARPA":
                sonido = MediaPlayer.create(this, R.raw.arpa_sonido);
                break;
            case "VIOLIN":
                sonido = MediaPlayer.create(this, R.raw.violin_sonido);
                break;
            case "GUITARRA":
                sonido = MediaPlayer.create(this, R.raw.guitarra_sonido);
                break;
            case "SAXOFON":
                sonido = MediaPlayer.create(this, R.raw.saxofon_sonido);
                break;
            case "BATERIA":
                sonido = MediaPlayer.create(this, R.raw.bateria_sonido);
                break;
            case "TROMPETA":
                sonido = MediaPlayer.create(this, R.raw.trompeta_sonido);
                break;
            case "ACORDEON":
                sonido = MediaPlayer.create(this, R.raw.acordeon_sonido);
                break;
            case "CLARINETE":
                sonido = MediaPlayer.create(this, R.raw.clarinete_sonido);
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
    public void SonarArpa(View view) {
        sonarSonido("ARPA");
        mostrarToast("Arpa");
    }

    public void SonarViolin(View view) {
        sonarSonido("VIOLIN");
        mostrarToast("Violin");
    }

    public void SonarGuitarra(View view) {
        sonarSonido("GUITARRA");
        mostrarToast("Guitarra");
    }

    public void SonarBateria(View view) {
        sonarSonido("BATERIA");
        mostrarToast("Bateria");
    }

    public void SonarSaxofon(View view) {
        sonarSonido("SAXOFON");
        mostrarToast("Saxofon");
    }

    public void SonarTrompeta(View view) {
        sonarSonido("TROMPETA");
        mostrarToast("Trompeta");
    }

    public void SonarAcordeon(View view) {
        sonarSonido("ACORDEON");
        mostrarToast("Acordeon");
    }

    public void SonarClarinete(View view) {
        sonarSonido("CLARINETE");
        mostrarToast("Clarinete");
    }
}