package br.com.dengodecrianca.util;

public class Formatadores {
	
	public String formataDataeHora(String datetime, boolean data, boolean hora) {
		String ano = datetime.substring(0, 4);
		String mes = datetime.substring(5, 7);
		String dia = datetime.substring(8, 10);
		String horas = datetime.substring(11,13);
		String minutos = datetime.substring(14,16);
		
		if ((data) && (!hora)){
			return dia+"/"+mes+"/"+ano;
		} else if ((!data) && (hora)) {
			return horas+":"+minutos;
		} else {
			return dia+"/"+mes+"/"+ano+"-"+horas+":"+minutos;
		}
	}
}
