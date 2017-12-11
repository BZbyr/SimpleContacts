package model;

import java.io.Serializable;

/**
 *
 *
 * @class: Category
 * @author: Boyang
 * @date: 2017/12/11 20:34
 */

public class Category implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String description;

    public Category(){}

    public Category(String categoryId, String categoryName, String catDescription){
        this.id = categoryId;
        this.name = categoryName;
        this.description = catDescription;
    }

    public String getId() {
        return this.id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets category id.
     *
     * @param categoryId the category id
     */
    public void setId(String categoryId) {
        this.id = categoryId;
    }

    /**
     * Sets name.
     *
     * @param categoryName the name
     */
    public void setName(String categoryName) {
        this.name = categoryName;
    }

    /**
     * Sets description.
     *
     * @param catDescription the description
     */
    public void setDescription(String catDescription) {
        this.description = catDescription;
    }

    //公共方法

    @Override
    public String toString() {
        return getId()+" "+getName()+" "+getDescription();
    }
}
