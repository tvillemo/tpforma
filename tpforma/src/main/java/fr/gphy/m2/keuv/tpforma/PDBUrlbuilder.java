
public class PDBUrlBuilder{
	public static URL getFirstPdbUrl(String uniprotId) throws IOExcpetion{
		//gerer proxy
		System.setProperty("http.proxyHost","cache.univpoitiers.fr");
		System.setProperty("http.proxyPort","3128");
		URL url = new URL("http://www.uniprot.org/uniprot/"+uniprotId+".txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		// lire fichier
		return null;
	}
}