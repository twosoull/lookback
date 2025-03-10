package com.lookback.domain.user.entity;

import com.lookback.domain.common.constant.enums.TrainingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.lookback.domain.record.entity.Record;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "TRAINING")
public class Training {

    @Id @GeneratedValue
    @Column(name = "TRAINING_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRAINER_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Trainer trainer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Users student;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "training")
    private List<Record> records;

    @Enumerated(EnumType.STRING) // Enum을 String으로 저장
    @Column(nullable = false)
    private TrainingStatus trainingStatus;

    public Training() {}

    public static Training create(Trainer trainer, Users student, TrainingStatus trainingStatus) {
        return builder().trainer(trainer)
                        .student(student)
                        .trainingStatus(trainingStatus)
                        .build();
    }

    public void cancel(){
        this.trainingStatus = TrainingStatus.CANCELED;
    }

}
