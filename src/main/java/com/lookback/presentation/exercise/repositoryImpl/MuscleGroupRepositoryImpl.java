package com.lookback.presentation.exercise.repositoryImpl;

import com.lookback.domain.handler.exception.RestApiException;
import com.lookback.domain.muscle.entity.MuscleGroup;
import com.lookback.domain.muscle.repository.MuscleGroupRepository;
import com.lookback.presentation.exercise.repositoryORM.MuscleGroupJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.lookback.domain.handler.exception.errorCode.CommonErrorCode.RESOURCE_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class MuscleGroupRepositoryImpl implements MuscleGroupRepository {

    private final MuscleGroupJpaRepository muscleGroupJpaRepository;

    @Override
    public MuscleGroup save(MuscleGroup muscleGroup) {
        return muscleGroupJpaRepository.save(muscleGroup);
    }

    @Override
    public MuscleGroup findById(Long id) {
        return muscleGroupJpaRepository.findById(id).orElseThrow(
                () -> new RestApiException(RESOURCE_NOT_FOUND));
    }
}
