package br.com.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.dominio.Negociacao;
import br.com.reader.LeitorXML;

public class ClienteWebService extends DefaultHandler {

	private static final String URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes";
	private static final String NEGOCIACAO = "negociacao";
	private static final String PRECO = "preco";
	private static final String QUANTIDADE = "quantidade";
	private List listaNegociacao = new ArrayList();
	private Negociacao negociacao = null;
	private int contador = 1;

	public List getNegociacoes() {
		HttpURLConnection connection = null;

		try {
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();
			InputStream content = connection.getInputStream();
			return new LeitorXML().carregaXML(content);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			connection.disconnect();
		}
	}

	public List getListaNegociacao() {
		return listaNegociacao;
	}

	boolean bPreco = false;
	boolean bQuantidade = false;

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase(NEGOCIACAO)) {
			negociacao = new Negociacao();
			int id = this.contador++;
			negociacao.setId(id);

		} else if (qName.equalsIgnoreCase(PRECO)) {
			bPreco = true;

		} else if (qName.equalsIgnoreCase(QUANTIDADE)) {
			bQuantidade = true;
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase(NEGOCIACAO)) {
			listaNegociacao.add(negociacao);
		}
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {

		if (bPreco) {
			negociacao.setPreco(new String(ch, start, length));
			bPreco = false;
		}

		if (bQuantidade) {
			negociacao.setQuantidade(new String(ch, start, length));
			bQuantidade = false;
		}
	}
}