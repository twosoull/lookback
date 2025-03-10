package com.lookback.presentation.users.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindTrainingUsersRequest {
    private Long trainerId;
    private String trainingStatus;
    private String sortBy;

    private String userName;
}
