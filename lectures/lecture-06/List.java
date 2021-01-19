public interface List<Element> {
  /* Add an element at the end of the list */
  void add(Element s);

  /* Get the element at the given index */
  Element get(int index);

  /* Get the number of elements in the list */
  int size();
}
