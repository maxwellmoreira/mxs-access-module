package com.mxs.factory;

import java.util.List;
import java.util.Optional;

public interface ConverterFactory<DTO, MODEL> {

    public DTO convertToDto(final Optional<MODEL> modelOptional);

    public Optional<MODEL> convertToModel(final DTO dto);

    public List<DTO> convertToDtoList(final List<Optional<MODEL>> modelOptionalList);

    public List<Optional<MODEL>> convertToModelList(final List<DTO> dtoList);
}