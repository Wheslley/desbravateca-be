package br.com.sisbrava.padroesEnum;

public enum ERegiao {
	
	PRIMEIRA(1),
	SEGUNDA(2),
	TERCEIRA(3),
	QUARTA(4),
	QUINTA(5),
	SEXTA(6),
	SETIMA(7),
	OITAVA(8),
	NONA(9),
	DECIMA(10),
	DECIMA_PRIMEIRA(11),
	DECIMA_SEGUNDA(12),
	DECIMA_TERCEIRA(13),
	DECIMA_QUARTA(14),
	DECIMA_QUINTA(15),
	DECIMA_SEXTA(16),
	DECIMA_SETIMA(17),
	DECIMA_OITAVA(18),
	DECIMA_NONA(19),
	VIGESIMA(20);
	
	private final int value;
	
	private ERegiao(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
