package com.fucloud.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Record {
    Integer id;
    Integer readerId;
    Integer bookId;

    Integer borrowAdminId;
    LocalDateTime borrowTime;

    Integer returnAdminId;
    LocalDateTime returnTime;

    boolean isRenewed;
    boolean isViolated;
}
