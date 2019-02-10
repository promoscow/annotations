package ru.xpendence.annotations.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 18.10.2018
 * Time: 11:33
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Entity
@Table(name = "api_logs")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiLog extends AbstractEntity {

    private String transferType;
    private String httpMethod;
    private String path;
    private String body;

    public static ApiLog of(String transferType, String httpMethod, String path, String body) {
        return new ApiLog(transferType, httpMethod, path, body);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "created", updatable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    @PrePersist
    void onCreate() {
        if (Objects.isNull(this.getCreated())) {
            this.setCreated(LocalDateTime.now());
        }
    }

    @Column(name = "updated", insertable = false)
    public LocalDateTime getUpdated() {
        return updated;
    }

    @PreUpdate
    void onUpdate() {
        this.setUpdated(LocalDateTime.now());
    }

    @Column(name = "transfer_type")
    public String getTransferType() {
        return transferType;
    }

    @Column(name = "http_method")
    public String getHttpMethod() {
        return httpMethod;
    }

    @Column(name = "path", columnDefinition = "text")
    public String getPath() {
        return path;
    }

    @Column(name = "body", columnDefinition = "text")
    public String getBody() {
        return body;
    }
}
