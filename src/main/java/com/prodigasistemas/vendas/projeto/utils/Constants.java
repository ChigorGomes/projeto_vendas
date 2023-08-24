package com.prodigasistemas.vendas.projeto.utils;

import java.util.List;

public class Constants {
    public final static List<String> COLUMS = List.of("DESCRICAO", "PRECO", "QTD", "CLIENTE_NOME", "CLIENTE_CPF_CNPJ", "CLIENTE_ENDERECO");
    public final static String FILE_EXCEPTION = "File is empty or invalid";
    public final static String NOT_FOUND = "Cpf/Cnpj not found. ";
    public final static String TIMESTAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public final static String TIMEZONE = "UTC";
    public static final String VALUE_FILE_TXT = "verify the file and key and value to send. (key= 'file',value='file.txt')";
    public static final String FILE_NOT_EXISTS = "File not exists";
    public static final String VERIFY_THE_FILE = "verify the file";

    public static final String FILE_ROW_COLUMN = "verify the file row/column";
    public static final String FILE_NOT_VALID = "File not valid";
    public static final String RESOURCE_NOT_FOUND = "Resource not found";


}
