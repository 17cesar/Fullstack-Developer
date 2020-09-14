package com.maximatech.pp.domain.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maximatech.pp.domain.modelo.Produto;
import com.maximatech.pp.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	
	@Autowired
	private ProdutoRepository ProdutoRepository;
	
	private List<Produto> listaProduto;
	
	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public Produto salvar(Produto Produto) {
		return ProdutoRepository.save(Produto);
	}
	
	
	public List<Produto> consultarProduto(){		
		validarProdutoJson();
		return ProdutoRepository.findAll();
	}
	
	public Optional<Produto> buscarProdutoCodigo(Long ProdutoId) {
		Optional<Produto> Produto = ProdutoRepository.findById(ProdutoId);
		return Produto;
	}
	
	private List<Produto> listarProdutoJson(){
		List<Produto> listaProduto = new ArrayList<Produto>();
		try {			
			Gson gson = new Gson();			
			String  json = jsonProduto();			
			java.lang.reflect.Type type = new TypeToken<List<Produto>>() {}.getType();		
			listaProduto = gson.fromJson(json, type);
		} catch (Exception e) {
			e.printStackTrace();
	}
		return listaProduto;
}	
	private static String jsonProduto() throws Exception {
		URL obj = new URL("http://maximatech.free.beeceptor.com/produto");
		HttpURLConnection conexao = (HttpURLConnection) obj.openConnection();
		conexao.setRequestMethod("GET");
		int responseCode = conexao.getResponseCode();
		BufferedReader in = new BufferedReader(	new InputStreamReader(conexao.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
        return response.toString();
		}
	
	private void validarProdutoJson(){
		
		List<Produto> listarProdutoJson = listarProdutoJson();
		List<Produto> listarProduto = ProdutoRepository.findAll();
		
		List<Produto> ProdutoEmComum = listarProdutoJson.stream().filter(item1 -> {
            return listarProduto.stream().filter(item2 -> item2.getId().equals(item1.getId())).findFirst().isPresent();
        }).collect(Collectors.toList());
		
		listarProdutoJson.removeAll(ProdutoEmComum);
		
		if (!listarProdutoJson.isEmpty()) {
			for (Produto Produto : listarProdutoJson) {
				salvar(Produto);
			}
		}
	}

}
