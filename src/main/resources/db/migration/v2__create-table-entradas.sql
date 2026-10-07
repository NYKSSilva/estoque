create table entradas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_produto INT AUTO_INCREMENT,
    quantidade_produto INT NOT NULL,
    data_entrada DATE NOT NULL,
    FOREIGN KEY(id_produto) REFERENCES produtos(id)
)