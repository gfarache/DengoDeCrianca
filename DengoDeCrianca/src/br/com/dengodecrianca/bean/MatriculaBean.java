package br.com.dengodecrianca.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "MBMatricula")
@SessionScoped
public class MatriculaBean {
	
	public void novaMatricula(AlunoBean aluno, FiliacaoBean filiacao, ResponsavelFinanceiroBean responsavel, SelectBooleanView checkbox) {
		
		System.out.println("Dados do Aluno: ");
		System.out.println("--> Nome			"+aluno.getAluno().getNome());
		System.out.println("--> Data Nascimento			"+aluno.getAluno().getDataNascimento());
		System.out.println("--> Série			");
		System.out.println("--> RG			"+aluno.getAluno().getRg());
		System.out.println("--> CPF			"+aluno.getAluno().getCpf());
		System.out.println("--> Sexo			"+aluno.getAluno().getSexo());
		System.out.println("--> Turno			"+aluno.getAluno().getTurno());
		System.out.println("--> Mensalidade			"+aluno.getResponsavel().getMensalidade());
		System.out.println("\nDados dos Pais:");
		System.out.println("--> Nome da Mãe			"+filiacao.getFiliacao().getNomeMae());
		System.out.println("--> Nome do Pai			"+filiacao.getFiliacao().getNomePai());
		System.out.println("\nDados do Responsável Financeiro:");
		if (checkbox.isMaeRespFin()) {
			responsavel.getRespFin().setParentesco("Mãe");
			responsavel.getRespFin().setNome(filiacao.getFiliacao().getNomeMae());
		} else if (checkbox.isPaiCheck() && checkbox.isPaiRespFin()) {
			responsavel.getRespFin().setParentesco("Pai");
			responsavel.getRespFin().setNome(filiacao.getFiliacao().getNomePai());
		}
		System.out.println("--> Nome			"+responsavel.getRespFin().getNome());
		System.out.println("--> Parentesco			"+responsavel.getRespFin().getParentesco());
		System.out.println("--> CPF			"+responsavel.getRespFin().getCpf());
		System.out.println("--> RG			"+responsavel.getRespFin().getRg());
		System.out.println("--> Endereço			"+responsavel.getRespFin().getEndereco());
		System.out.println("--> Numero			"+responsavel.getRespFin().getNumero());
		System.out.println("--> Bairro			"+responsavel.getRespFin().getBairro());
		System.out.println("--> Complemento			"+responsavel.getRespFin().getComplemento());
		System.out.println("--> Município			"+responsavel.getRespFin().getMunicipio());
		System.out.println("--> UF			"+responsavel.getRespFin().getUf());
		System.out.println("--> CEP			"+responsavel.getRespFin().getCep());
		System.out.println("--> Telefone			"+responsavel.getRespFin().getTelefone());
		System.out.println("--> E-mail			"+responsavel.getRespFin().getEmail());
		
		
		
	}
}
