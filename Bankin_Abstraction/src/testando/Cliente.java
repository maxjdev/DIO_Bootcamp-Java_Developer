package testando;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {
	private String nome;
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

}
