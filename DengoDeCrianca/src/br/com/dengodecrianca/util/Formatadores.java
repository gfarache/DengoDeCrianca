package br.com.dengodecrianca.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class Formatadores {

	public String formataDataeHora(String datetime, boolean data, boolean hora) {
		String ano = datetime.substring(0, 4);
		String mes = datetime.substring(5, 7);
		String dia = datetime.substring(8, 10);
		String horas = datetime.substring(11, 13);
		String minutos = datetime.substring(14, 16);

		if ((data) && (!hora)) {
			return dia + "/" + mes + "/" + ano;
		} else if ((!data) && (hora)) {
			return horas + ":" + minutos;
		} else {
			return dia + "/" + mes + "/" + ano + "-" + horas + ":" + minutos;
		}
	}

	public static String getAnoAtual(Date data) {
		SimpleDateFormat formatoTela = new SimpleDateFormat("yyyy");
		return formatoTela.format(data);
	}

	public static String getMesAtual(Date data) {
		SimpleDateFormat formatoTela = new SimpleDateFormat("MM");
		return formatoTela.format(data);
	}

	public static String getDiaAtual(Date data) {
		SimpleDateFormat formatoTela = new SimpleDateFormat("dd");
		return formatoTela.format(data);
	}

	public static String formataDataToBanco(String data) {

		SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatoTela = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormat = "";

		try {
			if (data != null && !data.equals("")) {
				dataFormat = formatoBanco.format(formatoTela.parse(data));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataFormat;
	}

	public static String getHoraCompletaServidorToBanco() {
		SimpleDateFormat formatoHora = new SimpleDateFormat("HHmmss");
		return formatoHora.format(new Date());
	}

	public static String formataHoraToTela(String hora) {
		if ((hora != null) && (hora.length() == 4)) {
			return hora.substring(0, 2) + ":" + hora.substring(2, 4);
		} else if ((hora != null) && (hora.length() == 6)) {
			return hora.substring(0, 2) + ":" + hora.substring(2, 4) + ":" + hora.substring(4, 6);
		}
		return "";
	}

	public static boolean validaCpfCnpj(String cpfCnpj) {
		if (StringUtils.isNotBlank(cpfCnpj)) {
			if (cpfCnpj.length() == 11) {
				return validaCpf(cpfCnpj);
			} else if (cpfCnpj.length() == 14) {
				return validaCnpj(cpfCnpj);
			}
		}
		return false;
	}

	public static boolean validaCpf(String cpf) {

		if (cpf.length() == 11) {
			cpf = tiraFormatoCpf(cpf);
			int d1, d2;
			int digito1, digito2, resto;
			int digitoCPF;
			String nDigResult;
			d1 = d2 = 0;
			digito1 = digito2 = resto = 0;
			for (int n_Count = 1; n_Count < cpf.length() - 1; n_Count++) {
				digitoCPF = Integer.valueOf(cpf.substring(n_Count - 1, n_Count)).intValue();

				d1 = d1 + (11 - n_Count) * digitoCPF;

				d2 = d2 + (12 - n_Count) * digitoCPF;
			}

			resto = (d1 % 11);

			if (resto < 2)
				digito1 = 0;
			else
				digito1 = 11 - resto;
			d2 += 2 * digito1;

			resto = (d2 % 11);

			if (resto < 2)
				digito2 = 0;
			else
				digito2 = 11 - resto;

			String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

			nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

			return nDigVerific.equals(nDigResult);
		} else {
			return false;
		}
	}

	public static boolean validaCnpj(String cnpj) {

		if (cnpj.length() == 14) {
			cnpj = tiraFormatoCnpj(cnpj);
			int soma = 0, dig;
			String cnpj_calc = cnpj.substring(0, 12);
			char[] chr_cnpj = cnpj.toCharArray();

			for (int i = 0; i < 4; i++)
				if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
					soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
			for (int i = 0; i < 8; i++)
				if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9)
					soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
			dig = 11 - (soma % 11);
			cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

			soma = 0;
			for (int i = 0; i < 5; i++)
				if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
					soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
			for (int i = 0; i < 8; i++)
				if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9)
					soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
			dig = 11 - (soma % 11);
			cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);
			return cnpj.equals(cnpj_calc);
		} else {
			return false;
		}
	}

	public static String tiraFormatoCpf(String cpf) {
		return cpf.replaceAll("[.]", "").replaceAll("[-]", "");
	}

	public static String tiraFormatoCnpj(String cnpj) {
		return cnpj.replaceAll("[.]", "").replaceAll("[/]", "").replaceAll("-", "");
	}

	public static String colocaFormatoCpf(String cpf) {
		if (validaCpf(cpf) && cpf.length() == 11) {
			StringBuffer sb = new StringBuffer(cpf);
			sb.insert(3, ".");
			sb.insert(7, ".");
			sb.insert(11, "-");
			return sb.toString();
		}
		return null;
	}

	public static String colocaFormatoCnpj(String cnpj) {
		if (validaCnpj(cnpj) && cnpj.length() == 14) {
			StringBuffer sb = new StringBuffer(cnpj);
			sb.insert(2, ".");
			sb.insert(6, ".");
			sb.insert(10, "/");
			sb.insert(15, "-");
			return sb.toString();
		}
		return null;
	}

	public static String colocaFormato_CPF_CNPJ(String codigo) {
		if (codigo.length() == 11) {
			codigo = Formatadores.colocaFormatoCpf(codigo);
		} else if (codigo.length() == 14) {
			codigo = Formatadores.colocaFormatoCnpj(codigo);
		}
		return codigo;
	}

	public static void main(String[] args) {
		String a = getHoraCompletaServidorToBanco();
		Date data = new Date();
		String b = getAnoAtual(data);
		String c = getMesAtual(data);
		String d = getDiaAtual(data);
		System.out.println(d + "/" + c + "/" + b + " - " + formataHoraToTela(a));
	}
}
