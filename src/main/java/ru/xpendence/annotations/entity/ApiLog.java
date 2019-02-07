package ru.xpendence.annotations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ApiLog {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss.SSS")
    private LocalDateTime created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss.SSS")
    private LocalDateTime updated;

    private LocalDateTime eventDateTime;
    private String transferType;
    private String httpMethod;
    private String path;
    private String body;

    public static ApiLog of(LocalDateTime eventDateTime, String transferType, String httpMethod, String path, String body) {
        return new ApiLog(null, null, eventDateTime, transferType, httpMethod, path, body);
    }

    public ApiLog(Long id, LocalDateTime created, LocalDateTime eventDateTime, String transferType, String httpMethod,
                  String path, String body) {
        this.id = id;
        this.created = created;
        this.eventDateTime = eventDateTime;
        this.transferType = transferType;
        this.httpMethod = httpMethod;
        this.path = path;
        this.body = body;
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
        if (Objects.isNull(this.getEventDateTime())) {
            this.setEventDateTime(LocalDateTime.now());
        }
    }

    @Column(name = "event_date_time")
    public LocalDateTime getEventDateTime() {
        return eventDateTime;
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

    @Column(name = "path", columnDefinition = "mediumtext")
    public String getPath() {
        return path;
    }

    @Column(name = "body", columnDefinition = "mediumtext")
    public String getBody() {
        return body;
    }
}
