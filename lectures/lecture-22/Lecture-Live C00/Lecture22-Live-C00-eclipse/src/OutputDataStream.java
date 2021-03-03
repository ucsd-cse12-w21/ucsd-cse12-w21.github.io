
public interface OutputDataStream<T> {
	void write(T input);
	void close();
}
