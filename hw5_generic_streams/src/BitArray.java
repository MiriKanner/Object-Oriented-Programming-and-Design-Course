import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Stream;
public class BitArray implements Clusterable<BitArray>{
	private ArrayList<Boolean> bits;

	public BitArray(String str) {
		bits = new ArrayList<>();
		String[]parts=str.split(",");
		for (int i = 0; i < parts.length; i++) {
			String s=parts[i];
			if (s.equals("true")) {
				bits.add(true);
			} else  {
				bits.add(false);
			}
		}
	}

	public BitArray(boolean[] bits) {
		this.bits = new ArrayList<>();
		for (boolean bit : bits) {
			this.bits.add(bit);
		}
	}


	@Override
	public double distance(BitArray other) {
		//cheak size
		// TODO: Complete. If the file contains bitarrays of different lengths,
		//  retain only those of maximal length
		if(this.bits.size()!=other.bits.size())
			throw  new RuntimeException();
		double distance=0;
		for(int i=0;i<this.bits.size();i++){
			if(this.bits.get(i)!=other.bits.get(i))
				distance=distance+1;
		}
		return  distance;
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
