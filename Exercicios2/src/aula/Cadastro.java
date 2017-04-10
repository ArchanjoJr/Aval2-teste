package aula;
import java.io.*;

public class Cadastro {
	private File file;
	private FileWriter fw;

	public Cadastro(String filename) throws IOException {
		file = new File(filename);
		fw = new FileWriter(file);
		fw.close();
	}

	public boolean insert(int idFilme, String nome) throws IOException {
		if (idFilme > 0 && nome != null && !nome.isEmpty()) {
			fw = new FileWriter(file, true);
			fw.write(idFilme + ";" + nome + "\r\n");
			fw.close();
			return true;
		} else {
			return false;
		}
	}

	public void imprimir() throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String linha = null;
		do {
			linha = br.readLine();
			if (linha != null) {
				System.out.println(linha);
			}
		} while (linha != null);
		br.close();
		fr.close();
	}
}