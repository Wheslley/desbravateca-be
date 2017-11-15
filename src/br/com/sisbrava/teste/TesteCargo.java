package br.com.sisbrava.teste;

import br.com.sisbrava.bean.Cargo;
import br.com.sisbrava.repository.CargoRepository;

public class TesteCargo {

	public static void main(String[] args) {

		Cargo cargo = (Cargo) CargoRepository.getInstance().getSelectOneObject(3);
		cargo.setDescricao("Regional");
				
		Cargo cargo2 = (Cargo) CargoRepository.getInstance().getSelectOneObject(3);
		
		System.out.println(cargo.toString());
		System.out.println(cargo2.toString());
		
		CargoRepository.getInstance().update(cargo);
		
	}

}
