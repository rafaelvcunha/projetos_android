package br.com.rafaelvcunha.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.rafaelvcunha.agenda.modelo.Aluno;

/**
 * Created by rafael on 18/10/17.
 */

public class FormularioHelper extends FormularioActivity {

    private Aluno aluno;

    private EditText campoNome;
    private EditText campoEndereco;
    private EditText campoTelefone;
    private EditText campoSite;
    private RatingBar campoNota;

    public FormularioHelper(FormularioActivity activity) {
        this.aluno = new Aluno();

        this.campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        this.campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        this.campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        this.campoSite = (EditText) activity.findViewById(R.id.formulario_site);
        this.campoNota = (RatingBar) activity.findViewById(R.id.formulario_ratingbar);
    }

    public Aluno pegaAluno(){
        //Aluno aluno = new Aluno();
        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereço(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));
        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        this.aluno.setId(aluno.getId());
        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereço());
        campoTelefone.setText(aluno.getTelefone());
        campoSite.setText(aluno.getSite());
        campoNota.setProgress(aluno.getNota().intValue());
        this.aluno = aluno;
    }
}
