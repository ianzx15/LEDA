package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorInverso;
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorFatia;
	private Integer[] vetorUnitario;
	private Integer[] vetorOrdenadoCrescente;
	private Integer[] vetorOrdenadoDecrescente;
	private Integer[] vetorParZero;
	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorInverso(new Integer[] {35,5,22,18,15,1});
		popularFatia(new Integer[] {35,5,22,18,15,1});
		popularVetorUnitario(new Integer[] {1});
		popularVetorOrdenadoCrescente(new Integer[] {1,2,3,4,5});
		popularVetorOrdenadoDecrescente(new Integer[] {5,4,3,2,1});
		popularVetorParZero(new Integer[] {0,0});
		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new QuickSortMedianOfThree<>();
	}
	public void popularVetorOrdenadoCrescente(Integer[] arrayPadrao){
		this.vetorOrdenadoCrescente = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	public void popularVetorOrdenadoDecrescente(Integer[] arrayPadrao){
		this.vetorOrdenadoDecrescente = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	public void populaVetorInverso(Integer[] arrayPadrao){
		this.vetorInverso = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void popularVetorUnitario(Integer[] arrayPadrao){
		this.vetorUnitario = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void popularFatia(Integer[] arrayPadrao) {
		this.vetorFatia = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void popularVetorParZero(Integer[] arraryPadrao){
		this.vetorParZero = Arrays.copyOf(arraryPadrao, arraryPadrao.length);
	}
	public void fatiaTeste(Integer[] array){
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(vetorFatia,1,4);
		Arrays.sort(copy1,1,5);
		Assert.assertArrayEquals(copy1, array);

	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE


	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	public void testSort06() {
		genericTest(vetorInverso);
	}


	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	@Test
	public void testSort07() {
		fatiaTeste(vetorFatia);
	}

	@Test
	public void testSort09() {
		genericTest(vetorUnitario);
	}

	@Test
	public void testSort10() {
		genericTest(vetorOrdenadoCrescente);
	}

	@Test
	public void testSort11() {
		genericTest(vetorOrdenadoDecrescente);
	}

	@Test
	public void testSort12() {genericTest(vetorParZero);}
}