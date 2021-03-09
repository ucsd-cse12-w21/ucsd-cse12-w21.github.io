
public interface InputDataStream<T> {
	T next();
	boolean hasNext();
	void close();
	void next(OutputDataStream<T> stream);
}