package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		Vetor a = new Vetor(5);
		a.inserir(1);
		a.inserir(2);
		a.inserir(3);
		a.inserir(4);
		a.inserir(5);
		System.out.println(a.procurar(1));
		System.out.println(a.remover(3));
	}
}
