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
		String[]parts=str.split(",");
		Arrays.stream(parts).forEach(s->{
			if(s.equals("true"))
				bits.add(true);
			else bits.add(false);
		});
	}

public BitArray(boolean[] bits) {
	this.bits = IntStream.range(0, bits.length)
			.mapToObj(i -> bits[i])
			.collect(Collectors.toCollection(ArrayList::new));
}

	@Override
	public double distance(BitArray other) {

		if(this.bits.size()!=other.bits.size())
			throw  new RuntimeException();
		double []distance={0};
		int[]i={0};
		double[] finalDistance = distance;
		this.bits.stream().forEach(b->{
			if(b!=other.bits.get(i[0]))
				finalDistance[0]= finalDistance[0]+1;
			i[0]=i[0]+1;
		});

		return  finalDistance[0];
	}

	public static Set<BitArray> readClusterableSet(String path) throws IOException {
		try (Stream<String> lines = Files.lines(Paths.get(path))){
			Set<BitArray> setBitsArray = new HashSet<BitArray>();
			int[] maxLength = { -1 };
			lines
					.map(l -> l.split(" "))
					.forEach(b -> {
						BitArray bitArray = new BitArray(b[0]);
						if (bitArray.bits.size() > maxLength[0]) {
							maxLength[0] = bitArray.bits.size();
							setBitsArray.clear();
						}
						if (bitArray.bits.size() == maxLength[0]) {
							setBitsArray.add(bitArray);
						}
					});
			return setBitsArray;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return null;
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
