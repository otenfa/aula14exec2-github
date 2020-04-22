package entities;

public class PessoaJuridica extends Contribuinte{

	private Integer numeroDeFuncionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String name, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(name, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	public Integer getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double impostoPago() {
		double valor = 0.0;
		if (numeroDeFuncionarios > 10) {
			valor = super.getRendaAnual() * 0.14;
		} else {
			valor = super.getRendaAnual() * 0.16;
		}
		return valor;
	}
	
}
