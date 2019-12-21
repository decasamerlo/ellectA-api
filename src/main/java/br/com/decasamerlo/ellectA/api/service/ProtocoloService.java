package br.com.decasamerlo.ellectA.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.decasamerlo.ellectA.api.model.Protocolo;
import br.com.decasamerlo.ellectA.api.repository.ProtocoloRepository;

@Service
public class ProtocoloService {
	
	@Autowired
	private ProtocoloRepository protocoloRepository;
	
	public Protocolo salvar(Protocolo protocolo) {
		protocolo.setCodigo(gerarCodigoAleatorio(4, 4, '-'));
		return protocoloRepository.save(protocolo);
	}
	
	private String gerarCodigoAleatorio(int espacos, int tamanho, char espacador) {
		StringBuilder str = new StringBuilder();
		str.append(gerarCodigoAleatorio(tamanho));
		for (int i = 0; i < espacos-1; i++) {
			str.append(espacador);
			str.append(gerarCodigoAleatorio(tamanho));
		}
		return str.toString();
	}

	private String gerarCodigoAleatorio(int tamanho) {
		String s = Long.toHexString(Double.doubleToLongBits(Math.random()));
		return s.substring(s.length()-tamanho);
	}

}
