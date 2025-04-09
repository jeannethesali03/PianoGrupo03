package sv.edu.catolica.pianogrupo03;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PianoTradicional extends AppCompatActivity {

    MediaPlayer sonido;
    private Toast ultimoToast;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.cambiarPiano) {
            final String[] pianos = {"Piano Tradicional", "Piano Infantil", "Piano de Instrumentos"};
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
            builder3.setTitle("Elige un Piano");
            builder3.setItems(pianos, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    switch (pianos[i]) {
                        case "Piano Tradicional": {
                            liberarRecursos();
                            finish();
                            Intent intent = new Intent(PianoTradicional.this, PianoTradicional.class);
                            startActivity(intent);
                            break;
                        }
                        case "Piano Infantil": {
                            liberarRecursos();
                            finish();
                            Intent intent = new Intent(PianoTradicional.this, PianoInfantil.class);
                            startActivity(intent);
                            break;
                        }
                        case "Piano de Instrumentos": {
                            liberarRecursos();
                            finish();
                            Intent intent = new Intent(PianoTradicional.this, PianoInstrumentos.class);
                            startActivity(intent);
                            break;
                        }
                        default:
                            break;
                    }
                    Toast mensajito = Toast.makeText(getApplicationContext(),
                            pianos[i], Toast.LENGTH_SHORT);
                    mensajito.show();
                }
            });
            builder3.create();
            builder3.show();
        } else if (item.getItemId() == R.id.acercaDe) {
            liberarRecursos();
            finish();
            Intent intent = new Intent(PianoTradicional.this, AcercaDe.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.salir) {
            // Libera recursos como MediaPlayer si están en uso
            liberarRecursos();

            // Finaliza todas las actividades
            finishAffinity();

            // Detiene el proceso de la aplicación
            System.exit(0);
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    
    private void liberarRecursos() {
        if (sonido != null) {
            try {
                if (sonido.isPlaying() || sonido.getCurrentPosition() > 0) {
                    sonido.stop(); // Detiene la reproducción si está activa o en cola
                }
                sonido.reset(); // Resetea el MediaPlayer para evitar problemas
                sonido.release(); // Libera los recursos del MediaPlayer
            } catch (IllegalStateException e) {
                e.printStackTrace(); // Maneja cualquier excepción inesperada
            } finally {
                sonido = null; // Asegúrate de que el objeto se establezca en null
            }
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
    private void sonarSonido(String tecla) {


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
            sonido.setOnCompletionListener(mp -> {
                mp.release();
            });
            sonido.start();
        }
    }


    public void SonarDoSostenido(View view) {
        sonarSonido("DO_Sostenido");
        mostrarToast("Do Sostenido");
    }

    public void SonarDo(View view) {
        sonarSonido("DO");
        mostrarToast("Do");
    }

    public void SonarRe(View view) {
        sonarSonido("RE");
        mostrarToast("RE");
    }

    public void SonarMi(View view) {
        sonarSonido("MI");
        mostrarToast("MI");
    }

    public void SonarFa(View view) {
        sonarSonido("FA");
        mostrarToast("FA");
    }

    public void SonarSol(View view) {
        sonarSonido("SOL");
        mostrarToast("SOL");
    }

    public void SonarLa(View view) {
        sonarSonido("LA");
        mostrarToast("LA");
    }

    public void SonarSi(View view) {
        sonarSonido("SI");
        mostrarToast("SI");
    }

    public void SonarReSostenido(View view) {
        sonarSonido("RE_Sostenido");
        mostrarToast("RE Sostenido");
    }

    public void SonarFaSostenido(View view) {
        sonarSonido("FA_Sostenido");
        mostrarToast("FA Sostenido");
    }

    public void SonarSolSostenido(View view) {
        sonarSonido("SOL_Sostenido");
        mostrarToast("SOL Sostenido");
    }

    public void SonarLaSostenido(View view) {
        sonarSonido("LA_Sostenido");
        mostrarToast("LA Sostenido");
    }
}
