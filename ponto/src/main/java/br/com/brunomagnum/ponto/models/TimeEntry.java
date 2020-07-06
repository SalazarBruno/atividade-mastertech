package br.com.brunomagnum.ponto.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.brunomagnum.ponto.enums.EntryType;

@Entity // This tells Hibernate to make a table out of this class
public class TimeEntry {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  private User user;

  @Enumerated(EnumType.STRING)
  private EntryType entryType;

  @Temporal(TemporalType.DATE)
  private Date date;

  @Temporal(TemporalType.TIME)
  private Date time;

  @PrePersist
  protected void onCreate() {
    date = new Date();
    time = new Date();
  }

  public TimeEntry() {
  }
  

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EntryType getEntryType() {
    return entryType;
  }

  public void setEntryType(EntryType entryType) {
    this.entryType = entryType;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}