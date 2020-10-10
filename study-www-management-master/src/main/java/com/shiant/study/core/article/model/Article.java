package com.shiant.study.core.article.model;

import com.shiant.common.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "t_study_article")
public class Article extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5244601507634998733L;

	@Id
    @Column(name = "aid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;
    
	@Column(name="cover_file")
	private String coverFile;

    @Column(name = "content")
    private String content;
    
	@Column(name="show_time")
	private Long showTime;

	@Column(name="create_date")
	private Date createDate;

	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="creater")
	private String creater;
	
	@Column(name="updater")
	private String updater;

    public Article() {
    }

    public Article(String textType, String title, String content, Date createDate, Date updateDate) {
        this.type = textType;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getCoverFile() {
		return coverFile;
	}

	public void setCoverFile(String coverFile) {
		this.coverFile = coverFile;
	}

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Long getShowTime() {
		return showTime;
	}

	public void setShowTime(Long showTime) {
		this.showTime = showTime;
	}

}
