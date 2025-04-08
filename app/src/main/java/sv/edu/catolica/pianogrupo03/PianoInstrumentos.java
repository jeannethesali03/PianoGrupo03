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

public class PianoInstrumentos extends AppCompatActivity {

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


    public void SonarArpa(View view) {
        sonarSonido("ARPA");
        Toast.makeText(this, "Arpa", Toast.LENGTH_SHORT).show();
    }

    public void SonarViolin(View view) {
        sonarSonido("VIOLIN");
        Toast.makeText(this, "Violin", Toast.LENGTH_SHORT).show();
    }

    public void SonarGuitarra(View view) {
        sonarSonido("GUITARRA");
        Toast.makeText(this, "Guitarra", Toast.LENGTH_SHORT).show();
    }

    public void SonarBateria(View view) {
        sonarSonido("BATERIA");
        Toast.makeText(this, "Bateria", Toast.LENGTH_SHORT).show();
    }

    public void SonarSaxofon(View view) {
        sonarSonido("SAXOFON");
        Toast.makeText(this, "Saxofon", Toast.LENGTH_SHORT).show();
    }

    public void SonarTrompeta(View view) {
        sonarSonido("TROMPETA");
        Toast.makeText(this, "Trompeta", Toast.LENGTH_SHORT).show();
    }

    public void SonarAcordeon(View view) {
        sonarSonido("ACORDEON");
        Toast.makeText(this, "Acordeon", Toast.LENGTH_SHORT).show();
    }

    public void SonarClarinete(View view) {
        sonarSonido("CLARINETE");
        Toast.makeText(this, "Clarinete", Toast.LENGTH_SHORT).show();
    }
}