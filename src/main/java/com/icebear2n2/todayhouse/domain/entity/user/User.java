package com.icebear2n2.todayhouse.domain.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class User {

    @Id
    private UUID id;
    private String name;
    private String number;
    private String address;

    public void UpdateAddress(String address) {
        if (address != null) {
            this.address = address;
        }
    }
}
