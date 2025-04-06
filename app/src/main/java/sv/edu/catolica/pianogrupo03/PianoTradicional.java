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

public class PianoTradicional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piano_tradicional);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void sonarSonido(String tecla) {
        MediaPlayer sonido = null;

        switch (tecla) {
            case "DO":
                sonido = MediaPlayer.create(this, R.raw.do_sonido);
                break;
            case "DO_Sostenido":
                sonido = MediaPlayer.create(this, R.raw.do_sostenido_sonido);
                break;
            case "RE":
                sonido = MediaPlayer.create(this, R.raw.re_sonido);
                break;
            case "RE_Sostenido":
                sonido = MediaPlayer.create(this, R.raw.re_sostenido_sonido);
                break;
            case "MI":
                sonido = MediaPlayer.create(this, R.raw.mi_sonido);
                break;
            case "FA":
                sonido = MediaPlayer.create(this, R.raw.fa_sonido);
                break;
            case "FA_Sostenido":
                sonido = MediaPlayer.create(this, R.raw.fa_sostenido_sonido);
                break;
            case "SOL":
                sonido = MediaPlayer.create(this, R.raw.sol_sonido);
                break;
            case "SOL_Sostenido":
                sonido = MediaPlayer.create(this, R.raw.sol_sostenido_sonido);
                break;
            case "LA":
                sonido = MediaPlayer.create(this, R.raw.la_sonido);
                break;
            case "LA_Sostenido":
                sonido = MediaPlayer.create(this, R.raw.la_sostenido_sonido);
                break;
            case "SI":
                sonido = MediaPlayer.create(this, R.raw.si_sonido);
                break;
            default:
                return;
        }

        if (sonido != null) {
            if (sonido.isPlaying()) {
                sonido.stop();
            } else {
                try {
                    sonido.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void SonarDoSostenido(View view) {
        sonarSonido("DO_Sostenido");
        Toast.makeText(this, "Do Sostenido", Toast.LENGTH_SHORT).show();
    }

    public void SonarDo(View view) {
        sonarSonido("DO");
        Toast.makeText(this, "Do", Toast.LENGTH_SHORT).show();
    }

    public void SonarRe(View view) {
        sonarSonido("RE");
        Toast.makeText(this, "RE", Toast.LENGTH_SHORT).show();
    }

    public void SonarMi(View view) {
        sonarSonido("RE_Sostenido");
        Toast.makeText(this, "RE Sostenido", Toast.LENGTH_SHORT).show();
    }

    public void SonarFa(View view) {
        sonarSonido("FA");
        Toast.makeText(this, "FA", Toast.LENGTH_SHORT).show();
    }

    public void SonarSol(View view) {
        sonarSonido("SOL");
        Toast.makeText(this, "SOL", Toast.LENGTH_SHORT).show();
    }

    public void SonarLa(View view) {
        sonarSonido("LA");
        Toast.makeText(this, "LA", Toast.LENGTH_SHORT).show();
    }

    public void SonarSi(View view) {
        sonarSonido("SI");
        Toast.makeText(this, "SI", Toast.LENGTH_SHORT).show();
    }

    public void SonarReSostenido(View view) {
        sonarSonido("RE_Sostenido");
        Toast.makeText(this, "RE Sostenido", Toast.LENGTH_SHORT).show();
    }

    public void SonarFaSostenido(View view) {
        sonarSonido("FA_Sostenido");
        Toast.makeText(this, "FA Sostenido", Toast.LENGTH_SHORT).show();
    }

    public void SonarSolSostenido(View view) {
        sonarSonido("SOL_Sostenido");
        Toast.makeText(this, "SOL Sostenido", Toast.LENGTH_SHORT).show();
    }

    public void SonarLaSostenido(View view) {
        sonarSonido("LA_Sostenido");
        Toast.makeText(this, "LA Sostenido", Toast.LENGTH_SHORT).show();
    }
}