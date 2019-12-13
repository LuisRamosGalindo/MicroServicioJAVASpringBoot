package com.ibk.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*; 
import java.lang.Math;
import com.ibk.beans.*;

@Controller
public class CreaClienteController {

	List<Cliente> listaClientes = new ArrayList<Cliente>();
	KpiClientes kpiClientes = new KpiClientes(0.0,0.0);

	@GetMapping("/creaCliente")
	public String creaCliente(String nombres, String apellidos, Integer edad, String fecNacimiento, String accion, String mensaje, Model model) {

		if (accion != null && accion.equals("registrar") ){
			Cliente cliente = new Cliente(nombres,  apellidos,  edad,  fecNacimiento);
			listaClientes.add(cliente); 
			model.addAttribute("mensaje", "Se registró el cliente");
			System.out.println("Se registró el cliente");		
		}else{
			model.addAttribute("mensaje", "Ingrese los datos del cliente");		
			System.out.println("Datos incompletos");	
		}

		model.addAttribute("listaClientes", listaClientes);	
		
		return "creaCliente";
	}


	@GetMapping("/listaClientes")
	public String listaClientes(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("listaClientes", listaClientes);
		return "listaClientes";
	}

	@GetMapping("/kpiClientes")
	public String kpiClientes(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
		Double promEdad = 0.0; 
		Double desvEstadar =0.0; 
		Double sum =0.0; 
		double totalClientes = 0.0;

		totalClientes = listaClientes.size(); 

		if(totalClientes != 0) {
			for (Cliente cli : listaClientes) {
				promEdad = promEdad + cli.edad();			
				
			}

			System.out.println("promEdad   :   " +promEdad  +  "totalClientes  : " +totalClientes);
			promEdad = promEdad / totalClientes;
			System.out.println("promEdad   :   " +promEdad  +  "totalClientes  : " +totalClientes);

			for (Cliente cli : listaClientes) {
				sum += Math.pow ( cli.edad() - promEdad, 2 );
				System.out.println(cli.nombres() + cli.apellidos());
			}
			desvEstadar = Math.sqrt ( sum / totalClientes );
		}

		kpiClientes.setPromEdad(promEdad); 
		kpiClientes.setDesvEstandar(desvEstadar); 

		model.addAttribute("kpiClientes", kpiClientes);
		return "kpiClientes";
	}

}

