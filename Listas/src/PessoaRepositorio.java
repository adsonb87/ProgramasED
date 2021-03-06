import Exceptions.ObjetoJaExistenteException;
import Exceptions.ObjetoNaoExistenteException;

public class PessoaRepositorio implements IListaEstatica{

	
	private static final int MAX_LIST = 100	;
	
	private Pessoa[] pessoas = new Pessoa[MAX_LIST];
	
	private int tamanhoLista = 0;
	
	@Override
	public void inserir(Object object) throws ObjetoJaExistenteException {
		Pessoa p = (Pessoa) object;
		
		if(localizarIndice(p) == -1){
			int i=0;
			for(i=0;i<pessoas.length;i++){
				if(pessoas[i]==null){
					pessoas[i]=p;
					incrementaTamanho();
					break;
				}
			}
			if(i==pessoas.length){
				throw new RuntimeException("Repositorio esta cheio");
			}else{
				throw new ObjetoJaExistenteException();
			}
		}
	}

	@Override
	public void remover(Object object) throws ObjetoNaoExistenteException {
		int posicao = localizarIndice(object);
		if(posicao == -1){
			throw new ObjetoNaoExistenteException();
		}else{
			pessoas[posicao]=null;
			decrementaTamanho();
		}
		
	}

	@Override
	public int localizarIndice(Object object) {
		for(int i=0;i<pessoas.length;i++){
			if(pessoas[i]!=null && pessoas[i].getCpf().equals(((Pessoa) object).getCpf())){
				return i;
			}
		}
		return -1;
	}

	@Override
	public Object pesquisarPorValor(Object object) throws ObjetoNaoExistenteException {
		int posicao = localizarIndice(object);
		if(posicao == -1){
			throw new ObjetoNaoExistenteException();
		}else{
			return pessoas[posicao];
		}
	}

	@Override
	public void alterar(Object object) throws ObjetoNaoExistenteException {
		int posicao = localizarIndice(object);
		if(posicao == -1){
			throw new ObjetoNaoExistenteException();
		}else{
			pessoas[posicao] = (Pessoa)object;
		}		
	}

	private void incrementaTamanho(){
		setTamanhoLista(getTamanhoLista()+1);
	}
	
	private void decrementaTamanho(){
		setTamanhoLista(getTamanhoLista()+1);
	}
	
	public int getTamanhoLista(){
		return tamanhoLista;
	}
	
	public void setTamanhoLista(int tamanhoLista){
		this.tamanhoLista = tamanhoLista;
	}
	
	
	
}
