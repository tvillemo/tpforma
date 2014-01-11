package fr.gphy.m2.keuv.tpforma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PDBUrlBuilder {

    /**
     * Parse an Uniprot entry according to its Uniprot ID, extract the first PDB
     * id, then return the URL for this PDB id (null if none).
     *
     * @param uniprotId An Uniprot ID.
     * @return A PDB File URL.
     * @throws IOException An IOException is thrown if the URL for this Uniprot
     * ID can not be read.
     */
    public static URL getFirstPdbUrlFromUniprotEntry(String uniprotId) throws IOException {
        System.setProperty("http.proxyHost", "cache.univ-poitiers.fr");
        System.setProperty("http.proxyPort", "3128");

        URL url = new URL("http://www.uniprot.org/uniprot/" + uniprotId + ".txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.matches("^DR\\s+PDB;.+$")) {
                in.close();
                return new URL("http://www.ebi.ac.uk/pdbe/entry-files/pdb" + line.substring(10, 14).toLowerCase() + ".ent");
            }
        }
        in.close();
        return null;
    }
}
