import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
public class AgglomerativeClustering <T extends Clusterable<T>> implements Clustering<T> {
	double threshold;

	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}

	public Set<Set<T>> clusterSet(Set<T> elements) {
		Set<Set<T>> clusters = elements.stream()
				.map(tItem -> {
					Set<T> s = new HashSet<>();
					s.add(tItem);
					return s;
				})
				.collect(Collectors.toSet());
		Set<T> clusterA = new HashSet<>();
		Set<T> clusterB = new HashSet<>();

		while (clusters.size() != 1) {
			double[] minDistance = {Double.MAX_VALUE};
			Set<T> finalClusterA = clusterA;
			Set<T> finalClusterB = clusterB;
			clusters.stream().flatMap(cluster1 ->
							clusters.stream()
									.filter(cluster2 -> !cluster2.equals(cluster1) && minDistance(cluster2, cluster1) < minDistance[0])
									.peek(cluster2 -> {
										minDistance[0] = minDistance(cluster2, cluster1);
										finalClusterA.clear();
										finalClusterA.addAll(cluster1);
										finalClusterB.clear();
										finalClusterB.addAll(cluster2);
									}))
					.count();
			if (minDistance[0] > threshold)
				return clusters;
			Set<T> union = new HashSet<>();
			union.addAll(finalClusterA);
			union.addAll(finalClusterB);
			clusters.remove(finalClusterA);
			clusters.remove(finalClusterB);
			clusters.add(union);
		}
		return clusters;
	}


	private double minDistance(Set<T> elements1, Set<T> elements2) {
		return elements1.stream()
				.flatMapToDouble(item1->elements2.stream().mapToDouble(item2->item1.distance(item2)))
				.min()
				.orElse(Double.POSITIVE_INFINITY);
	}
}
