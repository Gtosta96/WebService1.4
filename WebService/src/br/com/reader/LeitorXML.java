package br.com.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import br.com.dominio.Negociacao;
import br.com.webservice.ClienteWebService;

public class LeitorXML {
	private String content;
	private List listaNegociacao;

	// private static final String startPreco = "<preco>";
	// private static final String endPreco = "</preco>";
	// private static final String startQuantidade = "<quantidade>";
	// private static final String endQuantidade = "</quantidade>";

	public List carregaXML(InputStream inputStream) throws IOException {

		// XStream stream = new XStream(new DomDriver());
		// stream.alias("negociacao", Negociacao.class);
		// return (List) stream.fromXML(inputStream);

		// Scanner s = new Scanner(inputStream).useDelimiter("\\A");

		BufferedReader br = new BufferedReader(new InputStreamReader(
				inputStream));
		List list = new ArrayList();

		while ((content = br.readLine()) != null)
			list.add(content);

		return trataXML(list);
		// return list;
	}

	public List trataXML(List list) {
		Negociacao negociacao = null;
		List listaTratada = new ArrayList();

		for (int i = 0; i < list.size(); i++) {
			negociacao = new Negociacao();
			content = list.get(i).toString();

			// if(content.startsWith(startPreco) && content.endsWith(endPreco)){
			// content = content.substring(startPreco.length(),
			// endPreco.length());
			// negociacao.setPreco(Double.parseDouble(content));
			// };
			//
			// if(content.startsWith(startQuantidade) &&
			// content.endsWith(endQuantidade)){
			// content = content.substring(startQuantidade.length(),
			// endQuantidade.length());
			// negociacao.setQuantidade(Integer.parseInt(content));
			// };

			listaTratada.add(negociacao);
		}

		return listaTratada;
	}

	public List SAXParser() {
		
		try {
			URL link = new URL("http://argentumws.caelum.com.br/negociacoes");
			
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
	        XMLReader xr = sp.getXMLReader();
			ClienteWebService handler = new ClienteWebService();
	        xr.setContentHandler(handler);
	        xr.parse(new InputSource(link.openStream()));
			
	        listaNegociacao = handler.getListaNegociacao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaNegociacao;
	}

}