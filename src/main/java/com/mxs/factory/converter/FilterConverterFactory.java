package com.mxs.factory.converter;

import java.util.Optional;

public interface FilterConverterFactory<FILTER, MODEL> {
    public Optional<MODEL> convertToModel(final FILTER filter);
}
