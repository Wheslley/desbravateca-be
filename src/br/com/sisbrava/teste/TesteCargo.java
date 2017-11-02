package br.com.sisbrava.teste;

import java.util.List;

import br.com.sisbrava.bean.Cargo;
import br.com.sisbrava.interfaces.mensagem.ITables;
import br.com.sisbrava.repository.CargoRepository;

public class TesteCargo {

	public static void main(String[] args) {

		List<Object> lo = (List<Object>) CargoRepository.getInstance().selectMultiplusObjects(ITables.CARGO);

		for (Object obj : lo) {
			Cargo c2 = (Cargo) obj;
			System.out.println(c2.toString());
		}
		
	}

}
