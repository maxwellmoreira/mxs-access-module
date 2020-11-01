package com.mxs.factory;

public interface ConverterFactory<DTO, MODEL> {

    public DTO convertToDto(final MODEL model);

    public MODEL convertToModel(final DTO dto);
}
