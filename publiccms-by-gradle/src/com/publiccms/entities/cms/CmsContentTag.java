package com.publiccms.entities.cms;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;

// Generated 2016-1-19 11:28:06 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CmsContentTag generated by hbm2java
 */
@Entity
@Table(name = "cms_content_tag")
public class CmsContentTag implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private CmsContentTagId id;

    public CmsContentTag() {
    }

    public CmsContentTag(CmsContentTagId id) {
        this.id = id;
    }

    @EmbeddedId

    @AttributeOverrides({ @AttributeOverride(name = "tagId", column = @Column(name = "tag_id", nullable = false)),
            @AttributeOverride(name = "contentId", column = @Column(name = "content_id", nullable = false)) })
    public CmsContentTagId getId() {
        return this.id;
    }

    public void setId(CmsContentTagId id) {
        this.id = id;
    }

}
