package com.hospitality.util;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(PrimaryKeyListener.class)
public class BaseEntity<T> extends AuditFields<T>{

}
