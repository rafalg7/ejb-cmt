package pl.itcrowd.tutorials.ejbcmt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String topic;

    public BlogPost(){
    }

    public BlogPost(String topic)
    {
        this.topic = topic;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "BlogPost{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                '}';
    }
}