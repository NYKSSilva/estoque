create table produtos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome CHAR(55) NOT NULL,
    categoria CHAR(55) NOT NULL,
    quantidade INT,
    valor_unitario FLOAT NOT NULL
)
