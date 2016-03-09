import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Pessoa {
	
	private String cpf;
	private String nome;
	
	public Pessoa(){
		
	}
	
	public Pessoa(String cpf, String nome){
		this.cpf = cpf.replaceAll("[.-]", "");
		this.nome = nome;
	}
	
	private String format(String pattern, Object value){
		MaskFormatter mask;
		try {
			mask = new MaskFormatter(pattern);
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(value);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public String getCpfFormatado(){
		return format("###.###.###-##",cpf);
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	
}
