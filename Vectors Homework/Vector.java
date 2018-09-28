import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import java.lang.RuntimeException;
import java.util.Arrays;

public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess {
  
  protected Object[] data;
  protected int size;

  public int size() {
   	return size; 
  }
  
  private void rangeCheck(int index) {
   	 if (index < 0 || index >= size)
       throw new IndexOutOfBoundsException("");
  }
  
  @SuppressWarnings("unchecked")
  private E data(int index) {
    return (E) data[index];
  }
  
  private void grow() {
    int newCapacity = data.length*2;
   	data = Arrays.copyOf(data, newCapacity); 
  }
  
  public Vector() {
  	this(10); 
  }
  
  public Vector(int initialCapacity) {
   	data = new Object[initialCapacity];
    size = 0;
  }
  
  public E get(int index) {
    rangeCheck(index);
    return data(index);
  }
  
  public E set(int index, E element) {
    rangeCheck(index);
    E oldValue = data(index);
   	data[index] = element; 
  	return oldValue;
  }
  
  public boolean add(E element) {
   	if (size == data.length) grow(); 
    data[size++] = element;
    return true;
  }
  
   public void add(int index, E element)
  {
      for (int i = size - 1; i >= index; i--)
          data[i + 1] = data[i];
      
      data[index] = element;
      size++;
  }  
   
   public E remove(int index)
  {
      Object o = data[index];
      
      for (int j = index; j < size - 1; j++)
          data[j] = data[j + 1];
      
      size--;
      
      return (E) o;
  }  
	 public int indexOf(Object o)
  {
      for (int i = 0; i < size; i++)
          if (o.equals(data[i])) return i;
      return -1;
  }  
  public static void main(String[] args) {
  	Vector<Integer> intlist = new Vector<Integer>();
    Vector<String> stringlist = new Vector<String>();
    Vector<Vector<Integer>> intveclist = new Vector<Vector<Integer>>();

		for (Integer i = 0; i < 10; i++) {
				intlist.add(i);
		}

		System.out.println(intlist.indexOf(7));
		System.out.println(intlist.indexOf("seven"));
  }
}



