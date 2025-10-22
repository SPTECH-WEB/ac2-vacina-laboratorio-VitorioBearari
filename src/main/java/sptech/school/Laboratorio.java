package sptech.school;

import sptech.school.exception.ArgumentoInvalidoException;
import sptech.school.exception.VacinaInvalidaException;
import sptech.school.exception.VacinaNaoEncontradaException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private String nome;
    private List<Vacina> vacinas;

    public Laboratorio(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void adicionarVacina(Vacina vacina){
        if(vacina == null){
            throw new VacinaInvalidaException("Vacina não pode ser nulo");
        }

        if(vacina.getCodigo().isEmpty()){
            throw new VacinaInvalidaException("Código não pode ser vazio");
        }

        if(vacina.getNome().isEmpty()){
            throw new VacinaInvalidaException("Nome não pode ser vazio");
        }

        if(vacina.getPreco() <= 0 || vacina.getPreco() == null){
            throw new VacinaInvalidaException("Preço inválido (maior que zero e diferente de nulo)");
        }

        if(vacina.getEficacia() < 0 || vacina.getEficacia() > 5 ||
                vacina.getEficacia() == null){
            throw new VacinaInvalidaException("Eficacia inválida (0-5 e diferente de nulo)");
        }

        if(vacina.getDataLancamento() == null || vacina.getDataLancamento().isAfter(LocalDate.now())){
            throw new VacinaInvalidaException("Data inválida!");
        }

        vacinas.add(vacina);
    }

    public Vacina buscarVacinaPorCodigo(String codigo){
        if(codigo == null || codigo.isEmpty()){
            throw new ArgumentoInvalidoException("Código inválido");
        }

        for (int i = 0; i < vacinas.size() - 1; i++) {
            if(vacinas.get(i).getCodigo().equals(codigo)){
                return vacinas.get(i);
            } else {
                throw new VacinaNaoEncontradaException("Vacina não encontrada");
            }
        }
        return null;
    }

    public Vacina removerVacinaPorCodigo(String codigo){
        if(codigo == null || codigo.isEmpty()){
            throw new ArgumentoInvalidoException("Código inválido");
        }

        for (int i = 0; i < vacinas.size() - 1; i++) {
            if(vacinas.get(i).getCodigo().equals(codigo)){
                vacinas.remove(vacinas.get(i));
                return vacinas.get(i);
            } else {
                throw new VacinaNaoEncontradaException("Vacina não encontrada");
            }
        }
        return null;
    }

    public Vacina buscarVacinaComMelhorEficacia(){
        if(vacinas.isEmpty()){
            throw new VacinaNaoEncontradaException("Lista de vacinas está vazia");
        }

        Vacina melhorEficacia = vacinas.getFirst();
        for (int i = 0; i < vacinas.size() - 1; i++) {
            if(vacinas.get(i).getEficacia() > melhorEficacia.getEficacia()){
                melhorEficacia = vacinas.get(i);
            } else if (vacinas.get(i).getEficacia().equals(melhorEficacia.getEficacia())) {
                if(vacinas.get(i).getDataLancamento().isAfter(melhorEficacia.getDataLancamento())){
                    melhorEficacia = vacinas.get(i);
                }
            }
        }
        return melhorEficacia;
    }

    public List<Vacina> buscarVacinaPorPeriodo(LocalDate dataInicio, LocalDate dataFim){
        if(dataInicio == null || dataFim == null || dataInicio.isAfter(dataFim)){
            throw new ArgumentoInvalidoException("Data inválida!");
        }

        List<Vacina> vacinasBusca = new ArrayList<>();

        for (int i = 0; i < vacinas.size() - 1; i++) {
            if(vacinas.get(i).getDataLancamento().isBefore(dataFim) && vacinas.get(i).getDataLancamento().isAfter(dataInicio)){
                vacinasBusca.add(vacinas.get(i));
            }
        }
        return vacinasBusca;
    }
}
