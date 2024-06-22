import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
public class BitArray implements Clusterable<BitArray>{
	private ArrayList<Boolean> bits;

	public BitArray(String str) {
		bits = new ArrayList<>();
		String[] parts = str.split(",");
		bits = Arrays.stream(parts)
				.map(s -> s.equals("true"))
				.collect(Collectors.toCollection(ArrayList::new));
	}



	public BitArray(boolean[] bits) {
	this.bits = IntStream.range(0, bits.length)
			.mapToObj(i -> bits[i])
			.collect(Collectors.toCollection(ArrayList::new));
}

	@Override
	public double distance(BitArray other) {
		if (this.bits.size() != other.bits.size())
			throw new RuntimeException();

		return IntStream.range(0, this.bits.size())
				.mapToDouble(i -> this.bits.get(i).equals(other.bits.get(i)) ? 0 : 1)
				.sum();
	}

	public static Set<BitArray> readClusterableSet(String path) throws IOException {
		Set<BitArray> setBitsArray = Files.lines(Paths.get(path))
				.map(line -> line.split(" "))
				.map(parts -> new BitArray(parts[0]))
				.collect(Collectors.groupingBy(
						bitArray -> bitArray.bits.size(),
						Collectors.toSet()))
				.entrySet().stream()
				.max(Comparator.comparingInt(Map.Entry::getKey))
				.map(Map.Entry::getValue)
				.orElseGet(HashSet::new);

		return setBitsArray;
	}

	@Override
	public String toString() {
		return bits.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BitArray bitArray = (BitArray) o;
		return bits.equals(bitArray.bits);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bits);
	}
}
