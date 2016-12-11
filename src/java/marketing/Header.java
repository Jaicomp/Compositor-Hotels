/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketing;

/**
 *
 * @author jaimescript
 */
public class Header {
    
    private int id;
    private String namePage;
    private String title;
    private String keywords;
    private String description;
    private String language;
    private int visits;
    
    public Header(int id, String namePage, String title, String keywords, String description, String language) {
        this.id = id;
        this.namePage = namePage;
        this.title = title;
        this.keywords = keywords;
        this.description = description;
        this.language = language;
        this.visits = 0;
    }

    public Header(int id, String namePage, String title, String keywords, String description, String language, int visits) {
        this.id = id;
        this.namePage = namePage;
        this.title = title;
        this.keywords = keywords;
        this.description = description;
        this.language = language;
        this.visits = visits;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNamePage() {
        return namePage;
    }

    public String getTitle() {
        return title;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public int getVisited() {
        return visits;
    }
    
    
    
}
