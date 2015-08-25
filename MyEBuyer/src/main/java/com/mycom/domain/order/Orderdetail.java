package com.mycom.domain.order;

public class Orderdetail {
  private String id;
  private String userId;
  private String itemId;
  private Integer itemNum;

  public Orderdetail() {}

  public Orderdetail(String userId, String itemId, Integer itemNum) {
    super();
    this.userId = userId;
    this.itemId = itemId;
    this.itemNum = itemNum;
  }

  @Override
  public String toString() {
    return "Orderdetail [id=" + id + ", userId=" + userId + ", itemId=" + itemId + ", itemNum="
        + itemNum + "]";
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public Integer getItemNum() {
    return itemNum;
  }

  public void setItemNum(Integer itemNum) {
    this.itemNum = itemNum;
  }


}
