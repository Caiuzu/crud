package br.com.simple.crud.cucumber.step;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class Steps {

    @Dado("que realizado um POST no endpoint de estudante")
    public void thatPerformedAPostOnTheStudentEndpoint() {
    }

    @Quando("preenchida o requisição com os dados de cadastro")
    public void preenchidaORequisiçãoComOsDadosDeCadastro() {
    }

    @E("enviada a requisição HTTP")
    public void enviadaARequisiçãoHTTP() {
    }

    @Então("deverá ser recebido uma resposta válida")
    public void deveráSerRecebidoUmaRespostaVálida() {
    }
}
