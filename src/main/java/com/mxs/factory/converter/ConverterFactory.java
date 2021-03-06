package com.mxs.factory.converter;

import java.util.List;
import java.util.Optional;

public interface ConverterFactory<DTO, MODEL> {

    DTO convertToDto(final MODEL model);

    MODEL convertToModel(final DTO dto);

    List<DTO> convertToDtoList(final List<MODEL> modelList);

    List<MODEL> convertToModelList(final List<DTO> dtoList);
}