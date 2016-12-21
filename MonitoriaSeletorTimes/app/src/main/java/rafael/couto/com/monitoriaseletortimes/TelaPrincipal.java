package rafael.couto.com.monitoriaseletortimes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class TelaPrincipal extends AppCompatActivity {


    private EditText etNome;
    private EditText etIdade;
    private Spinner spEstadoCivil;
    private Button btnOk;
    private Button btnLimpar;
    private Button btnGerar;
    private ArrayAdapter<Cliente> adapter;
    private ListView ls;
    private ArrayList<Cliente> clientes;

    private Cliente cli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNome = (EditText) findViewById(R.id.tc_et_nome);
        etIdade = (EditText) findViewById(R.id.tc_et_idade);
        spEstadoCivil = (Spinner) findViewById(R.id.tc_spin_estado);
        btnOk = (Button) findViewById(R.id.tc_btn_ok);
        btnLimpar = (Button) findViewById(R.id.tc_btn_limpar);
        btnGerar = (Button) findViewById(R.id.tc_btn_gerar);
        ls = (ListView) findViewById(R.id.tc_lv_pessoas);

        clientes = new ArrayList<>();
        adapter = new ArrayAdapter<Cliente>(
                TelaPrincipal.this,android.R.layout.simple_list_item_1,clientes);
        ls.setAdapter(adapter);



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cli = new Cliente();
                cli.setNome(etNome.getText().toString());
                cli.setIdade(Integer.parseInt(etIdade.getText().toString()));
                cli.setEstCivil(spEstadoCivil.getSelectedItem().toString());
                clientes.add(cli);
                adapter.notifyDataSetChanged();
            }//fecha click
        });//fecha listener

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clientes.size()<2){
                    Toast.makeText(getBaseContext(),"NUM TEM NINGUÉM, FIH",Toast.LENGTH_SHORT).show();
                }else{
                    Cliente c1;
                    Cliente c2;

                    do{
                        c1 = clientes.get(gerarAleatorio());
                        c2 = clientes.get(gerarAleatorio());
                    }while(c1 == c2);

                    Intent it = new Intent(TelaPrincipal.this, Tela2.class);
                    it.putExtra("c1",c1);
                    it.putExtra("c2",c2);
                    startActivity(it);
                }// Fim do if
            }// Fecha onClick
        });// Fecha setOnClickListener

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientes.clear();
                adapter.notifyDataSetChanged();
            }
        });

    }//x onCreate

    private int gerarAleatorio(){
        Random randon = new Random();
        return randon.nextInt(clientes.size());
    }// Fecha gerarAleatorio
}//x class
