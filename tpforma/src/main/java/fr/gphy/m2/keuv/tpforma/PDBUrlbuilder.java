
public class PDBUrlBuilder{
	public static URL getFirstPdbUrl(String uniprotId) throws IOExcpetion{
		//gerer proxy
		URL url = new URL("http://www.uniprot.org/uniprot/"+uniprotId+".txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		// lire fichier
		return null;
	}
}