package com.idat.EFJorgeHuamacctoTurista.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EFJorgeHuamacctoTurista.dto.TuristaDTO;
import com.idat.EFJorgeHuamacctoTurista.model.Turista;
import com.idat.EFJorgeHuamacctoTurista.repository.TuristaRepository;

@Service
public class TuristaServiceImpl implements TuristaService {

	//
	
	@Autowired
	private TuristaRepository repository;
	
	
	@Override
	public List<TuristaDTO> listar() {
		List<TuristaDTO> listadto = new ArrayList<>();
		TuristaDTO dto = null;
		
		for( Turista turista : repository.findAll()) {
			dto= new TuristaDTO();
			dto.setDire(turista.getDireccion());
			dto.setNro(turista.getNroCelular());
			dto.setNom(turista.getNombreTurista());
			dto.setCodigo(turista.getIdTurista());
			listadto.add(dto);	
		}
		return listadto;
	}
	
	
	


	@Override
	public TuristaDTO obtenerId(Integer id) {
		
		Turista turista = repository.findById(id).orElse(null);
		
		TuristaDTO dto = new TuristaDTO();
		dto.setDire(turista.getDireccion());
		dto.setNro(turista.getNroCelular());
		dto.setNom(turista.getNombreTurista());
		dto.setCodigo(turista.getIdTurista());
		
		return dto;
	}

	
	
	
	@Override
	public void guardar(TuristaDTO turista) {
		// TODO Auto-generated method stub
		Turista turi = new Turista();
		turi.setDireccion(turista.getDire());
		turi.setNroCelular(turista.getNro());
		turi.setNombreTurista(turista.getNom());
		turi.setIdTurista(turista.getCodigo());
		repository.save(turi);
	}

	

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void actualizar(TuristaDTO turista) {
		// TODO Auto-generated method stub
		Turista turi = new Turista();
		turi.setDireccion(turista.getDire());
		turi.setNroCelular(turista.getNro());
		turi.setNombreTurista(turista.getNom());
		turi.setIdTurista(turista.getCodigo());
		repository.saveAndFlush(turi);

	}

}
