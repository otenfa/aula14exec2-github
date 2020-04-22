package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double totalImposto = 0.0;
		
		List<Contribuinte> list = new ArrayList<>();
		
		System.out.print("Número de contribuintes: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println();
			System.out.print("Informe o nome: ");
			String name = sc.next();
			System.out.print("Informe a renda anual: ");
			double rendaAnual = sc.nextDouble();
			System.out.print("Qual o tipo do contrubuinte? pessoa [F]ísica ou [J]urídica? ");
			char ch = sc.next().charAt(0);
			if (ch == 'F') {
				System.out.print("Informe os gastos com saúde: ");
				double gastosComSaude = sc.nextDouble();
				list.add(new PessoaFisica(name, rendaAnual, gastosComSaude));
			} else {
				System.out.print("Informe onúmero de funcionários: ");
				int numeroDeFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(name, rendaAnual, numeroDeFuncionarios));
			}
		}
		
		System.out.println();
		System.out.println("LISTA DE CONTRIBUINTES");
		for (Contribuinte c : list) {
			totalImposto += c.impostoPago();
			System.out.println();
			System.out.printf(c.getName() + " - Imposto pago $ " + String.format("%.2f", c.impostoPago()));
		}
		System.out.println();
		System.out.println();
		System.out.println("TOTA DE IMPOSTOS PAGOS: $ " + String.format("%.2f", totalImposto));
						
		sc.close();

	}

}
