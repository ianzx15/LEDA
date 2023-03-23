package vetor;

import java.util.Comparator;
import java.util.List;
/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor < T extends Comparable<T>>{
	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.arrayInterno = (T[]) new Comparable[tamanho];
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	public T maximo(){
		int maior = 0;
		for (int i = 0; i <= arrayInterno.length; i ++){
			if (this.arrayInterno[i] > maior){

			}
		}

	}



	// Insere um objeto no vetor
	public void inserir(T o) {
		this.arrayInterno[++indice] = o;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		T result = null;
		boolean achou = false;
		int i = 0;
		while (i <= indice && !achou) {
			if (arrayInterno[i].equals(o) && this.arrayInterno[i] != null) {
				result = arrayInterno[i];
				arrayInterno[i] = arrayInterno[indice];
				arrayInterno[indice] = null;
				indice--;
				achou = true;
			}
			i++;
		}
		return result;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		T elemento = null;
		boolean achou = false;
		int i = 0;
		while (!achou && i <= this.arrayInterno.length) {
			if (this.arrayInterno[i].equals(o)){
				elemento = o;
				achou = true;
			}
			i ++;
		}
		return elemento;
	}
	// Diz se o vetor está vazio
	public boolean isVazio() {
	return	this.indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.arrayInterno[-1] != null;
	}

}
