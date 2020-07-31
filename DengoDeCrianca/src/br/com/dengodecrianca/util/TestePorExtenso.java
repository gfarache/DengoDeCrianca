package br.com.dengodecrianca.util;

import java.math.BigDecimal;

public class TestePorExtenso {

	public static void main(String[] args) {
		CurrencyWriter cw = CurrencyWriter.getInstance();

		String extenso = cw.write(new BigDecimal("7821234.89"));
		System.out.println(extenso);

		extenso = cw.write(new BigDecimal("130000000.34"));
		System.out.println(extenso);
	}

}
