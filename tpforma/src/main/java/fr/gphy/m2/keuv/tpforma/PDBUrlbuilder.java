
public class PDBUrlBuilder{
	public static URL getFirstPdbUrl(String uniprotId) throws IOExcpetion{
		//gerer proxy
		System.setProperty("http.proxyHost","cache.univpoitiers.fr");
		System.setProperty("http.proxyPort","3128");
		URL url = new URL("http://www.uniprot.org/uniprot/"+uniprotId+".txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		// lire fichier
		String line;
		while ((line = in.readLine())!=null){
			if (line.matches("^DR\\s+PDB;.+$")){
				in.close();
				return new URL("http:/www.ebi.ac.uk/pdbe/ent/ryfiles/pdb"+ line.substring(10,14).toLowerCase()+".ent");
				
			}
		}
		in.close();
	}
}
