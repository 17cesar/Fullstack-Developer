package com.maximatech.pp.domain.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maximatech.pp.domain.modelo.Cliente;
import com.maximatech.pp.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	private List<Cliente> listaCliente;
	
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
	public List<Cliente> consultarCliente(){		
		validarClienteJson();
		return clienteRepository.findAll();
	}
	
	private List<Cliente> listarClienteJson(){
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		try {			
			Gson gson = new Gson();			
			String  json = jsonCliente();			
			java.lang.reflect.Type type = new TypeToken<List<Cliente>>() {}.getType();		
			listaCliente = gson.fromJson(json, type);
		} catch (Exception e) {
			e.printStackTrace();
	}
		return listaCliente;
}	
	private static String jsonCliente() throws Exception {
		URL obj = new URL("http://maximatech.free.beeceptor.com/cliente");
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
	
	private void validarClienteJson(){
		
		List<Cliente> listarClienteJson = listarClienteJson();
		List<Cliente> listarCliente = clienteRepository.findAll();
		
		List<Cliente> clienteEmComum = listarClienteJson.stream().filter(item1 -> {
            return listarCliente.stream().filter(item2 -> item2.getId().equals(item1.getId())).findFirst().isPresent();
        }).collect(Collectors.toList());
		
		listarClienteJson.removeAll(clienteEmComum);
		
		if (!listarClienteJson.isEmpty()) {
			for (Cliente cliente : listarClienteJson) {
				salvar(cliente);
			}
		}
	}
}
	
	
	
