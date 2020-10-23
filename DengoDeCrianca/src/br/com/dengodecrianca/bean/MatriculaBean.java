package br.com.dengodecrianca.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "MBMatricula")
@SessionScoped
public class MatriculaBean {
	
	public void novaMatricula(AlunoBean aluno, FiliacaoBean filiacao, ResponsavelFinanceiroBean responsavel, SelectBooleanView checkbox) {
		
		System.out.println("Dados do Aluno: ");
		System.out.println("--> Nome\t\t\t\t\t"+aluno.getAluno().getNome());
		System.out.println("--> Data Nascimento\t\t\t\t"+aluno.getAluno().getDataNascimento());
		System.out.println("--> Série\t\t\t\t\t"+aluno.getSerie());
		System.out.println("--> RG\t\t\t\t\t\t"+aluno.getAluno().getRg());
		System.out.println("--> CPF\t\t\t\t\t\t"+aluno.getAluno().getCpf());
		System.out.println("--> Sexo\t\t\t\t\t"+aluno.getAluno().getSexo());
		System.out.println("--> Turno\t\t\t\t\t"+aluno.getAluno().getTurno());
		System.out.println("--> Mensalidade\t\t\t\t\t"+aluno.getResponsavel().getMensalidade());
		System.out.println("\nDados dos Pais:");
		System.out.println("--> Nome da Mãe\t\t\t\t\t"+filiacao.getFiliacao().getNomeMae());
		System.out.println("--> Nome do Pai\t\t\t\t\t"+filiacao.getFiliacao().getNomePai());
		System.out.println("\nDados do Responsável Financeiro:");
		if (checkbox.isMaeRespFin()) {
			responsavel.getRespFin().setParentesco("Mãe");
			responsavel.getRespFin().setNome(filiacao.getFiliacao().getNomeMae());
		} else if (checkbox.isPaiCheck() && checkbox.isPaiRespFin()) {
			responsavel.getRespFin().setParentesco("Pai");
			responsavel.getRespFin().setNome(filiacao.getFiliacao().getNomePai());
		}
		System.out.println("--> Nome\t\t\t\t\t"+responsavel.getRespFin().getNome());
		System.out.println("--> Parentesco\t\t\t\t\t"+responsavel.getRespFin().getParentesco());
		System.out.println("--> CPF\t\t\t\t\t\t"+responsavel.getRespFin().getCpf());
		System.out.println("--> RG\t\t\t\t\t\t"+responsavel.getRespFin().getRg());
		System.out.println("--> Endereço\t\t\t\t\t"+responsavel.getRespFin().getEndereco());
		System.out.println("--> Numero\t\t\t\t\t"+responsavel.getRespFin().getNumero());
		System.out.println("--> Bairro\t\t\t\t\t"+responsavel.getRespFin().getBairro());
		System.out.println("--> Complemento\t\t\t\t\t"+responsavel.getRespFin().getComplemento());
		System.out.println("--> Município\t\t\t\t\t"+responsavel.getRespFin().getMunicipio());
		System.out.println("--> UF\t\t\t\t\t\t"+responsavel.getRespFin().getUf());
		System.out.println("--> CEP\t\t\t\t\t\t"+responsavel.getRespFin().getCep());
		System.out.println("--> Telefone\t\t\t\t\t"+responsavel.getRespFin().getTelefone());
		System.out.println("--> E-mail\t\t\t\t\t"+responsavel.getRespFin().getEmail());
		System.out.println();
		System.out.println();
		
		
	}
}
