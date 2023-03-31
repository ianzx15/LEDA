package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array, int indice){
		int result = 0;
		int size = array.length - 1;
		if (indice >= 0){
			result += calcularSomaArray(array, indice - 1) + array[indice];
		}
		return  result;
	}

	public int calcularSomaArray(int[] array1){
		int result = 0;
		result = calcularSomaArray(array1, array1.length-1);
		return result;
	}
	public long calcularFatorial(int n) {
		long result = 1;
		if (n > 0){
			result = n * calcularFatorial(n - 1);
		}
		 System.out.println(n + "! = " + result);
		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		if (n > 2){
			result = calcularFibonacci(n-1) + calcularFibonacci(n - 2);
		}
		return result;
	}

	public int countNotNull(Object[] array, int indice){
		int result = 0;
		int size = array.length - 1;
		if (indice >= 0){
			result += countNotNull(array, indice - 1);
		if (array[indice] == null)
			return result += 1;
		}
		return  result;
	}
	public int countNotNull(Object[] array) {
		int result = 0;

		result = countNotNull(array, array.length -1);

		return result;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		if(expoente > 0){
			result = 2 * potenciaDe2(expoente - 1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		if (n == 0) {
			result = termoInicial;
		}
		else{
			result += progressaoAritmetica(termoInicial, razao, n - 1) + razao;
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		result *= termoInicial;
		if (n >= 1){
			result *= progressaoGeometrica(termoInicial, razao, n -1) * razao;
		}
		return result;
	}
	
	
}
