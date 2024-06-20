import java.util.Set;


public class AgglomerativeClustering <T extends Clusterable<T>> implements Clustering<T>{
	double threshold;
	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}
	public Set<Set<T>> clusterSet(Set<T> elements) {
		Set<Set<T>> clusters=elements.stream().forEach((tItem->{
			Set<T> s= new  HashSet<T>();
			s.add(tItem);
			return s;
		}));
		while (clusters.size() !=1) {
			find the two closest clusters, c1, c2 from clusters
			if (distance(c1, c2) > threshold) return clusters;
			replace c1, c2 in clusters with the union of c1, c2
		}
		return clusters;
	}
	private  minDistance(Set<T> elements1,Set<T> elements2)
	{
		int minLength=0;
		elements1.stream().forEach(item1->elements2.stream().forEach(item2->{
			double dis=item1.distance(item2);
			if(dis<minLength)
				minLength=dis;
		}));
		return minLength;
	}
}
