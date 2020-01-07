package com.fangjian.zhenbao.business.system.entity;

import java.io.Serializable;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@SuppressWarnings("serial")
public class Resource implements Serializable {
    private Long id; //编号
    private String name; //资源名称
    private String type; //资源类型
    private String url; //资源路径
    private String permission; //权限字符串
    private Long parentId; //父编号
    private String parentIds; //父编号列表
    private Boolean available = Boolean.FALSE;
    private String icon;
    private int weight; //页面权重

    /***********************冗余字段************************/
    private String checkedFlag = "0";;//是否被选中

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
/*public boolean isRootNode() {
        return parentId == 0;
    }*/

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

	public String getCheckedFlag() {
		return checkedFlag;
	}

	public void setCheckedFlag(String checkedFlag) {
		this.checkedFlag = checkedFlag;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Resource resource = (Resource) o;

        return !(id != null ? !id.equals(resource.id) : resource.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Resource{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", type=" + type +
            ", permission='" + permission + '\'' +
            ", parentId=" + parentId +
            ", parentIds='" + parentIds + '\'' +
            ", available=" + available +
            ", checkedFlag=" + checkedFlag +
            '}';
    }
}
