package com.lookback.domain.muscle.repository;

import com.lookback.domain.muscle.entity.MuscleCategory;

public interface MuscleCategoryRepository {

    MuscleCategory save(MuscleCategory muscleCategory);

    MuscleCategory findById(Long muscleCategoryId);
}
