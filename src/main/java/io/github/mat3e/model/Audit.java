package io.github.mat3e.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
class Audit {
    @Column(name = "updated_time")
    private LocalDateTime updatedTime;
    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @PreUpdate
    void preMerge() {
        updatedTime = LocalDateTime.now();
    }

    @PrePersist
    void preCreate() {
        createdTime = LocalDateTime.now();
    }
}
