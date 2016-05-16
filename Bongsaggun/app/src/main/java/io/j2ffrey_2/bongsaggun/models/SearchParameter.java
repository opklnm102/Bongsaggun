package io.j2ffrey_2.bongsaggun.models;

/**
 * Created by Dong on 2015-12-04.
 */
public class SearchParameter {

    String word;
    Integer categoryId;
    Integer regionId;
    Integer schoolId;
    Integer timeId;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public SearchParameter(String word, Integer categoryId, Integer regionId, Integer schoolId, Integer timeId) {
        this.word = word;
        this.categoryId = categoryId;
        this.regionId = regionId;
        this.schoolId = schoolId;
        this.timeId = timeId;
    }

    public SearchParameter() {
        word = null;
        categoryId = null;
        regionId = null;
        schoolId = null;
        timeId = null;
    }
}
