package com.smartrm.smartrmcommodity.commodity.domain.model;

public class ImageUrl {

  private String url;
  private Integer width;
  private Integer height;
  private Integer fileSize;
  private String fileMd5;

  public String getUrl() {
    return url;
  }

  public Integer getWidth() {
    return width;
  }

  public Integer getHeight() {
    return height;
  }

  public Integer getFileSize() {
    return fileSize;
  }

  public String getFileMd5() {
    return fileMd5;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public void setFileSize(Integer fileSize) {
    this.fileSize = fileSize;
  }

  public void setFileMd5(String fileMd5) {
    this.fileMd5 = fileMd5;
  }

}
