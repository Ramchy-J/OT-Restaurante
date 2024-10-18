package com.restaurante.entities;

import constants.Status;
import java.time.Instant;

public abstract class Base {

  // Attributes

  private Long id;
  private Instant createdDate;
  private Instant updatedDate;
  private Long createdBy;
  private Long updatedBy;
  private Status status;

  // Constructor

  public Base() {}

  public Base(
      final Long id,
      final Instant createdDate,
      final Instant updatedDate,
      final Long createdBy,
      final Long updatedBy,
      final Status status) {
    this.id = id;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
    this.status = status;
  }

  // Methods

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Instant getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(final Instant createdDate) {
    this.createdDate = createdDate;
  }

  public Instant getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(final Instant updatedDate) {
    this.updatedDate = updatedDate;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy;
  }

  public Long getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(final Long updatedBy) {
    this.updatedBy = updatedBy;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(final Status status) {
    this.status = status;
  }
}
