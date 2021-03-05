
public interface OutputDataStream<T> {
	void write(T input);
	void close();
	void write(InputDataStream<T> stream);
}
