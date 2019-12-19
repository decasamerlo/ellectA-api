CREATE TABLE eleicao (
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	data_inicio DATE NOT NULL,
	data_fim DATE NOT NULL
);

CREATE TABLE cargo (
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL
);

CREATE TABLE candidato (
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	id_cargo BIGINT NOT NULL,
	FOREIGN KEY (id_cargo) REFERENCES cargo(id)
);

CREATE TABLE eleitor (
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(50) NOT NULL
);

CREATE TABLE protocolo (
	id BIGSERIAL PRIMARY KEY,
	id_eleitor BIGINT NOT NULL,
	id_eleicao BIGINT NOT NULL,
    codigo VARCHAR(19) NOT NULL,
	FOREIGN KEY (id_eleitor) REFERENCES eleitor(id),
	FOREIGN KEY (id_eleicao) REFERENCES eleicao(id)
);

CREATE TABLE voto (
	id BIGSERIAL PRIMARY KEY,
	id_protocolo BIGINT NOT NULL,
	id_candidato BIGINT NOT NULL,
	FOREIGN KEY (id_protocolo) REFERENCES protocolo(id),
	FOREIGN KEY (id_candidato) REFERENCES candidato(id)
);
