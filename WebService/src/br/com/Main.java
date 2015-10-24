package br.com;

import java.util.List;

import br.com.dominio.Negociacao;
import br.com.reader.LeitorXML;

public class Main {

	public static void main(String[] args) {
		
		LeitorXML xml = new LeitorXML();
		
		List listaNegociacao = xml.SAXParser();
		
		for (int i = 0; i < listaNegociacao.size(); i++) {
			if(listaNegociacao.get(i) instanceof Negociacao){
			System.out.println(((Negociacao)listaNegociacao.get(i)));
			
//			RETIRAR TOSTRING DE NEGOCIACAO
//			Negociacao n = new Negociacao();
//			n = (Negociacao) listaNegociacao.get(i);
//			System.out.println(n.getId());
//			System.out.println(n.getPreco());
//			System.out.println(n.getQuantidade());
			}
		}
		
		
//		ClienteWebService ws = new ClienteWebService();
//		List negociacoes = null;
//		try {
//			negociacoes = ws.getNegociacoes();	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//				
//		for (int i = 0; i < negociacoes.size(); i++) {
//			if(negociacoes.get(i) instanceof Negociacao){
//			System.out.println("Index " + i);
//			System.out.println(((Negociacao)negociacoes.get(i)).getPreco());
//			System.out.println(((Negociacao)negociacoes.get(i)).getQuantidade());
//			System.out.println(negociacoes.get(i));
//			}
//		}
			
		//ITERATOR
//		Iterator iterator = negociacoes.iterator();
//		while(iterator.hasNext()){
//			if(iterator.next() instanceof Negociacao){
//				System.out.println(((Negociacao)iterator.next()).getPreco());
//				System.out.println(((Negociacao)iterator.next()).getQuantidade());
//				}
//			}
		
		//FOREACH
//		for (Object object : negociacoes) {
//			System.out.println(((Negociacao) object).getPreco());
//			System.out.println(((Negociacao) object).getQuantidade());
//		}
	
	}
}
