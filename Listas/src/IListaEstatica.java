import Exceptions.ObjetoJaExistenteException;
import Exceptions.ObjetoNaoExistenteException;

public interface IListaEstatica {
	
	public void inserir (Object object) throws ObjetoJaExistenteException;
	public void remover (Object object) throws ObjetoNaoExistenteException;
	public int localizarIndice (Object object);
	public Object pesquisarPorValor(Object object) throws ObjetoNaoExistenteException;
	public void alterar (Object object) throws ObjetoNaoExistenteException;
}
