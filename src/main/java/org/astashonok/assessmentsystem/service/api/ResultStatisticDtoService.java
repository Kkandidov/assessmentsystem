package org.astashonok.assessmentsystem.service.api;

import org.astashonok.assessmentsystem.dto.user.ResultStatisticDto;

import java.util.List;

public interface ResultStatisticDtoService {
    List<ResultStatisticDto> getByUserId(long userId);
}
