package com.lookback.domain.user.entity;

import com.lookback.common.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TRAINER_INFO")
public class TrainerInfo extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRAINER_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Trainer trainerInfo;

    private String infoName;
    private String infoContent;
    private String infoType;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String inProgress;
    private String privateYn;
}
