CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE alunos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(500) NOT NULL,
    email VARCHAR(500) NOT NULL
);