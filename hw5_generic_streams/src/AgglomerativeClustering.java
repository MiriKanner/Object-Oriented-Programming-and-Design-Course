import java.util.Set;
import java.util.HashSet;

public class AgglomerativeClustering <T extends Clusterable<T>> implements Clustering<T>{
	double threshold;
	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}
	public Set<Set<T>> clusterSet(Set<T> elements) {
		Set<Set<T>> clusters= new HashSet<Set<T>>();
		elements.stream().forEach((tItem->{
			Set<T> s= new  HashSet<T>();
			s.add(tItem);
			clusters.add(s);
		}));
		Set<T> clusterA = new HashSet<>();
		Set<T> clusterB = new HashSet<>();

		while (clusters.size() != 1) {
			double[] minDistance = { Double.MAX_VALUE };
			Set<T> finalClusterA = clusterA;
			Set<T> finalClusterB = clusterB;
		clusters.stream().forEach(cluster1->
				clusters.stream().forEach(cluster2->{
					if(!cluster2.equals(cluster1)&&minDistance[0]>minDistance(cluster2,cluster1)){
						minDistance[0]=minDistance(cluster2,cluster1);

						finalClusterA.clear();
						finalClusterA.addAll(cluster1);
						finalClusterB.clear();
						finalClusterB.addAll(cluster2);
					}
				}));
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
	private double minDistance(Set<T> elements1,Set<T> elements2)
	{
		double[] minLength = {Double.POSITIVE_INFINITY };
		elements1.stream().forEach(item1->elements2.stream().forEach(item2->{
			double distance=item1.distance(item2);
			if(distance<minLength[0])
				minLength[0]=distance;
		}));
		return minLength[0];
	}
}
