package ch.beerpro.presentation.profile;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Spinner;
import butterknife.BindView;
import ch.beerpro.MyApplication;
import ch.beerpro.presentation.MainActivity;
import ch.beerpro.presentation.utils.ThemeChanger;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import ch.beerpro.R;

public class ThemeSettings extends AppCompatActivity {
    Spinner spThemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeChanger.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_theme_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupSpinnerItemSelection();

     }

    private void setupSpinnerItemSelection() {
        spThemes = (Spinner)findViewById(R.id.spThemes);
        spThemes.setSelection(MyApplication.currentPosition);
        MyApplication.currentPosition = spThemes.getSelectedItemPosition();

        spThemes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if (MyApplication.currentPosition != position) {
                    ThemeChanger.changeToTheme(ThemeSettings.this, position);
                }
                MyApplication.currentPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}
