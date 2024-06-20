
import java.io.IOException;
import java.util.Objects;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.Stream;

public class TwoDPoint implements Clusterable<TwoDPoint>{
	double x;
	double y;
	//28.9,5.55
	public TwoDPoint(String str){
		String[] parts = str.split(",");
		this.x = Double.parseDouble(parts[0]);
		this.y = Double.parseDouble(parts[1]);
	}
	public TwoDPoint(double x, double y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public double distance(TwoDPoint other) {
		double xDiff = this.x - other.x;
		double yDiff = this.y - other.y;
		double dis= Math.sqrt(xDiff * xDiff + yDiff * yDiff);
		return  dis;
	}

	public static Set<TwoDPoint> readClusterableSet(String path) throws IOException{
		try (Stream<String> lines = Files.lines(Paths.get(path))){
			Set<TwoDPoint> setTwoDPoint = new HashSet<TwoDPoint>();
			lines .map(l -> l.split(" "))
					.forEach(t ->
						setTwoDPoint.add(new TwoDPoint(t[0])));
						return setTwoDPoint;
					} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public boolean equals(Object other) {
		TwoDPoint otherP = (TwoDPoint) other;
		return (otherP.x == x && otherP.y == y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
