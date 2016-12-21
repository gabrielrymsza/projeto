package rafael.couto.com.monitoriaseletortimes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    private TextView tvc1;
    private TextView tvc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvc1 = (TextView) findViewById(R.id.tv_c1);
        tvc2 = (TextView) findViewById(R.id.tv_c2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// de verdade <<<
        Cliente c1 = (Cliente) getIntent().getSerializableExtra("c1");
        Cliente c2 = (Cliente) getIntent().getSerializableExtra("c2");
        tvc1.setText(c1.toString());
        tvc2.setText(c2.toString());

    }

}
