-- CREATE DATABASE grupo02;
CREATE TABLE IF NOT EXISTS tab_professor (
	id     serial     NOT NULL,
	nome     varchar(255)     NOT NULL,
    dataNascimento     date     NOT NULL,
    cargaHoraria     time without time zone     NOT NULL,
    valorHora     numeric(7,2)     NOT NULL,
    estrangeiro     boolean     NOT NULL,
    horasDisponiveis     integer     NOT NULL,
    biografia     character varying(200)     NOT NULL, 
    dataHoraCadastro     timestamp     NOT NULL,   
	CONSTRAINT tab_professor_pkey PRIMARY KEY (id)
);

