package com.onlinedating.model;

import java.util.Set;

/**
 * Created by Aver on 17.06.2015.
 */
    public class Category implements java.io.Serializable {
        private int CategoryID;
        private  String Category_Name;
        private Set<Question> questionSet;

        public int getCategoryID()  {
            return CategoryID;
        }
        public void setCategoryID(int id) {
            this.CategoryID = id;
        }

        public String getCategory_Name() {
            return Category_Name;
        }
        public void setCategory_Name(String name) {
            this.Category_Name = name;
        }

        public Set<Question> getQuestions () {
            return questionSet;
        }
        public void setQuestions(Set<Question> items) {
            this.questionSet = items;
        }

        @Override
        public String toString(){
            return Category_Name;
        }
}
