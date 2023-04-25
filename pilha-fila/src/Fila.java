import java.util.Arrays;

public class Fila {


    private Integer[] array;
    private int tail;
    private int result;
    public void QueueImpl(int size){
        array = new Integer[size];
        tail = 0;
    }

    public void enqueue(int elem) throws Exception {
        if (array.length != tail){
            array[tail] = elem;
            if (this.tail == this.array.length){
                tail = 1;
            }else{
                tail++;
            }
        }else{
            throw new Exception("FILA CHEIA");
        }
    }

    public int dequeue() throws  Exception{
        if (array.length != 0){
            result = array[0];
            shiftLeft();
            tail--;
        }else{
            throw new Exception("FILA VAZIA");
        } return result;
    }
//FALTA EVITAR O SHIFT DO DEQUEUE
    public void shiftLeft(){
        this.array[0] = 0;
        for (int i = 0; i < tail; i++){
            array[i] = array[i + 1];
            System.out.println(Arrays.toString(array));
        }
    }


    public static void main(String[] args) throws Exception {
        Fila a = new Fila();
        a.QueueImpl(5);
        a.enqueue(10);
        a.enqueue(3);
        a.enqueue(53);
        a.enqueue(6);
        a.enqueue(73);
        a.dequeue();
        System.out.println(Arrays.toString(a.array));
    }
}
