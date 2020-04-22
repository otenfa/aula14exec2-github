package entities;

public class PessoaFisica extends Contribuinte{

	private Double gastosComSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String name, Double rendaAnual, Double gastosComSaude) {
		super(name, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public double impostoPago() {
		double valor = 0.0;
		if (super.getRendaAnual() <= 20000.00 ) {
			valor = super.getRendaAnual() * 0.15;
		} else {
			valor = super.getRendaAnual() * 0.25;
		}
		if (gastosComSaude > 0.0) {
			valor -= gastosComSaude * 0.50;
		}
		return valor;
	}
	
}
