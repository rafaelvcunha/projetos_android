package br.com.rafaelvcunha.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.rafaelvcunha.agenda.dao.AlunoDAO;
import br.com.rafaelvcunha.agenda.modelo.Aluno;

import static br.com.rafaelvcunha.agenda.R.id.lista_alunos;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listaAlunos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        //String[] alunos = {"Rafael", "Mônica", "Soraia", "João"};
        /*
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        ListView lista_alunos = (ListView) findViewById(R.id.lista_alunos);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);
        lista_alunos.setAdapter(adapter);
        */
        Button btnNovoAluno = (Button) findViewById(R.id.listaAlunos_novoAluno);
        btnNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }

    public void carregarLista(){

        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();


        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }
}
