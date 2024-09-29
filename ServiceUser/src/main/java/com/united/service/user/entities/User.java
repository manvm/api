package com.united.service.user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.time.Instant;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "UserID", length = 255, nullable = false)
    private String UserID;

    @Column (name="UserName", length = 255, nullable = false)
    private String UserName;

    @Column(name = "FirstName", length = 255, nullable = false)
    private String FirstName;

    @Column(name = "LastName", length = 255, nullable = false)
    private String LastName;

    @Column(name = "Address", length = 255)
    private String Address;

    @Column(name = "City", length = 255)
    private String City;

    @Column(name = "ContactNumber", length = 255)
    private String ContactNumber;

    @Column(name = "EMailId", length = 255)
    private String EMailId;

    @Column(name = "CreatedBy", nullable = false, updatable = false)
    private int CreatedBy;

    @Column(name = "CreatedDateTime", nullable = false, updatable = false)
    private Instant CreatedDateTime;

    @Column(name = "UpdatedBy")
    private int UpdatedBy;

    @Column(name = "UpdatedDatetime")
    private Instant UpdatedDateTime;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "isDeleted")
    private boolean isDeleted;
}