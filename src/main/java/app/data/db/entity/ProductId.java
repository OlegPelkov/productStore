package app.data.db.entity;

import javax.persistence.Id;

public class ProductId {

  @Id
  private long id;

  public ProductId(long seq) {
    this.id = id;
  }

  public ProductId() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ProductId inc(){
    id = id+1;
    return this;
  }
}