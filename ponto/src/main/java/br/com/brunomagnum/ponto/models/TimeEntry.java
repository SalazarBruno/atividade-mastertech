package br.com.brunomagnum.ponto.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.validation.constraints.NotNull;

import br.com.brunomagnum.ponto.enums.EntryType;

@Entity // This tells Hibernate to make a table out of this class
public class TimeEntry {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @NotNull
  @ManyToOne
  private User user;

  @NotNull
  @Enumerated(EnumType.STRING)
  private EntryType entryType;

  private LocalDateTime punch;

  /*
  @Temporal(TemporalType.DATE)
  private Date date;

  @Temporal(TemporalType.TIME)
  private Date time;

  @PrePersist
  protected void onCreate() {
    date = new Date();
    time = new Date();
  }
*/

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

  public LocalDateTime getPunch() {
    return punch;
  }

  public void setPunch(LocalDateTime punch) {
    this.punch = punch;
  }
}