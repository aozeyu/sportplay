package com.deyunjiaoyu.sportplay.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class SubMenu {
   private int id;
   private String title;
   private String path;

   public SubMenu() {
   }

   public SubMenu(String title, String path) {
      this.title = title;
      this.path = path;
   }

   public int getId() {
      return id;
   }

   @Override
   public String toString() {
      return "SubMenu{" +
              "id=" + id +
              ", title='" + title + '\'' +
              ", path='" + path + '\'' +
              '}';
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getPath() {
      return path;
   }

   public void setPath(String path) {
      this.path = path;
   }
}
