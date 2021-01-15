public interface List<E> {

  /* Add an element at the beginning of the list */
  void prepend(E s);

  /* Add an element at the end of the list */
  void add(E s);

  /* Get the element at the given index */
  E get(int index);

  /* Get the number of elements in the list */
  int size();

  /* Add an element at the specified index */
  void insert(int index, E s);

  /* Remove the element at the specified index */
  void remove(int index);

}
