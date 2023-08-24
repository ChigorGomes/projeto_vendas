package com.prodigasistemas.vendas.projeto.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.Instant;

import static com.prodigasistemas.vendas.projeto.utils.Constants.TIMESTAMP_PATTERN;
import static com.prodigasistemas.vendas.projeto.utils.Constants.TIMEZONE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StandardError implements Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIMESTAMP_PATTERN, timezone = TIMEZONE)
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
