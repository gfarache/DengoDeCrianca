package br.com.dengodecrianca.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Idade {
	public static String dataAtual() {
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		formatador.format(data);
		
		return data.toString();
	}
	
	public int calculaIdade(String dt_nasc) {

	    // Data de hoje.  
	    GregorianCalendar hoje = new GregorianCalendar();
	    int diaH = hoje.get(Calendar.DAY_OF_MONTH);
	    int mesH = hoje.get(Calendar.MONTH) + 1;
	    int anoH = hoje.get(Calendar.YEAR);

	    // Data do nascimento.
	    int diaN = Integer.valueOf(dt_nasc.substring(0,2));
	    int mesN = Integer.valueOf(dt_nasc.substring(3,5));
	    int anoN = Integer.valueOf(dt_nasc.substring(6,10));

	    // Idade.
	    int idade;

	    if (mesN < mesH || (mesN == mesH && diaN <= diaH))
	        idade = anoH - anoN;
	    else
	        idade = (anoH - anoN) - 1;

	    return (idade);
	}
}
