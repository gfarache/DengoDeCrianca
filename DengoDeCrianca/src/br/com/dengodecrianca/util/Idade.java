package br.com.dengodecrianca.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.Years;

public class Idade {
	public static String dataAtual() {
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		formatador.format(data);

		return data.toString();
	}

	public String calculaIdade(String dt_nasc) {
		// Data de hoje.
		GregorianCalendar dataAtual = new GregorianCalendar();
		int diaH = dataAtual.get(Calendar.DAY_OF_MONTH);
		int mesH = dataAtual.get(Calendar.MONTH) + 1;
		int anoH = dataAtual.get(Calendar.YEAR);

		// Data do nascimento.
		int diaN = Integer.valueOf(dt_nasc.substring(0, 2));
		int mesN = Integer.valueOf(dt_nasc.substring(3, 5));
		int anoN = Integer.valueOf(dt_nasc.substring(6, 10));
		
		DateTime nasc = new DateTime(anoN, mesN, diaN, 0, 0, 0, 0);
		DateTime hoje = new DateTime(anoH, mesH, diaH, 0, 0, 0, 0);
		
		int anos = Years.yearsBetween(nasc, hoje).getYears();
		int meses = Months.monthsBetween(nasc, hoje).getMonths();
		
		if (anos > 0) {
			if (anos == 1) {
				return Integer.toString(anos) +" ano";
			} else {
				return Integer.toString(anos) +" anos";
			}
		} else {
			if (meses == 1) {
				return Integer.toString(meses) + " mês";
			} else {
				return Integer.toString(meses) + " meses";
			}
		}
	}
}
